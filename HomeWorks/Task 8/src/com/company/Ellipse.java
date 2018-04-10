package com.company;

public class Ellipse  extends Rectangle {

    public Ellipse(String name,double rad, double a) {
        super(name,rad,a); //а - второй радиус
    }

    @Override
    public double area() {
        return Math.PI * (rad * a);
    }
}
