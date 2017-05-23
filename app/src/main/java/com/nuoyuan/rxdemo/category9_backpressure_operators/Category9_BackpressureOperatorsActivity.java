package com.nuoyuan.rxdemo.category9_backpressure_operators;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.nuoyuan.rxdemo.R;
import com.nuoyuan.rxdemo.base.BaseActivity;


public class Category9_BackpressureOperatorsActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_category9_backpressure_operators);
    }

    /**
     * 9.1 onBackpressureBuffer
     *
     * @param view
     */
    public void jumpToCategory9Operator1OnBackpressureBufferActivity(View view) {
        startActivity(new Intent(this, Category9Operator1OnBackpressureBufferActivity.class));
    }

    /**
     * 9.2 onBackpressureDrop
     *
     * @param view
     */
    public void jumpToCategory9Operator2OnBackpressureDropActivity(View view) {
        startActivity(new Intent(this, Category9Operator2OnBackpressureDropActivity.class));
    }

    /**
     * 9.3 onBackpressureLatest
     *
     * @param view
     */
    public void jumpToCategory9Operator3OnBackpressureLatestActivity(View view) {
        startActivity(new Intent(this, Category9Operator3OnBackpressureLatestActivity.class));
    }
}
