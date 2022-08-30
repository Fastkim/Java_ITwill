package edu.java.modifier07;

public class StaticTest {
    int instanceVariable; // 인스턴스 변수
    static int staticVariable; // static 변수
    
    public void printVariables() { // 인스턴스 메서드
        System.out.println("--- instance method ---");
        System.out.println("인스턴스 = " + instanceVariable);
        System.out.println("static 변수 = " + staticVariable);
    }
    
    public static void printVarialbes2() { // static 메서드
        System.out.println("--- static method ---");
//        System.out.println("인스턴스 = " + instanceVariable);
        // static 멤버는 static이 아닌 멤버를 사용할 수 없다!
        System.out.println("인스턴스 = " + staticVariable);
        
    }
}
