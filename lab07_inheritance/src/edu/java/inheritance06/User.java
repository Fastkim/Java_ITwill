package edu.java.inheritance06;

public class User {
    // field : 사용자 아이디,비밀번호
    private String id;
    private String passWord;
    
    // 생성자 : 기본 생성자, argument 2개를 갖는 생성자.

    public User() {}
    
    public User(String id,String passWord) {
        this.id = id;
        this.passWord = passWord;
    }
    
    // getters/setters
    
    public String getid() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getpassWord() {
        return this.passWord;
    }
    
    public void setpassWord(String passWord) {
        this.passWord = passWord;
    }
    
    
    // toString() 재정의 : User 객체를 출력할 때 아이디와 비밀번호가 출력될 수 있도록.
    
    @Override
    public String toString() {
        String User = String.format("User ID = %s , User PassWord = %s", this.id, this.passWord);
        return User;
        
        //return "User(userId= " + this.id + "user password = " + this.passWord);
    }
    
    // equals() 재정의 : 아이디가 일치하는 User 객체는 같은 객체.
    
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if(obj instanceof User) {
            User us = ((User) obj);
            result = this.id.equals(us.id);    
        }  
        return result;
    }
    // hashCode() 재정의 : 아이디가 같으면 해쉬코드(int)도 같으면 됨. String의 hashCode를 리턴하겠다는 뜻임
    
    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
    
    
}
