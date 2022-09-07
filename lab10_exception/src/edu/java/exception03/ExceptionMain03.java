package edu.java.exception03;

import java.util.Scanner;

public class ExceptionMain03 {

    private Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        ExceptionMain03 app = new ExceptionMain03();
        app.intputInteger();
    }
    
    private int intputInteger() {
        // TODO : Scanner를 사용해서 입력받은 정수를 리턴.
        // Integer.parseInt(), scanner.nextLine() 사용.
        // NumberFormatException을 처리.
        int result = 0;
        while (true) {
            try {
                System.out.print("정수를 입력>> ");
                result = Integer.parseInt(scanner.nextLine());
                break;
                 // 반복문 종료
            } catch (NumberFormatException e) {
                System.out.println("정수를 다시 입력해주세요.");
            }
        } // end while
        return result;
    }
}
