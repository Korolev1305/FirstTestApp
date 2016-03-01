package com.example.firsttestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // объявили
    TextView labelTextView;
    Button pressMeButton;
    int counter;
    public static final String SHARED_VALUE = "SHARED_VALUE";
    public static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //инициализация
        labelTextView = (TextView) findViewById(R.id.label_text_view);
        pressMeButton = (Button) findViewById(R.id.press_me_button);

        pressMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // создаем намерение перейти на другую активность
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                // кладем данные по ключу
                intent.putExtra(SHARED_VALUE, "privet, epta");

                // переходим по намерению
                // говорим то, что мы запускаем для получния результата после
                // окончания активити, который открываем
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    // принимаем то, что кинул законившийся активити
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(REQUEST_CODE == requestCode) {
            String responseMessage = data.getStringExtra(SecondActivity.RESPONSE_MESSAGE);
            labelTextView.setText(responseMessage);
        }
    }
}
