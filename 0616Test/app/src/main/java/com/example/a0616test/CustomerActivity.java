package com.example.a0616test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CustomerActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_CUSTOM = 103;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        Button buttonMenu = findViewById(R.id.buttonMenu);
        Button buttonLogin = findViewById(R.id.buttonLogin);

        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);

                startActivityForResult(intent, REQUEST_CODE_CUSTOM);
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);

                startActivityForResult(intent, REQUEST_CODE_CUSTOM);
            }
        });

        Toast.makeText(this, "고객 관리 화면", Toast.LENGTH_LONG).show();
    }
}