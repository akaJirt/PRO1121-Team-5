package com.example.hotel_luxvoy.adapter;

import static android.app.PendingIntent.getActivity;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotel_luxvoy.PaymentActivity;
import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.fragment.FragmentBook;
import com.example.hotel_luxvoy.models.Current;
import com.example.hotel_luxvoy.models.Gallery;

import java.util.List;

public class RcvCurrentAdapter extends RecyclerView.Adapter<RcvCurrentAdapter.RcvCurrentViewHolder> {
    private Context context;
    private List<Current> mcurrent;
    public RcvCurrentAdapter(List<Current> mcurrent, Context context) {
        this.mcurrent = mcurrent;
        this.context = context;
    }
    @NonNull
    @Override
    public RcvCurrentAdapter.RcvCurrentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.layout_itemcurrent, null);

        return new RcvCurrentAdapter.RcvCurrentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RcvCurrentViewHolder holder, int position) {
        Current current = mcurrent.get(position);
        holder.imgHotel.setImageResource(current.getImg());
        holder.txtcfnumber.setText(current.getCfnumber());
        holder.txtdate.setText(current.getDate());
        holder.txtNameHT.setText(current.getNamehotel());
        holder.btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity)v.getContext();
                FragmentBook fragmentBook = new FragmentBook();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout2, fragmentBook).commit();
            }
        });


    }




    @Override
    public int getItemCount() {
        return mcurrent.size();
    }

    public class RcvCurrentViewHolder extends RecyclerView.ViewHolder {


        ImageView imgHotel;
        TextView txtNameHT, txtdate, txtcfnumber;
        Button btnDetails;


        public RcvCurrentViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNameHT = itemView.findViewById(R.id.txtNameHT);
            txtdate = itemView.findViewById(R.id.txtdate);
            txtcfnumber = itemView.findViewById(R.id.txtcfnumber);
            btnDetails = itemView.findViewById(R.id.btnDetails);
            imgHotel = itemView.findViewById(R.id.imgHotel);

        }
    }

}
