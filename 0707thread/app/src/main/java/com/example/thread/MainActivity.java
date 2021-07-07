package com.example.thread;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    TextView textView;

//    MainHandler handler;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
             @Override
            public void onClick(View v) {
                BackGroundThread thread  = new BackGroundThread();
                thread.start();
            }
        });

//        handler = new MainHandler();
    }

    class BackGroundThread extends Thread {
        int value = 0;

        public void run() {
            for (int i=0; i<100; i++) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e ) {

                }
                value += 1;
                Log.d("Thread", "value" + value);
//                textView.setText(value); // 프로그램 강제 다운 됨. // GUI, View 들에 대한 데이터 처리는 Main Thread에서만 가능.

//                Message message = handler.obtainMessage();
//                Bundle bundle = new Bundle();
//                bundle.putInt("value", value);
//                message.setData(bundle);
//
//                handler.sendMessage(message);

    // Runnable 객체 실행 방식

                handler.post(
                        new Runnable() {
                            @Override
                            public void run() {
                                textView.setText(String.valueOf(value));
                            }
                        }
                );
            }
        }
    }

//    class MainHandler extends Handler {
//        @Override
//        public void handleMessage( Message msg) {
//            super.handleMessage(msg);
//
//            Bundle bundle = msg.getData();
//            int value = bundle.getInt("value");
////            textView.setText("value 값 : " + value);
//            textView.setText(String.valueOf(value));
//        }
//    }

}
