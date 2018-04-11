package com.company;

public class Circle  extends Figure {

    public Circle(String name, double rad ) {
        super(name,rad);

    }
    @Override

    public double area() {

        return Math.PI * (rad * rad);
    }
}
