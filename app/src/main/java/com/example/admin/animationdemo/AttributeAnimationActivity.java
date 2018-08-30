package com.example.admin.animationdemo;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;


/**
 * 属性动画
 */
public class AttributeAnimationActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView;

    Button bt1, bt2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_attribute);
        imageView = findViewById(R.id.imageView);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt1:
                startAnimation();
                break;
            case R.id.bt2:
                startAnimator();
                break;
        }
    }

    /**
     * 使用ValuaAnimator改变透明度
     */
    private void startAnimation() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(1f, 0.3f);
        valueAnimator.setDuration(2000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float currenAlpha = (float) animation.getAnimatedValue();
                imageView.setAlpha(currenAlpha);
            }
        });
        valueAnimator.start();
    }

    /**
     * 使用ObjectAnimator和估值器改变透明度
     * 注意：属性名字必须有对应的get和set方法
     */
    private void startAnimator() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofObject(imageView, "alpha", new MyCustomEvaluator(), 1f, 0.3f);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }



}
