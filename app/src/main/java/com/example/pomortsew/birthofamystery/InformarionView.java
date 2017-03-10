package com.example.pomortsew.birthofamystery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import human.*;
import computing.*;
import inputOutputData.*;

public class InformarionView extends AppCompatActivity {
    Button buttonInformationViewNewCalculation;
    Button buttonInformationVuewBack;
    TextView textViewInformationViewInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informarion_view);

        String name = getIntent().getStringExtra("name");
        String surname = getIntent().getStringExtra("surname");
        String patronymic = getIntent().getStringExtra("patronymic");

        int year = Integer.valueOf(getIntent().getStringExtra("year"));
        int month = Integer.valueOf(getIntent().getStringExtra("month"));
        int day = Integer.valueOf(getIntent().getStringExtra("day"));

        Human human = new HumanBuilder().name(name)
                .surname(surname)
                .patronymic(patronymic)
                .yearOfBirth(year)
                .monthOfBirth(month)
                .birthday(day).bilid();
            Cycles cycles=new Cycles(human);
        outInputData in = new outInputData();
//        Selection selection=new Selection(cycles);
          ConstruclionInformation construclionInformation=new ConstruclionInformation(cycles);
        String info=construclionInformation.OutInfo(this);
        buttonInformationViewNewCalculation = (Button) findViewById(R.id.button_information_new_calculation);
        buttonInformationVuewBack = (Button) findViewById(R.id.button_informationView_back);
        textViewInformationViewInformation = (TextView) findViewById(R.id.textView_informationView_information);
//        textViewInformationViewInformation.setText(in.out(human,cycles));
            textViewInformationViewInformation.setText(info);

        View.OnClickListener onClickListenerButton = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button_information_new_calculation:
                        Intent intent = new Intent(InformarionView.this, FillForm.class);
                        startActivity(intent);
                        break;
                    case R.id.button_informationView_back:
                        onDestroy();

                }
            }
        };
        buttonInformationVuewBack.setOnClickListener(onClickListenerButton);
        buttonInformationViewNewCalculation.setOnClickListener(onClickListenerButton);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }
}
