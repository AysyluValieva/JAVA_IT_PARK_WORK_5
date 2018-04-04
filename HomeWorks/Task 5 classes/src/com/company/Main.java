package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число X: ");
        int x = scanner.nextInt();
        System.out.println("Введите число Y: ");
        int y = scanner.nextInt();

        RationalNumber rationalNumber;

        rationalNumber = new RationalNumber(x,y);

        rationalNumber.show();

        System.out.println(rationalNumber.toDouble());

        System.out.println("НОД = "+rationalNumber.nod(x,y));

        rationalNumber.optimize();

    }
}
