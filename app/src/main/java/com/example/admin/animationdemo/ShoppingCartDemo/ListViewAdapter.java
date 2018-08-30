package com.example.admin.animationdemo.ShoppingCartDemo;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.Path;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.animationdemo.R;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    private Activity activity;
    private List<String> list;
    private LayoutInflater layoutInflater;
    private Point endPoint;
    private int statusBarHeight;
    private ImageView iv_shoppingCart;

    public ListViewAdapter(Activity activity, List<String> list) {
        this.activity = activity;
        this.list = list;
        layoutInflater = LayoutInflater.from(activity);
        statusBarHeight = getStateBar3();
    }


    public void setIv_shoppingCart(ImageView iv_shoppingCart) {
        this.iv_shoppingCart = iv_shoppingCart;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_layout_listview, null);
            viewHolder = new ViewHolder();
            viewHolder.tv_name = convertView.findViewById(R.id.tv_name);
            viewHolder.bt_subtract = convertView.findViewById(R.id.bt_subtract);
            viewHolder.tv_show_count = convertView.findViewById(R.id.tv_show_count);
            viewHolder.bt_add = convertView.findViewById(R.id.bt_add);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_name.setText("item" + position);
        viewHolder.tv_show_count.setText("" + 0);
        viewHolder.bt_subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = Integer.parseInt(viewHolder.tv_show_count.getText().toString());
                count--;
                viewHolder.tv_show_count.setText("" + count);
            }
        });
        viewHolder.bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = Integer.parseInt(viewHolder.tv_show_count.getText().toString());
                count++;
                viewHolder.tv_show_count.setText("" + count);
                startAnimation(viewHolder.bt_add);
            }
        });
        return convertView;
    }


    class ViewHolder {
        TextView tv_name, tv_show_count;
        ImageView bt_subtract, bt_add;
    }


    public void startAnimation(final View view) {

        if (iv_shoppingCart == null) {
            return;
        }

        int[] size = new int[2];
        view.getLocationInWindow(size);
        //动画的起点坐标
        float x = size[0];
        float y = size[1] - statusBarHeight;
        Point startPoint = new Point((int) x, (int) y);
        //终点坐标
        if (endPoint == null) {
            int[] size2 = new int[2];
            iv_shoppingCart.getLocationInWindow(size2);
            float x2 = size2[0];
            float y2 = size2[1] - statusBarHeight;
            endPoint = new Point((int) x2, (int) y2);
        }
        //控制点坐标
        final Point controllPoint = new Point(endPoint.x, (int) y);





        //在起点增加一个控件
        final ImageView imageView = new ImageView(activity);
        imageView.setImageBitmap(BitmapFactory.decodeResource(activity.getResources(), R.drawable.image_add));
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setTranslationX(startPoint.x);
        imageView.setTranslationY(startPoint.y);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(view.getLayoutParams().width, view.getLayoutParams().height);
        activity.addContentView(imageView, lp);

        //-----------------------方式一  ----------------
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new MyEvaluator(controllPoint), startPoint, endPoint);
        valueAnimator.setDuration(2000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Point currenPoint = (Point) animation.getAnimatedValue();
                imageView.setTranslationX(currenPoint.x);
                imageView.setTranslationY(currenPoint.y);
            }
        });
        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                //动画结束时移除view
                ((ViewGroup)imageView.getParent()).removeView(imageView);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        valueAnimator.start();
    }

    /**
     * 获取状态栏高度
     * @return
     */
    private int getStateBar3() {
        int result = 0;
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = activity.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }


}
