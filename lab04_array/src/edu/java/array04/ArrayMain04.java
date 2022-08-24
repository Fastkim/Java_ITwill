package edu.java.array04;

public class ArrayMain04 {

    public static void main(String[] args) {
        // 2차원 배열 : 1차원 배열들을 원소로 갖는 배열.
        // 2차원 배열은 인덱스가 2개
        // 타입 [][] 배열이름 = { {...} , {...} , ...};
        
        // 원소의 개수가 불규칙적일때는 length 메서드를 잘 활용
        int[][] array = {
                {1, 2, 3, 4},
                {5, 6, 7, 8, 9},
                {9, 10, 11},
        };
//        System.out.println(array);
//        System.out.println(array[0]);
//        System.out.println(array[0][0]);
        
        // 2차원 배열에서의 length의 의미:
        System.out.println("array.length = " + array.length); //array배열은 1차원 배열 3개를 가지고있다 
        System.out.println("array[0].length = " + array[0].length);
        System.out.println("array[1].length = " + array[1].length);
        System.out.println("array[2].length = " + array[2].length);
        
        // for 문을 사용한 배열 원소 출력
        
        for(int i=0;i<array.length;i++) {
            System.out.print("{");
            for(int j=0;j<array[i].length;j++) {
                System.out.print(array[i][j]+",");
            }
            System.out.print("}");
            System.out.println();
        }
        
        
        //for-each 문을 사용한 배열 원소 출력
        
        for (int[] arr : array) {
            System.out.print("{");
            for(int x : arr) {
                System.out.print(x + ",");
            }
            System.out.print("}");
            System.out.println();
        }
    }

}
