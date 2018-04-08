package com.company;

public class Transport {
    private String model; //name
    protected  int mileage; //km
    protected  double fuelConsumption; // l/km
    protected  double fuelAmount; // (l/km)*km

    public Transport(String model, double fuelConsumption) {
        this.model = model;
        this.mileage = 0;
        this.fuelConsumption = fuelConsumption;
        this.fuelAmount = 0;
    }

    public String getModel() {
        return model;
    }

    public int getMileage() {
        return mileage;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void addFuel(double fuel) {
        this.fuelAmount += fuel;
        System.out.println("Begin V: " + this.fuelAmount);
    }

    public void go(int km) {
        this.mileage = mileage + km;
        this.fuelAmount = this.fuelAmount - km * (this.fuelConsumption / 100);

    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void show (){
        System.out.println("S: " + this.mileage );
        System.out.println("End V: " + this.fuelAmount );


    }
}
