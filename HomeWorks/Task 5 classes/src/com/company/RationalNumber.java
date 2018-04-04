package com.company;

public class RationalNumber {

    int a;
    int b;
    double c = 0.0;

    public RationalNumber(){
        a = 0;
        b = 1;
    }

    public RationalNumber(int a_, int b_){
        a = a_;
        b = b_;
    }

    double toDouble (){
        c = ((double)a/b);
        return c;
    }

    void show () {
        System.out.println(a+"/"+b);
    }

    int nod(int a_, int b_){
        while (a_ !=0 && b_!=0){
            if (a_ > b_) {
                a_ = a_ % b_;
            }
            else {
                b_ = b_ % a_;
            }
        }
        return a_ + b_;

        }

    void optimize(){
        int c = nod(a, b);
        a = a / c;
        b = b / c;
        System.out.println("Дробь после оптимизации = "+a+"/"+b);
    }


    }


