package com.example.notes.dbl;

import com.example.notes.model.Notes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Максим on 12.03.2016.
 */
public class NotesDatabase {
    public List<Notes> getNotes(){
        List<Notes> notes = new ArrayList<>();
        notes.add(new Notes("Заметка",1));
        notes.add(new Notes("Картошка",2));
        return notes;
    }
}
