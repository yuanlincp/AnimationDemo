package com.example.admin.animationdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.admin.animationdemo.ShoppingCartDemo.ShoppingCartActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt1, bt2, bt3,bt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            case R.id.bt1:
                startActivity(new Intent(this, ViewAnimationActivity.class));
                break;
            case R.id.bt2:
                startActivity(new Intent(this, FrameAnimationActivity.class));
                break;
            case R.id.bt3:
                startActivity(new Intent(this, AttributeAnimationActivity.class));
                break;
            case R.id.bt4:
                startActivity(new  Intent(this, ShoppingCartActivity.class));
                break;
        }
    }
}
