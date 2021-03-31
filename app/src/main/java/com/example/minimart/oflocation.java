package com.example.minimart;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class oflocation extends AppCompatActivity {

    ArrayList<String> myArrayList = new ArrayList<>();
    ListView listView;
    DatabaseReference ref;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_oflocation );

    }
}