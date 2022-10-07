package edu.java.jdbc04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

import static edu.java.ojdbc.OracleJdbc.*;

import static edu.java.ojdbc.model.Blog.Entity.*;

public class JdbcMain04 {

    public static void main(String[] args) {
        // JDBC를 사용한 delete
        
        Scanner scanner = new Scanner(System.in);
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            // 드라이버 매니저(관리자)에게 오라클 라이브러리 드라이버 등록
            DriverManager.registerDriver(new OracleDriver());
            
            // 드라이버 관리저에게 데이터베이스 계정 접속
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            // sql 문장 생성
            
            String sql = String.format(
                    "delete from %s where %s = ? ", TBL_BLOGS, COL_BLOG_NO);
            
            // sql 문장 데이터베이스에 접속
            stmt = conn.prepareStatement(sql);
            
            // 삭제할 행 번호 입력받기
            System.out.print("삭제할 행 번호를 입력하세요>> ");
            
            int no = Integer.parseInt(scanner.nextLine());
            
            stmt.setInt(1, no); // setInt(sql 문장에서 적용될 몇 번째 파라미터인지, 변수)
            
            int result = stmt.executeUpdate();
            System.out.println(result + "개 행이 업데이트됐습니다.");
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // 자원 해제
                conn.close();
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
