package com.cadelina.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 4000;
    // Variables
    Animation topAnimation, bottomAnimation;
    ImageView image;
    TextView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        //Animations
        topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        //Hooks
        image = findViewById(R.id.imgLogo);
        logo = findViewById(R.id.txtApp);

        image.setAnimation(topAnimation);
        logo.setAnimation(bottomAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, Onboard.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_SCREEN);

    }
}