package com.cesarvaliente.kotlinforecastapp.domain.model


data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>) {
    operator fun get(position: Int) = dailyForecast[position]
    fun size() = dailyForecast.size
}

data class Forecast(internal val date: String, internal val description: String, internal val high: Int,
                    internal val low: Int, internal val iconUrl: String)
