package edu.java.inheritance09;

public class Rectangle extends Shape {
    
    // field
    private double width;
    private double height;

    // 생성자
    public Rectangle(String type,double width,double height) {
        super(type);
        this.height = height;
        this.width = width;
    }
    
    // 재정의된 메서드(overriding)
    
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
