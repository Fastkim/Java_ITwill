package edu.java.array09;

import java.util.Scanner;

public class ArrayMain09 {

    public static void main(String[] args) {
        // Ch. 6-2 Ex. 6 (p201)
        
        boolean run = true;
        int[] scores = null;
        Scanner scanner = new Scanner(System.in);
        
        
        
        while(run) {
            System.out.println("----------------------------------------");
            System.out.println("1. 학생수 | 2. 점수입력 | 3.점수리스트 | 4. 분석 | 5. 종료");
            System.out.println("----------------------------------------");
            System.out.print("선택> ");
            
            int selectNo = Integer.parseInt(scanner.nextLine());
            
            if(selectNo == 1) {
                // 작성 위치
                System.out.print("학생수> ");
                int student = Integer.parseInt(scanner.nextLine());
                scores = new int[student]; 
                
            }else if(selectNo == 2) {
                // 작성 위치
                for(int i=0 ; i <scores.length; i++) {
                    System.out.print("scores["+ i + "]" + ">" + " ");
                    int student_score = Integer.parseInt(scanner.nextLine());
                    scores[i] = student_score;
                }
                
            }else if(selectNo == 3) {
                // 작성 위치
                for(int i=0 ; i <scores.length; i++) {
                    System.out.println("scores["+ i + "]" + ">" + " " + scores[i]);
                }
            }else if(selectNo == 4) {
                // 작성 위치
                int max = 0;
                for(int i=0 ; i <scores.length; i++) {
                    if(scores[i] > max) {
                        max = scores[i];
                    }
                }
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
            
        }

        System.out.println("프로그램 종료");
    }

}
