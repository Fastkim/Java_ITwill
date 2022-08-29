package edu.java.class04;

public class Circle {
    // field - 반지름 멤버변수(클래스변수),property
    double radius;
    
    // constructor - 기본 생성자, argument를 갖는 생성자
    public Circle() {}
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    // method - 둘레 길이, 넓이 
    
    public double perimeter() {
        return 2 * 3.14 * this.radius;
    }
    
    public double area() {
        return 3.14 * this.radius * this.radius;
    }
}
