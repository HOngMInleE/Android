package com.example.drawer;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, FragmentCallback {

    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    DrawerLayout drawer;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar( toolbar);

        drawer = findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);

            fragment1 = new Fragment1();
            fragment2 = new Fragment2();
            fragment3 = new Fragment3();

            getSupportFragmentManager().beginTransaction().add(R.id.container, fragment1).commit();

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.f1) {
            Toast.makeText(this, "첫 번째 메뉴 선택됨.", Toast.LENGTH_LONG).show();
            onFragment(0, null);
        }else if(id == R.id.f2) {
            Toast.makeText(this, "두 번째 메뉴 선택됨.", Toast.LENGTH_LONG).show();
            onFragment(1, null);
        }else if(id == R.id.f3) {
            Toast.makeText(this, "세 번째 메뉴 선택됨.", Toast.LENGTH_LONG).show();
            onFragment(2, null);
        }

        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onFragment(int position, Bundle bundle) {
        Fragment curFragment = null;

        if(position == 0) {
            curFragment = fragment1;
            toolbar.setTitle("첫 번째 화면");
        }if(position == 1) {
            curFragment = fragment2;
            toolbar.setTitle("두 번째 화면");
        }if(position == 2) {
            curFragment = fragment3;
            toolbar.setTitle("세 번째 화면");
        }


        getSupportFragmentManager().beginTransaction().replace(R.id.container, curFragment).commit();
    }



}