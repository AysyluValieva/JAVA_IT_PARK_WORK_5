package com.company;

public class Motorcycles extends Car {

    public Motorcycles(String model, double fuelConsumption) {
        super(model, fuelConsumption);
        this.mileage = 0;
        this.fuelAmount = 5;
    }
}
