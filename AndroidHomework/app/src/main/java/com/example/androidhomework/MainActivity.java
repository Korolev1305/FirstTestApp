package com.example.androidhomework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView lableTextView,lableTextView2;
    Button pressMeButton;
    EditText editTextView;
    public static final String SHARED_VALUE = "Shared_value";
    public static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lableTextView = (TextView) findViewById(R.id.label_text_view);
        pressMeButton = (Button) findViewById(R.id.press_me_button);
        editTextView = (EditText) findViewById(R.id.edit_text_view);
        lableTextView2 = (TextView) findViewById(R.id.label3_text_view);
        pressMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextView.getText().toString().isEmpty() )
                {
                    lableTextView2.setText("Необходимо ввести строку");
                }


                else
                {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra(SHARED_VALUE, editTextView.getText().toString());
                    startActivityForResult(intent, REQUEST_CODE);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (REQUEST_CODE == requestCode) {
            String responseMessage = data.getStringExtra(SecondActivity.RESPONSE_MESSAGE);
            lableTextView.setText(responseMessage);
        }
    }
}
