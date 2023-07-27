package com.example.hotel_luxvoy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.fragment.FragmentBook;
import com.example.hotel_luxvoy.models.ListHA;

import java.util.List;

public class RCV1Adapter extends RecyclerView.Adapter<RCV1Adapter.RCVViewHolder> {
   private Context context;
    private List<ListHA> mlistHA;
    public RCV1Adapter(List<ListHA> mlistHA, Context context) {
        this.mlistHA = mlistHA;
        this.context = context;
    }
    @NonNull
    @Override
    public RCV1Adapter.RCVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.layout_item1, null);

        return new RCVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RCV1Adapter.RCVViewHolder holder, int position) {
        ListHA listHA = mlistHA.get(position);
        holder.txtRoom.setText(listHA.getText());
        holder.ivRoom.setImageResource(listHA.getPicture());
    }

    @Override
    public int getItemCount() {
        return mlistHA.size();
    }

    public class RCVViewHolder extends RecyclerView.ViewHolder {
        TextView txtRoom;

        ImageView ivRoom;

        public RCVViewHolder(@NonNull View itemView) {
            super(itemView);
            txtRoom = itemView.findViewById(R.id.txtRoom);
            ivRoom = itemView.findViewById(R.id.ivRoom);
        }
    }
}
