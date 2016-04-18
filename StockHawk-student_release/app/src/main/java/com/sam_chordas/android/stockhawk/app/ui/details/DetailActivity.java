package com.sam_chordas.android.stockhawk.app.ui.details;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.sam_chordas.android.stockhawk.R;
import com.sam_chordas.android.stockhawk.app.base.BaseActivity;
import com.sam_chordas.android.stockhawk.app.model.Quote;

import butterknife.Bind;
import butterknife.ButterKnife;
/**
 * Copyright (C) 2015 The Android Open Source Project
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class DetailActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    /**
     * Create a new Instance of the activity with the movie form data.
     */
    public static void newInstance(Activity activity, Quote quote) {
        Intent intent = new Intent(activity, DetailActivity.class);
        Bundle extras = new Bundle();
        extras.putParcelable(Quote.QUOTE, quote);
        intent.putExtras(extras);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setToolbar(toolbar);
        initVars();
    }

    private void initVars() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        if (getIntent() != null && getIntent().getExtras().containsKey(Quote.QUOTE)) {
            navigateMainContent(DetailFragment.newInstance((Quote) getIntent().getExtras().getParcelable(Quote.QUOTE)), getString(R.string.app_name));
        }
    }
}
