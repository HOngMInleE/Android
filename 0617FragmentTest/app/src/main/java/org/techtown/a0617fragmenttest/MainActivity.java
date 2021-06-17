package org.techtown.a0617fragmenttest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    LoginFragment loginFragment;
    MenuFragment menuFragment;
    CustomerFragment customerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginFragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.mainFragment);
        menuFragment = new MenuFragment();
        customerFragment = new CustomerFragment();

    }

    public void onFragmentChanged(int index) {
        if ( index == 0) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, menuFragment).commit();
        }else if (index == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, customerFragment).commit();
        }else if (index == 2) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, loginFragment).commit();
        }
    }


}