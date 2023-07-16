package com.example.hotel_luxvoy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemChangeListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.hotel_luxvoy.R;

import java.util.ArrayList;

public class OnboardSliderActivity extends AppCompatActivity {
    TextView tvTitle, tvDescription;

    ImageView imgSignUp, imgSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding_slider);
        tvTitle = findViewById(R.id.tvTitle);
        tvDescription = findViewById(R.id.tvDescription);

        imgSignUp = findViewById(R.id.imgSignUp);
        imgSignIn = findViewById(R.id.imgSignIn);

        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.slider1, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.slider2, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.slider3, ScaleTypes.FIT));

        ImageSlider imageSlider = findViewById(R.id.image_slider);
        imageSlider.setImageList(imageList);

        imageSlider.setItemChangeListener(new ItemChangeListener() {
            @Override
            public void onItemChanged(int position) {
                switch (position) {
                    case 0:
                        updateSlideContent("Discover the beauty of Vietnam", "230+ Hotels to earn and redeem your point.");
                        break;
                    case 1:
                        updateSlideContent("Travel with ease", "Book, check in and make requests from anywhere.");
                        break;
                    case 2:
                        updateSlideContent("Elevate your experience", "Gain access to special rates and exclusive experiences.");
                        break;
                }
            }
        });

        imgSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OnboardSliderActivity.this, SignUpActivity.class));
            }
        });

        imgSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OnboardingSliderActivity.this, SignInActivity.class));
            }
        });
    }

    private void updateSlideContent(String title, String description) {
        tvTitle.setText(title);
        tvDescription.setText(description);
    }
}
