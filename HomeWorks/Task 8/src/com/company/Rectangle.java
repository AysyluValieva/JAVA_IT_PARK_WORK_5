package com.company;

public class Rectangle extends Square{
    protected double a; //одна из сторон прямоугольника

    public Rectangle(String name,double rad, double a) {
        super(name,rad);
        this.a = a;
    }

    @Override
    public double area() {
        return a*(Math.sqrt((4*rad*rad) - (a*a))); //через радиус описанной окружности
    }
}

