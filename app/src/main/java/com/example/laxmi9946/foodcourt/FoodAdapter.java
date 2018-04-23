package com.example.laxmi9946.foodcourt;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by laxmi9946 on 4/22/2018.
 */

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ItemHolder> implements Filterable {
    Context context;
    List<FoodItems> items;
    List<FoodItems> foodItemsList;
    CharSequence filteredText;
    FoodItems details;


    public FoodAdapter(Context context, List<FoodItems>
            items) {
        this.context = context;
        this.items = items;
        this.foodItemsList = items;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_foodcategory, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                filteredText = constraint;
                FilterResults filterResults = new FilterResults();
                List<FoodItems> filteredDummyContents = new ArrayList<>();
                constraint = constraint.toString().toLowerCase();
                if (TextUtils.isEmpty(constraint)) {
                    filterResults.values = foodItemsList;
                    filterResults.count = foodItemsList.size();
                } else {
                    for (int i = 0; i < foodItemsList.size(); i++) {
                        details = foodItemsList.get(i);
                        if (details.foodTitle.toLowerCase().contains(constraint)) {
                            filteredDummyContents.add(details);
                        }
                    }

                    filterResults.values = filteredDummyContents;
                    filterResults.count = filteredDummyContents.size();
                }

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                items = (List<FoodItems>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        final FoodItems foodItems = items.get(position);
        holder.foodTitle.setText(foodItems.foodTitle);
        holder.ingredientsInfoText.setText(foodItems.ingredients);
        holder.qtyNo.setText(foodItems.quantity);
        holder.foodImage.setImageResource(foodItems.foodImage);
        holder.addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Item added into your cart", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.foodImage)
        ImageView foodImage;
        @BindView(R.id.foodTitle)
        TextView foodTitle;
        @BindView(R.id.ingredientsTitleText)
        TextView ingredientsTitleText;
        @BindView(R.id.ingredientsInfoText)
        TextView ingredientsInfoText;
        @BindView(R.id.qtyTitle)
        TextView qtyTitle;
        @BindView(R.id.qtyNo)
        TextView qtyNo;
        @BindView(R.id.addToCartButton)
        Button addToCartButton;
        @BindView(R.id.minusImageView)
        ImageView minusImageView;
        @BindView(R.id.itemCountTextView)
        TextView itemCountTextView;
        @BindView(R.id.addImageView)
        ImageView addImageView;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
