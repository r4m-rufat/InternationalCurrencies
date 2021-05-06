package com.kivitool.internationalcurrencies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.kivitool.internationalcurrencies.Utils.BottomAppBar
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    var txtCurrency: TextView? = null
    var bottomNavigationView: BottomNavigationView? = null
    var fromSpinner: Spinner? = null
    var toSpinner: Spinner? = null
    lateinit var text0: TextView
    lateinit var text1: TextView
    lateinit var text2: TextView
    lateinit var text3: TextView
    lateinit var text4: TextView
    lateinit var text5: TextView
    lateinit var text6: TextView
    lateinit var text7: TextView
    lateinit var text8: TextView
    lateinit var text9: TextView
    lateinit var textPoint: TextView
    lateinit var icRemove: ImageView
    lateinit var fromText: TextView
    lateinit var toText: TextView
    lateinit var icConvert: FloatingActionButton
    lateinit var requestQueue: RequestQueue
    val url =
        "https://openexchangerates.org/api/latest.json?app_id=ba4baa2410654310a16d43418bd2f7dd"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getWidgets()
        setupCustomKeyboard()
        setupFromAndToSpinners()

        BottomAppBar().setupBottomAppBar(this@MainActivity, bottomNavigationView!!)


        icConvert.setOnClickListener {
            getCurrencyInformations()
        }


    }

    fun getCurrencyInformations() {

        requestQueue = Volley.newRequestQueue(this@MainActivity)

        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
            Response.Listener { response ->
                var rates = response.getJSONObject("rates")

                setupFromAndToCurrencies(rates)


            }, Response.ErrorListener {


            })

        requestQueue.add(jsonObjectRequest)

    }


    fun getWidgets() {

        fromSpinner = findViewById(R.id.spinner1)
        toSpinner = findViewById(R.id.spinner2)
        text0 = findViewById(R.id.text0)
        text1 = findViewById(R.id.text1)
        text2 = findViewById(R.id.text2)
        text3 = findViewById(R.id.text3)
        text4 = findViewById(R.id.text4)
        text5 = findViewById(R.id.text5)
        text6 = findViewById(R.id.text6)
        text7 = findViewById(R.id.text7)
        text8 = findViewById(R.id.text8)
        text9 = findViewById(R.id.text9)
        textPoint = findViewById(R.id.textPoint)
        icRemove = findViewById(R.id.icRemove)
        fromText = findViewById(R.id.fromTextCurrency)
        toText = findViewById(R.id.toTxtCurrency)
        icConvert = findViewById(R.id.floatingExchange)

        bottomNavigationView = findViewById(R.id.bottomnavigationview)
        bottomNavigationView?.background = null

    }

    /**
     * set all converter values after jsonObject which get currencies from rates
     */
    fun setupFromAndToCurrencies(jsonObject: JSONObject) {

        var txtTo = toSpinner!!.selectedItem

        when (fromSpinner!!.selectedItem) {

            "USD" -> when (txtTo) {

                "AUD" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString().toDouble() * jsonObject.getDouble("AUD"))
                    )
                )
                "AZN" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString().toDouble() * jsonObject.getDouble("AZN"))
                    )
                )
                "BGN" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString().toDouble() * jsonObject.getDouble("BGN"))
                    )
                )
                "CAD" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString().toDouble() * jsonObject.getDouble("CAD"))
                    )
                )
                "CHF" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString().toDouble() * jsonObject.getDouble("CHF"))
                    )
                )
                "EUR" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString().toDouble() * jsonObject.getDouble("EUR"))
                    )
                )
                "GBP" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString().toDouble() * jsonObject.getDouble("GBP"))
                    )
                )
                "INR" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString().toDouble() * jsonObject.getDouble("INR"))
                    )
                )
                "JPY" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString().toDouble() * jsonObject.getDouble("JPY"))
                    )
                )
                "NZD" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString().toDouble() * jsonObject.getDouble("NZD"))
                    )
                )
                "RUB" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString().toDouble() * jsonObject.getDouble("RUB"))
                    )
                )
                "USD" -> toText.setText(fromText.text.toString())
                "ZAR" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString().toDouble() * jsonObject.getDouble("ZAR"))
                    )
                )

            }

            "EUR" -> when (txtTo) {

                "AUD" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString()
                            .toDouble() * jsonObject.getDouble("AUD") / jsonObject.getDouble("EUR"))
                    )
                )
                "AZN" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString()
                            .toDouble() * jsonObject.getDouble("AZN") / jsonObject.getDouble("EUR"))
                    )
                )
                "BGN" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString()
                            .toDouble() * jsonObject.getDouble("BGN") / jsonObject.getDouble("EUR"))
                    )
                )
                "CAD" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString()
                            .toDouble() * jsonObject.getDouble("CAD") / jsonObject.getDouble("EUR"))
                    )
                )
                "CHF" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString()
                            .toDouble() * jsonObject.getDouble("CHF") / jsonObject.getDouble("EUR"))
                    )
                )
                "EUR" -> toText.setText(fromText.text.toString())
                "GBP" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString()
                            .toDouble() * jsonObject.getDouble("GBP") / jsonObject.getDouble("EUR"))
                    )
                )
                "INR" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString()
                            .toDouble() * jsonObject.getDouble("INR") / jsonObject.getDouble("EUR"))
                    )
                )
                "JPY" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString()
                            .toDouble() * jsonObject.getDouble("JPY") / jsonObject.getDouble("EUR"))
                    )
                )
                "NZD" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString()
                            .toDouble() * jsonObject.getDouble("NZD") / jsonObject.getDouble("EUR"))
                    )
                )
                "RUB" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString()
                            .toDouble() * jsonObject.getDouble("RUB") / jsonObject.getDouble("EUR"))
                    )
                )
                "USD" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString()
                            .toDouble() * jsonObject.getDouble("USD") / jsonObject.getDouble("EUR"))
                    )
                )
                "ZAR" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString()
                            .toDouble() * jsonObject.getDouble("ZAR") / jsonObject.getDouble("EUR"))
                    )
                )

            }

            "AZN" -> when (txtTo) {

                "AUD" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString()
                            .toDouble() * jsonObject.getDouble("AUD") / jsonObject.getDouble("AZN"))
                    )
                )
                "AZN" -> toText.setText(fromText.text.toString())
                "BGN" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString()
                            .toDouble() * jsonObject.getDouble("BGN") / jsonObject.getDouble("AZN"))
                    )
                )
                "CAD" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString()
                            .toDouble() * jsonObject.getDouble("CAD") / jsonObject.getDouble("AZN"))
                    )
                )
                "CHF" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString()
                            .toDouble() * jsonObject.getDouble("CHF") / jsonObject.getDouble("AZN"))
                    )
                )
                "EUR" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString()
                            .toDouble() * jsonObject.getDouble("EUR") / jsonObject.getDouble("AZN"))
                    )
                )
                "GBP" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString()
                            .toDouble() * jsonObject.getDouble("GBP") / jsonObject.getDouble("AZN"))
                    )
                )
                "INR" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString()
                            .toDouble() * jsonObject.getDouble("INR") / jsonObject.getDouble("AZN"))
                    )
                )
                "JPY" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString()
                            .toDouble() * jsonObject.getDouble("JPY") / jsonObject.getDouble("AZN"))
                    )
                )
                "NZD" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString()
                            .toDouble() * jsonObject.getDouble("NZD") / jsonObject.getDouble("AZN"))
                    )
                )
                "RUB" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString()
                            .toDouble() * jsonObject.getDouble("RUB") / jsonObject.getDouble("AZN"))
                    )
                )
                "USD" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString()
                            .toDouble() * jsonObject.getDouble("USD") / jsonObject.getDouble("AZN"))
                    )
                )
                "ZAR" -> toText.setText(
                    String.format(
                        "%.3f",
                        (fromText.text.toString()
                            .toDouble() * jsonObject.getDouble("ZAR") / jsonObject.getDouble("AZN"))
                    )
                )

            }

        }


    }

    /*
    spinner adapter and item of list set in this function
     */
    fun setupFromAndToSpinners() {

        var fromCurrencies: MutableList<String> = arrayListOf()
        var toCurrencies: MutableList<String> = arrayListOf()
        fromCurrencies.addAll(listOf("AZN", "EUR", "USD"))
        toCurrencies.addAll(
            listOf(
                "AUD",
                "AZN",
                "BGN",
                "CAD",
                "CHF",
                "EUR",
                "GBP",
                "INR",
                "JPY",
                "NZD",
                "RUB",
                "USD",
                "ZAR"
            )
        )

        var fromAdapter = ArrayAdapter<String>(
            this@MainActivity,
            R.layout.support_simple_spinner_dropdown_item,
            fromCurrencies
        )
        var toAdapter = ArrayAdapter<String>(
            this@MainActivity,
            R.layout.support_simple_spinner_dropdown_item,
            toCurrencies
        )

        fromSpinner!!.adapter = fromAdapter
        toSpinner!!.adapter = toAdapter

    }

    /**
     * the buttons of keyboard which use in exchange page
     */
    fun setupCustomKeyboard() {

        fromText.text = "1"

        text0.setOnClickListener {
            if (fromText.text.toString() != "0") {
                fromText.text = fromText.text.toString() + "0"
            }
        }

        text1.setOnClickListener {
            if (fromText.text.toString() != "0") {
                fromText.text = fromText.text.toString() + "1"
            } else {
                fromText.text = "1"
            }
        }

        text2.setOnClickListener {
            if (fromText.text.toString() != "0") {
                fromText.text = fromText.text.toString() + "2"
            } else {
                fromText.text = "2"
            }

        }

        text3.setOnClickListener {
            if (fromText.text.toString() != "0") {
                fromText.text = fromText.text.toString() + "3"
            } else {
                fromText.text = "3"
            }

        }

        text4.setOnClickListener {
            if (fromText.text.toString() != "0") {
                fromText.text = fromText.text.toString() + "4"
            } else {
                fromText.text = "4"
            }
        }

        text5.setOnClickListener {
            if (fromText.text.toString() != "0") {
                fromText.text = fromText.text.toString() + "5"
            } else {
                fromText.text = "5"
            }
        }

        text6.setOnClickListener {
            if (fromText.text.toString() != "0") {
                fromText.text = fromText.text.toString() + "6"
            } else {
                fromText.text = "6"
            }
        }

        text7.setOnClickListener {
            if (fromText.text.toString() != "0") {
                fromText.text = fromText.text.toString() + "7"
            } else {
                fromText.text = "7"
            }
        }

        text8.setOnClickListener {
            if (fromText.text.toString() != "0") {
                fromText.text = fromText.text.toString() + "8"
            } else {
                fromText.text = "8"
            }
        }

        text9.setOnClickListener {
            if (fromText.text.toString() != "0") {
                fromText.text = fromText.text.toString() + "9"
            } else {
                fromText.text = "9"
            }
        }

        textPoint.setOnClickListener {
            fromText.text = fromText.text.toString() + "."
        }

        icRemove.setOnClickListener {
            if (fromText.text.toString().length != 1) {
                fromText.text = fromText.text.toString().dropLast(1)
            } else if (fromText.text.length == 1 && fromText.text.toString() != "0") {
                fromText.text = "0"
            }
        }

    }

}