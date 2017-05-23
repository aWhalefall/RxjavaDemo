package com.nuoyuan.rxdemo.category10_connectable_observable_operators;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.nuoyuan.rxdemo.base.BaseActivity;
import com.nuoyuan.rxdemo.R;

public class Category10_ConnectableObservableOperatorsActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_category10_connectable_observable_operators);
    }

    /**
     * 10.1 connect
     * @param view
     */
    public void jumpToCategory10Operator1ConnectActivity(View view) {
        startActivity(new Intent(this, Category10Operator1ConnectActivity.class));
    }

    /**
     * 10.2 publish
     * @param view
     */
    public void jumpToCategory10Operator2PublishActivity(View view) {
        startActivity(new Intent(this, Category10Operator2PublishActivity.class));
    }

    /**
     * 10.3 replay
     * @param view
     */
    public void jumpToCategory10Operator3ReplayActivity(View view) {
        startActivity(new Intent(this, Category10Operator3ReplayActivity.class));
    }

    /**
     * 10.4 refCount
     * @param view
     */
    public void jumpToCategory10Operator4RefCountActivity(View view) {
        startActivity(new Intent(this, Category10Operator4RefCountActivity.class));
    }
}
