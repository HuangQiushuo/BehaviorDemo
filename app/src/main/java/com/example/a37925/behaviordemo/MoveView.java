package com.example.a37925.behaviordemo;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by Qiushuo Huang on 2017/4/19.
 */

public class MoveView extends TextView {
    private float lastX, lastY;

    public MoveView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        float x = event.getRawX();
        float y = event.getRawY();
        if (action == MotionEvent.ACTION_MOVE) {
            CoordinatorLayout.MarginLayoutParams layoutParams = (CoordinatorLayout.MarginLayoutParams) getLayoutParams();
            //计算当前的左上角坐标
            float left = layoutParams.leftMargin + x - lastX;
            float top = layoutParams.topMargin + y - lastY;
            //设置坐标
            layoutParams.leftMargin = (int) left;
            layoutParams.topMargin = (int) top;
            setLayoutParams(layoutParams);
        }
        lastX = x;
        lastY = y;
        return true;
    }
}
