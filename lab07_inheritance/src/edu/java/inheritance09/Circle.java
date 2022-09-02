package edu.java.inheritance09;

public class Circle extends Shape{

    private double radius;
    
    public Circle(String type,double radius) {
        super(type);
        this.radius = radius;
    }
    
    @Override
    public double area() {
        double area = Math.PI * radius * radius;
        return area;
    }
    
    @Override
    public double perimeter() {
        double perimeter = 2 * Math.PI * radius;
        return perimeter;
    }
}
