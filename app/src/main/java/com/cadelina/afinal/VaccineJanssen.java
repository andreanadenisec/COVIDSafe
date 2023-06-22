package com.cadelina.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class VaccineJanssen extends AppCompatActivity {

    private TextView txtPlatformm, txtDosee, txtVaxxEfficc, txtSidee, txtInfoo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_janssen);
        getSupportActionBar().hide();

        txtInfoo = (TextView) findViewById(R.id.txtInfoJJ);
        txtPlatformm = (TextView) findViewById(R.id.txtPlatformJJ);
        txtDosee = (TextView) findViewById(R.id.txtDoseJJ);
        txtVaxxEfficc = (TextView) findViewById(R.id.txtVaxxEfficJJ);
        txtSidee = (TextView) findViewById(R.id.txtSideJJ);

        txtInfoo.setText("The Janssen COVID-19 vaccine or Johnson & Johnson COVID-19 vaccine is a COVID-19 vaccine that was developed by Janssen Vaccines in Leiden, Netherlands.");
        txtPlatformm.setText("Viral Vector (non-replicating)");
        txtDosee.setText("1 dose");
        txtVaxxEfficc.setText("66.1-66.9% against confirmed moderate to severe/critical COVID-19 \n~77-85% against severe COVID-19");
        txtSidee.setText("• injection site pain, redness, swelling\n• tiredness, headache, muscle pain, chills, fever, nausea");
    }
}