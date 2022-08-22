package edu.java.loops06;

public class LoopMain06 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        // for 반복문
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }
        
        System.out.println("-------");
        // while 반복문
        int n = 1;
        while (n <= 5) {
            System.out.println(n);
            n++;
        }
        
        System.out.println("-----------");
        // 10부터 1까지 정수들을 내림차순으로 한 줄에 출력하세요. (10 9 8 ... 3 2 1)
        
        for(int i=10; i>=1; i--)
            System.out.print(i + " ");
        
        System.out.println();
        
        int i = 10;
        while(i >= 1) {
            System.out.print(i + " ");
            i--;
        }
        System.out.println();
        System.out.println("-----------");
        
        // 10 이하의 양의 홀수들을 한 줄에 출력하세요. (1 3 5 7 9)
        for(int s=1;s<=5;s++)
            System.out.print((s*2)-1 + " ");
        
        System.out.println();
        
        int s = 1;
        while(s<=5) {
            System.out.print((s*2)-1 + " ");
            s++;
        }
        
        
        n = 1;
        System.out.println();
        while (n < 10) {
            if (n % 2 ==1) { // n이 홀수이면,
                System.out.print(n + " ");
                //n++; 안에 들어오면 무한루프가 된다.
            }
            n++;
        }
        
        
    }

}
