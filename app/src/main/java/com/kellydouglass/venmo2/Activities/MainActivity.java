package com.kellydouglass.venmo2.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.kellydouglass.venmo2.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);


        NavigationView navView = findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_search:
                Intent searchIntent = new Intent(MainActivity.this, SearchPeople.class);
                startActivity(searchIntent);
                break;
            case R.id.nav_venmo_card:
                Intent cardIntent = new Intent(MainActivity.this, VenmoCard.class);
                startActivity(cardIntent);
                break;
            case R.id.nav_scan_code:
                Intent scanIntent = new Intent(MainActivity.this, ScanCard.class);
                startActivity(scanIntent);
                break;
            case R.id.nav_payment_methods:
                Intent payIntent = new Intent(MainActivity.this, PaymentMethods.class);
                startActivity(payIntent);
                break;
            case R.id.nav_incomplete:
                Intent incompleteIntent = new Intent(MainActivity.this, Incomplete.class);
                startActivity(incompleteIntent);
                break;
            case R.id.nav_purchases:
                Intent purchasesIntent = new Intent(MainActivity.this, Purchases.class);
                startActivity(purchasesIntent);
                break;
            case R.id.nav_get_help:
                Intent helpIntent = new Intent(MainActivity.this, GetHelp.class);
                startActivity(helpIntent);
                break;
            case R.id.nav_settings:
                Intent settingsIntent = new Intent(MainActivity.this, Settings.class);
                startActivity(settingsIntent);
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {


        MenuItem navigation_item_1 = menu.findItem(R.id.navigation_item_1);
        MenuItem nav_search = menu.findItem(R.id.nav_search);
        MenuItem nav_venmo_card = menu.findItem(R.id.nav_venmo_card);
        MenuItem nav_scan_code = menu.findItem(R.id.nav_scan_code);
        MenuItem nav_payment_methods = menu.findItem(R.id.nav_payment_methods);
        MenuItem nav_incomplete = menu.findItem(R.id.nav_incomplete);
        MenuItem nav_purchases = menu.findItem(R.id.nav_purchases);
        MenuItem nav_get_help = menu.findItem(R.id.nav_get_help);
        MenuItem nav_settings = menu.findItem(R.id.nav_settings);

        navigation_item_1.setVisible(false);
        nav_search.setVisible(false);
        nav_venmo_card.setVisible(false);
        nav_scan_code.setVisible(false);
        nav_payment_methods.setVisible(false);
        nav_incomplete.setVisible(false);
        nav_purchases.setVisible(false);
        nav_get_help.setVisible(false);
        nav_settings.setVisible(false);


        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {



        getMenuInflater().inflate(R.menu.drawer_menu, menu);
        MenuCompat.setGroupDividerEnabled(menu, true);

        return true;
    }
}
