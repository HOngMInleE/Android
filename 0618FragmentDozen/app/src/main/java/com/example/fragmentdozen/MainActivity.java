package com.example.fragmentdozen;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ListFragment.ImageSelection {

    ListFragment listFragment;
    ViewFragment viewerFragment;

    int[] images = {R.drawable.a1, R.drawable.a2, R.drawable.a3};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onImageSelected(int position) {

    }
}