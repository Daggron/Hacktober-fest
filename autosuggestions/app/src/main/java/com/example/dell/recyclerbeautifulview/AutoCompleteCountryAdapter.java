package com.example.dell.recyclerbeautifulview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AutoCompleteCountryAdapter extends ArrayAdapter<CountryItem> {

    private List<CountryItem> countryListFull;
    public AutoCompleteCountryAdapter( Context context, List<CountryItem> countryList) {
        super(context,0,countryList);
        countryListFull = new ArrayList<>(countryList);

    }

    @NonNull
    @Override
    public Filter getFilter() {
        return countryFilter;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.country_autocomplete_row,parent,false);
        }

        TextView textViewName = convertView.findViewById(R.id.text_view_name);
        ImageView imageViewFlag = convertView.findViewById(R.id.image_view_flag);

        CountryItem countryItem = getItem(position);

        if(countryItem != null){
            textViewName.setText(countryItem.getCountryName());
            imageViewFlag.setImageResource(countryItem.getFlagImage());
        }
        return convertView;
    }

    private Filter countryFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            List<CountryItem> suggestion = new ArrayList<>();

            if(constraint == null || constraint.length() == 0){
                suggestion.addAll(countryListFull);
            }else{
                String filterPattern = constraint.toString().toLowerCase().trim();

                for(CountryItem item : countryListFull){
                    if(item.getCountryName().toLowerCase().contains(filterPattern)){
                        suggestion.add(item);
                    }
                }
            }
            results.values = suggestion;
            results.count = suggestion.size();

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
          clear();
          addAll((List)results.values);

          notifyDataSetChanged();
        }

        @Override
        public CharSequence convertResultToString(Object resultValue) {
            return ((CountryItem)resultValue).getCountryName();

        }
    };
}