package com.example.admin.animationdemo;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * view动画activity
 */
public class ViewAnimationActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    Button bt1, bt2, bt3, bt4;
    Button bt5, bt6;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_view_animation);
        imageView = findViewById(R.id.imageView);
        imageView.setOnClickListener(this);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        bt5 = findViewById(R.id.bt5);
        bt6 = findViewById(R.id.bt6);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageView:
                Toast.makeText(this, "我是imageview", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt1://平移
                translationAnimation();
                break;
            case R.id.bt2://旋转
                rotateAnimation();
                break;
            case R.id.bt3://缩放
                scaleAnimation();
                break;
            case R.id.bt4://改变透明度
                alphaAnimation();
                break;
            case R.id.bt5://组合动画--同时执行
                combinedAnimation();
                break;
            case R.id.bt6://组合动画--先后执行
                combinedAnimation2();
                break;
        }
    }

    /**
     * 平移动画
     */
    private void translationAnimation() {
        //屏幕的宽高
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        int screenWidth = point.x;//屏幕宽
        int screenHeight = point.y;//屏幕高
        TranslateAnimation translateAnimation = new TranslateAnimation(0,
                screenWidth - imageView.getWidth(),
                0,
                screenHeight - imageView.getHeight());
        //设置动画在结束的位置显示
        translateAnimation.setFillEnabled(true);
        translateAnimation.setFillBefore(false);
        translateAnimation.setFillAfter(true);
        //重复次数
        translateAnimation.setRepeatCount(2);
        //重复的模式
        // Animation.RESTART:重新开始  Animation.REVERSE：第二遍动画倒序执行
        translateAnimation.setRepeatMode(Animation.REVERSE);
        translateAnimation.setDuration(2000);
        imageView.startAnimation(translateAnimation);
    }

    /**
     * 旋转
     */
    private void rotateAnimation() {
        RotateAnimation rotateAnimation = new RotateAnimation(0, 90,
                imageView.getWidth() / 2, imageView.getHeight() / 2);
        rotateAnimation.setDuration(2000);
        rotateAnimation.setFillEnabled(true);
        rotateAnimation.setFillBefore(false);
        rotateAnimation.setFillAfter(true);
//        rotateAnimation.setRepeatCount();
        //可以设置其他属性
        imageView.startAnimation(rotateAnimation);
    }

    /**
     * 缩放
     */
    private void scaleAnimation() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1f, 0.5f,
                1f, 0.5f);
        scaleAnimation.setDuration(2000);
        scaleAnimation.setFillEnabled(true);
        scaleAnimation.setFillBefore(false);
        scaleAnimation.setFillAfter(true);
        imageView.startAnimation(scaleAnimation);
    }

    /**
     * 改变透明度
     */
    private void alphaAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1f, 0.2f);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setFillAfter(true);
        imageView.startAnimation(alphaAnimation);
    }

    /**
     * 组合动画--同时执行
     */
    private void combinedAnimation() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1f, 0.5f, 1f, 0.5f);
        RotateAnimation rotateAnimation = new RotateAnimation(0, 180, imageView.getWidth() / 2, imageView.getHeight() / 2);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1f, 0.5f);

        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setFillAfter(true);
        animationSet.setDuration(2000);
        imageView.startAnimation(animationSet);
    }

    /**
     * 组合动画--先后执行
     */
    private void combinedAnimation2() {
        final ScaleAnimation scaleAnimation = new ScaleAnimation(1f, 0.5f, 1f, 0.5f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(2000);
        final RotateAnimation rotateAnimation = new RotateAnimation(0, 180, imageView.getWidth() / 2, imageView.getHeight() / 2);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setDuration(2000);
        final AlphaAnimation alphaAnimation = new AlphaAnimation(1f, 0.5f);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration(2000);

        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.startAnimation(rotateAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.startAnimation(alphaAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        imageView.startAnimation(scaleAnimation);
    }


}
