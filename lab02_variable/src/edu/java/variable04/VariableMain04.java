package edu.java.variable04;

import java.util.Scanner;

public class VariableMain04 {

    public static void main(String[] args) {
        /*
         * 콘솔 창에서 키보드로 숫자를 입력받아서 변수에 저장.
         * 
         * // 1. Scanner 타입의 변수를 선언하고 초기화. Scanner scanner = new Scanner(System.in);
         * 
         * System.out.println("정수를 입력>>>");
         * 
         * // 2. Scanner 객체를 사용해서 콘솔 창에서 정수를 입력받고 저장. int number = scanner.nextInt();
         * 
         * System.out.println("number = " + number);
         * 
         */

        // Java 시험 점수(정수)를 입력하세요.
        // SQL 시험 점수를 입력하세요.
        // JSP 시험 점수를 입력하세요.
        // 세 과목의 총점(정수)을 계산하고 출력.
        // 세 과목의 평균(실수)을 계산하고 출력.

        Scanner sc = new Scanner(System.in); // 스캐너 셋팅 스캐너의 객체는 한가지만 생성해도 된다.

        System.out.println("JAVA의 시험 점수를 입력하세요."); // 자바, SQL ,JSP 값 입력받기
        int java = sc.nextInt();
        System.out.println("SQL의 시험 점수를 입력하세요."); // 변수이름,메서드
                                                  // 이름은 소문자로 시작하기(관습)
        int sql = sc.nextInt();
        System.out.println("JSP의 시험 점수를 입력하세요.");
        int jsp = sc.nextInt();

        int sum = java + sql + jsp; // 세과목의 총점 저장할 변수 선언과 저장
        double avg = (double) sum / 3; // 세과목의 평균 저장할 변수 선언과 저장

        System.out.println("세 과목의 총점은 : " + sum); // 총점 출력
        System.out.println("세 과목의 평균은 : " + avg); // 평균 출력

        // Ctrl+Shift+F: 소스 코드 포맷팅(자동 정렬)
    }

}
