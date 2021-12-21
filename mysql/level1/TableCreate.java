package mysql.level1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreate {
    public static void main(String[] args) {
      try {
        Class.forName("com.mysql.cj.jdbc.Driver");
     } catch(ClassNotFoundException cnfe) {
        System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
        return;
     } 
    
     Connection conn = null;
     Statement stmt = null;

     try {
        String url = "jdbc:mysql://localhost:3306/sqldb?characterEncoding=UTF-8&serverTimezone=UTC";
        String user = "root";
        String passwd = "1234";

        conn = DriverManager.getConnection(url, user, passwd);
        System.out.println("데이터베이스에 접속했습니다.");
        stmt = conn.createStatement();
        stmt.executeUpdate("create table studetn (name varchar(10), score int");
        System.out.println("데이터베이스에 접속했습니다.");
        System.out.println("student 테이블 생성");
        
     }catch(SQLException se1) {
        System.out.println(se1.getMessage());
     }finally {
        try {
           if(stmt != null) {
              stmt.close();
           }
           if(conn != null) {
              conn.close();
           }            
        }catch(SQLException se2) {
           System.out.println(se2.getMessage());
        }
     }
    }
}
