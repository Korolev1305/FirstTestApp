package com.example.firsttestapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.firsttestapp.model.Cat;

import java.util.List;

/**
 * Created by Жамбыл on 3/11/2016.
 */
public class CatsAdapter extends ArrayAdapter<Cat> {

    private final Context context;
    private final int resource;
    private List<Cat> cats;
    private LayoutInflater inflater;

    public CatsAdapter(Context context, int resource, List<Cat> cats) {
        super(context, resource, cats);
        this.context = context;
        this.resource = resource;
        this.cats = cats;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // View шаблона
        View templateView = inflater.inflate(resource, null);

        // Достаем его вьюшки
        TextView nameTextView = (TextView) templateView.findViewById(R.id.name_text_view);
        TextView ageTextView = (TextView) templateView.findViewById(R.id.age_text_view);
        TextView colorTextView = (TextView) templateView.findViewById(R.id.color_text_view);

        // Достаем текущего кота по позиции
        Cat currentCat = cats.get(position);

        // Присваиваем значение TextView
        nameTextView.setText(currentCat.getName());
        ageTextView.setText(currentCat.getAge());
        colorTextView.setText(currentCat.getColor());

        // Возвращаем view шаблона
        return templateView;
    }
}
