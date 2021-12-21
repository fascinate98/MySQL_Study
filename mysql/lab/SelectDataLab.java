package mysql.lab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectDataLab {
    public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
			return;
		} 
		String url = "jdbc:mysql://localhost:3306/jdbcdb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "root";
		String passwd = "1234";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);  
		//트라이 괄호 안에서 변수 선언중. 
		//closerble이라는 인터페이스를 추가상속받는 클래스의 객체만 가능. 변수선언도 여기서 해야함. 미리해놓고 대입 ㄴㄴ
			Statement stmt = conn.createStatement()){     //이렇게 하면 나중에 클로즈 안해도 됨..           try catch with resource 구문이라고 함. 
			ResultSet rs = stmt.executeQuery("select id, name, title, date_format(meetingdate, '%Y년%m월%d일 %H시%i분') as dates from meeting");
			while(rs.next()) {
                System.out.println("id가 " + rs.getInt("id") + "인 친구");
				System.out.println( "친구이름 : " + rs.getString("name"));
                System.out.println( "미팅목적 : " + rs.getString("title"));
                System.out.println( "미팅시간 : " + rs.getString("dates"));
			}				
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}
