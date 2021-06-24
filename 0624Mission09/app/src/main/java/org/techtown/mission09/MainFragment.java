package org.techtown.mission09;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MainFragment extends Fragment {

    EditText nameInput;
    EditText ageInput;

    Button birthButton;
    Button saveButton;

    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);

        nameInput = rootView.findViewById(R.id.nameInput);
        ageInput = rootView.findViewById(R.id.ageInput);

        birthButton = rootView.findViewById(R.id.birthButton);
        saveButton = rootView.findViewById(R.id.saveButton);

        birthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //showDataDialog();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameStr = nameInput.getText().toString();
                String ageStr = ageInput.getText().toString();
                String birthStr = birthButton.getText().toString();

                Toast.makeText(getContext(),"이름: " + nameStr + "나이: " + ageStr+ "생년월일: " + birthStr,Toast.LENGTH_LONG).show();
            }
        });

        Date curDate = new Date();
        setSelectDate(curDate);

        return rootView;
    }

    private void setSelectDate(Date curDate) {
        String selectDateStr = dateFormat.format(curDate);
    }




}