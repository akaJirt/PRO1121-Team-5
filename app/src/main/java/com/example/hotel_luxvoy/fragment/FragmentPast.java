package com.example.hotel_luxvoy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.hotel_luxvoy.R;

public class FragmentPast extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookatrips, container,false);
        Button btnBook = view.findViewById(R.id.btnBook);

    btnBook.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentBook fragmentBook = new FragmentBook();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout2, fragmentBook).commit();
        }
    });
        return view;

    }
}
