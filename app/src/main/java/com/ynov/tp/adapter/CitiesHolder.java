package com.ynov.tp.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ynov.tp.databinding.RowLayoutCitiesBinding;

public class CitiesHolder extends RecyclerView .ViewHolder{
    RowLayoutCitiesBinding binding;

    public CitiesHolder(@NonNull RowLayoutCitiesBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
