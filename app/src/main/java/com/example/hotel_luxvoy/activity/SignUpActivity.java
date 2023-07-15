package com.example.hotel_luxvoy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.ServiceAPI.APIService;
import com.example.hotel_luxvoy.models.UserModel;
import com.example.hotel_luxvoy.models.UserPostModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUpActivity extends AppCompatActivity {

    TextView tvPasswordLength, tvPasswordUpperCase, tvPasswordNumber, tvPasswordLowerCase, tvPasswordSpecialCharacter, tvSignIn;

    EditText edtFullName, edtUsername, edtPhoneNumber, edtWard, edtDistrict, edtStreet, edtPassword, edtConfirmPassword;

    Button btnSignUp;

    private boolean isAtLeast8 = false, hasUppercase = false, hasNumber = false, hasSymbol = false, hasLowercase = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        tvPasswordLength = findViewById(R.id.tvPasswordLength);
        tvPasswordUpperCase = findViewById(R.id.tvPasswordUpperCase);
        tvPasswordNumber = findViewById(R.id.tvPasswordNumber);
        tvPasswordLowerCase = findViewById(R.id.tvPasswordLowerCase);
        tvPasswordSpecialCharacter = findViewById(R.id.tvPasswordSpecialCharacter);
        tvSignIn = findViewById(R.id.tvSignIn);

        edtFullName = findViewById(R.id.edtFullName);
        edtUsername = findViewById(R.id.edtUsername);
        edtPhoneNumber = findViewById(R.id.edtPhoneNumber);
        edtWard = findViewById(R.id.edtWard);
        edtDistrict = findViewById(R.id.edtDistrict);
        edtStreet = findViewById(R.id.edtStreet);
        edtPassword = findViewById(R.id.edtPassword);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);

        btnSignUp = findViewById(R.id.btnSignUp);

        //retrofit API
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("172.16.92.242:6969/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService apiService = retrofit.create(APIService.class);

        //btn sign up
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                String fullName = edtFullName.getText().toString();
                String phoneNumber = edtPhoneNumber.getText().toString();
                String ward = edtWard.getText().toString();
                String district = edtDistrict.getText().toString();
                String street = edtStreet.getText().toString();

                postData(userName, password, fullName, phoneNumber, ward, district, street);
            }
        });

        tvSignIn.setOnClickListener(v -> {
            Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
            startActivity(intent);
        });


        edtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String password = s.toString();
                checkPasswordConditions(password);
                setTextColorBasedOnConditions();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void postData(String userName, String password, String fullName, String phoneNumber, String ward, String district, String street) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("172.16.92.242:6969/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService apiService = retrofit.create(APIService.class);
        UserPostModel userPostModel = new UserPostModel(userName, password, fullName, Integer.parseInt(phoneNumber), ward, district, street);
        Call<UserPostModel> call = apiService.createUser(userPostModel);
        call.enqueue(new Callback<UserPostModel>() {
            @Override
            public void onResponse(Call<UserPostModel> call, Response<UserPostModel> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(SignUpActivity.this, "Đăng ký Thành Công!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserPostModel> call, Throwable t) {
                Toast.makeText(SignUpActivity.this, "Đăng ký Thất Bại!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void checkPasswordConditions(String password) {
        isAtLeast8 = password.length() >= 8;
        hasUppercase = !password.equals(password.toLowerCase());
        hasLowercase = !password.equals(password.toUpperCase());
        hasNumber = password.matches(".*\\d.*");
        hasSymbol = !password.matches("[A-Za-z\\d ]*");
        // "\d" == [0-9].
    }

    private void setTextColorBasedOnConditions() {
        tvPasswordLength.setTextColor(isAtLeast8 ? Color.GREEN : Color.BLACK);
        tvPasswordUpperCase.setTextColor(hasUppercase ? Color.GREEN : Color.BLACK);
        tvPasswordNumber.setTextColor(hasNumber ? Color.GREEN : Color.BLACK);
        tvPasswordLowerCase.setTextColor(hasLowercase ? Color.GREEN : Color.BLACK);
        tvPasswordSpecialCharacter.setTextColor(hasSymbol ? Color.GREEN : Color.BLACK);
    }
}