package com.company;

public class Tank extends Transport {

    protected double fuelConsumption_grunt;
    protected double mileage_gr;

    public Tank(String model, double fuelConsumption) {
        super(model, fuelConsumption);
        this.mileage = 0;
        this.fuelAmount = 0;
        this.fuelConsumption_grunt = 300;
    }

    public void go(int km, int mileage_grunt) {
        this.mileage = mileage + km;
        this.mileage_gr = mileage_grunt;
        this.fuelAmount = this.fuelAmount - km * (this.fuelConsumption / 100) - mileage_gr * (this.fuelConsumption_grunt / 100);
    }

    public void show (){
        System.out.println("S: " + this.mileage );
        System.out.println("S grunt: " + this.mileage_gr );

        System.out.println("End V: " + this.fuelAmount );


    }

}


