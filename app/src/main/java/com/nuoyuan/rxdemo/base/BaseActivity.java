package com.nuoyuan.rxdemo.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nuoyuan.rxdemo.R;

/**
 * Created by weichyang on 2017/4/21.
 */

public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baseactvitiy);

    }

    private NestedScrollView contentView = null;
    protected Toolbar mToolbar;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        if (contentView == null && R.layout.baseactvitiy == layoutResID) {
            super.setContentView(R.layout.baseactvitiy);
            contentView = (NestedScrollView) findViewById(R.id.nsv_content);
            contentView.removeAllViews();
        } else if (layoutResID != R.layout.baseactvitiy) {
            View addView = LayoutInflater.from(this).inflate(layoutResID, null);
            contentView.addView(addView, new ViewGroup.LayoutParams(NestedScrollView.LayoutParams.MATCH_PARENT, NestedScrollView.LayoutParams.MATCH_PARENT));

            mToolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }
    }


}
