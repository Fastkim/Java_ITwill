package edu.java.contact.ver06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleDriver;

import static edu.java.contact.ver06.OracleConnection.*;
import static edu.java.contact.ver06.ContactSql.*;
import static edu.java.contact.ver06.Contact.Entity.*;


public class ContactDaoImpl implements ContactDao {

    // Singleton 적용
    private static ContactDaoImpl instance = null;
    
    // 기본생성자 생성
    private ContactDaoImpl() {}
    
    public static ContactDaoImpl getInstance() {
        if (instance == null) {
            instance = new ContactDaoImpl();
        }
        
        return instance;
    }
    
    private Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        
        return DriverManager.getConnection("URL, USER, PASSWORD");
    }
    
    private void closeResources(Connection conn, Statement stmt)
            throws SQLException{
        conn.close();
        stmt.close();
    }
    
    
    private void closeResources(Connection conn, Statement stmt, ResultSet rs)
            throws SQLException {
        closeResources(conn, stmt);
        rs.close();
    }
    
    
   
    @Override
    public List<Contact> read() {
        List<Contact> list = new ArrayList<>(); // 리턴하기 위한 ArrayList - read의 결과를 저장.
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = getConnection(); // Oracle DB와 연결(접속)
            
            System.out.println(SQL_READ);
            stmt = conn.prepareStatement(SQL_READ); // SQL 문장 준비
            
            rs = stmt.executeQuery(); // SQL 문장 실행
            while (rs.next()) { // ResultSet에 row 데이터가 있으면
                // row에서 각 column에 있는 값들을 분석.
                Integer cid = rs.getInt(COL_CID);
                String name = rs.getString(COL_NAME);
                String phone = rs.getString(COL_PHONE);
                String email = rs.getString(COL_EMAIL);
                
                // Contact 타입 객체 생성.
                Contact contact = new Contact(cid, name, phone, email);
                list.add(contact);
            }
                      
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                closeResources(conn, stmt, rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return list;
    }


    @Override
    public Contact read(Integer cid) {
        Contact contact = null;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = getConnection();
            
            System.out.println(SQL_READ_CID);
            stmt = conn.prepareStatement(SQL_READ_CID);
            stmt.setInt(1, cid);
            
            rs = stmt.executeQuery();
            if (rs.next()) { // 검색 결과에서 row 데이터가 있으면
                Integer no = rs.getInt(COL_CID);
                String name = rs.getString(COL_NAME);
                String phone = rs.getString(COL_PHONE);
                String email = rs.getString(COL_EMAIL);
                
                contact = new Contact(cid, name, phone, email);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                closeResources(conn, stmt, rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return contact;
    }

    @Override
    public int create(Contact contact) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            
            System.out.println(SQL_INSERT);
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, contact.getName());
            stmt.setString(2, contact.getPhone());
            stmt.setString(3, contact.getEmail());
            
            result = stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                closeResources(conn, stmt);
            } catch (SQLException e) {
                 e.printStackTrace();
            }
            
        }
        
        return result;
    }
    
    
    @Override
    public int update(Contact contact) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = getConnection();
            
            System.out.println(SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, contact.getName());
            stmt.setString(2, contact.getPhone());
            stmt.setString(3, contact.getEmail());
            
            result = stmt.executeUpdate();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
                try {
                    closeResources(conn, stmt);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        
        return result;
    }
    
    @Override
    public int delete(Integer cid) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = getConnection();
            
            System.out.println(SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cid);
            
            result = stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                closeResources(conn, stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return result;
    }

}
