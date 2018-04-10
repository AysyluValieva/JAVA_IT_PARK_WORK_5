package com.company;

public class Square extends Circle{

    public Square(String name, double rad) {
        super(name, rad);
    }

    @Override
    public double area() {
        return 2*(rad * rad); //через радиус описанной окружности
    }
}
