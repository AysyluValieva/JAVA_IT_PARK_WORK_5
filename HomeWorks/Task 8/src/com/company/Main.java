package com.company;

public class Main {

     public static void main(String[] args) {
	// write your code here

        Circle circle = new Circle("Circle",3);
        Square square = new Square("Square",3);
        Rectangle rectangle = new Rectangle("Rectangle",3, 5);
        Ellipse ellipse = new Ellipse("Ellipse",3, 5);
        Triangle triangle = new Triangle("Triangle",3, 5, 4, 2);


        Figure numbers[] = {circle, square, rectangle, ellipse, triangle};

        for (Figure number : numbers) {
            System.out.println(number.toString() + String.format("%.5g",number.area()));
        }
    }
}
