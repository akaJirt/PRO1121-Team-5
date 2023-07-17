package com.example.hotel_luxvoy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hotel_luxvoy.FullScreenHelper;
import com.example.hotel_luxvoy.R;

public class SignInActivity extends AppCompatActivity {
    TextView tvSignUp;

    EditText edtUsername, edtPassword;

    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FullScreenHelper.setFullScreen(this);
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
            Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
            Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });
    }
}