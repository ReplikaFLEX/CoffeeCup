package com.example.coffeecup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;

public class shop_page extends AppCompatActivity implements RecyclerViewInterface{

    ArrayList<CoffeeModelClass> coffeeModelClasses = new ArrayList<>();

    int[] coffeeImages = {R.drawable.espresso, R.drawable.lungo, R.drawable.americano, R.drawable.ristretto,
                R.drawable.cappuccino, R.drawable.latte, R.drawable.flatwhite, R.drawable.cortado, R.drawable.mochacino};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_page);

        RecyclerView recyclerView = findViewById(R.id.list);

        setUpCoffeeModelClasses();

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, coffeeModelClasses, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpCoffeeModelClasses()
    {
        String[] coffeeNames = getResources().getStringArray(R.array.coffeeVariants);
        String[] coffeeDescs = getResources().getStringArray(R.array.coffeeDescriptions);

        for (int i = 0; i<coffeeNames.length; i++){
            coffeeModelClasses.add(new CoffeeModelClass(coffeeNames[i], coffeeDescs[i], coffeeImages[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(shop_page.this, information_page.class);

        intent.putExtra("NAME", coffeeModelClasses.get(position).getCoffeeName());
        intent.putExtra("DESCRIPTION", coffeeModelClasses.get(position).getDescription());
        intent.putExtra("IMAGE", coffeeModelClasses.get(position).getImage());

        startActivity(intent);
    }
}