package com.kivitool.internationalcurrencies.Utils

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kivitool.internationalcurrencies.DollarRate
import com.kivitool.internationalcurrencies.EuroRate
import com.kivitool.internationalcurrencies.R

class BottomAppBar {

    fun setupBottomAppBar(context: Context, bottomNavigationView: BottomNavigationView){

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){

                R.id.usd_rate -> {

                    var intent = Intent(context, DollarRate:: class.java)
                    context.startActivity(intent)

                    return@setOnNavigationItemSelectedListener true

                }

                R.id.euro_rate -> {

                    var intent = Intent(context, EuroRate:: class.java)
                    context.startActivity(intent)

                    return@setOnNavigationItemSelectedListener true

                }

                else -> return@setOnNavigationItemSelectedListener false
            }
        }

    }

}