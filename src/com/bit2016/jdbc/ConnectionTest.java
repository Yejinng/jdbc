package com.bit2016.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. Connection 얻어오기			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = 
					DriverManager.getConnection(url, "hr", "hr");
		
			System.out.println("연결성공");
		
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e );
		} catch (SQLException e) {
			System.out.println("error:" + e );
		} finally {
			try {
			// 3. 자원정리	
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
			
		}
	}

}
