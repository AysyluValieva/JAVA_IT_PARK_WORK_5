package com.company;

public class Car extends Transport {

    public Car(String model, double fuelConsumption) {
        super(model, fuelConsumption);
        this.mileage = 0;
        this.fuelAmount = 10;
    }

    public void addFuel(double fuel) {
        this.fuelAmount += fuel;
        if (this.fuelAmount <= 70.0) {
            System.out.println("Begin V: " + this.fuelAmount);
        }
        else{
            double sh = this.fuelAmount - 70;
            this.fuelAmount = (double)70.0;
            System.out.println("Begin V: " + this.fuelAmount);
            System.out.println("Shed V: " + sh);
        }
    }


}
