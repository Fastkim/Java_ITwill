package edu.java.loop02;

public class LoopMain02 {

    public static void main(String[] args) {
        // 복합 할당 연산자 : +=, -=, *=, /=, ...
        int x =1;
        x = x + 3;
        x += 3;
        // 0 2 4 6 8 10을 한 줄씩 출력
        
        for(int i=0;i<=5;i++) {
            System.out.println(2*i);
        }
        
        for(int n = 0; n<= 10; n+=2) {
            System.out.println(n);
        }
        
        for(int i=0;i<=5;i++) {
            int result;
            result = i * 2;
            System.out.println(result);
        }
        
        for(int i=0;i<=10;i++) {
            if(i % 2 ==0) {
                System.out.println(i);
            }
        }
    }
}
