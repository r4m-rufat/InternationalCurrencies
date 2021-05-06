package com.kivitool.internationalcurrencies

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.kivitool.internationalcurrencies.Utils.BottomAppBar
import com.kivitool.internationalcurrencies.models.RatesListModel
import org.json.JSONObject

class EuroRate : AppCompatActivity() {

    var rateListModel = ArrayList<RatesListModel>()
    lateinit var bottomNavigationView: BottomNavigationView
    val url = "https://openexchangerates.org/api/latest.json?app_id=ba4baa2410654310a16d43418bd2f7dd"
    var euroRateList: ListView? = null
    var listView: com.kivitool.internationalcurrencies.Adapters.ListView? = null
    lateinit var floatingConverter: FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_euro_rate)

        euroRateList = findViewById(R.id.listViewForEUR)
        bottomNavigationView = findViewById(R.id.bottomnavigationview)
        floatingConverter = findViewById(R.id.floatingExchange)
        bottomNavigationView.background = null
        BottomAppBar().setupBottomAppBar(this@EuroRate, bottomNavigationView)
        floatingConverter.setOnClickListener {
            startActivity(Intent(this@EuroRate, MainActivity :: class.java))
        }


        var requestQueue = Volley.newRequestQueue(this@EuroRate)


        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
            Response.Listener { response ->

                var rates = response.getJSONObject("rates")
                getEuroRateList(rates)


            }, Response.ErrorListener {


            });

        requestQueue.add(jsonObjectRequest)



    }

    /**
     * gets euro rates and in this function euro is base currency
     */
    fun getEuroRateList(jsonObject: JSONObject){

        rateListModel.add(
            RatesListModel(
                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b7/Flag_of_Europe.svg/1200px-Flag_of_Europe.svg.png",
                "EUR",
                "Euro",
                "1",
                "€"
            )
        )
        rateListModel.add(
            RatesListModel(
                "https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/Flag_of_Australia_%28converted%29.svg/1200px-Flag_of_Australia_%28converted%29.svg.png",
                "AUD",
                "Australian Dollar",
                String.format(
                    "%.3f", jsonObject.getDouble(
                        "AUD"
                    ) / jsonObject.getDouble("EUR")
                ),
                "$"
            )
        )
        rateListModel.add(
            RatesListModel(
                "https://upload.wikimedia.org/wikipedia/commons/thumb/d/dd/Flag_of_Azerbaijan.svg/1200px-Flag_of_Azerbaijan.svg.png",
                "AZN",
                "Manat",
                String.format(
                    "%.3f", jsonObject.getDouble(
                        "AZN"
                    ) / jsonObject.getDouble("EUR")
                ),
                "₼"
            )
        )
        rateListModel.add(
            RatesListModel(
                "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Flag_of_Canada_%28Pantone%29.svg/1200px-Flag_of_Canada_%28Pantone%29.svg.png",
                "CAD",
                "Canadian Dollar",
                String.format(
                    "%.3f", jsonObject.getDouble(
                        "CAD"
                    ) / jsonObject.getDouble("EUR")
                ),
                "$"
            )
        )
        rateListModel.add(
            RatesListModel(
                "https://upload.wikimedia.org/wikipedia/en/thumb/a/ae/Flag_of_the_United_Kingdom.svg/1200px-Flag_of_the_United_Kingdom.svg.png",
                "GBP",
                "Pound Sterling",
                String.format(
                    "%.3f", jsonObject.getDouble(
                        "GBP"
                    ) / jsonObject.getDouble("EUR")
                ),
                "£"
            )
        )
        rateListModel.add(
            RatesListModel(
                "https://cdn.britannica.com/04/6204-004-DC5CFE4F/Flag-Bulgaria.jpg",
                "BGN",
                "Bulgarian Lev",
                String.format(
                    "%.3f", jsonObject.getDouble(
                        "BGN"
                    ) / jsonObject.getDouble("EUR")
                ),
                "Лв"
            )
        )
        rateListModel.add(
            RatesListModel(
                "https://cdn.britannica.com/97/1597-004-05816F4E/Flag-India.jpg",
                "INR",
                "Indian Rupee",
                String.format(
                    "%.3f", jsonObject.getDouble(
                        "INR"
                    ) / jsonObject.getDouble("EUR")
                ),
                "₹"
            )
        )
        rateListModel.add(
            RatesListModel(
                "https://cdn.britannica.com/02/2102-050-2976AFDD/Flag-Liechtenstein.jpg",
                "CHF",
                "Swiss Franc",
                String.format(
                    "%.3f", jsonObject.getDouble(
                        "CHF"
                    ) / jsonObject.getDouble("EUR")
                ),
                "Fr"
            )
        )
        rateListModel.add(
            RatesListModel(
                "https://cdn.countryflags.com/thumbs/japan/flag-800.png",
                "JPY",
                "Japanese Yen",
                String.format(
                    "%.3f", jsonObject.getDouble(
                        "JPY"
                    ) / jsonObject.getDouble("EUR")
                ),
                "¥"
            )
        )
        rateListModel.add(
            RatesListModel(
                "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/Flag_of_New_Zealand.svg/1024px-Flag_of_New_Zealand.svg.png",
                "NZD",
                "New Zealand dollar",
                String.format(
                    "%.3f", jsonObject.getDouble(
                        "NZD"
                    ) / jsonObject.getDouble("EUR")
                ),
                "$"
            )
        )
        rateListModel.add(
            RatesListModel(
                "https://upload.wikimedia.org/wikipedia/en/thumb/f/f3/Flag_of_Russia.svg/1200px-Flag_of_Russia.svg.png",
                "RUB",
                "Russian Ruble",
                String.format(
                    "%.3f", jsonObject.getDouble(
                        "RUB"
                    ) / jsonObject.getDouble("EUR")
                ),
                "₽"
            )
        )
        rateListModel.add(
            RatesListModel(
                "https://upload.wikimedia.org/wikipedia/en/thumb/a/a4/Flag_of_the_United_States.svg/1200px-Flag_of_the_United_States.svg.png",
                "USD",
                "American Dollar",
                String.format(
                    "%.3f", jsonObject.getDouble(
                        "CHF"
                    ) / jsonObject.getDouble("EUR")
                ),
                "$"
            )
        )
        rateListModel.add(
            RatesListModel(
                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/af/Flag_of_South_Africa.svg/1200px-Flag_of_South_Africa.svg.png",
                "ZAR",
                "South African Rand",
                String.format(
                    "%.3f", jsonObject.getDouble(
                        "ZAR"
                    ) / jsonObject.getDouble("EUR")
                ),
                "R"
            )
        )

        listView = com.kivitool.internationalcurrencies.Adapters.ListView(
            rateListModel,
            this@EuroRate
        )
        euroRateList!!.adapter = listView

    }

}