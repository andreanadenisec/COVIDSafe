package com.cadelina.afinal;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    //Arrays
    public int[] slide_images = {
            R.drawable.picture_1,
            R.drawable.picture_2,
            R.drawable.picture_3,
            R.drawable.picture_4
    };

    public int[] slide_bgs = {
            R.drawable.onboarding_1,
            R.drawable.onboarding_2,
            R.drawable.onboarding_3,
            R.drawable.onboarding_4
    };

    public String[] slide_headings = {
            "Welcome to COVIDSafe",
            "Keep your records",
            "Protect Yourself",
            "Stop the spread of Covid-19"
    };

    public String[] slide_descs = {
            "COVIDSafe lets you access your personal \n up to date health information.",
            "Keep track of the places you’ve been through \n for contact tracing purposes.",
            "Be aware and prepared of COVID-19 Pandemic \n by knowing the symptoms and preventions.",
            "Let’s help each other in stopping the pandemic by \n strictly following the health and safety protocols."
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (LinearLayout) object;
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((LinearLayout)object);
    }
}
