package com.example.firsttestapp.dbl;

import com.example.firsttestapp.model.Cat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Жамбыл on 3/11/2016.
 */
public class CatsDatabase {

    public List<Cat> getCats() {
        List<Cat> cats = new ArrayList<>();

        cats.add(new Cat("Барсик",34,"blue"));
        cats.add(new Cat("Мурзик",14,"red"));
        cats.add(new Cat("Снежок",34,"ginger"));

        return cats;
    }
}
