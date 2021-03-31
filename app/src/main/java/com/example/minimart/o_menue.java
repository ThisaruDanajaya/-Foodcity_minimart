package com.example.minimart;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class o_menue extends AppCompatActivity {
    Button rice,vegetables,fruits,meats,bakery,beverages,pharmacy,snacks,baby,personalcare,household,tea,diliveredto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_menue);



        Button rice = findViewById (R.id.rice );
        rice.setOnClickListener ( v -> {
            Intent intent = new Intent(this, o_rice.class);
            startActivity(intent);
    });

        Button vegetables = findViewById (R.id.vegetables );
        vegetables.setOnClickListener ( v -> {
            Intent intent = new Intent(this, o_vegetables.class);
            startActivity(intent);
        });

        Button fruits = findViewById (R.id.fruits );
        fruits.setOnClickListener ( v -> {
            Intent intent = new Intent(this, o_fruits.class);
            startActivity(intent);
        });

        Button meats = findViewById (R.id.meats );
        meats.setOnClickListener ( v -> {
            Intent intent = new Intent(this, o_meats.class);
            startActivity(intent);
        });

        Button bakery = findViewById (R.id.bakery);
        bakery.setOnClickListener ( v -> {
            Intent intent = new Intent(this, o_bakery.class);
            startActivity(intent);
        });

        Button beverages = findViewById (R.id.beverages );
        beverages.setOnClickListener ( v -> {
            Intent intent = new Intent(this, o_beverages.class);
            startActivity(intent);
        });

        Button pharmacy = findViewById (R.id.pharmacy );
        pharmacy.setOnClickListener ( v -> {
            Intent intent = new Intent(this, o_pharmacy.class);
            startActivity(intent);
        });

        Button snacks = findViewById (R.id.snacks);
        snacks.setOnClickListener ( v -> {
            Intent intent = new Intent(this, o_snacks.class);
            startActivity(intent);
        });

        Button baby = findViewById (R.id.baby );
        baby.setOnClickListener ( v -> {
            Intent intent = new Intent(this, o_baby.class);
            startActivity(intent);
        });

        Button personalcare = findViewById (R.id.personalcare );
        personalcare.setOnClickListener ( v -> {
            Intent intent = new Intent(this, o_personalcare.class);
            startActivity(intent);
        });

        Button household = findViewById (R.id.household);
        household.setOnClickListener ( v -> {
            Intent intent = new Intent(this, o_household.class);
            startActivity(intent);
        });

        Button tea = findViewById (R.id.tea );
        tea.setOnClickListener ( v -> {
            Intent intent = new Intent(this, o_tea.class);
            startActivity(intent);
        });

        Button diliveredto = findViewById (R.id.diliveredto );
        diliveredto.setOnClickListener ( v -> {
            Intent intent = new Intent(this, address.class);
            startActivity(intent);
        });








}
}