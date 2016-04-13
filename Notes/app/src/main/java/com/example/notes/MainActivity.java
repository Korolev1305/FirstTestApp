package com.example.notes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.notes.dbl.NotesDatabase;
import com.example.notes.model.Notes;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private  NotesAdapter notesAdapter;
    private NotesDatabase notesDatabase;
    private List<Notes> notes;
    private ListView notesListView;
    Button addButton;
    public static final int REQUEST_CODE =1;
    public static final String SHARED_VALUE = "Shared_value";
    public static final String SHARED_VALUE2 = "Shared_value2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButton = (Button) findViewById(R.id.add_button);
        notesListView =(ListView) findViewById(R.id.notes_list_view);
        notesDatabase = new NotesDatabase();
        notes = notesDatabase.getNotes();
        notesAdapter = new NotesAdapter(this,R.layout.notes_template,notes);
        notesListView.setAdapter(notesAdapter);
        notesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(SHARED_VALUE2,notes.get(position).getNumber());
                intent.putExtra(SHARED_VALUE,notes.get(position).getName().toString());
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });

    }
   protected void onActivityResult (int requestCode,int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        int position=-1;
       if (data!=null)
        if (REQUEST_CODE == requestCode){
            String responseMessage =  data.getStringExtra(ThirdActivity.RESPONSE_MESSAGE);
            position=data.getExtras().getInt(SecondActivity.DELETE_MESSAGE);
            if (position>0) {

                notes.remove(position-1);
                notesAdapter.notifyDataSetChanged();
            }
            if (responseMessage!=null) {

                notes.add(new Notes(responseMessage, notes.size() + 1));
                notesAdapter.notifyDataSetChanged();
            }
        }
    }
}
