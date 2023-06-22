package com.cadelina.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class VaccineAstrazeneca extends AppCompatActivity {

    private TextView txtPlatformm, txtDosee, txtVaxxEfficc, txtSidee, txtInfoo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_astrazeneca);
        getSupportActionBar().hide();

        txtInfoo = (TextView) findViewById(R.id.txtInfoAz);
        txtPlatformm = (TextView) findViewById(R.id.txtPlatformAz);
        txtDosee = (TextView) findViewById(R.id.txtDoseAz);
        txtVaxxEfficc = (TextView) findViewById(R.id.txtVaxxEfficAz);
        txtSidee = (TextView) findViewById(R.id.txtSideAz);

        txtInfoo.setText("The Oxford–AstraZeneca COVID-19 vaccine is a COVID-19 vaccine is developed in the United Kingdom by the Oxford University and British-Swedish company AstraZeneca.");
        txtPlatformm.setText("Viral Vector (non-replicating)");
        txtDosee.setText("2 doses, 4-12 weeks apart");
        txtVaxxEfficc.setText("70.4% against symptomatic COVID-19 \n100% against severe COVID-19");
        txtSidee.setText("• injection site pain and tenderness\n• fatigue, headache, feverishness, myalgia");
    }
}