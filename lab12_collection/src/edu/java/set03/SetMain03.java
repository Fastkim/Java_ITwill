package edu.java.set03;

import java.util.HashSet;
import java.util.Random;

public class SetMain03 {

    public static void main(String[] args) {
        // HashSet<E> 사용.
        HashSet<Integer> numbers = new HashSet<>();

        // [0, 10) 범위의 정수 난수 5개를 저장.

        Random random = new Random();

        while (true) {
            numbers.add(random.nextInt(10));
            System.out.println(numbers);

            if (numbers.size() == 5) {
                break;
            }
        }

        // Set의 내용을 출력.
        System.out.println(numbers);

    }

}
