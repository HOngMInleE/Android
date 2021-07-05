package com.example.mission15;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CustomerInputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_input);

        Button button = findViewById(R.id.saveButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMainActivity();
            }
        });
    }

    private void goToMainActivity() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.entry, R.anim.exit);

    }
}