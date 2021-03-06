package com.ynov.tp.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.ynov.tp.R;
import com.ynov.tp.bo.City;
import com.ynov.tp.databinding.RowLayoutCitiesBinding;

import java.util.ArrayList;

public class CitiesAdapter extends RecyclerView.Adapter<CitiesHolder> {

    ArrayList<City> citiesArrayList;

    public CitiesAdapter(ArrayList<City> citiesArrayList) {
        this.citiesArrayList = citiesArrayList;
    }

    @NonNull
    @Override
    public CitiesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowLayoutCitiesBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.row_layout_cities,
                parent,
                false
        );
        return new CitiesHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CitiesHolder holder, int position) {
        City city= citiesArrayList.get(position);
        Bundle bundle = new Bundle();
        bundle.putString("cityId", city.getId());
        holder.itemView.setOnClickListener(
                (view) -> Navigation.findNavController(holder.itemView)
                        .navigate(R.id.detailCityFragment, bundle)
        );
        holder.binding.setCity(city);
        if(city.getPic().getUrl().length() > 0) {
            Picasso.get()
                    .load("https://flutter-learning.mooo.com"+city.getPic().getUrl()).resize(50, 50).into(holder.binding.imageView);
        }

    }

    @Override
    public int getItemCount() {
        return citiesArrayList.size();
    }
}
