package com.cadelina.afinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Guide extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        getSupportActionBar().hide();
        //overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        //Initialize And Assign Variables
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.guide);

        //Perform ItemSelectedListener

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), Home.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.updates:
                        startActivity(new Intent(getApplicationContext(), Updates.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.calendar:
                        startActivity(new Intent(getApplicationContext(), Calendar.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.guide:
                        return true;
                    case R.id.vaccine:
                        startActivity(new Intent(getApplicationContext(), Vaccine.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }
}