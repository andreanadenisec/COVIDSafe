package com.cadelina.afinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Vaccine extends AppCompatActivity {

    private ImageButton vSinovac, vPfizer, vAstrazeneca, vMooderna, vSputnik, vJanssen;
    private TextView brand;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine);
        getSupportActionBar().hide();
        //overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        addListenerOnButton();

        //Initialize And Assign Variables
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.vaccine);

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
                        startActivity(new Intent(getApplicationContext(), Guide.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.vaccine:
                        return true;
                }
                return false;
            }
        });

    }

    public void addListenerOnButton() {

        vSinovac = (ImageButton) findViewById(R.id.imgBSinovac);
        vPfizer = (ImageButton) findViewById(R.id.imgBPfizer);
        vAstrazeneca = (ImageButton) findViewById(R.id.imgBAstrazeneca);
        vMooderna = (ImageButton) findViewById(R.id.imgBModerna);
        vSputnik = (ImageButton) findViewById(R.id.imgBSputnik);
        vJanssen = (ImageButton) findViewById(R.id.imgBJanssen);

        vSinovac.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent iIntent = new Intent(getApplicationContext(), VaccineSinovac.class);
                startActivity(iIntent);
            }

        });

        vPfizer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent iIntent = new Intent(getApplicationContext(), VaccinePfizer.class);
                startActivity(iIntent);
            }

        });

        vAstrazeneca.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent iIntent = new Intent(getApplicationContext(), VaccineAstrazeneca.class);
                startActivity(iIntent);
            }

        });

        vMooderna.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent iIntent = new Intent(getApplicationContext(), VaccineModerna.class);
                startActivity(iIntent);
            }

        });

        vSputnik.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent iIntent = new Intent(getApplicationContext(), VaccineSputnik.class);
                startActivity(iIntent);
            }

        });

        vJanssen.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent iIntent = new Intent(getApplicationContext(), VaccineJanssen.class);
                startActivity(iIntent);
            }

        });
    }

    public void onBtnVaxx(View v){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://doh.gov.ph/vaccines/know-your-vaccines"));
        startActivity(i);
    }
}