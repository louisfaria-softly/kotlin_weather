package com.example.kotlin_weather

import com.google.gson.annotations.SerializedName

//This is where I handle the Response from the API


class WeatherResponse {

    @SerializedName("sys")
    var sys: Sys? = null

    @SerializedName("main")
    var main: Main? = null


    @SerializedName("name")
    var name: String? = null



}


class Main {
    @SerializedName("temp")
    var temp: Float = 0.0f
    @SerializedName("humidity")
    var humidity: Float = 0.0f
    @SerializedName("pressure")
    var pressure: Float = 0.0f
    @SerializedName("temp_min")
    var temp_min: Float = 0.0f
    @SerializedName("temp_max")
    var temp_max: Float = 0.0f

}

class Sys {
    @SerializedName("country")
    var country: String? = null
}






