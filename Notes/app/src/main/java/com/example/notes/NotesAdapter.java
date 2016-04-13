package com.example.notes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.notes.model.Notes;

import java.util.List;

public class NotesAdapter extends ArrayAdapter<Notes> {
    private final int resource;
    private List<Notes> notes;
    private LayoutInflater inflater;

    public NotesAdapter(Context context, int resource, List<Notes> notes) {
        super(context, resource, notes);
        this.resource = resource;
        this.notes = notes;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //VIew шаблона
        View templateView = inflater.inflate(resource, null);
        //Достаем его вьюшки
        TextView nameTextView = (TextView) templateView.findViewById(R.id.name_text_view);
        TextView numberTextView = (TextView) templateView.findViewById(R.id.number_text_view);
        // Достаем текущего кота по позиции
        Notes currentcCat = notes.get(position);
        // Присваиваем значение текствьюшкам
        nameTextView.setText(currentcCat.getName());
        numberTextView.setText(String.valueOf(currentcCat.getNumber()));
        // Возвращаем вью шаблон
        return templateView;
    }
}
