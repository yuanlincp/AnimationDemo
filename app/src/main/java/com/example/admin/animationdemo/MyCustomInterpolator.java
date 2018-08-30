package com.example.admin.animationdemo;

import android.animation.TimeInterpolator;

public class MyCustomInterpolator implements TimeInterpolator {
    @Override
    public float getInterpolation(float input) {
        if (input < 0.5) {

        }
        return 0;
    }
}
