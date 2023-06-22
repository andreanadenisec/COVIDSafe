package com.cadelina.afinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Updates extends AppCompatActivity {

    private TextView date, recovered, confirmed, death;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updates);
        getSupportActionBar().hide();
        //overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        date = findViewById(R.id.txtDate);
        recovered = findViewById(R.id.txtRecoveredNumber);
        confirmed = findViewById(R.id.txtFact1);
        death = findViewById(R.id.txtDeathsNumber);

        //URL Request
        mQueue = Volley.newRequestQueue(this);

        String url = "https://api.apify.com/v2/key-value-stores/lFItbkoNDXKeSWBBA/records/LATEST?disableRedirect=true";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                    LocalDateTime now = LocalDateTime.now();
                    DecimalFormat formatter = new DecimalFormat("#,###");

                    date.setText("As of " + dtf.format(now));
                    String confirmedInfo = response.getString("infected");
                    confirmed.setText(confirmedInfo);
                    String recoveredInfo = response.getString("recovered");
                    recovered.setText(recoveredInfo);
                    String deathInfo = response.getString("deceased");
                    death.setText(deathInfo);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);

        //Initialize And Assign Variables
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.updates);

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

    public void onBtnAPISource(View v){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://endcov.ph/dashboard/"));
        startActivity(i);
    }
}