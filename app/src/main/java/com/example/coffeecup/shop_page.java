package com.example.coffeecup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class shop_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_page);

        RecyclerView recyclerView = findViewById(R.id.list);

        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Espresso",R.drawable.espresso));
        items.add(new Item("Lungo",R.drawable.lungo));
        items.add(new Item("Americano",R.drawable.americano));
        items.add(new Item("Ristretto",R.drawable.ristretto));
        items.add(new Item("Cappuccino",R.drawable.cappuccino));
        items.add(new Item("Latte",R.drawable.latte));
        items.add(new Item("Flat White",R.drawable.flatwhite));
        items.add(new Item("Cortado",R.drawable.cortado));
        items.add(new Item("Mochacino",R.drawable.mochacino));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), items));
    }
}