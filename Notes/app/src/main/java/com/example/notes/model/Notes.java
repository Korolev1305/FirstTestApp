package com.example.notes.model;

/**
 * Created by Максим on 12.03.2016.
 */
public class Notes {


    public void setNumber(int number) {
        this.number = number;
    }

    private int number;
    private final String name;

    public Notes(String name, int number) {
        this.name = name;
        this.number = number;
    }
    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
