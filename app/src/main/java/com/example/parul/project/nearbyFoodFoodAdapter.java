package com.example.parul.project;

import android.content.Context;
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

public class nearbyFoodFoodAdapter extends RecyclerView.Adapter<nearbyFoodFoodAdapter.FoodViewHolder> {

    private List<nearbyFoodFoodClass> foodList;
    private Context context;

    private static int currentPosition = -1;

    public nearbyFoodFoodAdapter(List<nearbyFoodFoodClass> foodList, Context context) {
        this.foodList = foodList;
        this.context = context;
    }

    @Override
    public FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        //inflating and returning our view holder
        View v = LayoutInflater.from(context).inflate(R.layout.nearby_food_layout, null);
        return new FoodViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final FoodViewHolder holder, final int position){
        //getting the product of the specified position
        nearbyFoodFoodClass food = foodList.get(position);

        //binding the data with the viewholder views
        holder.textViewRestaurant.setText(food.getName());
        holder.textViewAddress.setText(food.getAddress());
        holder.textViewPhone.setText(food.getPhone());
        holder.textViewHours.setText(food.getHours());
        holder.textViewOrder.setText(food.getOrder());

        holder.imageViewRestaurant.setImageDrawable(context.getResources().getDrawable(food.getDisplay_pic()));

        holder.linearLayout.setVisibility(View.GONE);

        //if the position is equals to the item position which is to be expanded
        if (currentPosition == position) {
            //creating an animation
            Animation slideDown = AnimationUtils.loadAnimation(context, R.anim.animation);

            //toggling visibility
            holder.linearLayout.setVisibility(View.VISIBLE);

            //adding sliding effect
            holder.linearLayout.startAnimation(slideDown);
        }
        holder.clickLayout.setOnClickListener(new View.OnClickListener() {
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
    public int getItemCount() { return foodList.size(); }

    class FoodViewHolder extends RecyclerView.ViewHolder {
        TextView textViewRestaurant, textViewAddress, textViewHours, textViewPhone, textViewOrder;
        LinearLayout linearLayout, clickLayout;
        ImageView imageViewRestaurant;

        FoodViewHolder(View itemView) {
            super(itemView);

            textViewRestaurant = itemView.findViewById(R.id.textViewRestaurant);
            textViewAddress = itemView.findViewById(R.id.textViewAddress);
            textViewHours = itemView.findViewById(R.id.textViewHours);
            textViewPhone= itemView.findViewById(R.id.textViewPhone);
            textViewOrder = itemView.findViewById(R.id.textViewOrder);
            imageViewRestaurant = itemView.findViewById(R.id.restaurant_img);

            linearLayout = itemView.findViewById(R.id.linearLayout);
            clickLayout = itemView.findViewById(R.id.food_btn);
        }
    }

}
