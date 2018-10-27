package com.example.parul.project;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ImportEventsEventAdapter extends RecyclerView.Adapter<ImportEventsEventAdapter.EventViewHolder>{

    private List<ImportEventsEventClass> eventsList;
    private Context context;

    private static int currentPosition = -1;

    public ImportEventsEventAdapter(List<ImportEventsEventClass> eventsList, Context context){
        this.eventsList = eventsList;
        this.context = context;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        View v = LayoutInflater.from(context).inflate(R.layout.events_card_layout, null);
        return new EventViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final EventViewHolder holder, final int position){
        //getting the product of the specified position
        ImportEventsEventClass event = eventsList.get(position);

        //binding the data with the viewholder views
        holder.textViewEvent.setText(event.getName());
        holder.textViewVenue.setText(event.getVenue());
        holder.textViewDate.setText(event.getDate());
        holder.textViewTimings.setText(event.getTimings());

        holder.imageViewEvent.setImageDrawable(context.getResources().getDrawable(event.getEvent_img()));

        holder.linearLayout.setVisibility(View.GONE);

        if (currentPosition == position) {
            //creating an animation
            Animation slideDown = AnimationUtils.loadAnimation(context, R.anim.events_expand);

            //toggling visibility
            holder.linearLayout.setVisibility(View.VISIBLE);

            //adding sliding effect
            holder.linearLayout.startAnimation(slideDown);
        }
        holder.eventLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getting the position of the item to expand it
                currentPosition = position;

                //reloading the list
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount(){ return eventsList.size(); }

    class EventViewHolder extends RecyclerView.ViewHolder{
        TextView textViewEvent, textViewVenue, textViewDate, textViewTimings;
        ImageView imageViewEvent;
        LinearLayout eventLayout, linearLayout;

        EventViewHolder(View itemView){
            super(itemView);

            textViewEvent = itemView.findViewById(R.id.textViewEvent);
            textViewVenue = itemView.findViewById(R.id.textViewVenue);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewTimings = itemView.findViewById(R.id.textViewTimings);

            imageViewEvent = itemView.findViewById(R.id.event_img);

            eventLayout = itemView.findViewById(R.id.event_btn);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }
}
