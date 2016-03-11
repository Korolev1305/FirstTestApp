package com.example.firsttestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.firsttestapp.dbl.CatsDatabase;
import com.example.firsttestapp.model.Cat;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CatsDatabase catsDatabase;
    private List<Cat> cats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setResult(R.layout.activity_main);

        catsDatabase = new CatsDatabase();
        cats = catsDatabase.getCats();

        CatsAdapter catsAdapter = new CatsAdapter(this, R.layout.cat_template,cats);
    }
}
