package com.kivitool.internationalcurrencies.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kivitool.internationalcurrencies.R;
import com.kivitool.internationalcurrencies.models.RatesListModel;

import java.util.ArrayList;

public class ListView extends BaseAdapter {

    private ArrayList<RatesListModel> listModel;
    private Context context;

    public ListView(ArrayList<RatesListModel> listModel, Context context) {
        this.listModel = listModel;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listModel.size();
    }

    @Override
    public Object getItem(int position) {
        return listModel.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_list_view_for_dollar_rate, parent, false);
        }

        ImageView flag = convertView.findViewById(R.id.flagUSA);
        TextView currencyShortName = convertView.findViewById(R.id.txtUSD);
        TextView currencyFullName = convertView.findViewById(R.id.txtAmericanDollar);
        TextView currencySymbol = convertView.findViewById(R.id.symbolDollar);
        TextView currencyRate = convertView.findViewById(R.id.dollarRate);

        Glide.with(context).load(listModel.get(position).getFlag()).into(flag);
        currencyShortName.setText(listModel.get(position).getCurrencyShortName());
        currencyFullName.setText(listModel.get(position).getCurrencyFullName());
        currencySymbol.setText(listModel.get(position).getCurrencySymbol());
        currencyRate.setText(listModel.get(position).getCurrencyRate());



        return convertView;
    }
}
