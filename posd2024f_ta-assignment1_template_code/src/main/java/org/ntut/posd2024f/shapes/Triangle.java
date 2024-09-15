package org.ntut.posd2024f.shapes;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;

public class Triangle implements Shape
{
    double s;
    double length1,length2,length3;
    Triangle(double a, double b, double c) throws Exception {
        if(!cheak(a, b, c)){
            throw new ArithmeticException("It's not a triangle!");
        }
        length1 = a;
        length2 = b;
        length3 = c;
        s = (a + b + c) / 2;
    }
    public boolean cheak(double a, double b, double c){
        if(a <= 0 || b <= 0 || c <= 0){
            return false;
        }
        if(a >= b+c){
            return false;
        }
        if(b >= a+c){
            return false;
        }
        if(c >= a+b){
            return false;
        }
        return true;
    }
    public double perimeter() {//周長
        return length1+length2+length3;
    }

    public double area() {
        return Math.sqrt(s*(s-length1)*(s-length2)*(s-length3));
    }

    public String toString() {
        return("Triangle"+ " "  + String.valueOf(length1)+ " "  + String.valueOf(length2)+ " "  + String.valueOf(length3));
    }
}
