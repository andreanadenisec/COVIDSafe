package com.cadelina.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class VaccineSputnik extends AppCompatActivity {

    private TextView txtPlatformm, txtDosee, txtVaxxEfficc, txtSidee, txtInfoo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_sputnik);
        getSupportActionBar().hide();

        txtInfoo = (TextView) findViewById(R.id.txtInfoSV);
        txtPlatformm = (TextView) findViewById(R.id.txtPlatformSV);
        txtDosee = (TextView) findViewById(R.id.txtDoseSV);
        txtVaxxEfficc = (TextView) findViewById(R.id.txtVaxxEfficSV);
        txtSidee = (TextView) findViewById(R.id.txtSideSV);

        txtInfoo.setText("Sputnik V is an adenovirus viral vector vaccine for COVID-19 developed by the Gamaleya Research Institute of Epidemiology and Microbiology in Russia.");
        txtPlatformm.setText("Viral Vector (non-replicating)");
        txtDosee.setText("2 doses, 3 weeks apart");
        txtVaxxEfficc.setText("91.6% against symptomatic COVID-19 \n100% against moderate or severe cases");
        txtSidee.setText("• pain on injection site, hyperthermia, swelling\n• headache, asthenia, muscle/joint pain, malaise, sore throat, diarrhea, rhinorrhea, loss of appetite, pain in the oropharynx, nasal congestion, colds, sneezing, cough");
    }
}