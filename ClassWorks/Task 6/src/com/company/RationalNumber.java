package com.company;

public class RationalNumber {

    int a;
    int b;
    double c = 0;

    public RationalNumber(){
        a = 0;
        b = 1;
    }

    public RationalNumber(int a_, int b_){
        a = a_;
        b = b_;
    }

    double ResDub (int a__, int b__){
        c = (double)(a__/b__);
        return c;
    }

    void Res (int a__, int b__) {
        System.out.println(a__+"/"+b__);
    }

}
