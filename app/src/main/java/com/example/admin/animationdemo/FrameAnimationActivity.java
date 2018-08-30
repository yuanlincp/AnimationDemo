package com.example.admin.animationdemo;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * 帧动画
 */
public class FrameAnimationActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    Button btStart, btStop;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_frame);
        imageView = findViewById(R.id.imageView);
        btStart = findViewById(R.id.btStart);
        btStop = findViewById(R.id.btStop);
        btStart.setOnClickListener(this);
        btStop.setOnClickListener(this);
        initFrameAnimation();
    }

    private void initFrameAnimation() {
        animationDrawable = new AnimationDrawable();
        Drawable drawable1 = getResources().getDrawable(R.drawable.image1);
        Drawable drawable2 = getResources().getDrawable(R.drawable.image2);
        Drawable drawable3 = getResources().getDrawable(R.drawable.image3);
        Drawable drawable4 = getResources().getDrawable(R.drawable.image4);
        Drawable drawable5 = getResources().getDrawable(R.drawable.image5);
        animationDrawable.addFrame(drawable1, 200);
        animationDrawable.addFrame(drawable2, 200);
        animationDrawable.addFrame(drawable3, 200);
        animationDrawable.addFrame(drawable4, 200);
        animationDrawable.addFrame(drawable5, 200);
        animationDrawable.setOneShot(true);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btStart:
                startFrameAnimation();
                break;
            case R.id.btStop:
                stopFrameAnimation();
                break;
        }
    }

    private void startFrameAnimation() {
        imageView.setImageDrawable(animationDrawable);
        animationDrawable.start();
    }

    private void stopFrameAnimation() {
        imageView.setImageDrawable(animationDrawable);
        animationDrawable.stop();
    }
}
