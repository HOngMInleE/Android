package org.techtown.teachertest;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    WebView webView;
    Button button;
    Button buttonBack;
    Button buttonfor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        webView = findViewById(R.id.webView);

        button = findViewById(R.id.button);
        buttonBack = findViewById(R.id.buttonBack);
        buttonfor = findViewById(R.id.buttonForward);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl(editText.getText().toString());
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.goBack();
            }
        });

        buttonfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.goForward();
            }
        });



    }



}