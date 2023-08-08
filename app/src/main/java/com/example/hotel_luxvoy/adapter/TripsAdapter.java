package com.example.hotel_luxvoy.adapter;

import android.content.Context;

import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.activity.BookLocationActivity;
import com.example.hotel_luxvoy.fragment.FragmentBook;
import com.example.hotel_luxvoy.models.Trips;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TripsAdapter extends RecyclerView.Adapter<TripsAdapter.TripsViewHolder> {
    public enum FragmentType {
        CURRENT,
        PAST,
        CANCLED
    }

    private FragmentType fragmentType;

    public List<Trips> tripsList;

    public Context context;

    public TripsAdapter(List<Trips> tripsList, Context context, FragmentType fragmentType) {
        this.tripsList = tripsList;
        this.context = context;
        this.fragmentType = fragmentType;
    }

    @NonNull
    @Override
    public TripsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_trips, null);
        return new TripsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TripsViewHolder holder, int position) {
        Trips trips = tripsList.get(position);
        holder.tvHotelName.setText(trips.getHotelName());
        holder.tvDescription.setText(trips.getDescription());
        holder.tvConfirmation.setText(trips.getConfirmationNumber());
        holder.tvCancellation.setText(trips.getCancellationNumber());
//        holder.imgTrips.setImageResource(trips.getImage());
        Picasso.get()
                .load(trips.getImage())
                .resize(550,300)
                .into(holder.imgTrips);

        switch (fragmentType) {
            case CURRENT:
                holder.btnTrips.setText("Details");
                holder.tvCancellation.setVisibility(View.GONE);
                holder.btnTrips.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FragmentBook fragmentBook = new FragmentBook();
                        Bundle bundle = new Bundle();
                        bundle.putString("hotelName", trips.getHotelName());
                        bundle.putString("description", trips.getDescription());
                        bundle.putString("confirmationNumber", trips.getConfirmationNumber());
                        bundle.putString("cancellationNumber", trips.getCancellationNumber());
                        bundle.putString("image", trips.getImage());
                        fragmentBook.setArguments(bundle);
                        FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();

                        fragmentManager.beginTransaction()
                                .replace(R.id.frameLayout, fragmentBook)
                                .addToBackStack(null)
                                .commit();
                    }
                });
                break;
            case PAST:
                holder.btnTrips.setText("Rebook");
                holder.tvConfirmation.setVisibility(View.GONE);
                holder.tvCancellation.setVisibility(View.GONE);
                holder.btnTrips.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, BookLocationActivity.class);
                        context.startActivity(intent);
                    }
                });
                break;
            case CANCLED:
                holder.btnTrips.setText("Rebook a room");
                holder.tvCancellation.setVisibility(View.VISIBLE);
                holder.btnTrips.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, BookLocationActivity.class);
                        context.startActivity(intent);
                    }
                });
                break;
        }
    }

    @Override
    public int getItemCount() {
        return tripsList.size();
    }

    public class TripsViewHolder extends RecyclerView.ViewHolder {
        ImageView imgTrips;

        TextView tvHotelName, tvDescription, tvConfirmation, tvCancellation;

        Button btnTrips;

        public TripsViewHolder(@NonNull View itemView) {
            super(itemView);
            imgTrips = itemView.findViewById(R.id.imgTrips);
            tvHotelName = itemView.findViewById(R.id.tvHotelName);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvConfirmation = itemView.findViewById(R.id.tvConfirmation);
            tvCancellation = itemView.findViewById(R.id.tvCancellation);
            btnTrips = itemView.findViewById(R.id.btnTrips);
        }
    }
}
