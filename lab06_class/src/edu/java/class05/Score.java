package edu.java.class05;

public class Score {

    // field
    
    int korea; // 국어 점수
    int english; // 영어 점수
    int math; // 수학 점수
    
    // constructor - 기본 생성자, argument를 갖는 생성자.
    
    public Score() {}
    
    public Score(int korea,int english,int math) {
        
        this.korea = korea;
        this.english = english;
        this.math = math;
        
    }
    
    // 세 과목의 점수를 출력하는 메서드.
    
    public void printScore() {
        System.out.println("국어의 점수는 = " + this.korea);
        System.out.println("영어의 점수는 = " + this.english);
        System.out.println("수학의 점수는 = " + this.math);
    }
    
    // 세 과목의 총점을 리턴하는 메서드.
    
    public int sum() {
        return this.korea + this.english + this.math ;
    }
    
    // 세 과목의 평균(소수점까지 계산)을 리턴하는 메서드.
    
    public double avg() {
        return sum()/(double)3;
    }
}
