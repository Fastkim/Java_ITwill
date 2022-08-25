package edu.java.array08;

import java.util.Random;

public class ArrayMain08 {

    public static void main(String[] args) {
        // Ch. 5-2 Ex. 5 (p201)
        // 1차원 정수(int) 배열 3개를 갖는 2차원 배열을 선언
        
        int[][] array = new int[3][];
        
        Random random = new Random();
        
        // 첫번째 배열에는 난수 2개, 두번째 배열에는 난수 3개, 세번째 배열에는 난수 4개 저장.
        // 난수의 범위는 [70, 100) [-> 포함 , ) -> 미포함 = 70 이상 100 미만.
        array[0] = new int[2];
        array[1] = new int[3];
        array[2] = new int[4];
        
        for (int i = 0; i < array.length;i++) {
            array[i] = new int[array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(70,100);
                System.out.println("array[" + i + "] = " + array[i][j]);
            }
        }

        // 2차원 배열 array의 모든 원소들의 합(int)을 계산하고 출력.
        int sum = 0;
        int count = 0;
        for(int[]x : array) {
            for(int y : x) {
                sum += y;
                count++;
            }
        }
        System.out.println("2차원 배열의 모든 원소들의 합은 : " + sum);
        System.out.println("2차원 배열의 모든 원소들의 갯수는 : " + count);
        // 차원 배열 array의 모든 원소들의 평균(double)을 계산하고 출력.
     
        double avg =(double) (sum/((array.length * array[0].length) + 
                (array.length * array[1].length) + (array.length * array[2].length)));
        
        System.out.println("2차원 배열 array의 모든 원소들의 평균은 : " + avg);
    }

}

// 다 한사람은 교재에 201p 6번 이메일로 숙제 제출 