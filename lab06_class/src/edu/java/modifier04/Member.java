package edu.java.modifier04;

/*
 * field : 아이디, 비밀번호
 * constructor : argument 2개를 갖는 생성자.
 * method : 아이디 getter, 비밀번호 getter/setter
 */

public class Member {
    
    private String Id;
    private String passWord;
    
    
    public Member(String Id,String passWord) {
        
        this.Id = Id;
        this.passWord = passWord;
        
    }
    
    public String getId() {
        return this.Id;
    }
    
    public String getPassWord() {
        return this.passWord;
    }
    
    public void setPassWord(String newPassWord) {
        this.passWord = newPassWord;
    }
    

}
