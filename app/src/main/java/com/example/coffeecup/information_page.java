package com.example.coffeecup;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class information_page extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_page);

        View exit = findViewById(R.id.exist);
        View shop = findViewById(R.id.gotoshop);

        exit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

        String name = getIntent().getStringExtra("NAME");
        String desc = getIntent().getStringExtra("DESCRIPTION");
        int image = getIntent().getIntExtra("IMAGE", 0);
        int price = getIntent().getIntExtra("PRICE", 0);

        TextView coffeename = findViewById(R.id.coffeename);
        TextView coffeedesc = findViewById(R.id.coffeedesc);
        ImageView coffeeimage = findViewById(R.id.imagecoffee);
        TextView pricecounter = findViewById(R.id.pricecounter);

        coffeename.setText(name);
        coffeedesc.setText(desc);
        coffeeimage.setImageResource(image);
        pricecounter.setText("Price: " + price + "$");

        shop.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                shop_page.moneySpend += price;
                Intent intent = new Intent(information_page.this, shop_page.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {}
}