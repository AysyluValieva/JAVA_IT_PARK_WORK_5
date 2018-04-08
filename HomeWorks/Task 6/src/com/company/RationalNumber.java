package com.company;

public class RationalNumber {

    private  int a;
    private  int b;
    private  double c = 0.0;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {
            this.a = a;
    }

    public void setB(int b) {
        if (b != 0) {
            this.b = b;
        } else {
            this.b = 1;
        }
    }

    public RationalNumber(){
        a = 0;
        b = 1;
    }

    public RationalNumber(int a_, int b_){
        a = a_;
        b = b_;
    }

    double toDouble (){
        c = ((double)this.a/this.b);
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
        this.a = this.a / c;
        this.b = this.b / c;
        System.out.println("Дробь после оптимизации = "+a+"/"+b);
    }


}
