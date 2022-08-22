// 중첩 if문 사용

package edu.java.rps;

import java.util.Random;
import java.util.Scanner;

public class RpsMain02 {

    public static void main(String[] args) {
        // 가위바위보 게임
        // 가위-0, 바위-1, 보-2

        // 컴퓨터의 가위/바위/보는 (정수) 난수로 만듦.
        Random rn = new Random();

        // 0 보다는 크거나 같고 3보다는 작은 무작위 정수 셋팅
        int computer = rn.nextInt(3);

        // 사용자는 콘솔창에서 키보드로 가위/바위/보에 해당하는 정수를 입력.
        System.out.println("가위/바위/보 게임");
        System.out.println("-----------------");
        System.out.println("[0] 가위");
        System.out.println("[1] 바위");
        System.out.println("[2] 보");
        System.out.println("-----------------");
        System.out.println("0,1,2 중 하나의 숫자를 입력하세요 : ");

        Scanner sc = new Scanner(System.in); // System은 콘솔창을 의미
        // 사용자에게 숫자를 입력받음.
        int user = sc.nextInt();

        
        // 중첩if문 사용
        // 컴퓨터가 가위를 낼 경우
        if (computer == 0)
            if (user == 0)
                System.out.println("computer(가위):user(가위) - 비겼습니다.");
            else if (user == 1)
                System.out.println("computer(가위):user(바위) - 유저가 이겼습니다.");
            else
                System.out.println("computer(가위):user(보) - 컴퓨터가 이겼습니다.");

        
        // 컴퓨터가 바위를 낼 경우
        if (computer == 1)
            if (user == 0)
                System.out.println("computer(바위):user(가위) - 컴퓨터가 이겼습니다.");

            else if (user == 1)
                System.out.println("computer(바위):user(바위) - 비겼습니다.");

            else
                System.out.println("computer(바위):user(보) - 유저가 이겼습니다.");

        // 컴퓨터가 보를 낼 경우

        if (computer == 2)
            if (user == 0)
                System.out.println("computer(보):user(가위) - 유저가 이겼습니다.");

            else if (user == 1)
                System.out.println("computer(보):user(바위) - 컴퓨터가 이겼습니다.");

            else 
                System.out.println("computer(보):user(보) - 비겼습니다.");
            
    }

}