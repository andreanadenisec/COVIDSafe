package com.cadelina.afinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {

    TextView txt, f1, f2, f3, f4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
        //overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        txt = (TextView) findViewById(R.id.txtWelcome);
        f1 = (TextView) findViewById(R.id.txtFact1);
        f2 = (TextView) findViewById(R.id.txtFact2);
        f3 = (TextView) findViewById(R.id.txtFact3);
        f4 = (TextView) findViewById(R.id.txtFact4);

        txt.setText("These facts come from leading health organisations. They correct common, untrue rumours about COVID-19");
        f1.setText("People of all ages can be infected by the COVID-19 virus. Everyone, no matter how old, should practice prevention measures.");
        f2.setText("Vaccines go through extensive trials before they can be introduced in a country. Expert doctors and scientists follow strict international standards.");
        f3.setText("You are far more likely to be seriously harmed by COVID-19 than by vaccines. Vaccines are proven to be safe and effective. ");
        f4.setText("COVID-19 vaccines can't give you COVID-19. They may cause minor side effects for this is a sign that the vaccine is working.");

        //Initialize And Assign Variables
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.home);

        //Perform ItemSelectedListener

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
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
                        startActivity(new Intent(getApplicationContext(), Vaccine.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }

    //Logout Method
    public void goLogout(View v){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }

    public void goCalendar(View v) {
        Intent c = new Intent(getApplicationContext(), Calendar.class);
        startActivity(c);
    }

}