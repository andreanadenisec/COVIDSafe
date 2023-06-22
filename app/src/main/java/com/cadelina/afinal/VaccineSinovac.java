package com.cadelina.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class VaccineSinovac extends AppCompatActivity {

    private TextView txtPlatformm, txtDosee, txtVaxxEfficc, txtSidee, txtInfoo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_sinovac);
        getSupportActionBar().hide();

        txtInfoo = (TextView) findViewById(R.id.txtInfo);
        txtPlatformm = (TextView) findViewById(R.id.txtPlatform);
        txtDosee = (TextView) findViewById(R.id.txtDose);
        txtVaxxEfficc = (TextView) findViewById(R.id.txtVaxxEffic);
        txtSidee = (TextView) findViewById(R.id.txtSide);

        txtInfoo.setText("CoronaVac, also known as the Sinovac COVID-19 vaccine, is a COVID-19 vaccine developed by the Chinese company Sinovac Biotech.");
        txtPlatformm.setText("Inactivated Virus");
        txtDosee.setText("2 doses, 28 days apart");
        txtVaxxEfficc.setText("51% overall VE against symptomatic COVID-19\n100% against severe COVID-19 and hospitalization");
        txtSidee.setText("• local lymphodenopathy at injection site\n• allergic reaction that may be caused by any component of the vaccine (hives, allergic rashes and purpura, and anaphylactic shock)\n• convulsion (with or without fever)");

    }
}