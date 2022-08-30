package edu.java.modifier04;

public class ModifierMain04 {

    public static void main(String[] args) {
        // Member 타입의 객체 생성.    
        Member member = new Member("ekgns019","60142468");
        
        // System.out.println(member.Id); 찾을 수 없대
        
        System.out.println(member.getId());
        
        System.out.println(member.getPassWord());
        // member.Id = " "; // private 멤버는 다른 클래스에서 직접 사용할 수 없음.
        
        member.setPassWord("1501916");
        
        System.out.println(member.getPassWord());
        

    }

}
