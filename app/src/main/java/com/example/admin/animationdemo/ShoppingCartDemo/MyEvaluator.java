package com.example.admin.animationdemo.ShoppingCartDemo;

import android.animation.TypeEvaluator;
import android.graphics.Point;

public class MyEvaluator implements TypeEvaluator<Point> {

    Point controlPoint;

    public MyEvaluator(Point controlPoint) {
        this.controlPoint = controlPoint;
    }

    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        //二阶贝塞尔曲线公式
        //value=（1-t）²P1+2t（1-t）P2+t²P3
        int x = Berizaer2(fraction, startValue.x, controlPoint.x, endValue.x);
        int y = Berizaer2(fraction, startValue.y, controlPoint.y, endValue.y);
        return new Point(x, y);
    }


    private int Berizaer2(float fraction, int start, int controll, int end) {
        int x = (int) ((1 - fraction) * (1 - fraction) * start + 2 * fraction * (1 - fraction) * controll + fraction * fraction * end);
        return x;
    }
}
