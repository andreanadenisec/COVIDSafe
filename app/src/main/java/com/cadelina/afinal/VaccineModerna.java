package com.cadelina.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class VaccineModerna extends AppCompatActivity {

    private TextView txtPlatformm, txtDosee, txtVaxxEfficc, txtSidee, txtInfoo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_moderna);
        getSupportActionBar().hide();

        txtInfoo = (TextView) findViewById(R.id.txtInfoM);
        txtPlatformm = (TextView) findViewById(R.id.txtPlatformM);
        txtDosee = (TextView) findViewById(R.id.txtDoseM);
        txtVaxxEfficc = (TextView) findViewById(R.id.txtVaxxEfficM);
        txtSidee = (TextView) findViewById(R.id.txtSideM);

        txtInfoo.setText("The Moderna COVID‑19 vaccine is a COVID-19 vaccine developed by American company Moderna, the United States NIAID, and the BARDA.");
        txtPlatformm.setText("mRNA");
        txtDosee.setText("2 doses, 28 days apart");
        txtVaxxEfficc.setText("91.4% against symptomatic COVID-19 \n100% against severe COVID-19");
        txtSidee.setText("• pain/erythema/swelling on injection site, axillary lymphadenopathy\n• fever, heeadache, fatigue, myalgia, arthralgia, nausea, vomiting, chills");


    }
}