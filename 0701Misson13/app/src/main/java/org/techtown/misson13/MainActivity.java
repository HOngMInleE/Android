package org.techtown.misson13;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    EditText editText2;
    EditText editText3;

    TextView textView;
    RecyclerView recyclerView;

    CustomerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        textView = findViewById(R.id.textView);

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new CustomerAdapter();

        adapter.addItem(new Customer("이홍민", "1998-04-15", "010-4214-7385", R.drawable.customerimage));
        adapter.addItem(new Customer("고길동", "1998-03-12", "010-1234-5678", R.drawable.customerimage));

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnCustomerItemClickListener() {
            @Override
            public void onItemClick(CustomerAdapter.ViewHolder holder, View view, int position) {
                Customer item = adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "선택 정보 : " + item.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                String birth = editText2.getText().toString();
                String mobile = editText3.getText().toString();

                adapter.addItem(new Customer(name, birth, mobile, R.drawable.customerimage));
                adapter.notifyDataSetChanged();

                textView.setText(adapter.getItemCount() + "명");
            }
        });



    }


}