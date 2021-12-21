package mysql.level1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectEmp {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
      } catch(ClassNotFoundException cnfe) {
         System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
         return;
      } 
      
      String url = "jdbc:mysql://localhost:3306/sqldb?characterEncoding=UTF-8&serverTimezone=UTC";
      String user = "root";
      String passwd = "1234";
      Connection conn = null;
      Statement stmt = null;
      ResultSet rs = null;
      //트라이 밖에 넣은 이유 : 클로즈는 파이널리에서 하는데 그럴라면 블럭에서 나와야함.
      try {
         conn = DriverManager.getConnection(url, user, passwd);
         System.out.println(conn.getClass().getName());
         stmt = conn.createStatement();
         System.out.println(stmt.getClass().getName());
         rs = stmt.executeQuery("select ename, sal, hiredate from emp");
         System.out.println(rs.getClass().getName());
         while(rs.next()) {
            System.out.println(rs.getString("ename") + "," + rs.getDate("hiredate")+","+
            rs.getInt("sal"));
         }
      }catch(SQLException se1) {
         System.out.println(se1.getMessage());
      }finally {
         try {
            if(rs != null) {
               rs.close();
            }
            if(stmt != null) {
               stmt.close();
            }
            if(conn != null) {
               conn.close();
            }            
            //클로즈 할때도 예외처리 해야함
         }catch(SQLException se2) {
            System.out.println(se2.getMessage());
         }
      }
   }

}