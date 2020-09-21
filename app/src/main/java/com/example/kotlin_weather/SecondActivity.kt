package com.example.kotlin_weather

import android.os.Bundle
import android.text.Html
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SecondActivity: AppCompatActivity() {


    private var weatherData: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        weatherData = findViewById(R.id.textView2)



    }






    private fun getCurrentData1(text: String) {

        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(DailyService::class.java)
        val call = service.getDailyData(text, AppId)

        call.enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                if (response.code() == 200) {
                    val weatherResponse = response.body()!!

                    val stringBuilder = Html.fromHtml("<b>Country:</b> " +
                            weatherResponse.sys!!.country +

                            "<b>City:</b> " +
                            weatherResponse.name +

                            "<br>" +
                            "<b>Temp:</b> " +
                            (weatherResponse.main!!.temp - 273).toString().substring(0,3) + " ºC" +
                            "<br>" +
                            "<b>Temp(Min):</b> " +
                            (weatherResponse.main!!.temp_min - 273).toString().substring(0,3) + " ºC" +
                            "<br>" +
                            "<b>Temp(Max):</b> " +
                            (weatherResponse.main!!.temp_max - 273).toString().substring(0,3) + " ºC" +
                            "<br>" +
                            "<b>Humidity:</b> " +
                            weatherResponse.main!!.humidity +
                            "<br>" +
                            "<b>Pressure:</b> " +
                            weatherResponse.main!!.pressure)

                    weatherData!!.text = stringBuilder
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                weatherData!!.text = t.message
            }



        })
    }

    private fun getCurrentData2(text: String) {

        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(DailyService::class.java)
        val call = service.getDailyData(text, AppId)

        call.enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                if (response.code() == 200) {
                    val weatherResponse = response.body()!!

                    val stringBuilder = Html.fromHtml("<b>Country:</b> " +
                            weatherResponse.sys!!.country +

                            "<b>City:</b> " +
                            weatherResponse.name +

                            "<br>" +
                            "<b>Temp:</b> " +
                            (weatherResponse.main!!.temp - 273).toString().substring(0,3) + " ºC" +
                            "<br>" +
                            "<b>Temp(Min):</b> " +
                            (weatherResponse.main!!.temp_min - 273).toString().substring(0,3) + " ºC" +
                            "<br>" +
                            "<b>Temp(Max):</b> " +
                            (weatherResponse.main!!.temp_max - 273).toString().substring(0,3) + " ºC" +
                            "<br>" +
                            "<b>Humidity:</b> " +
                            weatherResponse.main!!.humidity +
                            "<br>" +
                            "<b>Pressure:</b> " +
                            weatherResponse.main!!.pressure)

                    weatherData!!.text = stringBuilder
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                weatherData!!.text = t.message
            }



        })
    }


    private fun getCurrentData3(text: String) {

        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(DailyService::class.java)
        val call = service.getDailyData(text, AppId)

        call.enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                if (response.code() == 200) {
                    val weatherResponse = response.body()!!

                    val stringBuilder = Html.fromHtml("<b>Country:</b> " +
                            weatherResponse.sys!!.country +

                            "<b>City:</b> " +
                            weatherResponse.name +

                            "<br>" +
                            "<b>Temp:</b> " +
                            (weatherResponse.main!!.temp - 273).toString().substring(0,3) + " ºC" +
                            "<br>" +
                            "<b>Temp(Min):</b> " +
                            (weatherResponse.main!!.temp_min - 273).toString().substring(0,3) + " ºC" +
                            "<br>" +
                            "<b>Temp(Max):</b> " +
                            (weatherResponse.main!!.temp_max - 273).toString().substring(0,3) + " ºC" +
                            "<br>" +
                            "<b>Humidity:</b> " +
                            weatherResponse.main!!.humidity +
                            "<br>" +
                            "<b>Pressure:</b> " +
                            weatherResponse.main!!.pressure)

                    weatherData!!.text = stringBuilder
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                weatherData!!.text = t.message
            }



        })
    }

    companion object {

        var BaseUrl = "http://api.openweathermap.org/"
        var AppId = "2e65127e909e178d0af311a81f39948c"
        var lat = "40.4167"
        var lon = "-3.7036"
        var q = "london"
    }

}