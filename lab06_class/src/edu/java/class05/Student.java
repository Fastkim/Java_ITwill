package edu.java.class05;

public class Student {

    // field
    int stuNo; // 학번
    String stuName; //학생 이름
    Score score; // 국어/영어/수학 점수 , 클래스 타입


    // constructor
    // 기본 생성자
    public Student() {}
    
    // (2) arguments : int, String, Score
    
    public Student(int stuNo,String stuName,Score score) {
        
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.score = score;
        
    }
    // (3) arguments : int,String, int 국어, int 영어, int 수학
    
    public Student(int stuNo,String stuName,int korean,int english,int math) {
        
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.score = new Score(korean,english,math);
    
//        this(stuNo, stuName, new Score(korean, english, math));
        
    }
    

    // method - 학생 정보(학번, 이름, 국/영/수 과목 점수, 총점, 평균)를 출력

    public void stuInformation() {
        
        System.out.println("----학생 정보-----");
        System.out.println("학번은 = "+this.stuNo);
        System.out.println("이름은 = "+this.stuName);
        if (score != null) {
            this.score.printScore(); // 국/영/수 점수 출력
            System.out.println("총점은 = "+ this.score.sum());
            System.out.println("평균은 = "+ this.score.avg());
        } 
        else {
            System.out.println("점수: null");
        }
    }

}