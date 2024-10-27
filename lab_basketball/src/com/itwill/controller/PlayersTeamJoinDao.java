package com.itwill.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.itwill.model.Player;

import oracle.jdbc.OracleDriver;

import static com.itwill.jdbc.OracleJdbc.*;
import static com.itwill.model.Player.Entity.*;
import static com.itwill.model.Team.Entity.*;

// MVC 아키텍쳐에서 Controller를 담당하는 클래스. DAO(Data Access Object)
//CRUD(Create, Read, Update, Delete) 기능 담당: insert, select, update, delete SQL
public class PlayersTeamJoinDao {
	// -----> singleton
	private static PlayersTeamJoinDao instance = null;

	private PlayersTeamJoinDao() {
		try {
			// Oracle 드라이버(라이브러리)를 등록.
			DriverManager.registerDriver(new OracleDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static PlayersTeamJoinDao getInstance() {
		if (instance == null) {
			instance = new PlayersTeamJoinDao();
		}

		return instance;
	}
	// <----- singleton

	/**
	 * CRUD 메서드들에서 사용했던 리소스들을 해제.
	 * 
	 * @param conn Connection 객체
	 * @param stmt Statement 객체
	 * @param rs   ResultSet 객체
	 */
	public void closeResources(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * CRUD 메서드들에서 사용했던 리소스들을 해제.
	 * 
	 * @param conn Connection 객체
	 * @param stmt Statement 객체
	 */
	public void closeResources(Connection conn, Statement stmt) {
		closeResources(conn, stmt, null);
	}

//	public String findTeam_Name(String team_code) {
//		String result = null;
//		String sql = String.format("select %s from %s where %s = ?", COL_TEAM_NAME, TBL_TEAM, COL_P_TEAM_CODE);
//
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//		try {
//			// 데이터베이스에 접속
//			conn = DriverManager.getConnection(URL, USER, PASSWORD);
//			// 실행할 SQL 문장을 갖고 있는 PreparedStatement 객체를 생성.
//			stmt = conn.prepareStatement(sql);
//			// SQL 문장을 데이터베이스로 전송해서 실행.
//			rs = stmt.executeQuery();
//			// 결과 처리.
//			if (rs.next()) {
//				result = rs.getString(COL_TEAM_NAME);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			closeResources(conn, stmt, rs);
//		}
//
//		return result;
//	}

	// readPlayersRank() 메서드에서 사용할 SQL 문장.
	// select p.id, p.name, t.team_name, p.points, rank() over (order by p.points
	// desc)
	// from players p
	// join team t on p.team_code = t.team_code
	// 선수별 득점 순위
	private static final String SQL_SELECT_PLAYERS_RANK = String.format(
			"select p.%s, p.%s, t.%s, p.%s, rank() over (order by p.%s desc) as ranking " + "from %s p "
					+ "join %s t on p.%s = t.%s",
			COL_ID, COL_NAME, COL_TEAM_NAME, COL_POINTS, COL_POINTS, TBL_PLAYERS, TBL_TEAM, COL_P_TEAM_CODE,
			COL_T_TEAM_CODE);

	/**
	 * 데이터베이스 테이블 PLAYERS 테이블과 TEAM 테이블에서 아이디, 이름, 팀 이름, 득점, 득점 순위 레코드(행)를 검색해서
	 * POINTS의 내림차순으로 정렬된 리스트를 반환. 테이블에 행이 없는 경우 빈 리스트를 리턴.
	 * 
	 * @return Player를 원소로 갖는 ArrayList.
	 */
	public List<Player> readPlayersRank() {
		List<Player> players = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// 데이터베이스에 접속
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			// 실행할 SQL 문장을 갖고 있는 PreparedStatement 객체를 생성.
			stmt = conn.prepareStatement(SQL_SELECT_PLAYERS_RANK);
			// SQL 문장을 데이터베이스로 전송해서 실행.
			rs = stmt.executeQuery();
			// 결과 처리.
			while (rs.next()) {
				int id = rs.getInt(COL_ID);
				String name = rs.getString(COL_NAME);
				String teamName = rs.getString(COL_TEAM_NAME);
				int points = rs.getInt(COL_POINTS);
				int playersRank = rs.getInt("ranking");
				Player player = new Player(id, name, teamName, points, playersRank);
				players.add(player);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}

		return players;
	}

	// readTeamRank() 메서드에서 사용할 SQL 문장.
	// select p.team_code, t.team_name, sum(p.points) as team_points, rank() over
	// (order by sum(p.points) desc) as ranking, t.coach
	// from players p
	// join team t on p.team_code = t.team_code
	// group by p.team_code, t.team_name;
	// 팀별 득점 순위
	private static final String SQL_SELECT_TEAM_RANK = String.format(
			"select p.%s, t.%s, sum(p.%s) as team_points, rank() over (order by sum(p.%s) desc) as ranking, t.%s "
					+ "from %s p " + "join %s t on p.%s = t.%s " + "group by p.%s, t.%s, t.%s",
			COL_P_TEAM_CODE, COL_TEAM_NAME, COL_POINTS, COL_POINTS, COL_COACH, TBL_PLAYERS, TBL_TEAM, COL_P_TEAM_CODE,
			COL_T_TEAM_CODE, COL_P_TEAM_CODE, COL_TEAM_NAME, COL_COACH);

	/**
	 * 데이터베이스 테이블 PLAYERS 테이블과 TEAM 테이블에서 팀 코드별 팀 코드, 팀 이름, 팀 득점 합계, 팀 순위 레코드(행)를
	 * 검색해서 POINTS의 내림차순으로 정렬된 리스트를 반환. 테이블에 행이 없는 경우 빈 리스트를 리턴.
	 * 
	 * @return Player를 원소로 갖는 ArrayList.
	 */
	public List<Player> readTeamRank() {
		List<Player> players = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// 데이터베이스에 접속
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			// 실행할 SQL 문장을 갖고 있는 PreparedStatement 객체를 생성.
			stmt = conn.prepareStatement(SQL_SELECT_TEAM_RANK);
			// SQL 문장을 데이터베이스로 전송해서 실행.
			rs = stmt.executeQuery();
			// 결과 처리.
			while (rs.next()) {
				String p_team_code = rs.getString(COL_P_TEAM_CODE);
				String teamName = rs.getString(COL_TEAM_NAME);
				int pointsSum = rs.getInt("team_points");
				int teamRank = rs.getInt("ranking");
				String coach = rs.getString(COL_COACH);
				players.add(new Player(p_team_code, teamName, pointsSum, teamRank, coach));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}

		return players;
	}

	// 팀 코드(team_code)로 검색하기
	// select p.team_code, t.team_name, p.name, p.uniform_number, p.points,
	// p.position
	// from players p
	// join team t on p.team_code = t.team_code
	// where p.team_code = '? order by points desc;
	private static final String SQL_SELECT_BY_TEAM_CODE = String.format(
			"select p.%s, t.%s, p.%s, p.%s, p.%s, p.%s " + "from %s p " + "join %s t on p.%s = t.%s "
					+ "where p.%s = ? order by %s desc",
			COL_P_TEAM_CODE, COL_TEAM_NAME, COL_NAME, COL_UNIFORM_NUMBER, COL_POINTS, COL_POSITION, TBL_PLAYERS,
			TBL_TEAM, COL_P_TEAM_CODE, COL_T_TEAM_CODE, COL_P_TEAM_CODE, COL_POINTS);

	/**
	 * 콤보박스에 있는 팀 코드로 검색하기. 검색 타입과 검색어를 전달받아서, 해당 SQL 문장을 실행하고 그 결과를 리턴.
	 * 
	 * @param teamIndex 콤보박스 인덱스
	 * @param team_code 텍스트 문자열
	 * @return 검색 결과 리스트. 검색 결과가 없으면 빈 리스트.
	 */
	public List<Player> read_By_Team_Code(int teamIndex, String team_code) {
		List<Player> players = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_SELECT_BY_TEAM_CODE);
			stmt.setString(1, team_code);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String p_team_code = rs.getString(COL_P_TEAM_CODE);
				String teamName = rs.getString(COL_TEAM_NAME);
				String name = rs.getString(COL_NAME);
				int uniform_number = rs.getInt(COL_UNIFORM_NUMBER);
				int points = rs.getInt(COL_POINTS);
				String position = rs.getString(COL_POSITION);

				players.add(new Player(p_team_code, teamName, name, uniform_number, points, position));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}

		return players;

	}

}
