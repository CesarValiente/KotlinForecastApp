package com.cesarvaliente.kotlinforecastapp.domain.commands

import com.cesarvaliente.kotlinforecastapp.domain.mappers.ForecastDataMapper
import com.cesarvaliente.kotlinforecastapp.domain.model.ForecastList
import com.cesarvaliente.kotlinforecastapp.net.ForecastRequest

class RequestForecastCommand(private val zipCode: String) : Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}