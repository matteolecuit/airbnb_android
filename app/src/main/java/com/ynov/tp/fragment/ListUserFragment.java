package com.ynov.tp.fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
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
import com.ynov.tp.adapter.UserAdapter;
import com.ynov.tp.bo.User;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ListUserFragment extends Fragment {
    private static final String TAG = "ListUserFragment";
    OkHttpClient client;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = new OkHttpClient();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //Button button = view.findViewById(R.id.buttonToDetail);
        //button.setOnClickListener(thisButton -> Navigation.findNavController(view).navigate(R.id.action_listMessageFragment_to_detailMessageFragment));
        fetchUsers();
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_user, container, false);

    }

    private void fetchUsers() {
        SharedPreferences sp = getContext().getSharedPreferences(getString(R.string.spConfigName), MODE_PRIVATE);
        String token = sp.getString(getString(R.string.keyJwt), "henlo");
        Request requestUser = new Request.Builder()
                .url("https://flutter-learning.mooo.com/users")
                .header("Authorization", "Bearer " + token)
                .build();
        client.newCall(requestUser).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.e(TAG, "onFailure: " + e.getMessage());

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                ArrayList<User> users = new Gson().fromJson(
                        response.body().string(),
                        new TypeToken<ArrayList<User>>() {
                        }.getType()
                );
                getActivity().runOnUiThread(() -> {
                    showUsers(users);
                });
            }

        });
    }

    private void showUsers(ArrayList<User> users) {
        RecyclerView rv = getView().findViewById(R.id.recyclerView);
        UserAdapter adapter = new UserAdapter(users);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(adapter);
    }
}
