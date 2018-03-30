package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int a[] = {3, 4, 6, 1, 8};
        int m = 2;

        for (int i = m-1; i <= a.length-2; i++) {
            a[i]=a[i+1];
            }
        a[a.length-1]=0;
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

     int b[] = {3, 4, 6, 1, 8};
     int t;
     for (int i = 0; i < b.length/2; i++) {
         t = b[b.length -1-i];
         b[b.length-1-i]=b[i];
         b[i]=t;
    }

        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");

        }
     System.out.println();
    }
}
