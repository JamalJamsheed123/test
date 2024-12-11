package com.example.codingtestmjamal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.codingtestmjamal.Adapter.UserAdapter;
import com.example.codingtestmjamal.Model.Users;
import com.example.codingtestmjamal.Services.ApiService;
import com.example.codingtestmjamal.Services.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Button addUserButton = findViewById(R.id.addUserButton);

        ApiService apiService = RetrofitClient.getInstance().create(ApiService.class);

        apiService.getUsersLists().enqueue(new Callback<List< Users >>() {
            @Override
            public void onResponse(Call< List<Users> > call, Response<List<Users>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    userAdapter = new UserAdapter(response.body(), getApplicationContext());
                    recyclerView.setAdapter(userAdapter);

                }
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
                t.printStackTrace();
            }
        });

        addUserButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
            startActivity(intent);
        });
    }
}