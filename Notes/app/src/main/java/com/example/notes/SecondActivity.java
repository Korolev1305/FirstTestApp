package com.example.notes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.notes.model.Notes;

/**
 * Created by Максим on 12.03.2016.
 */
public class SecondActivity extends AppCompatActivity{
    EditText name_edit_text;
    int position;
    boolean delete=false;
    Button delete_button,complete_button;
    public static final String DELETE_MESSAGE = "DELETE_MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        position = getIntent().getExtras().getInt(MainActivity.SHARED_VALUE2);
        String message = getIntent().getExtras().getString(MainActivity.SHARED_VALUE);
        name_edit_text = (EditText) findViewById(R.id.name_edit_text);
        delete_button = (Button)findViewById(R.id.delete_button);
        complete_button = (Button) findViewById(R.id.complete_button);
        name_edit_text.setText(message);
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deleteIntent = new Intent();
                deleteIntent.putExtra(DELETE_MESSAGE,position);
                setResult(MainActivity.REQUEST_CODE,deleteIntent);
            }
        });
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }
}
