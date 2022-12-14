package edu.java.jdbc03;

import static edu.java.ojdbc.OracleJdbc.PASSWORD;
import static edu.java.ojdbc.OracleJdbc.URL;
import static edu.java.ojdbc.OracleJdbc.USER;
import static edu.java.ojdbc.model.Blog.Entity.COL_BLOG_NO;
import static edu.java.ojdbc.model.Blog.Entity.COL_CONTENT;
import static edu.java.ojdbc.model.Blog.Entity.COL_MODIFIED_DATE;
import static edu.java.ojdbc.model.Blog.Entity.COL_TITLE;
import static edu.java.ojdbc.model.Blog.Entity.TBL_BLOGS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

public class JdbcMain03 {

    public static void main(String[] args) {
        // JDBC를 사용한 update
        
        Scanner scanner = new Scanner(System.in);
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = String.format(
                    "update %s set %s = ?, %s = ?, %s = sysdate where %s = ?", 
                    TBL_BLOGS, COL_TITLE, COL_CONTENT, COL_MODIFIED_DATE, COL_BLOG_NO);
            System.out.println(sql);
            
            stmt = conn.prepareStatement(sql);
            
            System.out.print("업데이트 할 글 번호>> ");
            int no = Integer.parseInt(scanner.nextLine());
            System.out.print("업데이트 할 제목>> ");
            String title = scanner.nextLine();
            System.out.print("업데이트 할 내용>> ");
            String content = scanner.nextLine();
            
            stmt.setString(1, title);
            stmt.setString(2, content);
            stmt.setInt(3, no);
        
            int result = stmt.executeUpdate();
            System.out.println(result + "개 행이 업데이트됐습니다.");
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 리소스 해제
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        

    }

}
