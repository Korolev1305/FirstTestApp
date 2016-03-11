package com.example.firsttestapp.model;

/**
 * Created by Жамбыл on 3/11/2016.
 */
public class Cat {

    private final String name;
    private final String color;
    private int age;

    public Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }
}
