package com.example.coffeecup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;

public class shop_page extends AppCompatActivity{

    ArrayList<CoffeeModelClass> coffeeModelClasses = new ArrayList<>();

    int[] coffeeImages = {R.drawable.espresso, R.drawable.lungo, R.drawable.americano, R.drawable.ristretto,
                R.drawable.cappuccino, R.drawable.latte, R.drawable.flatwhite, R.drawable.cortado, R.drawable.mochacino};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_page);

        RecyclerView recyclerView = findViewById(R.id.list);

        setUpCoffeeModelClasses();

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, coffeeModelClasses);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpCoffeeModelClasses()
    {
        String[] coffeeNames = getResources().getStringArray(R.array.coffeeVariants);

        for (int i = 0; i<coffeeNames.length; i++){
            coffeeModelClasses.add(new CoffeeModelClass(coffeeNames[i], coffeeImages[i]));
        }
    }
}