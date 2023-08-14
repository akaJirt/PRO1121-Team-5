package com.example.hotel_luxvoy.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.DialogFragment;

import com.example.hotel_luxvoy.R;

public class FramentDialogSignOut extends DialogFragment {
    private static final String TAG = "Dialog Sign Out";
    private AppCompatButton btnCanncelDiaLog, btnYesDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_signout, container, false);

        btnCanncelDiaLog = view.findViewById(R.id.btnCancelDialog);
        btnYesDialog = view.findViewById(R.id.btnYesDialog);
        btnCanncelDiaLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        btnYesDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finishAffinity();
                System.exit(0);
            }
        });

        return view;
    }
}
