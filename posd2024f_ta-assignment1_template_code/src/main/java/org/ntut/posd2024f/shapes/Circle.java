package org.ntut.posd2024f.shapes;

public class Circle implements Shape {
    double r;
    public Circle(double radius) throws Exception {
        r = radius;
        if(!check()){
            throw new ArithmeticException("It's not a circle!");
        }
    }
    public boolean check(){
        if(r < 0){
            return false;
        }
        return true;
    }
    public double area() {
        return(r*r*Math.PI);
    }

    public double perimeter() {
        return r * 2 * Math.PI;
    }

    public String toString() {
        return("Circle"+ " "  + String.valueOf(r));
    }
}
