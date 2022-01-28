package com.ynov.tp.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ynov.tp.R;
import com.ynov.tp.adapter.CitiesAdapter;
import com.ynov.tp.bo.City;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ListCitiesFragment extends Fragment {
    private static final String TAG = "ListCitiesFragment";
    OkHttpClient client;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = new OkHttpClient();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        fetchCities();
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_cities, container, false);

    }

    private void fetchCities() {
        Request requestCities = new Request.Builder()
                .url("https://flutter-learning.mooo.com/villes")
                .build();
        client.newCall(requestCities).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.e(TAG, "onFailure: " + e.toString()) ;
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                ArrayList<City> cities = new Gson().fromJson(
                        response.body().string(),
                        new TypeToken<ArrayList<City>>() {
                        }.getType()
                );
                getActivity().runOnUiThread(() -> {
                    showCities(cities);
                });
            }

        });
    }

    private void showCities(ArrayList<City> cities) {
        RecyclerView rv = getView().findViewById(R.id.recyclerView);
        CitiesAdapter adapter = new CitiesAdapter(cities);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(adapter);
    }
}
