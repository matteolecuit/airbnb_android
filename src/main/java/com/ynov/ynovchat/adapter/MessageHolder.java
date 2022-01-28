package com.ynov.tp.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ynov.tp.databinding.RowLayoutMessageBinding;

/**
 * Created by quentin for tp on 17/12/2021.
 */
class MessageHolder extends RecyclerView.ViewHolder {
    RowLayoutMessageBinding binding;

    public MessageHolder(@NonNull RowLayoutMessageBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
