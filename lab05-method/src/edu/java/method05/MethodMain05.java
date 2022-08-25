package edu.java.method05;

public class MethodMain05 {

    public static void main(String[] args) {
        // 메서드 작성 연습

        int[] scores = { 70, 60, 100, 50, 80 };

        int sum = sum(scores);
        System.out.println("총점 = " + sum); // 360

        double avg = mean(scores);
        System.out.println("평균 = " + avg); // 72.0

        int max = max(scores);
        System.out.println("최댓값 = " + max); // 100

        int min = min(scores);
        System.out.println("최솟값 = " + min); // 50
    }

    public static int sum(int[] scores) {
        int result = 0;
        for (int i = 0; i < scores.length; i++) {
            result += scores[i];
        }
        return result;
    }

    public static double mean(int[] scores) {
        double avg = 0;
         avg = (double)(sum(scores) / scores.length);
        
        return avg;
    }
    
    public static int max(int[] scores) {
        
        int max = scores[0];
        for(int i = 0 ; i < scores.length ; i++) {
            if(max < scores[i]) {
                max = scores[i];
            }
        }
        return max;
    }
    
    public static int min(int[] scores) {
        int min = scores[0];
        
        for(int i = 0 ; i < scores.length ; i++) {
            if(min > scores[i]) {
                min = scores[i];
            }
        }
        return min;
    }

}
