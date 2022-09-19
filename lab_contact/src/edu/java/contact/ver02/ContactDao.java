package edu.java.contact.ver02;

import edu.java.contact.ver02.Contact;

// MVC 아키텍쳐에서 Controller의 인터페이스 - 메서드 선언
public interface ContactDao { // Data Access Object(Dao) Access: 저장, 수정, 삭제, 검색
	
	/**
     * 신규 연락처 정보 등록. Argument로 전달된 Contact 객체를 배열에 저장.
     * 
     * @param m 신규 등록할 연락처 정보.
     * @return 배열에 새로운 연락처 저장이 성공하면 1, 그렇지 않으면 0을 리턴.
     */
	 int newContact(Contact C);
     
    /**
     * 전체 연락처 목록 검색 기능. 모든 연락처 정보가 저장된 배열을 리턴.
     * 
     * @return 연락처 정보가 저장된 배열.
     */
    Contact[] select();
    
    /**
     * 인덱스를 사용한 연락처 정보 검색 기능. 배열에서 해당 인덱스의 Contact 객체를 찾아서 리턴.
     * 
     * @param index 회원 정보를 검색할 인덱스. 0이상의 정수.
     * @return 배열의 index 위치에 null이 아닌 Contact 객체가 있으면 그 객체를 리턴.
     * index가 배열의 범위 밖에 있거나, 해당 인덱스의 배열원소가 null이면 null을 리턴.
     */
    Contact select(int index);
    
   /**
    *  연락처 정보 업데이트 기능. 해당 인덱스의 연락처 이름/전화번호/이메일을 수정.
    *  
    * @param index 수정할 연락처의 배열 인덱스. 0 이상의 정수.
    * @param name 
    * @param phone 
    * @param email
    * @return 비밀번호 수정 성공하면 1, 그렇지 않으면 0을 리턴.
    */
    
    int update(int index, String name, String phone, String email);
    

}
