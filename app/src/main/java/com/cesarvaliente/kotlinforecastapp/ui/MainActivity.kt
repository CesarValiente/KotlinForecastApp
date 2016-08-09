package com.cesarvaliente.kotlinforecastapp.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.cesarvaliente.kotlinforecastapp.R
import com.cesarvaliente.kotlinforecastapp.domain.commands.RequestForecastCommand
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindViews()
    }

    private fun bindViews() {
        //Conventional way
        //val forecastList = findViewById(R.id.forecast_list) as RecyclerView

        //Using Anko. Creates and extension function of the Activity (check source code of "find")
//        val forecastList: RecyclerView = find(R.id.forecast_list)

        //Using Kotlin Android Extensions we just use the name given by its id in the xml (forecastList)
        foreCastList.layoutManager = LinearLayoutManager(this)

        doAsync() {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                val adapter = ForecastListAdapter(result) { toast(it.date) }
                foreCastList.adapter = adapter
            }
        }
    }

}
