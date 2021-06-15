package org.techtown.a0615samplecallintent;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                ComponentName name = new ComponentName("org.techtown.a0615samplecallintent",
                        "org.techtown.a0615samplecallintent.MainActivity");
                intent.setComponent(name);
                startActivityForResult(intent,101);
            }
        });
//                  넘겨진 intent 정보를 받아옴.

        Intent receiveIntent = getIntent();
        String username = receiveIntent.getStringExtra("username");
        String password = receiveIntent.getStringExtra("password");

        Toast.makeText(this, "username : " + username + ", password : " + password, Toast.LENGTH_LONG).show();

    }
}