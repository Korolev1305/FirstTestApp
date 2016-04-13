package com.example.notes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Максим on 13.03.2016.
 */
public class ThirdActivity extends AppCompatActivity{
    EditText name_edit_text;
    public static final String RESPONSE_MESSAGE = "RESPONSE_MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        name_edit_text = (EditText) findViewById(R.id.name_edit_text);
    }

    @Override
    public void onBackPressed() {
        Intent backIntent = new Intent();
        backIntent.putExtra(RESPONSE_MESSAGE, name_edit_text.getText().toString());
        setResult(MainActivity.REQUEST_CODE,backIntent);
        super.onBackPressed();
    }
}
