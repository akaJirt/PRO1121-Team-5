package com.example.hotel_luxvoy.fragment;

import static android.content.Context.MODE_PRIVATE;
import static com.example.hotel_luxvoy.ServiceAPI.APIService.BASE_URL;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.DialogFragment;

import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.ServiceAPI.APIService;
import com.example.hotel_luxvoy.activity.ConfirmAndPayActivity;
import com.example.hotel_luxvoy.activity.HomeActivity;
import com.example.hotel_luxvoy.models.BillChangeSTT;
import com.example.hotel_luxvoy.models.UserAfterCheckLG;
import com.example.hotel_luxvoy.models.UserLoginModel;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FramentDialog extends DialogFragment {
    private static final  String TAG = "FramentDialog";
    private AppCompatButton btnCanncelDiaLog, btnYesDialog;
    private Context context;

    public FramentDialog(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_cancel,container,false);
        btnCanncelDiaLog = view.findViewById(R.id.btnCancelDialog);
        btnYesDialog = view.findViewById(R.id.btnYesDialog);

        btnCanncelDiaLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: closing dialog");
                getDialog().dismiss();
            }
        });

        btnYesDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getArguments();
                if (bundle != null){
                    String id = bundle.getString("idbill");
                    //tách chuỗi
                    String[] parts = id.split(" ");
                    String part1 = parts[0]; // 123
                    String part2 = parts[1]; // 654321
                    String part3 = parts[2]; // 654321
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    APIService apiService = retrofit.create(APIService.class);
                    BillChangeSTT billChangeSTT = new BillChangeSTT(part3,"cancelled");
                    Call<BillChangeSTT> call = apiService.changeBillStatus(billChangeSTT);
                    call.enqueue(new Callback<BillChangeSTT>() {
                        @Override
                        public void onResponse(Call<BillChangeSTT> call, Response<BillChangeSTT> response) {
                            Log.d(TAG, "onResponse: "+response.body());
                            SharedPreferences sharedPreferences = context.getSharedPreferences("user", MODE_PRIVATE);
                            Gson gson = new Gson();
                            String json = sharedPreferences.getString("user", "");
                            UserAfterCheckLG userAfterCheckLG = gson.fromJson(json, UserAfterCheckLG.class);
                            reCheckLogin(userAfterCheckLG.getPhoneNumber(), userAfterCheckLG.getPassword());

                        }

                        @Override
                        public void onFailure(Call<BillChangeSTT> call, Throwable t) {
                            Log.d(TAG, "onFailure: "+t.getMessage());
                        }
                    });


                }

                getDialog().dismiss();
            }
        });




        return view;
    }

    private void reCheckLogin(String userName, String password){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService apiService = retrofit.create(APIService.class);
        UserLoginModel userLoginModel = new UserLoginModel(userName, password);
        Call<UserAfterCheckLG> call = apiService.checkLogin(userLoginModel);
        call.enqueue(new Callback<UserAfterCheckLG>() {
            @Override
            public void onResponse(Call<UserAfterCheckLG> call, Response<UserAfterCheckLG> response) {
                UserAfterCheckLG userAfterCheckLG = response.body();
                if(userAfterCheckLG != null){
                    SharedPreferences sharedPreferences = context.getSharedPreferences("user", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    Gson gson = new Gson();
                    String json = gson.toJson(userAfterCheckLG);
                    editor.putString("user", json);
                    editor.apply();

                }


            }

            @Override
            public void onFailure(Call<UserAfterCheckLG> call, Throwable t) {
                Toast.makeText(context, "Lỗi kết nối", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
