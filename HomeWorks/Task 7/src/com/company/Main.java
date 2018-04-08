package com.company;


public class Main {

    public static void main(String[] args) {
	// write your code here

        Transport kia = new Transport("RIO", 7);
        System.out.println("Model: " + kia.getModel());
        kia.addFuel(45);
        kia.go(50);
        kia.show();

        System.out.println("-------------");
        Car toyota  = new Car("Tercel", 100);
        System.out.println("Model: " + toyota.getModel());
        toyota.addFuel(75);
        toyota.go(50);
        toyota.show();

        System.out.println("-------------");
        Motorcycles honda   = new Motorcycles(" GL-1800", 50);
        System.out.println("Model: " + honda.getModel());
        honda.addFuel(75);
        honda.go(50);
        honda.show();

        System.out.println("-------------");
        Plane boeing    = new Plane(" 737-300", 2600);
        System.out.println("Model: " + boeing.getModel());
        boeing.addFuel(1100);
        boeing.go(800);
        boeing.show();

        System.out.println("-------------");
        Tank T    = new Tank("72А", 200);
        System.out.println("Model: " + T.getModel());
        T.addFuel(1100);
        T.go(50, 10);
        T.show();
    }
}
