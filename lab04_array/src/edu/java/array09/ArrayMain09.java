package edu.java.array09;

import java.util.Scanner;

public class ArrayMain09 {

    public static void main(String[] args) {
        // Ch. 5-2 Ex. 6 (p201)
        
        boolean run = true; // 프로그램을 계속 실행할 지, 종료할 지를 결정하기 위한 변수.
        int studentNum = 0; // 입력받은 학생수를 저장할 변수.
        int[] scores = null; // 학생들의 점수들을 저장할 배열.
        // null: 배열이 만들어지지 않음.
        Scanner scanner = new Scanner(System.in);
        
        
        while(run) {
            System.out.println("----------------------------------------------------------");
            System.out.println("1. 학생수 | 2. 점수입력 | 3.점수리스트 | 4. 분석 | 5. 종료");
            System.out.println("----------------------------------------------------------");
            System.out.print("선택> ");
            
            // 콘솔창에서 문자열을 입력받아서 int로 변환.
            int selectNo = Integer.parseInt(scanner.nextLine());
            
            if(selectNo == 1) {
                // 만약 학생수 0을 입력했을 때는 Null은 아니고 배열이 생성은 되지만 원소가 존재하지않으므로
                // selectNo == 2,3,  
                // 학생 수 입력받기
                System.out.print("학생수> ");
                studentNum = Integer.parseInt(scanner.nextLine());
                // 입력받은 학생수 크기의 배열을 생성.
                scores = new int[studentNum]; 
                
            }else if(selectNo == 2) {
                if (scores == null) {
                    System.out.println("학생수를 먼저 입력하세요...");
                    continue; // while 반복문을 처음부터 다시 시작.
                }
                
                // 점수 입력 
                // 배열 scores의 길이만큼 반복하면서 점수를 입력받고, 배열에 저장.
                for(int i=0 ; i <scores.length; i++) {
                    System.out.print("scores["+ i + "]" + ">" + " ");
                    int student_score = Integer.parseInt(scanner.nextLine());
                    scores[i] = student_score;
                }
                
            }else if(selectNo == 3) {
                if (scores == null) {
                    System.out.println("학생수를 먼저 입력하세요...");
                    continue;
                }
                
                // 점수 리스트
                // 배열 scores에 저장된 모든 점수 출력.
                for(int i=0 ; i <scores.length; i++) {
                    System.out.println("scores["+ i + "]> " + scores[i]);
                }
                
                //for-each 문으로도 표현할수있지만 굳이...?
//                int count = 0;
//                for (int x : scores) {
//                    System.out.println("scores[" + count + "]> " + x);
//                    count++;
//                }
                
                
            }else if(selectNo == 4) {
                if (scores == null) {
                    System.out.println("학생수를 먼저 입력하세요...");
                    continue;
                }
                // 최댓값, 평균
                // 음수가 표현안될 수있으므로 max=0 으로 초기화하는건 위험
                int max = scores[0];
                for(int i=0 ; i <scores.length; i++) {
                    if(scores[i] > max) {
                        max = scores[i];
                    }
                }
                
                //for-each 구문으로 표현했을 때
//                for(int x : scores) {
//                    max = (x > max) ? x : max;
//                }
                
                // 합계 => 평균
                
                int sum = 0;
                for(int x : scores) {
                    sum += x;
                }
                
                double avg = (double) sum/scores.length;
                
                System.out.print("최고 점수: "+ max);
                System.out.println();
                System.out.print("평균 점수: "+ avg);
                System.out.println();
                
            }else if(selectNo == 5) {
                run = false;
            }
            else {
                System.out.println("메뉴(1 ~ 5)를 다시 선택...");
            }
            
        }

        System.out.println("프로그램 종료");
    }

}
