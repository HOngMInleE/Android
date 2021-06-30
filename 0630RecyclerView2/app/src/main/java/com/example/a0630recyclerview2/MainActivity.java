package com.example.a0630recyclerview2;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

//    RecyclerView recyclerView;
//    PersonAdapter personAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

//        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        PersonAdapter adapter = new PersonAdapter();

        adapter.addItem(new Person("사람1", "010-1234-7891"));
        adapter.addItem(new Person("사람2", "010-1234-8912"));
        adapter.addItem(new Person("사람3", "010-1234-9123"));
        adapter.addItem(new Person("사람4", "010-1234-1234"));
        adapter.addItem(new Person("사람5", "010-1234-2345"));
        adapter.addItem(new Person("사람6", "010-1234-3456"));
        adapter.addItem(new Person("사람7", "010-1234-4567"));
        adapter.addItem(new Person("사람8", "010-1234-5678"));
        adapter.addItem(new Person("사람9", "010-1234-6789"));
        adapter.addItem(new Person("사람10", "010-1234-7890"));

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnPersonItemClickListener() {
            @Override
            public void onItemClick(PersonAdapter.ViewHolder holder, View view, int position) {
                Person item = adapter.getItem(position);

                Toast.makeText(getApplicationContext(), "선택된 정보는 : " + item.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });


    }


}