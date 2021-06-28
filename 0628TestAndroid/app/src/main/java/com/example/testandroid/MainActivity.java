package com.example.testandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = (Fragment1) getSupportFragmentManager().findFragmentById(R.id.container);
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

    }




    public void onGotoMainFragment(int index) {
        if ( index == 0) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
        } else if ( index == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment2).commit();
        } else if ( index == 2) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment3).commit();
        }
    }


    public void onButton1(View view) {
        if ( view != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment2).commit();
        }

    }

    public void onButton2(View view) {
        if ( view != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment3).commit();
        }
    }



}