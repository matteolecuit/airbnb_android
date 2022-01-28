package com.ynov.tp.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;
import com.ynov.tp.R;
import com.ynov.tp.bo.Housing;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DetailCityFragment extends Fragment {
    private static final String TAG = "DetailCitiesFragment";
    OkHttpClient client;
    String cityId;

    ImageView imageView;
    TextView textViewTitle, textViewPrice;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_city, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = new OkHttpClient();
        cityId= getArguments().getString("cityId");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        fetchHousing();
        super.onViewCreated(view, savedInstanceState);
        imageView = (ImageView) view.findViewById(R.id.imageView);
        textViewTitle = (TextView) view.findViewById(R.id.textViewTitle);
        textViewPrice = (TextView) view.findViewById(R.id.textViewPrice);
    }
    private void fetchHousing() {
        // retrieve place id
        Request requestHousings = new Request.Builder()
                .url("https://flutter-learning.mooo.com/logements?place.id="+cityId)
                .build();
        client.newCall(requestHousings).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.e(TAG, "onFailure: " + e.toString()) ;
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                Log.i(TAG, "onResponse: " + response);
                ArrayList<Housing> housings = new Gson().fromJson(
                        response.body().string(),
                        new TypeToken<ArrayList<Housing>>() {
                        }.getType()
                );
                Log.i(TAG, "onResponse: "+housings.size());
                getActivity().runOnUiThread(() -> {
                    if(!housings.isEmpty()) {
                        showFirstHousing(housings.get(0));
                    }
                });
            }

        });
    }
    private void showFirstHousing(Housing housing) {
        Picasso.get().load("https://flutter-learning.mooo.com"+housing.getIllustrations().getUrl()).into(imageView);
        textViewTitle.setText(housing.getTitle());
        textViewPrice.setText(housing.getPrice().toString() + "€ / night");
    }
}