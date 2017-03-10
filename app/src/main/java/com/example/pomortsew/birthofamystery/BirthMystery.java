package com.example.pomortsew.birthofamystery;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BirthMystery extends AppCompatActivity {
    TextView textViewActivityMainGreeting;
    Button buttonActivityMainOk;
    SeekBar seekBar;
    float sizeFont = 16;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textViewActivityMainGreeting = (TextView) findViewById(R.id.textView_BirthMystery_greeting);
        textViewActivityMainGreeting.setText(readFileOutString(this));
        textViewActivityMainGreeting.setTextSize(sizeFont);
        buttonActivityMainOk = (Button) findViewById(R.id.button_BirthMistery_ok);

//установка клика на кнопки
        View.OnClickListener onClickButton = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button_BirthMistery_ok:
                        Intent intent = new Intent(BirthMystery.this, FillForm.class);
                        startActivity(intent);
//                       textViewActivityMainGreeting.setVisibility(View.GONE); // метод удаляет элемент TextView с экрана ACtivity
                        break;

                }
            }
        };
        buttonActivityMainOk.setOnClickListener(onClickButton);

    }

    //переопределенный метод создает меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    //
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu_font:
                seekBar = new SeekBar(this);
                Dialog dialog = new Dialog(this);
                dialog.setContentView(seekBar);
                dialog.setTitle(R.string.txt_font);
                dialog.show();

                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        textViewActivityMainGreeting.setTextSize(seekBar.getProgress());
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });

            case R.id.menu_about_the_programm:
        }

        return true;
//                super.onOptionsItemSelected(item);
    }

    //    Метод постоение информации для первого окна Activity
    private String readFileOutString(Activity activity) {
        String text = "";
        Resources resources = activity.getResources();
        StringBuilder txt = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resources.openRawResource(R.raw.infoapp)));
        try {
            while ((text = bufferedReader.readLine()) != null) {
                txt.append(text);
            }
            text = txt.toString();

        } catch (Exception e) {

        }
        return text;
    }

}

