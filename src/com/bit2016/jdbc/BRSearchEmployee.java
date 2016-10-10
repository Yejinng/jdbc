package com.bit2016.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BRSearchEmployee {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. Connection 얻어오기			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = 
					DriverManager.getConnection(url, "hr", "hr");
		
			// 3. Statement 생성
			stmt = conn.createStatement();
			
			// 4. SQL문 실행
			Scanner sc = new Scanner(System.in);
			String keyboard = sc.nextLine();
			String sql = "select first_name, last_name, email, phone_number, hire_date "
					+ "from employees where first_name like '%keyboard%' or last_name like '%keyboard%'";
					
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				String lastname = rs.getString(2);
				String firstName = rs.getString(2);
				String email = rs.getString(40);
				String hireDate = rs.getString(20);
				String phoneNo = rs.getString(13);
				
				System.out.println(
						lastname + " " + firstName + "," + email + "," + phoneNo + "," + hireDate);
			}
		
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e );
		} catch (SQLException e) {
			System.out.println("error:" + e );
		} finally {
			try {
			// 3. 자원정리	
				if(rs != null){
					rs.close();
				}
				if(stmt != null){
					stmt.close();
				}
				if( conn != null){
				conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
			
		}
	}

}
