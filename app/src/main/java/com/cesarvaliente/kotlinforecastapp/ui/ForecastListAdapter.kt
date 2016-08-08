package com.cesarvaliente.kotlinforecastapp.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.cesarvaliente.kotlinforecastapp.R
import com.cesarvaliente.kotlinforecastapp.domain.model.Forecast
import com.cesarvaliente.kotlinforecastapp.domain.model.ForecastList
import com.cesarvaliente.kotlinforecastapp.ui.utils.ctx
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

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
        private val iconView: ImageView
        private val dateView: TextView
        private val descriptionView: TextView
        private val maxTemperatureView: TextView
        private val minTemperatureView: TextView

        init {
            iconView = view.find(R.id.icon)
            dateView = view.find(R.id.date)
            descriptionView = view.find(R.id.description)
            maxTemperatureView = view.find(R.id.maxTemperature)
            minTemperatureView = view.find(R.id.minTemperature)
        }

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = "${high.toString()} C"
                minTemperatureView.text = "${low.toString()} C"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}

