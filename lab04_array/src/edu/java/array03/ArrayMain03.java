package edu.java.array03;

import java.util.Random;

public class ArrayMain03 {

    public static void main(String[] args) {
        // Random 객체를 선언, 생성.
        
        Random random = new Random();
        
        int x[] = new int[10];
        
        for(int i=0;i<10;i++) {
            x[i] = random.nextInt(10);
        }
        
        
        // 정수 10개를 저장할 수 있는 배열(scores)을 선언.
        
        int scores[] = new int[10];
        
        // 배열 scores에 0 이상 10 이하의 정수 난수 10개를 저장.
        
        for(int i=0; i<10; i++) {
            scores[i] = x[i];
            System.out.println("score[" + i + "]" + "=" + scores[i]);
        }
            
        // 배열 scores에 저장된 모든 점수들의 합계를 계산하고 출력.
        int sum = 0;
        for(int i=0; i<10; i++) {
            sum = sum + scores[i];
        }
        
        System.out.println("배열 scores의 총합은 : " + sum);
            
        // 배열 scores에 저장된 모든 점수들의 평균을 소수점까지 계산해서 출력.
            
        double avg = (double)sum/scores.length;
        System.out.println("배열 scores에 저장된 모든 점수들의 평균은 : " + avg);
        
    }

}
