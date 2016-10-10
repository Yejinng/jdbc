package com.bit2016.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. Connection 얻어오기			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = 
					DriverManager.getConnection(url, "bitdb", "bitdb");
			
			// 3. Statement 생성
			stmt = conn.createStatement();
			
			
			// 4.SQL실행
			Long no = 12L;
			String title = "토지10";
			String date = "2016-10-10";
			String state = "대여가능";
			Long authorNo = 1L;
			
			String sql =
					"insert into book values (" + no + ", '" + title + "', sysdate, '" + state + "', " + authorNo + ")";
			
			int count = stmt.executeUpdate(sql);
			System.out.println(count);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e );
		} catch (SQLException e) {
			System.out.println("error:" + e );
		} finally {
			try {
			// 3. 자원정리	
				if(stmt != null){
					stmt.close();
				}
				if(conn != null){
				conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
			
		}
	}

}
