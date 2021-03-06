package com.kellydouglass.venmo2.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.kellydouglass.venmo2.R;

public class Purchases extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchases);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_down_rev, R.anim.slide_up_rev);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            overridePendingTransition(R.anim.slide_down_rev, R.anim.slide_up_rev);
            return true;
        }
        return false;
    }
}
