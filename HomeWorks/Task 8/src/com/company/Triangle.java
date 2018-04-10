package com.company;

public class Triangle extends Ellipse {
    protected double b;
    protected double c;

    public Triangle(String name, double rad, double a, double b, double c) {
        super(name,rad,a); //а, b,c - стороны
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        return a*b*c*rad/4;
    }
}
