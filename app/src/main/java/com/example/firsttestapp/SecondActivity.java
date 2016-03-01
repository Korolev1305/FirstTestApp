package com.example.firsttestapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Жамбыл on 3/1/2016.
 */
public class SecondActivity extends AppCompatActivity {

    TextView textView;
    public static final String RESPONSE_MESSAGE = "RESPONSE_MESSAGE";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        // достаем данные по ключу
        String message = getIntent().getExtras().getString(MainActivity.SHARED_VALUE);

        textView = (TextView) findViewById(R.id.label2_text_view);
        textView.setText(message);
    }

    @Override
    public void onBackPressed() {
        Intent backIntent = new Intent();
        backIntent.putExtra(RESPONSE_MESSAGE, "NU PRIVET, EPTA!");
        setResult(MainActivity.REQUEST_CODE, backIntent);
        super.onBackPressed();
    }
}
