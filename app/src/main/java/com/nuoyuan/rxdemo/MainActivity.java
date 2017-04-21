package com.nuoyuan.rxdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.nuoyuan.rxdemo.transportcontrol.Category2Operator3ScanActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void jump(View view) {
        startActivity(new Intent(this, Category2Operator3ScanActivity.class));
    }
}
