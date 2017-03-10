package com.example.pomortsew.birthofamystery;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class FillForm extends AppCompatActivity {
    EditText editTextFillFormName;
    EditText editTextFillFormSurname;
    EditText editTextFillFormPatronymic;
    TextView textViewFillFormDateOfBirth;
//    EditText editTextFillFormMonth;
//    EditText editTextFillFormDay;

    Button buttonFillFormCalculation;
    Button buttonFillFormOtherCalculation;
    Button buttonFillFormInstallDate;

    Calendar calendar;


    String YEAR;
    String DAY;
    String MONTH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_form);

//        editTextFillFormDay = (EditText) findViewById(R.id.editText_fill_form_day);
//        editTextFillFormMonth = (EditText) findViewById(R.id.editText_fill_form_month);
        textViewFillFormDateOfBirth = (TextView) findViewById(R.id.textView_fill_form_date_of_birth);
        editTextFillFormName = (EditText) findViewById(R.id.editText_fill_form_name);
        editTextFillFormSurname = (EditText) findViewById(R.id.editText_fill_form_surname);
        editTextFillFormPatronymic = (EditText) findViewById(R.id.editText_fill_form_patronymic);

        buttonFillFormInstallDate=(Button) findViewById(R.id.button_fill_form_instal_date);
        buttonFillFormCalculation = (Button) findViewById(R.id.button_fill_form_calculation);
        buttonFillFormOtherCalculation = (Button) findViewById(R.id.button_fill_form_other_calculation);

        calendar = Calendar.getInstance();

        View.OnClickListener onClickListenerButton = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button_fill_form_calculation:
                        if (textViewFillFormDateOfBirth.getText().toString().equals("")) {
                            Toast toast = Toast.makeText(FillForm.this, R.string.txt_toast_error_input, Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                        } else {

                            Intent intent = new Intent(FillForm.this, InformarionView.class);
                            intent.putExtra("year", YEAR);
                            intent.putExtra("month", MONTH);
                            intent.putExtra("day", DAY);
                            startActivity(intent);


                        }
                        break;
                    case R.id.button_fill_form_other_calculation:
                        Toast toast = Toast.makeText(FillForm.this, R.string.txt_toast_other_calculation, Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                        break;

                    case R.id.button_fill_form_instal_date:
                        DatePickerDialog datePickerDialog = new DatePickerDialog(FillForm.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                YEAR = String.valueOf(year);
                                MONTH = String.valueOf(month+1);
                                DAY = String.valueOf(dayOfMonth);
                                textViewFillFormDateOfBirth.setText(year + ". " + month + ". " + dayOfMonth);
                                buttonFillFormInstallDate.setText("Исправить");
                            }
                        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));


                        datePickerDialog.show();
                }

            }
        };
        buttonFillFormOtherCalculation.setOnClickListener(onClickListenerButton);
        buttonFillFormCalculation.setOnClickListener(onClickListenerButton);
        buttonFillFormInstallDate.setOnClickListener(onClickListenerButton);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);

    }
}
