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
   private Context mcontext;
    private List<ListHA> mlistHA;

    public RCV1Adapter(Context mcontext) {
        this.mcontext = mcontext;
    }
    public void setData(List<ListHA> list){
        this.mlistHA = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RCVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item1, parent, false);
        return new RCVViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RCVViewHolder holder, int position) {
       ListHA listHA = mlistHA.get(position);
       if(listHA== null){
           return;
       }
       holder.ivRoom.setImageResource(listHA.getPicture());
       holder.txtRoom.setText(listHA.getText());

    }

    @Override
    public int getItemCount() {
       return mlistHA.size();
    }

    public static  class RCVViewHolder extends RecyclerView.ViewHolder{
        ImageView ivRoom;
        TextView txtRoom;
        public RCVViewHolder(@NonNull View itemView) {
            super(itemView);
            ivRoom = itemView.findViewById(R.id.ivRoom);
            txtRoom = itemView.findViewById(R.id.txtRoom);

        }
    }
}
