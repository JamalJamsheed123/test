package com.example.codingtestmjamal;

import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.codingtestmjamal.Model.Users;
import com.example.codingtestmjamal.Services.ApiService;
import com.example.codingtestmjamal.Services.RetrofitClient;

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
        EditText isActive = findViewById(R.id.isActive);

        Button submitButton = findViewById(R.id.submitButton);

        ApiService apiService = RetrofitClient.getInstance().create(ApiService.class);

        submitButton.setOnClickListener(v -> {
            String fName = firstName.getText().toString();
            String lName = lastName.getText().toString();
            String email = emailInput.getText().toString();
            String pass = password.getText().toString();
            int rid = roleid.getText().length();
            Boolean isAct = isActive.isActivated();

            Users newUser = new Users(fName, lName, email, pass, rid, isAct);
            apiService.addUser(newUser).enqueue(new Callback<Users>() {
                @Override
                public void onResponse(Call<Users> call, Response<Users> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(AddUserActivity.this, "User Added", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }

                @Override
                public void onFailure(Call<Users> call, Throwable t) {
                    Toast.makeText(AddUserActivity.this, "Failed to Add User", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}
