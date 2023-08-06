package com.example.hotel_luxvoy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotel_luxvoy.R;

import java.util.ArrayList;

public class Calendar_item_Adapter extends RecyclerView.Adapter<Calendar_item_Adapter.Viewholder>{

    private Context context;

    public Calendar_item_Adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.layout_item_calendar, null);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        ArrayList<Integer> month = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            month.add(i);
        }
        CalendarView calendarView = new CalendarView(context);
        calendarView.setShowWeekNumber(false);
        calendarView.setFirstDayOfWeek(2);
        calendarView.setMinDate(System.currentTimeMillis() - 1000);
calendarView.setDate(System.currentTimeMillis(), false, true);



    }

    @Override
    public int getItemCount() {
        return 12;
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        RecyclerView recyclerView_Calendar;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            recyclerView_Calendar = itemView.findViewById(R.id.recyclerView_Calendar);
        }
    }
}
