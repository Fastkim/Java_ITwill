package edu.java.method05;

public class MethodMain05 {

    public static void main(String[] args) {
        // 메서드 작성 연습

        int[] scores = { 70, 60, 100, 50, 81 };

        int sum = sum(scores);
        System.out.println("총점 = " + sum); // 360

        double avg = mean(scores);
        System.out.println("평균 = " + avg); // 72.0

        int max = max(scores);
        System.out.println("최댓값 = " + max); // 100

        int min = min(scores);
        System.out.println("최솟값 = " + min); // 50
        
        double Variance = Variance(scores);
        System.out.println("분산 = " + Variance);
        
        double standard_deviation = Math.sqrt(Variance);
        System.out.println("표준편차 = " + standard_deviation);
    }

    public static int sum(int[] scores) {
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        return sum;
    }

    public static double mean(int[] scores) {
         double mean = sum(scores) / (double)scores.length;
        return mean;
    }
    
    public static int max(int[] scores) {
        
        int max = scores[0];
        for(int i = 0 ; i < scores.length ; i++) {
            if(max < scores[i]) {
                max = scores[i];
            }
            
            // max = (max < x ) ? x : max ; (삼항연산자)
        }
        return max;
    }
    
    public static int min(int[] scores) {
        int min = scores[0]; // 최솟값을 배열의 첫번째 원소라고 가정하고 시작
        
        for(int i = 0 ; i < scores.length ; i++) {
            if(min > scores[i]) {
                min = scores[i];
            }
        }
        return min;
    }
    
    public static double Variance(int[] scores) {
        
        // 데이터 : {x1, x2, ..., xn}
        // 평균 : mu = (x1 + x2 + ... + xn) / n
        // 분산 : var = ((x1 - mu)^2 + (x2 - mu)^2 + ... + (xn - mu)^2) / n
        // 표준편차 : std = sqrt(var)
        
        /* double mu = mean(scores);
         * double total = 0;
         * for (int x ; array){
         *      total += (x - mu) * (x - mu);
         * }
         * */
        
        
        double result = 0;
        for (int i = 0; i < scores.length; i++) {
            result += Math.pow(scores[i] - mean(scores),2);
                    
        }
        
        return result / (scores.length);
        
    }
    

}
