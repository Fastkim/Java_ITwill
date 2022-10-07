package edu.java.ojdbc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.java.ojdbc.model.Blog;
import oracle.jdbc.OracleDriver;

import static edu.java.ojdbc.model.Blog.Entity.*;
import static edu.java.ojdbc.OracleJdbc.*;
import static edu.java.ojdbc.controller.JdbcSql.*;

public class BlogDaoImpl implements BlogDao {

    // Singleton 적용
    private static BlogDaoImpl instance = null;
    
    private BlogDaoImpl() {}
    
    public static BlogDaoImpl getInstance() {
        if (instance == null) {
            instance = new BlogDaoImpl();
        }
        return instance;
    }
    

    @Override
    public List<Blog> select() {
        List<Blog> list = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            
            // 드라이버 매니저에 오라클 라이브러리 드라이버 등록
            DriverManager.registerDriver(new OracleDriver());
            System.out.println("Oracle Driver 등록 성공!");
            
            // 오라클 DB에 접속.
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Oracle DB 접속 성공!");
            
            // 전체 검색(select)할 수 있는 SQL 문장과 Statement 객체를 생성
            // JDBC에서는 SQL 문장 끝에 세미콜론(;)을 사용하지 않음!
            
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
           
            
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        
        return null;
    }

    @Override
    public Blog select(Integer blogNo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int insert(Blog blog) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int update(Blog blog) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(Integer blogNo) {
        // TODO Auto-generated method stub
        return 0;
    }

}
