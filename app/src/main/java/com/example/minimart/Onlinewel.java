package com.example.minimart;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Onlinewel extends AppCompatActivity {
    FloatingActionButton onmenu;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.onlinewel );

        FloatingActionButton onmenu = findViewById (R.id.onmenu );
        onmenu.setOnClickListener ( v -> {
            Intent intent = new Intent (this,o_menue.class);
            startActivity ( intent );
        });
    }
}