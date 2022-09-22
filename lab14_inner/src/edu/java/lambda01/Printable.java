package edu.java.lambda01;

@FunctionalInterface // 인터페이스의 추상메서드가 1개만 존재하는지
public interface Printable {

    public void print(String msg);
    
}
