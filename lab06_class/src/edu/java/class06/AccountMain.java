package edu.java.class06;

public class AccountMain {

    public static void main(String[] args) {
        Account client = new Account(110322,500000);
        
        client.deposit(20000);
        
        System.out.println("현재 고객님의 잔액은 = " + client.balance + "원 입니다");
        
        client.withdraw(10000);
        
        
        System.out.println("현재 고객님의 잔액은 = " + client.balance + "원 입니다");
        
        Account client2 = new Account(60142468,800000);
        
        client2.transfer(client,client2,200000);
            
        client.printAccountInfo();
        client2.printAccountInfo();
        
        System.out.println(client.balance);
        
        
        
        
        
        

    }

}
