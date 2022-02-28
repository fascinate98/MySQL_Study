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
          
            System.out.println("MYSQL �뿰寃� �꽦怨�");
         } catch (ClassNotFoundException e) {
            System.out.println("MYSQL �뿰寃� �떎�뙣");
            System.out.print("�궗�쑀 : " + e.getMessage());
      }finally {
    	  try {
    		  conn.close();
    	  }
    	  
      }
   }

}