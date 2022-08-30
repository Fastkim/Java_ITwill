package edu.java.class06;

/**
 * 은행 계좌 정보 클래스.
 * 계좌번호, 잔액을 필드로 갖고, 입금, 출금, 이체, 정보 출력 기능을 메서드로 갖음.
 */
public class Account {
    // field
    int accountNo; // 계좌번호
    double balance; // 잔고
    
    // constructor - argument 2개를 갖는 생성자.
    // 매개변수 = 파라미터(Parameter)
    
    public Account(int accountNo,double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    /**
     * 입금(deposit)
     * 
     * @param amount 입금액.
     * @return 입금 후 잔액을 리턴.
     */
    
    public double deposit(double amount) {
        this.balance += amount;  // this.balance = this.balance + amount
        return this.balance;
    }
    
    /**
     * 출금(withdraw)
     * 
     * @param amount 출금액
     * @return 출금 후 잔액을 리턴.
     */
    
    public double withdraw(double amount) { 
        this.balance -= amount;
        return this.balance;
    }
    
    /**
     * 이체(transfer)
     * 
     * @param to 이체할 계좌 객체(Account 타입)
     * @param amount 이체할 금액
     * @return true(이체 성공).
     */
    
    public boolean transfer(Account to, double amount) { 
        // 클래스 이름은 클래스가 완성되지 않아도 단순히 변수를 선언하기 위한 데이터 타입으로써 사용할수있다.
        // 이체 : (1) 내 계좌 출금. (2) 상대방 계좌 입금.
//        this.balance -= amount;
//        to.balance += amount;
        
        // 메서드를 직접 호출해서 이용한 경우
        this.withdraw(amount);
        to.deposit(amount);
        
        return true;
    }
    
    /**
     * 계좌 정보 출력(printAccountInfo). 계좌 번호와 잔액을 출력.
     */
    
    public void printAccountInfo() {
        System.out.println("--- 계좌 정보 ---");
        System.out.println("계좌번호 : " + this.accountNo);
        System.out.println("잔액 : " + this.balance);
        
    }
    
}