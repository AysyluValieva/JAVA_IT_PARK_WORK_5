package com.company;

public class Plane extends Transport {
    protected  double fuelAmount2; //второй баг
    public Plane(String model, double fuelConsumption) {
        super(model, fuelConsumption);
        this.mileage = 0;
        this.fuelAmount = 0;
        this.fuelAmount2 = 0;
    }

    public void addFuel(double fuel) {
        this.fuelAmount += fuel;
        if(this.fuelAmount >= 1000){
            this.fuelAmount2 = this.fuelAmount - 1000;
            this.fuelAmount = 1000;
        }
        else {this.fuelAmount = this.fuelAmount;}
        System.out.println("Begin V1: " + this.fuelAmount);
        System.out.println("Begin V2: " + this.fuelAmount2);

    }

    public void go(int km) {
        this.mileage = mileage + km;
        double t = this.mileage/2500.0;
        double amount = (this.fuelAmount + this.fuelAmount2);
        amount = (amount - t*(this.fuelConsumption));
        if (amount > (double)1000.0){
            this.fuelAmount = (double)1000.0;
            this.fuelAmount2 = amount - (double)1000.0;
        }
        else {
            this.fuelAmount = amount;
            this.fuelAmount2 = 0;
        }
    }

    public void show (){
        System.out.println("S: " + this.mileage );
        System.out.println("End V1: " + this.fuelAmount );
        System.out.println("End V2: " + this.fuelAmount2 );

    }


}


