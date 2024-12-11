package com.example.codingtestmjamal;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.codingtestmjamal.Model.Users;
import com.example.codingtestmjamal.Services.ApiService;
import com.example.codingtestmjamal.Services.RetrofitClient;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        EditText firstName = findViewById(R.id.firstName);
        EditText lastName = findViewById(R.id.lastName);

        EditText emailInput = findViewById(R.id.emailId);
        EditText password = findViewById(R.id.password);

        EditText roleid = findViewById(R.id.roleid);
        EditText isActiveInput = findViewById(R.id.isActive);

        Button submitButton = findViewById(R.id.submitButton);

        ApiService apiService = RetrofitClient.getInstance().create(ApiService.class);

        submitButton.setOnClickListener(v -> {
            String fName = firstName.getText().toString().trim();
            String lName = lastName.getText().toString().trim();
            String email = emailInput.getText().toString().trim();
            String pass = password.getText().toString().trim();
            int rid = Integer.parseInt(roleid.getText().toString().trim());
            boolean isAct = Boolean.parseBoolean(isActiveInput.getText().toString().trim());

            if (fName.isEmpty() || lName.isEmpty() || email.isEmpty() || pass.isEmpty()) {
                Toast.makeText(AddUserActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                return;
            }

            Users newUser = new Users(fName, lName, email, pass, rid, isAct);


            apiService.addUser(newUser).enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        Log.d("API Response", response.body().toString());
                    }
                    else {
                        try {
                            Log.e("API Error", "Error Body: " + response.errorBody().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(AddUserActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.e("API Error", "Request failed: " + t.getMessage());
                }
            });
        });
    }
}
