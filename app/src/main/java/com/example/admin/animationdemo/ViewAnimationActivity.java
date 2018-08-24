package com.example.admin.animationdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

/**
 * view动画activity
 */
public class ViewAnimationActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    Button bt1, bt2, bt3, bt4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_view_animation);
        imageView = findViewById(R.id.imageView);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
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
        TranslateAnimation translateAnimation = new TranslateAnimation(0,
                display.getWidth() - imageView.getWidth(),
                0,
                display.getHeight() - imageView.getHeight());
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
//        ScaleAnimation scaleAnimation=new ScaleAnimation();
    }


}
