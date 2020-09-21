package com.example.kotlin_weather

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


// This is the to perform a GET to the API

interface WeatherService {
    @GET("data/2.5/weather?")
    fun getCurrentWeatherData(@Query("q") q: String, @Query("APPID") app_id: String): Call<WeatherResponse>
}

interface DailyService {
    @GET("data/2.5/weather?")
    fun getDailyData(@Query("q") q: String, @Query("APPID") app_id: String): Call<WeatherResponse>
}

