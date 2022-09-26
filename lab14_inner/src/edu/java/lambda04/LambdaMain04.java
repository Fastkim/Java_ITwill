package edu.java.lambda04;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class LambdaMain04 {

    public static void main(String[] args) {
        // Employee를 원소로 갖는 리스트를 선언, 생성
        List<Employee> employees = Arrays.asList(
            new Employee(100, "이존규","개발자","개발1팀", 300),
            new Employee(101, "김지훈","개발자","개발2팀", 301),
            new Employee(201, "김용훈","개발자","개발2팀", 302),
            new Employee(202, "김가영","디자이너","개발1팀", 303),
            new Employee(301, "최은정","디자이너","개발2팀", 400),
            new Employee(500, "추지훈","부사장","인사팀", 1000) 
        ); 
        
        // for-each 문장
        // Ex 1. 모든 직원들의 정보를 한 줄에 한 명씩 출력.
        for(Employee e : employees) {
            System.out.println(e);
        }
        
        System.out.println();
        employees.stream().forEach(System.out::println);
        
        
        // Ex 2. 직무가 "개발자"인 직원들의 급여 합계를 출력.
        System.out.println("\nEx 2.---------");
        int sum = 0;
        double salarySum = 0;
        for(Employee e : employees) {
            if(e.getJob().equals("개발자")) {
                salarySum = salarySum + e.getSalary();
            }
        }
        System.out.println("직무가 개발자인 직업들의 급여합계 : " + salarySum);
        
        System.out.println();
        sum = employees.stream()
                .filter(e -> e.getJob().equals("개발자"))
                .mapToInt(Employee::getSalary)//.mapToInt(e -> e.getSalary())
                .sum();
        
        
        // lambda 표현식 대신에 익명클래스로 표현 
        sum = employees.stream()
                .filter(new Predicate<Employee>() {
                    @Override
                    public boolean test(Employee t) {
                        return t.getJob().equals("개발자");
                    }
                }).mapToInt(new ToIntFunction<Employee>() {

                    @Override
                    public int applyAsInt(Employee value) {
                        return value.getSalary();
                    }
                    
                })
                .sum();
        
        // Ex 3. 부서가 "개발2팀"인 직원들의 급여 평균을 출력
        System.out.println("\nEx 3. --------");
        salarySum = 0; // 개발2팀 직원들의 월급의 합계를 저장할 변수
        int count = 0; // 개발2팀 직원수를 저장할 변수
        double salaryAvg = 0;
        for(Employee e : employees) {
            if(e.getDept().equals("개발2팀")) {
                salarySum = salarySum + e.getSalary();
                count++;
                
            }
        }
        salaryAvg = (double) salarySum / count;
        System.out.println("직무가 개발2팀인 직원들의 급여합계 : " + salarySum);
        System.out.println("직무가 개발2팀인 직원들의 급여평균 : " + salaryAvg);
        
        System.out.println();
        salaryAvg = employees.stream()
                      .filter(e -> e.getDept().equals("개발2팀"))
                      .mapToInt(e -> e.getSalary())
                    //.mapToInt(Employee::getSalary)
                      .average()
//                      .getAsDouble();  // Optional -> Double
//                      .orElse(0); //Optional -> 정상적인 값 또는 비정상일 경우 기본값.
                      .orElseThrow(); //Optional -> 정상적인 값 또는 Exception
        System.out.println("salaryAvg = " + salaryAvg);
        
        // Ex 4. 급여가 400 이상인 직원들의 정보를 한 줄씩 출력.
        
        System.out.println("\nEx 4, -----");
        
        for(Employee e : employees) {
            if(e.getSalary() >= 400) {
                System.out.println(e);
            }
        }
        
        System.out.println();
        employees.stream()
            .filter(e -> e.getSalary() >= 400)
            .forEach(System.out::println);
        
    }

}
