package com.example.minimart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


public class o_rice extends AppCompatActivity {
    Button araliyabtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_rice);


        Button araliyabtn = findViewById (R.id.araliyabtn );
        araliyabtn.setOnClickListener ( v -> {
            Intent intent = new Intent(this, dialog_quantity.class);
            startActivity(intent);
        });

    }
}