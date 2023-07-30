package com.example.hotel_luxvoy.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hotel_luxvoy.R;

public class FragmentSupport extends Fragment {
    private static final String TAG ="FragmentSupport";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_support, container, false);
        Button btnSignOut = view.findViewById(R.id.btnSignOut);


        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick : opening dialog");
                FramentDialogSignOut dialog = new FramentDialogSignOut();
                dialog.show(getChildFragmentManager(),"FramentDialogSignOut");
            }
        });
        return view;
    }
}
