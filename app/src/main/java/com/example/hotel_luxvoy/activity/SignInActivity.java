package com.example.hotel_luxvoy.activity;

import static com.example.hotel_luxvoy.ServiceAPI.APIService.BASE_URL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hotel_luxvoy.FullScreenHelper;
import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.ServiceAPI.APIService;
import com.example.hotel_luxvoy.models.Hotel;
import com.example.hotel_luxvoy.models.UserAfterCheckLG;
import com.example.hotel_luxvoy.models.UserLoginModel;
import com.google.gson.Gson;

import java.util.ArrayList;

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
        FullScreenHelper.setFullScreen(this);
        setContentView(R.layout.activity_sign_in);

        tvSignUp = findViewById(R.id.tvSignUp);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        Intent intent1 = getIntent();
        if(intent1.getSerializableExtra("user") != null){
            UserAfterCheckLG userAfterCheckLG = (UserAfterCheckLG) intent1.getSerializableExtra("user");
            edtUsername.setText(userAfterCheckLG.getPhoneNumber());
        }

        tvSignUp.setOnClickListener(v -> {
            Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
            startActivity(intent);
        });

        btnSignIn.setOnClickListener(v -> {
            if(edtUsername.getText().toString().isEmpty() || edtPassword.getText().toString().isEmpty()){
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }
            else {
                Toast.makeText(this, "Đang đăng nhập", Toast.LENGTH_SHORT).show();
                checklogin(edtUsername.getText().toString(), edtPassword.getText().toString());
            }

            Log.d("login button>>>>>>>>>", "onCreate: "+edtUsername.getText().toString()+" "+edtPassword.getText().toString());
        });
    }




    //ngủ dậy sẽ fix lỗi này
    private void checklogin(String toString, String toString1) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService apiService = retrofit.create(APIService.class);
        UserLoginModel userLoginModel = new UserLoginModel(toString, toString1);
        Call<UserAfterCheckLG> call = apiService.checkLogin(userLoginModel);
        call.enqueue(new Callback<UserAfterCheckLG>() {
            @Override
            public void onResponse(Call<UserAfterCheckLG> call, Response<UserAfterCheckLG> response) {
                if(response.isSuccessful()){
                    Toast.makeText(SignInActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    UserAfterCheckLG userAfterCheckLG = response.body();

                    Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("user", userAfterCheckLG);
                    //save user to share preference
                    Gson gson = new Gson();
                    String json = gson.toJson(userAfterCheckLG);
                    SharedPreferences.Editor editor = getSharedPreferences("user", MODE_PRIVATE).edit();
                    editor.putString("user", json);
                    editor.apply();
                    //end save user to share preference
                    intent.putExtras(bundle);

                    startActivity(intent);
                }
                else {
                    Log.d("TAG", "onResponse: "+response.body());
                    Toast.makeText(SignInActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }



            }

            @Override
            public void onFailure(Call<UserAfterCheckLG> call, Throwable t) {
                Toast.makeText(SignInActivity.this, "Lỗi kết nối", Toast.LENGTH_SHORT).show();
                Log.d("Log signin", "onFailure: "+t.getMessage());


            }
        });
    }


}