package mysql.level1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class SelectEmpLab {

   public static void main(String[] args) {
      
      Random ran = new Random();
      Boolean b = ran.nextBoolean();
      
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

      try {
         conn = DriverManager.getConnection(url, user, passwd);
         stmt = conn.createStatement();
         
         
         if(b) {
            rs = stmt.executeQuery("select ename, format(sal, 0) as sals from emp");
            while(rs.next()) {
               System.out.println(
                     rs.getString("ename") + 
                     " 직원의 월급은 " +
                     rs.getString("sals") + 
                     "원 입니다.");
            }
            
         }else {
            rs = stmt.executeQuery("select ename, DATE_FORMAT(hiredate,'%Y년%m월%d일') as date from emp order by hiredate");
            while(rs.next()) {
               System.out.println(
                     rs.getString("ename") + 
                     " 직원은 " +
                     rs.getString("date") + 
                     "에 입사하였습니다.");
            }
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
         }catch(SQLException se2) {
            System.out.println(se2.getMessage());
         }
      }
   }

}