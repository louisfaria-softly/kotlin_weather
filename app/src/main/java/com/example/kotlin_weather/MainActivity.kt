package com.example.kotlin_weather


import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.Html
import android.text.TextWatcher
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private var weatherData: TextView? = null
    var textEdit: TextView? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weatherData = findViewById(R.id.textView)
        textEdit = findViewById(R.id.text)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        button1.setOnClickListener { openView() }

        textEdit?.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {

                // Here the string is taken and parsed to the Getcurrentdata() function

              var text = textEdit!!.text
                var textEdit = text.toString()

                getCurrentData(textEdit )

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {


            }
        })
    }





 fun openView(){

     if (weatherData != null) {

         val myIntent = Intent(this, SecondActivity::class.java)
         //Optional parameters





         this.startActivity(myIntent)
     }
}




// The API calling function
    private fun getCurrentData(text: String) {


        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(WeatherService::class.java)
        val call = service.getCurrentWeatherData(text, AppId)

        call.enqueue(object : Callback<WeatherResponse> {
            @RequiresApi(Build.VERSION_CODES.M)
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                if (response.code() == 200) {
                    val weatherResponse = response.body()!!



                    val stringBuilder = Html.fromHtml(
//                            weatherResponse.sys!!.country +
//                            "<br>" +
//                            "<b>City:</b> " +
//                            weatherResponse.name +
//
//                            "<br>" +
//                            "<b>Temp:</b> " +
//                            (weatherResponse.main!!.temp - 273).toString().substring(0,3) + "ºC" +
//                            "<br>" +
                            "<b>Temp(Min):</b> " +
                            (weatherResponse.main!!.temp_min - 273).toString().substring(0,3) + "ºC" +
                            "<br>" +
                            "<b>Temp(Max):</b> " +
                            (weatherResponse.main!!.temp_max - 273).toString().substring(0,3) + "ºC" +
                            "<br>" +
                            "<b>Humidity:</b> " +
                            weatherResponse.main!!.humidity +
                            "<br>" +
                            "<b>Pressure:</b> " +
                            weatherResponse.main!!.pressure)

                    weatherData!!.text = stringBuilder

                    tempView.text = ((weatherResponse.main!!.temp - 273).toString().substring(0,3) + "ºC")

                    cityView.text = weatherResponse.name

                    countryView.text = weatherResponse.sys!!.country

                    humidityView.text = "Humidity: "+ weatherResponse.main!!.humidity .toString() + "%"

                    tempmaxView.text = "Temp(Max): "+(weatherResponse.main!!.temp_max - 273).toString().substring(0,3) + "ºC"

                    tempminView.text =  "Temp(Min): "+(weatherResponse.main!!.temp_min - 273).toString().substring(0,3) + "ºC"

                    pressureView.text =   "Pressure: "+weatherResponse.main!!.pressure.toString() + "hPa"




                    if(  ((weatherResponse.main!!.temp -273).toInt()) >= 24  ){

                     view2.visibility = View.VISIBLE

                     }

                    else{

                     view2.visibility = View.INVISIBLE
                 }



                 if ((weatherResponse.main!!.humidity).toInt() > 0 )  {

                     emptyView.visibility = View.VISIBLE
                     halfView.visibility = View.INVISIBLE
                     fullView.visibility = View.INVISIBLE
                 }

                    if ((weatherResponse.main!!.humidity).toInt() > 33 )  {

                        emptyView.visibility = View.INVISIBLE
                        halfView.visibility = View.VISIBLE
                        fullView.visibility = View.INVISIBLE
                    }

                    if ((weatherResponse.main!!.humidity).toInt() > 66 )  {

                        emptyView.visibility = View.INVISIBLE
                        halfView.visibility = View.INVISIBLE
                        fullView.visibility = View.VISIBLE
                    }





                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                weatherData!!.text = t.message
            }



        })
    }

    companion object {

        // Here I set the base Url and enter my AppID for the API

        var BaseUrl = "http://api.openweathermap.org/"
        var AppId = "105a3b2bbde2b69346852934d6e8df73"

        var q = "london"
    }





}


