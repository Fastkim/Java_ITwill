package edu.java.loop05;

public class LoopMain05 {

	public static void main(String[] args) {
		// 369 게임 출력

		for (int n = 1; n <= 100; n++) {
			
			if(n == 30 || n == 60 || n == 90) {
				System.out.println("*");
			}
			
			else if(n % 10 == 0) {
				System.out.println(n);
			}
			
			else if (n % 10 == 3 || n % 10 ==6 || n % 10 ==9) {
				System.out.print("*\t");
			}
			
			else if((n>29 && n<40) || (n>59 && n<70) || (n>89 && n<100)) {
				System.out.print("*\t");
			}
				
			 else {
				System.out.print(n + "\t");
			}

			 
		}
		
	}

}
