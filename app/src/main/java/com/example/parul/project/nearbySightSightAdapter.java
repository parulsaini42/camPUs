package com.example.parul.project;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class nearbySightSightAdapter extends RecyclerView.Adapter<nearbySightSightAdapter.sightViewHolder>{

    private List<nearbySightSightClass> sightList;
    private Context context;

    private static int currentPosition = 0;

    public nearbySightSightAdapter(List<nearbySightSightClass> sightList, Context context) {
        this.sightList = sightList;
        this.context = context;
    }

    @Override
    public sightViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        //inflating and returning our view holder
        View v = LayoutInflater.from(context).inflate(R.layout.nearby_sight_layout, null);
        return new sightViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final sightViewHolder holder, final int position){
        //getting the product of the specified position
        nearbySightSightClass sight = sightList.get(position);

        //binding the data with the viewholder views
        holder.textSight.setText(sight.getName());
        holder.sightAddress.setText(sight.getAddress());
        holder.sightPhone.setText(sight.getPhone());
        holder.sightHours.setText(sight.getHours());

        holder.imageSight.setImageDrawable(context.getResources().getDrawable(sight.getSight_img()));

    }

    @Override
    public int getItemCount() { return sightList.size(); }

    class sightViewHolder extends RecyclerView.ViewHolder {
        TextView textSight, sightAddress, sightHours, sightPhone;
        ImageView imageSight;

        sightViewHolder(View itemView) {
            super(itemView);

            textSight = itemView.findViewById(R.id.textSight);
            sightAddress = itemView.findViewById(R.id.sightAddress);
            sightHours = itemView.findViewById(R.id.sightHours);
            sightPhone = itemView.findViewById(R.id.sightPhone);
            imageSight = itemView.findViewById(R.id.sight_img);
        }
    }
}
