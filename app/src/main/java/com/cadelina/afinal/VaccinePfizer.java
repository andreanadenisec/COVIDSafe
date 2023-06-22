package com.cadelina.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class VaccinePfizer extends AppCompatActivity {

    private TextView txtPlatformm, txtDosee, txtVaxxEfficc, txtSidee, txtInfoo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_pfizer);
        getSupportActionBar().hide();

        txtInfoo = (TextView) findViewById(R.id.txtInfoPf);
        txtPlatformm = (TextView) findViewById(R.id.txtPlatformPf);
        txtDosee = (TextView) findViewById(R.id.txtDosePf);
        txtVaxxEfficc = (TextView) findViewById(R.id.txtVaxxEfficPf);
        txtSidee = (TextView) findViewById(R.id.txtSidePf);

        txtInfoo.setText("The Pfizer–BioNTech COVID-19 vaccine is a COVID-19 vaccine developed by the German biotechnology company BioNTech.");
        txtPlatformm.setText("mRNA");
        txtDosee.setText("2 doses, 21 days apart");
        txtVaxxEfficc.setText("100% against symptomatic COVID-19 \n(CT done for 16y/0 and above)\n100% against symptomatic COVID-19 \n(CT done for 12 to 15 y.o)");
        txtSidee.setText("• short-term, mild-to-moderate pain at the injection site\n• fatigue, headache");
    }
}