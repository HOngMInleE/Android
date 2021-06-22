package com.example.fragmentdozen;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity implements ListFragment.ImageSelection {

    ListFragment listFragment;
    ViewerFragment viewerFragment;

    int[] images = {R.drawable.a1, R.drawable.a2, R.drawable.a3};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    FragmentManager manager = getSupportFragmentManager();
    listFragment = (ListFragment)manager.findFragmentById(R.id.listFragment);
    viewerFragment = (ViewerFragment)manager.findFragmentById(R.id.viewerFragment);


    }



    @Override
    public void onImageSelected(int position) {
        viewerFragment.setImage(images[position]);
    }
}