package com.sam_chordas.android.stockhawk.app.ui.init;

import android.content.Intent;
import android.os.Bundle;

import com.sam_chordas.android.stockhawk.R;
import com.sam_chordas.android.stockhawk.app.base.BaseActivity;
import com.sam_chordas.android.stockhawk.app.ui.MainActivity;

import butterknife.ButterKnife;


public class ActivitySplash extends BaseActivity {

    private void initVars() {
        startActivity(new Intent(ActivitySplash.this, MainActivity.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initVars();
    }

}
