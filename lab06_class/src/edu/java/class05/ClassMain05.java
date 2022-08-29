package edu.java.class05;

public class ClassMain05 {

    public static void main(String[] args) {
        // Score 타입의 객체 생성, 메서드들을 테스트.
        
        Score score1 = new Score(65,70,95);
        
        System.out.println("score korean = " + score1.korea);
        System.out.println("score english = " + score1.english);
        System.out.println("score math = " + score1.math);
        
        score1.printScore();
        
        int total = score1.sum();
        
        
        System.out.println(score1.sum());
        
        System.out.println(score1.avg());
        
        // Student 타입의 객체 생성, 메서드를 테스트.

        Student stu1 = new Student();
        stu1.score = score1;
        System.out.println("stu1 = " + stu1);
        stu1.stuInformation();
        
        System.out.println("-----");
        Student stu2 = new Student(1,"홍길동",score1);
        stu2.stuInformation();
        
        System.out.println("-----");
        Student stu3 = new Student(2, "허균",null);
        stu3.stuInformation();
        
        System.out.println("-----");
        Student stu4 = new Student(3, "오쌤",new Score());
        stu4.stuInformation();
        
        System.out.println("-----");
        Student stu5 = new Student(5, "철수", 10, 20, 30);
        stu5.stuInformation();
        
        
    }

}
