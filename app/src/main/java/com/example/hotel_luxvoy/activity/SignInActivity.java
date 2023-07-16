package com.example.hotel_luxvoy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.ServiceAPI.APIService;
import com.example.hotel_luxvoy.models.UserLoginModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignInActivity extends AppCompatActivity {
    TextView tvSignUp;

    EditText edtUsername, edtPassword;

    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        tvSignUp = findViewById(R.id.tvSignUp);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnSignIn = findViewById(R.id.btnSignIn);

        tvSignUp.setOnClickListener(v -> {
            Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
            startActivity(intent);
        });

        btnSignIn.setOnClickListener(v -> {
            if(checklogin(edtUsername.getText().toString(), edtPassword.getText().toString())){
                Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(SignInActivity.this, "Sai tên đăng nhập hoặc mật khẩu", Toast.LENGTH_SHORT).show();
            }
        });
    }


    //ngủ dậy sẽ fix lỗi này
    private boolean checklogin(String toString, String toString1) {
        final boolean[] check = new boolean[1];
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://192.168.1.122:6969/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService apiService = retrofit.create(APIService.class);
        UserLoginModel userLoginModel = new UserLoginModel(toString, toString1);
        Call<UserLoginModel> call = apiService.checkLogin(userLoginModel);
        call.enqueue(new Callback<UserLoginModel>() {
            @Override
            public void onResponse(Call<UserLoginModel> call, Response<UserLoginModel> response) {
                if(response.isSuccessful()){
                    check[0] = true;
                }
                else {
                    check[0] = false;
                }
            }

            @Override
            public void onFailure(Call<UserLoginModel> call, Throwable t) {
                Toast.makeText(SignInActivity.this, "Lỗi kết nối", Toast.LENGTH_SHORT).show();
                Log.d("Log signin", "onFailure: "+t.getMessage());
                check[0] = false;

            }
        });
        return check[0];
    }
}