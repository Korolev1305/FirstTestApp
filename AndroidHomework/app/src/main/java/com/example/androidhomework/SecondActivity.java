package com.example.androidhomework;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Максим on 01.03.2016.
 */
public class SecondActivity extends AppCompatActivity {
    TextView textView,textView2;
    EditText editText;
    public static final String RESPONSE_MESSAGE = "RESPONSE_MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String message = getIntent().getExtras().getString(MainActivity.SHARED_VALUE);
        textView = (TextView)findViewById(R.id.label2_text_view);
        editText = (EditText) findViewById(R.id.edit2_text_view);
        textView2 = (TextView) findViewById(R.id.label4_text_view);
        textView.setText(message);
    }

    @Override
    public void onBackPressed() {
        Intent backIntent = new Intent();
        if (editText.getText().toString().isEmpty()) {
            textView2.setText("Необходимо ввести строку");
        }
        else
        {

            backIntent.putExtra(RESPONSE_MESSAGE, editText.getText().toString());
            setResult(MainActivity.REQUEST_CODE, backIntent);

            super.onBackPressed();
        }
    }
}
