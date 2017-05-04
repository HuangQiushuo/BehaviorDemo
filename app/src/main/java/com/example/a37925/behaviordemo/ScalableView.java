package com.example.a37925.behaviordemo;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by Qiushuo Huang on 2017/4/24.
 */

public class ScalableView extends TextView {
    private float lastX, lastY;

    public ScalableView(Context context) {
        super(context);
    }

    public ScalableView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScalableView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        float x = event.getRawX();
        float y = event.getRawY();
        if (action == MotionEvent.ACTION_MOVE) {
            CoordinatorLayout.MarginLayoutParams layoutParams = (CoordinatorLayout.MarginLayoutParams) getLayoutParams();
            //计算当前的左上角坐标
            float left = layoutParams.width + x - lastX;
            float top = layoutParams.height + y - lastY;
            //设置坐标
            layoutParams.width = (int) left;
            layoutParams.height = (int) top;
            setLayoutParams(layoutParams);
        }
        lastX = x;
        lastY = y;
        return true;
    }
}
