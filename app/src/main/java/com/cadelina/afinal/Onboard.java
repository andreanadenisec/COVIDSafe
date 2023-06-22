package com.cadelina.afinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Onboard extends AppCompatActivity {

    private ViewPager slideViewPager;
    private LinearLayout dotLayout;

    private TextView[] dots;

    private SliderAdapter sliderAdapter;

    private Button btn;

    private int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboard);
        getSupportActionBar().hide();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        slideViewPager = (ViewPager) findViewById(R.id.vpViewPager);
        dotLayout = (LinearLayout) findViewById(R.id.lytDot);

        btn = (Button) findViewById(R.id.btnGetStarted);

        sliderAdapter = new SliderAdapter(this);

        slideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);
        slideViewPager.addOnPageChangeListener(viewListener);

        //OnClickListeners
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                slideViewPager.setCurrentItem(currentPage + 1);

            }
        });

    }

    //Count the number of items
    public  void addDotsIndicator(int position){

        dots = new TextView[4];
        dotLayout.removeAllViews();

        for (int i=0; i<dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.lightGray));

            dotLayout.addView(dots[i]);
        }

        if(dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.lightTeal));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int j) {

        }

        @Override
        public void onPageSelected(int i) {

            addDotsIndicator(i);
            currentPage = i;

            if(i == 0 || i == 1 || i == 2){
                btn.setEnabled(true);
                btn.setText("Next");
            }
            else if(i == 3){
                btn.setEnabled(true);
                btn.setText("Get Started");
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent iIntent = new Intent(getApplicationContext(), Home.class);
                        startActivity(iIntent);
                    }
                });
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

    public void goLogin(View v){
        Intent i = new Intent(getApplicationContext(), Home.class);
        startActivity(i);
    }

}