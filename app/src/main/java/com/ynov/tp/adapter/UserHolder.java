package com.ynov.tp.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ynov.tp.databinding.RowLayoutUserBinding;

public class UserHolder extends RecyclerView .ViewHolder{
    RowLayoutUserBinding binding;

    public UserHolder(@NonNull RowLayoutUserBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
