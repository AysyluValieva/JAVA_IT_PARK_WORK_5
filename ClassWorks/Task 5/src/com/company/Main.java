package com.company;

public class Main {
    public static int sumNum(int a, int b){
        int sum = 0;
        if(a>b)
        {
            for(int j = a; j >=b; j--)
            {
              sum = sum + j;
            }
            return sum;
        }
        else
        {
            for(int i = a; i <= b; i++){
            sum = sum + i;
        }
            return sum;
        }
    }


    public static int sumcount(int a){
        int summ = 0;
        while(a != 0){
            summ = summ + a%10;
            a = a/10;
        }
        return  summ;
    }


    public static void main(String[] args) {
	// write your code here
    int s = sumcount(123);
    System.out.println(s);

    }
}
