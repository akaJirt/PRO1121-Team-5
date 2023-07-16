package com.example.hotel_luxvoy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hotel_luxvoy.FullScreenHelper;
import com.example.hotel_luxvoy.R;

public class SignUpActivity extends AppCompatActivity {

    TextView tvPasswordLength, tvPasswordUpperCase, tvPasswordNumber, tvPasswordLowerCase, tvPasswordSpecialCharacter, tvSignIn;

    EditText edtFullName, edtUsername, edtPhoneNumber, edtWard, edtDistrict, edtStreet, edtPassword, edtConfirmPassword;

    Button btnSignUp;

    private boolean isAtLeast8 = false, hasUppercase = false, hasNumber = false, hasSymbol = false, hasLowercase = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FullScreenHelper.setFullScreen(this);
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