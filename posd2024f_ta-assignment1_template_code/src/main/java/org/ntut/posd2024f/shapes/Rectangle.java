package org.ntut.posd2024f.shapes;

public class Rectangle implements Shape {
    double h,w;
    public Rectangle(double length, double width) throws Exception {
        if(!check(length, width)){
            throw new ArithmeticException("It's not a rectangle!");
        }
        h = length;
        w = width;
    }
    public boolean check(double length, double width){
        if(length < 0 || width < 0){
            return false;
        }
        return true;
    }
	public double area() {
        return h * w;
    }
    
    public double perimeter() {
        return (h + w)*2;
    }

    public String toString() {
        return("Rectangle" + " " + String.valueOf(h)+ " " +String.valueOf(w));
    }
}
