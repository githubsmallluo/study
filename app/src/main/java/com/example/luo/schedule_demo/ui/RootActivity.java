package com.example.luo.schedule_demo.ui;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import com.example.luo.schedule_demo.R;
import com.example.luo.schedule_demo.fragment.ChatFragment;
import com.example.luo.schedule_demo.fragment.PersonalcenterFragment;
import com.example.luo.schedule_demo.fragment.SchedulecardFragment;
import com.example.luo.schedule_demo.fragment.StudyFragment;

public class RootActivity extends Activity implements BottomNavigationBar.OnTabSelectedListener{

    private BottomNavigationBar bottomNavigationBar;
    private ChatFragment chatFragment = new ChatFragment();
    private PersonalcenterFragment personalcenterFragment = new PersonalcenterFragment();
    private SchedulecardFragment schedulecardFragment = new SchedulecardFragment();
    private StudyFragment studyFragment = new StudyFragment();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.root_activity);
        init();
    }

    private void init() {
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setTabSelectedListener(this);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED );
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_DEFAULT);
        bottomNavigationBar.setActiveColor(R.color.focus_true);  //选中颜色
        bottomNavigationBar.setInActiveColor(R.color.focus_false);         //未选中颜色
        bottomNavigationBar.setBarBackgroundColor(R.color.white);   //导航栏背景色

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.study, R.string.buttom_study))
                .addItem(new BottomNavigationItem(R.drawable.schedule_card, R.string.buttom_scheduleCard))
                .addItem(new BottomNavigationItem(R.drawable.chat, R.string.buttom_chat))
                .addItem(new BottomNavigationItem(R.drawable.personal_center,R.string.buttom_personalCenter))
                .initialise(); //initialise 一定要放在 所有设置的最后一项
        bottomNavigationBar.setTabSelectedListener(this);
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.tab_fragment, studyFragment);
        transaction.commit();
    }

    @Override
    public void onTabSelected(int position) {
        Log.d("TAG", "onTabSelected() called with: " + "position = [" + position + "]");
        FragmentManager fm = this.getFragmentManager();
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (position) {
            case 0:
                transaction.replace(R.id.tab_fragment, studyFragment);
                break;
            case 1:
                transaction.replace(R.id.tab_fragment, schedulecardFragment);
                break;
            case 2:
                transaction.replace(R.id.tab_fragment, chatFragment);
                break;
            case 3:
                transaction.replace(R.id.tab_fragment, personalcenterFragment);
                break;
            default:
                break;
        }
        // 事务提交
        transaction.commit();

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
