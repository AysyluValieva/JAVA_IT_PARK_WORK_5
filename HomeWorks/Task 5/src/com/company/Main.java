package com.company;
import java.util.Arrays;

public class Main {

    public static void BubbleSort(int array[]) {
        for (int i = 0; i < array.length; i++) {
            for(int j = i; j >= 1; j--)
            {   if (array[j]<array[j-1]) {
                int a = array[j];
                array[j] = array[j - 1];
                array[j - 1] = a;
            }
            else {array[j] = array[j];}
            }
        }
    }

    public static void main(String[] args) {
	// write your code here
        int array[] = {31, 3, 12, -5, 12, 4, 5, -10, 15, 2};
        BubbleSort(array);
        System.out.println(Arrays.toString(array));

    }
}
