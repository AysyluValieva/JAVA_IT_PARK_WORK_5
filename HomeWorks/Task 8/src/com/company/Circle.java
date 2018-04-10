package com.company;

public class Circle {
    protected String name;
    protected double rad ;


    public Circle(String name, double rad ) {
        this.name  = name ;
        this.rad  = rad ;

    }

    public String getName() {
        return name;
    }

    public double getRad() {
        return rad ;
    }

    public double area() {
        return Math.PI * (rad * rad);
    }
    public String toString() {
        return "Area "+ name + " = ";
    }

}
