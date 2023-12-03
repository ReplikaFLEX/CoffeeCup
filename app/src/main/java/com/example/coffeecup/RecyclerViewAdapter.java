package com.example.coffeecup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context context;
    ArrayList<CoffeeModelClass> coffeeModelClasses;

    public RecyclerViewAdapter(Context context, ArrayList<CoffeeModelClass> coffeeModelClasses){
        this.context = context;
        this.coffeeModelClasses = coffeeModelClasses;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_view, parent, false);
        return new RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.textViewName.setText(coffeeModelClasses.get(position).getCoffeeName());
        holder.imageView.setImageResource(coffeeModelClasses.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return coffeeModelClasses.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView textViewName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageexp);
            textViewName = itemView.findViewById(R.id.namecoffee);
        }
    }
}
