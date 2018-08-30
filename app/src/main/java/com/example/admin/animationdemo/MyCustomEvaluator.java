package com.example.admin.animationdemo;

import android.animation.TypeEvaluator;

public class MyCustomEvaluator implements TypeEvaluator<Float> {

    @Override
    public Float evaluate(float fraction, Float startValue, Float endValue) {
        //计算规则
        return startValue + (endValue - startValue) * fraction;
    }
}
