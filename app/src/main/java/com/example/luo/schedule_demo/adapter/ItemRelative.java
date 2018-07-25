package com.example.luo.schedule_demo.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.luo.schedule_demo.R;

/**
 * Created by luo on 2018/6/4.
 */
public class ItemRelative extends RelativeLayout {
    public ItemRelative(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.item_relative,this);
    }

    public ItemRelative(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public ItemRelative(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ItemRelative(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
