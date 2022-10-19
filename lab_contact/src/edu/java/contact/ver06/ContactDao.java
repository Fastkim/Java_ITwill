package edu.java.contact.ver06;

import java.util.List;


// CRUD(create(insert)/Read(select)/Update/Delete)를 담당하는 Controller
public interface ContactDao {

    List<Contact> read(); // 연락처 전체 검색
    Contact read (Integer cid); // 연락처 테이블의 고유키(PK)로 검색
    int create (Contact contact);
    int update (Contact contact);
    int delete (Integer cid);
}
