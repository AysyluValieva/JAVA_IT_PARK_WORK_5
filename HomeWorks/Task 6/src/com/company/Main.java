package com.company;
//import java.util.Scanner;
import java.util.Random;


public class Main {

    public static void main(String[] args) {
	// write your code here
        Random random = new Random();

        RationalNumber rationalNumber;

        rationalNumber = new RationalNumber();
        rationalNumber.setA(random.nextInt(100));
        //rationalNumber.setB(random.nextInt(100));
        rationalNumber.setB(0);
        rationalNumber.show();

        System.out.println(rationalNumber.toDouble());

        System.out.println("НОД = "+rationalNumber.nod(rationalNumber.getA(),rationalNumber.getB()));

        rationalNumber.optimize();

    }
}
