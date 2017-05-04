package com.example.a37925.behaviordemo;

import android.content.Context;
import android.provider.Settings;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Qiushuo Huang on 2017/4/19.
 */

public class LearnBehavior extends CoordinatorLayout.Behavior<TextView> {
    private int width, height;
    private long pretime;
    public LearnBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        DisplayMetrics display = context.getResources().getDisplayMetrics();
        width = display.widthPixels;
        height = display.heightPixels;
    }

    /**
     * 绑定
     *
     * @param parent     CoordinatorLayout
     * @param child      使用Behavior的childView，绑定对象
     * @param dependency 依赖的childView
     * @return true 绑定
     */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
        return dependency instanceof MoveView;
    }

    /**
     * 依赖的childView 发生改变时
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {
        int top = dependency.getTop();
        int left = dependency.getLeft();

        int x = width - left - child.getWidth();
        int y = height - top - child.getHeight();
        long currentTime = System.currentTimeMillis();
        Log.e("time", currentTime-pretime+"" );
        pretime = currentTime;
        setPosition(child, x, y);

        return true;
    }

    /**
     * 设置坐标
     */
    private void setPosition(View v, int x, int y) {
        CoordinatorLayout.MarginLayoutParams layoutParams = (CoordinatorLayout.MarginLayoutParams) v.getLayoutParams();
        layoutParams.leftMargin = x;
        layoutParams.topMargin = y;
        layoutParams.width = y / 2;
        v.setLayoutParams(layoutParams);
    }
}
