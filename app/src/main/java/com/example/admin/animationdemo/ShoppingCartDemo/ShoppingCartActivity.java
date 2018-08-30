package com.example.admin.animationdemo.ShoppingCartDemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.admin.animationdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 往购物车增加商品的动画demo
 */
public class ShoppingCartActivity extends AppCompatActivity {
    private ListView lv_show_data;
    private ImageView iv_shopping_cart;
    private List<String> list;
    private ListViewAdapter listAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_shopping_cart);
        lv_show_data = findViewById(R.id.lv_show_data);
        iv_shopping_cart = findViewById(R.id.iv_shopping_cart);
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("" + i);
        }
        listAdapter = new ListViewAdapter(this, list);
        lv_show_data.setAdapter(listAdapter);
        listAdapter.setIv_shoppingCart(iv_shopping_cart);
    }
}
