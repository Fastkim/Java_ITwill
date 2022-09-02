package edu.java.inheritance09;

public class Rectangle extends Shape {
    
    private double width;
    private double height;

    public Rectangle(String type,double width,double height) {
        super(type);
        this.height = height;
        this.width = width;
    }
    
    @Override
    public double area() {
        double area = width * height;
        return area;
    }
    
    @Override
    public double perimeter() {
        double perimeter = 2 * (width + height);
        return perimeter;
    }
    
    
}
