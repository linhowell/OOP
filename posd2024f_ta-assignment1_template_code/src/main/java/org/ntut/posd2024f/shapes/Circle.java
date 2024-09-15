package org.ntut.posd2024f.shapes;

public class Circle implements Shape {
    double r;
    public Circle(double radius) throws Exception {
        r = radius;
        if(!check()){
            throw new ArithmeticException("It's not a Circle!");
        }
    }
    public boolean check(){
        if(r < 0){
            return false;
        }
        return true;
    }
    public double area() {
        return((r/2)*(r/2)*3.14);
    } 

    public double perimeter() {
        return r * 3.14;
    }

    public String toString() {
        return("Circle" + String.valueOf(r));
    }
}
