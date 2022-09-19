package edu.java.contact.ver03;

import java.util.ArrayList;
import java.util.List;

import edu.java.contact.ver02.Contact;

import java.util.List;

public class ContactDaoImpl implements ContactDao {

    // 연락처 정보를 저장할 List
    List<Contact> contact = new ArrayList<>();
    
    @Override
    public List<Contact> read() {
        return contact;
    }

    @Override
    public Contact read(int index) {
        if (contact.size() == 0) {
            return null;
        } else {
            return contact.get(index);
        }

//    @Override
//    public Contact read(int index) {
//        try {
//            return contact.get(index);
//        } catch (ArrayIndexOutOfBoundsException e) {
//            // index < 0 || index >= size 인 경우
//            return null;
//        }
    
//    @Override
//    public Contact read(int index) {
//        if (!isValidIndex(index)) {
//            return null;
//        } 
//            return contact.get(index);
//        }
    
        
    }

    @Override
    public int create(Contact contact) {
        if (this.contact.add(contact)) {
            return 1;
        } else {
            return 0;
        }

    }

    @Override
    public int update(int index, Contact contact) {
        
//      if (!isValidIndex(index)) {
//      // valid index: index >= 0 && index < size
//      // not valid index < 0 || index >= size
//      return 0;
//  }
    
        if (index >= 0) {
            this.contact.get(index).setName(contact.getName());
            this.contact.get(index).setPhone(contact.getPhone());
            this.contact.get(index).setEmail(contact.getPhone());
            return 1;
        } else {
            return 0;
        }
        

   }

    @Override
    public int delete(int index) {
        if (index >= 0) {
            this.contact.remove(index);
            return 1;
        } else {
            return 0;
        }
    }
    
}
