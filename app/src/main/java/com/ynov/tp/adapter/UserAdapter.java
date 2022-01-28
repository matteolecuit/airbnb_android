package com.ynov.tp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.ynov.tp.R;
import com.ynov.tp.bo.User;
import com.ynov.tp.databinding.RowLayoutUserBinding;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserHolder> {

    ArrayList<User> userArrayList;

    public UserAdapter(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowLayoutUserBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.row_layout_user,
                parent,
                false
        );
        return new UserHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        User user= userArrayList.get(position);
        holder.itemView.setOnClickListener(
                (view) -> Navigation.findNavController(holder.itemView)
                        .navigate(R.id.detailUserFragment)
        );
        holder.binding.setUser(user);
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }
}
