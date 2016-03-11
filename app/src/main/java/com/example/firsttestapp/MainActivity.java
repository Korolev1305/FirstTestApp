package com.example.firsttestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firsttestapp.dbl.CatsDatabase;
import com.example.firsttestapp.model.Cat;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CatsDatabase catsDatabase;
    private List<Cat> cats;
    private ListView catsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        catsListView = (ListView) findViewById(R.id.cats_list_view);
        catsDatabase = new CatsDatabase();
        cats = catsDatabase.getCats();

        CatsAdapter catsAdapter =
                new CatsAdapter(this,R.layout.cat_template,cats);

        catsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Вы кликнули на кота под номером " + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

        catsListView.setAdapter(catsAdapter);
    }
}
