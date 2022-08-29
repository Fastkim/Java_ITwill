package edu.java.class04;

public class ClassMain04 {

    public static void main(String[] args) {
        
        Circle circle = new Circle();  // 기본생성자, 객체 생성
        
        System.out.println(circle.radius);
        System.out.println(circle.area());
        System.out.println(circle.perimeter());
        
        Circle circle1 = new Circle(5); // arguments를 가지는 생성자, 객체 생성
        
        System.out.println(circle1.radius);
        System.out.println(circle1.area());
        System.out.println(circle1.perimeter());
        
        Circle c3 = new Circle(5);
        System.out.println("c3 = " + c3);

    }
}
