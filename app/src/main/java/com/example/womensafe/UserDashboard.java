package com.example.womensafe;


import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import android.os.Bundle;


import com.google.android.material.navigation.NavigationView;

public class UserDashboard extends AppCompatActivity {
    DrawerLayout drawerlayout;
    NavigationView navigationView;
    Toolbar toolBar;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        drawerlayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view1);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerlayout, R.string.menu_Open, R.string.menu_Close);
        drawerlayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        navigationView = (NavigationView) findViewById(R.id.nav_view1);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.nav_user){
                    openUserDetail();
                    drawerlayout.closeDrawer(GravityCompat.START);
                }
                else if(item.getItemId() == R.id.nav_guardian){
                    openGuardian();
                    drawerlayout.closeDrawer(GravityCompat.START);
                }
                else if (item.getItemId() == R.id.nav_alert){
                    openAlert();
                    drawerlayout.closeDrawer(GravityCompat.START);
                }
                else if (item.getItemId() == R.id.nav_dashboard){
                    openDashBoard();
                    drawerlayout.closeDrawer(GravityCompat.START);
                }
                return true;

            }
        });

    }

    public void openUserDetail(){
        Intent intent = new Intent(UserDashboard.this, UserDetails.class);
        startActivity(intent);
    }

    public void openGuardian(){
        Intent intent = new Intent(this, Guardian.class);
        startActivity(intent);
    }

    public void openAlert(){
        Intent intent = new Intent(this, AddAlert.class);
        startActivity(intent);
    }

    public void openDashBoard(){
        Intent intent = new Intent(this, UserDashboard.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}


