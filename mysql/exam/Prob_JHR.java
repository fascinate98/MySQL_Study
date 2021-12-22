package mysql.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Prob_JHR {
    public static void main(String[] args) {
		printEmp("A");
		printEmp("Q");
		printEmp("T");
	}
	public static void printEmp(String pn) {
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("[오류발생] " + cnfe.getMessage());
			return;
		} 
		String url = "jdbc:mysql://localhost:3306/sqldb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "root";
		String passwd = "1234";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);  
			Statement stmt = conn.createStatement()){     //이렇게 하면 나중에 클로즈 안해도 됨..           try catch with resource 구문이라고 함. 
			ResultSet rs = stmt.executeQuery("select emp.ename as names, locations.city as citys"
            + " from emp" 
            + " join dept"
            + " using(deptno)"
            + " join locations"
            + " using(loc_code)"
            + " where ename like '%" + pn + "%'");
			
			if(rs.next()) {
				System.out.println("**이름에 " + pn + " 문자가 들어간 직원들의 리스트**");
				do {
					
					System.out.println(rs.getString("names") + "(" + rs.getString("citys")+ ")");
				} while(rs.next());
			} else 			
				 System.out.println("~~ 이름에 " + pn + " 문자가 들어간 직원들은 없음 ~~");
		
		} catch (SQLException se) {
			System.out.println("[오류발생] " + se.getMessage());
		}



	}


}
