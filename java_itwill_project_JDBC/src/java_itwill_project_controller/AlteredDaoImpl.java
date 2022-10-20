package java_itwill_project_controller;

import java.sql.Statement;
import java.time.LocalDateTime;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java_itwill_project_model.Altered;
import oracle.jdbc.OracleDriver;


import static java_itwill_project_controller.JdbcSql.*;
import static java_itwill_project_oracle.OracleJdbc.*;
import static java_itwill_project_model.Altered.Entity.*;

public class AlteredDaoImpl implements AlteredDao {

    // Singleton 적용
    private static AlteredDaoImpl instance = null;
    
    private AlteredDaoImpl() {}
    
    public static AlteredDaoImpl getInstance() {
        if (instance == null) {
            instance = new AlteredDaoImpl();
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
    public List<Altered> select() {
        List<Altered> list = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null; // SQL 쿼리문을 결과값으로 변환해 저장해준다.
            try {
                conn = getConnection();
                
                System.out.println(SQL_SELECT_ALL);
                stmt = conn.prepareStatement(SQL_SELECT_ALL);
                
                rs = stmt.executeQuery();
                while (rs.next()) {
                    Integer alteredNo = rs.getInt(COL_ALTERED_NO);
                    String title = rs.getString(COL_TITLE);
                    String detailAltered = rs.getString(COL_DETAIL_ALTERED);
                    String author = rs.getString(COL_AUTHOR);
                    String clothesType = rs.getString(COL_CLOTHES_TYPE);
                    LocalDateTime created = rs.getTimestamp(COL_CREATED_DATE).toLocalDateTime();
                    LocalDateTime modified = rs.getTimestamp(COL_MODIFIED_DATE).toLocalDateTime();
                    
                    // Altered 타입 객체 생성.
                    Altered altered = new Altered(alteredNo, title, detailAltered, author, clothesType, created, modified);
                    list.add(altered); // 결과 ArrayList에 추가.
                    
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
    public Altered select(Integer alteredNo) {
        Altered altered = null;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            
            System.out.println(SQL_SELECT_BY_NO);
            stmt = conn.prepareStatement(SQL_SELECT_BY_NO);
            stmt.setInt(1, alteredNo);
            
            rs = stmt.executeQuery();
            if (rs.next()) {
                Integer no = rs.getInt(COL_ALTERED_NO);
                String title = rs.getString(COL_TITLE);
                String detailAltered = rs.getString(COL_DETAIL_ALTERED);
                String author = rs.getString(COL_AUTHOR);
                String clothesType = rs.getString(COL_CLOTHES_TYPE);
                LocalDateTime created = rs.getTimestamp(COL_CREATED_DATE).toLocalDateTime();
                LocalDateTime modified = rs.getTimestamp(COL_MODIFIED_DATE).toLocalDateTime();
                
                altered = new Altered(alteredNo, title, detailAltered, author, clothesType, created, modified);
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
        return altered;
    }

    @Override
    public int request(Altered altered) {
        int result = 0; // DB insert 결과 값(insert된 행의 개수)를 저장할 변수
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = getConnection();
            
            System.out.println(SQL_REQUEST);
            stmt = conn.prepareStatement(SQL_REQUEST);
            stmt.setString(1, altered.getTitle());
            stmt.setString(2, altered.getDetailAltered());
            stmt.setString(3, altered.getAuthor());
            stmt.setString(4, altered.getClothesType());
            
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
    public int update(Altered altered) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            
            System.out.println(SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, altered.getTitle());
            stmt.setString(2, altered.getDetailAltered());
            stmt.setString(3, altered.getClothesType());
            stmt.setInt(4, altered.getAlteredNo());
            
            
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
    public int delete(Integer AlteredNo) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            
            System.out.println(SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, AlteredNo);
            
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
    public List<Altered> select(int type, String keyword) {
        List<Altered> list = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            switch (type) {
            case 0: // 제목 검색
                System.out.println(SQL_SELECT_BY_TITLE);
                stmt = conn.prepareStatement(SQL_SELECT_BY_TITLE);
                stmt.setString(1, "%" + keyword.toLowerCase() + "%");
                break;
            case 1: // 내용 검색
                System.out.println(SQL_SELECT_BY_DETAIL_ALTERED);
                stmt = conn.prepareStatement(SQL_SELECT_BY_DETAIL_ALTERED);
                stmt.setString(1, "%" + keyword.toLowerCase() + "%");
                break;
            case 2: // 제목 + 내용 검색
                System.out.println(SQL_SELECT_BY_TITLE_OR_DETAIL_ALTERED);
                stmt = conn.prepareStatement(SQL_SELECT_BY_TITLE_OR_DETAIL_ALTERED);
                stmt.setString(1, "%" + keyword.toLowerCase() + "%");
                stmt.setString(2, "%" + keyword.toLowerCase() + "%");
                break;
            case 3: // 작성자 검색
                System.out.println(SQL_SELECT_BY_AUTHOR);
                stmt = conn.prepareStatement(SQL_SELECT_BY_AUTHOR);
                stmt.setString(1, "%" + keyword.toLowerCase() + "%" );           
                break;
            default:
            }
            
            rs = stmt.executeQuery();
            while (rs.next()) {
                Integer alteredNo = rs.getInt(COL_ALTERED_NO);
                String title = rs.getString(COL_TITLE);
                String detailAltered = rs.getString(COL_DETAIL_ALTERED);
                String author = rs.getString(COL_AUTHOR);
                String clothesType = rs.getString(COL_CLOTHES_TYPE);
                LocalDateTime created = rs.getTimestamp(COL_CREATED_DATE).toLocalDateTime();
                LocalDateTime modified = rs.getTimestamp(COL_MODIFIED_DATE).toLocalDateTime();
    
                Altered altered = new Altered(alteredNo, title, detailAltered, author, clothesType, created, modified);
                list.add(altered);
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

}
