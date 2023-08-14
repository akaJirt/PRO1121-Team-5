package com.example.hotel_luxvoy.fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hotel_luxvoy.activity.PaymentActivity;
import com.example.hotel_luxvoy.R;

public class FragmentSetting extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        ImageView imageView = view.findViewById(R.id.ivPersona);
        Button btnSignOut = view.findViewById(R.id.btnSignout);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PaymentActivity.class);
                startActivity(intent);
            }
        });

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FramentDialogSignOut framentDialogSignOut = new FramentDialogSignOut();
                framentDialogSignOut.show(getFragmentManager(),"Dialog Sign Out");

            }
        });

        return view;
    }
}
