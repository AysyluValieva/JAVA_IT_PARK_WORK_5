package com.company;

public class Figure {

    protected String name;
    protected double rad ;


    public Figure(String name, double rad ) {
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
        return rad;
    }
    public String toString() {
        return "Area "+ name + " = ";
    }
}
