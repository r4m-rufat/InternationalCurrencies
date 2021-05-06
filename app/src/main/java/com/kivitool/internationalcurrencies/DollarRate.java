package com.kivitool.internationalcurrencies;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kivitool.internationalcurrencies.Utils.BottomAppBar;
import com.kivitool.internationalcurrencies.models.RatesListModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DollarRate extends AppCompatActivity {

    private Context context;
    private ArrayList<RatesListModel> ratesListItems;
    private RequestQueue requestQueue;
    private static final String url = "https://openexchangerates.org/api/latest.json?app_id=ba4baa2410654310a16d43418bd2f7dd";
    private static final String TAG = "Top3CurrenciesActivity";
    private ListView listView;
    private com.kivitool.internationalcurrencies.Adapters.ListView currenciesListAdapter;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dollar_rate);

        context = this;
        requestQueue = new Volley().newRequestQueue(context);
        listView = findViewById(R.id.listViewForUSD);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnavigationview);
        bottomNavigationView.setBackground(null); // to do transparent view color of bottomnavigation

        floatingActionButton = findViewById(R.id.floatingExchange);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, MainActivity.class));
            }
        });

        new BottomAppBar().setupBottomAppBar(context, bottomNavigationView);  // bottomappbar is helpful class

        ratesListItems = new ArrayList<>();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONObject jsonObject = response.getJSONObject("rates");

                            setListModel(jsonObject);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "OnErrorReponse: " + error.getMessage());
            }
        });

        requestQueue.add(jsonObjectRequest);

    }

    /**
     * gets dollar rates and in this function dollar is base currency
     */
    @SuppressLint("DefaultLocale")
    private void setListModel(JSONObject jsonObject) {

        try {

            ratesListItems.add(new RatesListModel("https://upload.wikimedia.org/wikipedia/en/thumb/a/a4/Flag_of_the_United_States.svg/1200px-Flag_of_the_United_States.svg.png", "USD", "American Dollar", "1", "$"));
            ratesListItems.add(new RatesListModel("https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/Flag_of_Australia_%28converted%29.svg/1200px-Flag_of_Australia_%28converted%29.svg.png", "AUD", "Australian Dollar", String.format("%.3f", jsonObject.getDouble("AUD")), "$"));
            ratesListItems.add(new RatesListModel("https://upload.wikimedia.org/wikipedia/commons/thumb/d/dd/Flag_of_Azerbaijan.svg/1200px-Flag_of_Azerbaijan.svg.png", "AZN", "Manat", String.format("%.3f", jsonObject.getDouble("AZN")), "₼"));
            ratesListItems.add(new RatesListModel("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Flag_of_Canada_%28Pantone%29.svg/1200px-Flag_of_Canada_%28Pantone%29.svg.png", "CAD", "Canadian Dollar", String.format("%.3f", jsonObject.getDouble("CAD")), "$"));
            ratesListItems.add(new RatesListModel("https://upload.wikimedia.org/wikipedia/commons/thumb/b/b7/Flag_of_Europe.svg/1200px-Flag_of_Europe.svg.png", "EUR", "Euro", String.format("%.3f", jsonObject.getDouble("EUR")), "€"));
            ratesListItems.add(new RatesListModel("https://upload.wikimedia.org/wikipedia/en/thumb/a/ae/Flag_of_the_United_Kingdom.svg/1200px-Flag_of_the_United_Kingdom.svg.png", "GBP", "Pound Sterling", String.format("%.3f", jsonObject.getDouble("GBP")), "£"));
            ratesListItems.add(new RatesListModel("https://cdn.britannica.com/04/6204-004-DC5CFE4F/Flag-Bulgaria.jpg", "BGN", "Bulgarian Lev", String.format("%.3f", jsonObject.getDouble("BGN")), "Лв"));
            ratesListItems.add(new RatesListModel("https://cdn.britannica.com/97/1597-004-05816F4E/Flag-India.jpg", "INR", "Indian Rupee", String.format("%.3f", jsonObject.getDouble("INR")), "₹"));
            ratesListItems.add(new RatesListModel("https://cdn.britannica.com/02/2102-050-2976AFDD/Flag-Liechtenstein.jpg", "CHF", "Swiss Franc", String.format("%.3f", jsonObject.getDouble("CHF")), "Fr"));
            ratesListItems.add(new RatesListModel("https://cdn.countryflags.com/thumbs/japan/flag-800.png", "JPY", "Japanese Yen", String.format("%.3f", jsonObject.getDouble("JPY")), "¥"));
            ratesListItems.add(new RatesListModel("https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/Flag_of_New_Zealand.svg/1024px-Flag_of_New_Zealand.svg.png", "NZD", "New Zealand dollar", String.format("%.3f", jsonObject.getDouble("NZD")), "$"));
            ratesListItems.add(new RatesListModel("https://upload.wikimedia.org/wikipedia/en/thumb/f/f3/Flag_of_Russia.svg/1200px-Flag_of_Russia.svg.png", "RUB", "Russian Ruble", String.format("%.3f", jsonObject.getDouble("RUB")), "₽"));
            ratesListItems.add(new RatesListModel("https://upload.wikimedia.org/wikipedia/commons/thumb/a/af/Flag_of_South_Africa.svg/1200px-Flag_of_South_Africa.svg.png", "ZAR", "South African Rand", String.format("%.3f", jsonObject.getDouble("ZAR")), "R"));


            currenciesListAdapter = new com.kivitool.internationalcurrencies.Adapters.ListView(ratesListItems, context);
            listView.setAdapter(currenciesListAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}