package com.example.a0616test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_LOGIN = 101;

    EditText usernameInput;
    EditText passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.passwordInput);

        Button loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();

                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("password", password);

                startActivityForResult(intent, REQUEST_CODE_LOGIN);

            }
        });

        Intent receivedIntent = getIntent();
        String username = receivedIntent.getStringExtra("username");
        String password = receivedIntent.getStringExtra("password");

        if (username == null || password == null) {
            Toast.makeText(this, "아이디 패스워드를 입력하세요.", Toast.LENGTH_LONG).show();

        }


    }

}