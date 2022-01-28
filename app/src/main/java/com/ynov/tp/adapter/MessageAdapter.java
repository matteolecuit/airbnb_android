package com.ynov.tp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.ynov.tp.R;
import com.ynov.tp.bo.Message;
import com.ynov.tp.databinding.RowLayoutMessageBinding;
import com.ynov.tp.fragment.ListMessageFragmentDirections;

import java.util.ArrayList;

/**
 * Created by quentin for tp on 17/12/2021.
 */
public class MessageAdapter extends RecyclerView.Adapter<MessageHolder> {
    ArrayList<Message> messageArrayList;

    public MessageAdapter() {
        messageArrayList = new ArrayList<>();
    }

    public void addMessage(Message m){
        messageArrayList.add(m);
        notifyItemInserted(messageArrayList.size()-1);
    }


    public void setMessageArrayList(ArrayList<Message> messageArrayList) {
        this.messageArrayList = messageArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MessageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowLayoutMessageBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.row_layout_message,
                parent,
                false
        );
        return new MessageHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageHolder holder, int position) {
        Message msg = messageArrayList.get(position);
        ListMessageFragmentDirections.ActionListMessageFragmentToDetailMessageFragment action =
                ListMessageFragmentDirections.actionListMessageFragmentToDetailMessageFragment(msg);
        holder.itemView.setOnClickListener(
                (view)-> Navigation.findNavController(holder.itemView)
                .navigate((NavDirections) action)
        );
        holder.binding.setMessage(msg);
    }

    @Override
    public int getItemCount() {
        return messageArrayList.size();
    }
}
