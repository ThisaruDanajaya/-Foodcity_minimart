package com.example.minimart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


public class address extends AppCompatActivity {
    Button okbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);


        Button okbtn = findViewById (R.id.okbtn );
        okbtn.setOnClickListener ( v -> {
            Intent intent = new Intent(this, o_menue.class);
            startActivity(intent);
        });

    }
}