package com.beast.nari;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    Animation atg,btg;
    TextView nari,text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        nari = findViewById(R.id.ssnari);
        text = findViewById(R.id.sstext);

        atg = AnimationUtils.loadAnimation(this,R.anim.atg);
        btg = AnimationUtils.loadAnimation(this,R.anim.btg);

        nari.startAnimation(atg);
        text.startAnimation(btg);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this,MainPage.class);

//                Pair[] pairs = new Pair[3];
//                pairs[0] = new Pair<View,String>(lottieAnimationView, "logo_image");
//                pairs[1] = new Pair<View,String>(textView, "logo_text");
//                pairs[2] = new Pair<View,String>(textView2, "logo_text1");
//
//                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(splashscreen.this, pairs);
                startActivity(intent);
                finish();

            }
        },2500);
    }
}