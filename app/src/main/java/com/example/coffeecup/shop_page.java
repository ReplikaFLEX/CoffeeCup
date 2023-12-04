package com.example.coffeecup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class shop_page extends AppCompatActivity implements RecyclerViewInterface{

    public static int moneySpend;
    ArrayList<CoffeeModelClass> coffeeModelClasses = new ArrayList<>();

    int[] coffeeImages = {R.drawable.espresso, R.drawable.lungo, R.drawable.americano, R.drawable.ristretto,
                R.drawable.cappuccino, R.drawable.latte, R.drawable.flatwhite, R.drawable.cortado, R.drawable.mochacino};
    int[] coffeePrices = {35, 50, 45, 55, 70, 75, 65, 80, 70};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_page);

        TextView moneycounter = findViewById(R.id.moneycounter);
        moneycounter.setText(moneySpend + "$");

        View exit = findViewById(R.id.close);
        View finish = findViewById(R.id.finishshopping);

        RecyclerView recyclerView = findViewById(R.id.list);

        setUpCoffeeModelClasses();

        exit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finishAndRemoveTask();
            }
        });

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, coffeeModelClasses, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        finish.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(moneySpend > 0)
                {
                    Intent intent = new Intent(shop_page.this, finish_shopping.class);
                    startActivity(intent);
                    moneySpend = 0;
                    moneycounter.setText("0$");
                }
            }
        });
    }

    private void setUpCoffeeModelClasses()
    {
        String[] coffeeNames = getResources().getStringArray(R.array.coffeeVariants);
        String[] coffeeDescs = getResources().getStringArray(R.array.coffeeDescriptions);

        for (int i = 0; i<coffeeNames.length; i++){
            coffeeModelClasses.add(new CoffeeModelClass(coffeeNames[i], coffeeDescs[i], coffeeImages[i], coffeePrices[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(shop_page.this, information_page.class);

        intent.putExtra("NAME", coffeeModelClasses.get(position).getCoffeeName());
        intent.putExtra("DESCRIPTION", coffeeModelClasses.get(position).getDescription());
        intent.putExtra("IMAGE", coffeeModelClasses.get(position).getImage());
        intent.putExtra("PRICE", coffeeModelClasses.get(position).getPrice());

        startActivity(intent);
        finish();
    }
}