package edu.java.inheritance09;

public class AbstractMain03 {

    public static void main(String[] args) {
        // Rectangle, Circle 클래스를 구현(implement)
        // Rectangle, Circle 타입의 객체에서 draw() 메서드 동작 여부 테스트
        
         Shape[] shapes = {
              new Rectangle("Rectangle", 4,3),
              new Circle("Circle", 10),
              new Square(3) };
        
        for (Shape s : shapes ) {
            s.draw();
        }
        Shape shape = new Rectangle("Rectangle",5,5);
        
        shape.draw();
        
        Shape shape1 = new Circle("Circle",5);
        
        shape1.draw();
        
        // Shape 클래스는 더이상 수정하면 안됨.
    }

}
