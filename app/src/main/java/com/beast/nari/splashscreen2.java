package com.beast.nari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class splashscreen2 extends AppCompatActivity {

    Animation atg;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen2);
        text = findViewById(R.id.hiii);


        atg = AnimationUtils.loadAnimation(this,R.anim.atg);
        text.startAnimation(atg);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splashscreen2.this,MainActivity.class);

//                Pair[] pairs = new Pair[3];
//                pairs[0] = new Pair<View,String>(lottieAnimationView, "logo_image");
//                pairs[1] = new Pair<View,String>(textView, "logo_text");
//                pairs[2] = new Pair<View,String>(textView2, "logo_text1");
//
//                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(splashscreen.this, pairs);
                startActivity(intent);
                finish();

            }
        },7000);

    }
}