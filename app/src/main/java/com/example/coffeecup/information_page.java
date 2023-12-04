package com.example.coffeecup;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class information_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_page);

        String name = getIntent().getStringExtra("NAME");
        String desc = getIntent().getStringExtra("DESCRIPTION");
        int image = getIntent().getIntExtra("IMAGE", 0);

        TextView coffeename = findViewById(R.id.coffeename);
        TextView coffeedesc = findViewById(R.id.coffeedesc);
        ImageView coffeeimage = findViewById(R.id.imagecoffee);

        coffeename.setText(name);
        coffeedesc.setText(desc);
        coffeeimage.setImageResource(image);
    }

    private void closeActivity()
    {

    }
}