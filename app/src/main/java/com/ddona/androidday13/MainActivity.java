package com.ddona.androidday13;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.ddona.androidday13.adapter.MusicPagerAdapter;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ViewPager vpPage;
    private MusicPagerAdapter adapter;
    private TabLayout tlMusic;
    private NavigationView navMusic;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vpPage = findViewById(R.id.vp_page);
        adapter = new MusicPagerAdapter(getSupportFragmentManager());
        drawerLayout = findViewById(R.id.drawer);
        vpPage.setAdapter(adapter);
        tlMusic = findViewById(R.id.tab_music);
        tlMusic.setupWithViewPager(vpPage);
        navMusic = findViewById(R.id.nav_music);
        navMusic.setNavigationItemSelectedListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            if(drawerLayout.isDrawerOpen(GravityCompat.END)) {
                drawerLayout.closeDrawer(GravityCompat.END);
            } else {
                drawerLayout.openDrawer(GravityCompat.END);
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_song:
                vpPage.setCurrentItem(0);
                return true;
            case R.id.nav_album:
                vpPage.setCurrentItem(1);
                return true;
            case R.id.nav_artist:
                vpPage.setCurrentItem(2);
                return true;
            case R.id.nav_app_infor:
                Toast.makeText(this, "I'm pro", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }
}
