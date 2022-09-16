package edu.java.contact.ver03;

import java.util.ArrayList;
import java.util.List;

import edu.java.contact.ver02.Contact;

import java.util.List;

public class ContactDaoImpl implements ContactDao {

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
