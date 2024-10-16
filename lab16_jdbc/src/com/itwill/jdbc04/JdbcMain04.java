package com.itwill.jdbc04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

import static com.itwill.jdbc.OracleJdbc.*;

public class JdbcMain04 {

	public static void main(String[] args) throws SQLException {
		// delete 문장 실행 & 결과 처리
		
		// 오라클 드라이버를 등록
		DriverManager.registerDriver(new OracleDriver());
		
		// 오라클 DB 접속
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		
		// Statement 객체 생성
//		final String sql = String.format("delete from %s where %s = ?", TBL_BLOGS, COL_ID);
		final String sql = "delete from blogs where id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		// PreparedStatement에서 ? 부분을 삭제.
		stmt.setInt(1, 1);
		
		// SQL 문장을 실행 & 결과 처리
		int result = stmt.executeUpdate();
		System.out.println(result + "개 행이 삭제됨.");
		
		// 사용했던 DB 리소스 해제
		stmt.close();
		conn.close();

	}

}
