package mysql.level1;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sqldb?characterEncoding=UTF-8&serverTimezone=UTC";
            String user = "root";
            String passwd = "1234";
            Connection conn = DriverManager.getConnection(url, user, passwd);
            conn.close();
            System.out.println("MYSQL 연결 성공");
         } catch (Exception e) {
            System.out.println("MYSQL 연결 실패");
            System.out.print("사유 : " + e.getMessage());
      }
   }

}