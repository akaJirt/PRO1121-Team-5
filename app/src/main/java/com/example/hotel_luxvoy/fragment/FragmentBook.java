package com.example.hotel_luxvoy.fragment;

import static android.content.ContentValues.TAG;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.adapter.RCV1Adapter;
import com.example.hotel_luxvoy.models.ListHA;

import java.util.ArrayList;

public class FragmentBook extends Fragment {
    private static final String TAG ="FragmentBook";
   private RecyclerView recyclerView1;
   private RCV1Adapter rcv1Adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View  view = inflater.inflate(R.layout.fragment_books,container, false);
      recyclerView1 = view.findViewById(R.id.rcvroom);
      recyclerView1.setHasFixedSize(true);
     ImageView ivCancelres = view.findViewById(R.id.ivCancelres) ;
      //rcv1Adapter = new RCV1Adapter(FragmentBook);
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);


      ivCancelres.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              Log.d(TAG, "onClick : opening dialog");
              FramentDialog dialog = new FramentDialog();
              dialog.show(getChildFragmentManager(),"FramnetDialog");

          }
      });


      return view;
    }





}
