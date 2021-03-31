package com.example.minimart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;



public class o_fruits extends AppCompatActivity {
    Button apple_cart,diliveredto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_fruits);



        Button apple_cart = findViewById (R.id.apple_cart );
        apple_cart.setOnClickListener ( v -> {
            Intent intent = new Intent(this, apple.class);
            startActivity(intent);
        });




        Button diliveredto = findViewById (R.id.diliveredto );
        diliveredto.setOnClickListener ( v -> {
            Intent intent = new Intent(this, address.class);
            startActivity(intent);
        });
    }
}