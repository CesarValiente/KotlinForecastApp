package com.cesarvaliente.kotlinforecastapp.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cesarvaliente.kotlinforecastapp.R
import com.cesarvaliente.kotlinforecastapp.domain.model.Forecast
import com.cesarvaliente.kotlinforecastapp.domain.model.ForecastList
import com.cesarvaliente.kotlinforecastapp.ui.utils.ctx
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_forecast.view.*

class ForecastListAdapter(private val weekForecast: ForecastList, private val itemClick: (Forecast) -> Unit) :
        RecyclerView.Adapter<ForecastListAdapter.Viewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)
        return Viewholder(view, itemClick)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    override fun getItemCount(): Int {
        return weekForecast.size()
    }

    class Viewholder(view: View, private val itemClick: (Forecast) -> Unit) :
            RecyclerView.ViewHolder(view) {

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(itemView.icon)
                itemView.date.text = date
                itemView.description.text = description
                itemView.maxTemperature.text = "${high.toString()} C"
                itemView.minTemperature.text = "${low.toString()} C"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}

