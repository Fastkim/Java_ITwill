package java_itwill_project_controller;

import static java_itwill_project_oracle.OracleJdbc.*;
import static java_itwill_project_model.Login.Entity.*;
import static java_itwill_project_controller.jdbcSqlLogin.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java_itwill_project_model.Login;
import java_itwill_project_view.AlteredMain;
import java_itwill_project_view.AlteredMain.OnLoginListener;
import java_itwill_project_view.LoginMain;
import oracle.jdbc.OracleDriver;
import java_itwill_project_view.AlteredMain;
import java_itwill_project_view.LoginMain;

public class LoginDaoImpl extends JFrame implements LoginDao {

    private OnLoginListener dao;
    private LoginMain logindao;
    
    // Singleton 적용
    private static LoginDaoImpl instance = null;
    
    private LoginDaoImpl() {}
    
    public static LoginDaoImpl getInstance() {
        if (instance == null) {
            instance = new LoginDaoImpl();
        }
        
        return instance;
    }
    
    public Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    public void closeResources(Connection conn, Statement stmt) 
            throws SQLException {
        stmt.close();
        conn.close();
    }
    
    public void closeResources(Connection conn, Statement stmt, ResultSet rs)
            throws SQLException {
        rs.close();
        closeResources(conn, stmt);
    }
    
    @Override
    public int create(Login login) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = getConnection();
            
            System.out.println(SQL_CREATE_ACCOUNT);
            stmt = conn.prepareStatement(SQL_CREATE_ACCOUNT);
            stmt.setString(1, login.getLoginId());
            stmt.setString(2, login.getLoginPassword());
            stmt.setString(3, login.getName());
            stmt.setString(4, login.getPhone());
            
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
    
    public int select(String loginId, String loginPassword) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = getConnection();
            
            System.out.println(SQL_SELECT_LOGIN);
            stmt = conn.prepareStatement(SQL_SELECT_LOGIN);
            stmt.setString(1, loginId);
            stmt.setString(2, loginPassword);
            
            // return 값 
            rs = stmt.executeQuery();
            if (rs.next()) { // 검색 결과에서 row 데이터가 있으면
                return 1; 
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
        
        return result;
    }
    
   
    
}
