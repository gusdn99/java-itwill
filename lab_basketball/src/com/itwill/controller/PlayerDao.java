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

// MVC 아키텍쳐에서 Controller를 담당하는 클래스. DAO(Data Access Object)
//CRUD(Create, Read, Update, Delete) 기능 담당: insert, select, update, delete SQL
public class PlayerDao {
	// -----> singleton
	private static PlayerDao instance = null;

	private PlayerDao() {
		try {
			// Oracle 드라이버(라이브러리)를 등록.
			DriverManager.registerDriver(new OracleDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static PlayerDao getInstance() {
		if (instance == null) {
			instance = new PlayerDao();
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

	// ResultSet에서 각 컬럼의 값들을 읽어서 Player 타입 객체를 생성하고 리턴.
	private Player makePlayerFromResultSet(ResultSet rs) throws SQLException {
		int id = rs.getInt(COL_ID);
		String name = rs.getString(COL_NAME);
		int height = rs.getInt(COL_HEIGHT);
		int weight = rs.getInt(COL_WEIGHT);
		int uniform_number = rs.getInt(COL_UNIFORM_NUMBER);
		int points = rs.getInt(COL_POINTS);
		String position = rs.getString(COL_POSITION);
		String p_team_code = rs.getString(COL_P_TEAM_CODE);

		Player player = new Player(id, name, height, weight, uniform_number, points, position, p_team_code);

		return player;
	}

	// readByIdDesc() 메서드에서 사용할 SQL 문장. select * from order by id desc
	private static final String SQL_SELECT_ALL_ID_DESC = String.format("select * from %s order by %s desc", TBL_PLAYERS,
			COL_ID);

	/**
	 * 데이터베이스 테이블 PLAYERS 테이블에서 모든 레코드(행)를 검색해서 ID(고유키)의 내림차순으로 정렬된 리스트를 반환. 테이블에 행이
	 * 없는 경우 빈 리스트를 리턴.
	 * 
	 * @return Player를 원소로 갖는 ArrayList.
	 */
	public List<Player> readByIdDesc() {
		List<Player> players = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// 데이터베이스에 접속
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			// 실행할 SQL 문장을 갖고 있는 PreparedStatement 객체를 생성.
			stmt = conn.prepareStatement(SQL_SELECT_ALL_ID_DESC);
			// SQL 문장을 데이터베이스로 전송해서 실행.
			rs = stmt.executeQuery();
			// 결과 처리.
			while (rs.next()) {
				Player player = makePlayerFromResultSet(rs);
				players.add(player);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}

		return players;
	}

	// readByPointsDesc() 메서드에서 사용할 SQL 문장. select * from order by points desc
	private static final String SQL_SELECT_ALL_POINTS_DESC = String.format("select * from %s order by %s desc",
			TBL_PLAYERS, COL_POINTS);

	/**
	 * 데이터베이스 테이블 PLAYERS 테이블에서 모든 레코드(행)를 검색해서 POINTS의 내림차순으로 정렬된 리스트를 반환. 테이블에 행이
	 * 없는 경우 빈 리스트를 리턴.
	 * 
	 * @return Player를 원소로 갖는 ArrayList.
	 */
	public List<Player> readByPointsDesc() {
		List<Player> players = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// 데이터베이스에 접속
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			// 실행할 SQL 문장을 갖고 있는 PreparedStatement 객체를 생성.
			stmt = conn.prepareStatement(SQL_SELECT_ALL_POINTS_DESC);
			// SQL 문장을 데이터베이스로 전송해서 실행.
			rs = stmt.executeQuery();
			// 결과 처리.
			while (rs.next()) {
				Player player = makePlayerFromResultSet(rs);
				players.add(player);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}

		return players;
	}

	// 팀 아이디(PK)로 검색하기:
	// select * from players where id = ?;
	private static final String SQL_SELECT_BY_ID = String.format("select * from %s where %s = ?", TBL_PLAYERS, COL_ID);

	/**
	 * PLAYERS 테이블의 고유키 id를 전달받아서, 해당 Player 객체를 리턴.
	 * 
	 * @param id 검색하기 위한 고유키.
	 * @return 테이블에서 검색한 Player 객체. 고유키에 해당하는 행이 없는 경우 null을 리턴.
	 */
	public Player read_By_ID(int id) {
		Player player = null;

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				player = makePlayerFromResultSet(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}

		return player;
	}

	private static final String SQL_SELECT_BY_POSITIONCOMBOBOX = String
			.format("select * from %s where %s = ? order by %s desc", TBL_PLAYERS, COL_POSITION, COL_ID);

	/**
	 * 콤보박스에 있는 포지션 이름으로 검색하기. 검색 타입과 검색어를 전달받아서, 해당 SQL 문장을 실행하고 그 결과를 리턴.
	 * 
	 * @param position 텍스트 문자열
	 * @return 검색 결과 리스트. 검색 결과가 없으면 빈 리스트.
	 */
	public List<Player> searchByPosition(String position) {
		List<Player> players = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_SELECT_BY_POSITIONCOMBOBOX);
			stmt.setString(1, position);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Player player = makePlayerFromResultSet(rs);
				players.add(player);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}

		return players;

	}

	private static final String SQL_SELECT_BY_TEAMCOMBOBOX = String
			.format("select * from %s where %s = ? order by %s desc", TBL_PLAYERS, COL_P_TEAM_CODE, COL_ID);

	/**
	 * 콤보박스에 있는 팀 코드로 검색하기. 검색 타입과 검색어를 전달받아서, 해당 SQL 문장을 실행하고 그 결과를 리턴.
	 * 
	 * @param team 텍스트 문자열
	 * @return 검색 결과 리스트. 검색 결과가 없으면 빈 리스트.
	 */
	public List<Player> searchByTeam(String team) {
		List<Player> players = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_SELECT_BY_TEAMCOMBOBOX);
			stmt.setString(1, team);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Player player = makePlayerFromResultSet(rs);
				players.add(player);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}

		return players;

	}

	private static final String SQL_Duplicate_Team_UniformNUmber = String.format(
			"select count(*) from %s where %s = ? and %s = ?", TBL_PLAYERS, COL_P_TEAM_CODE, COL_UNIFORM_NUMBER);

	public boolean isDuplicateTeamUniformNumber(String team_code, int uniform_number) {
		// 데이터베이스 쿼리를 사용하여 등번호 중복 여부 확인

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_Duplicate_Team_UniformNUmber);
			stmt.setString(1, team_code);
			stmt.setInt(2, uniform_number);
			rs = stmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				return count > 0; // 등번호가 이미 존재하면 true 반환
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}

		return false; // 등번호가 존재하지 않으면 false 반환

	}

	private static final String SQL_INSERT = String.format(
			"insert into %s (%s, %s, %s, %s, %s, %s, %s) values (?, ?, ?, ?, ?, ?, ?)", TBL_PLAYERS, COL_NAME,
			COL_HEIGHT, COL_WEIGHT, COL_UNIFORM_NUMBER, COL_POINTS, COL_POSITION, COL_P_TEAM_CODE);

	/**
	 * 데이터베이스의 PLAYERS 테이블에 행을 삽입.
	 * 
	 * @param player 테이블에 삽입할 이름, 키, 몸무게, 득점, 포지션, 팀 코드 정보를 가지고 있는 객체
	 * @return 테이블에 삽입된 행의 개수.
	 */
	public int create(Player player) {
		int result = 0;

		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD); // DB 접속
			stmt = conn.prepareStatement(SQL_INSERT); // Statement 객체 생성.

			stmt.setString(1, player.getName()); // Statement의 첫 번째 ? 채움.
			stmt.setInt(2, player.getHeight()); // Statement의 두 번째 ? 채움.
			stmt.setInt(3, player.getWeight()); // Statement의 세 번째 ? 채움.
			stmt.setInt(4, player.getUniform_number()); // Statement의 네 번째 ? 채움.
			stmt.setInt(5, player.getPoints()); // Statement의 다섯 번째 ? 채움.
			stmt.setString(6, player.getPosition()); // Statement의 여섯 번째 ? 채움.
			stmt.setString(7, player.getP_team_code()); // Statement의 일곱 번째 ? 채움.

			result = stmt.executeUpdate(); // SQL 실행.
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt);
		}

		return result;
	}

//  update(Player player) 메서드에서 사용할 SQL:
//  update players set name = ?, weight = ?, uniformNumber = ?, score = ?, position = ?, team_name = ? where id = ?
	private static final String SQL_UPDATE = String.format(
			"update %s set %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ? where %s = ?", TBL_PLAYERS, COL_NAME,
			COL_WEIGHT, COL_UNIFORM_NUMBER, COL_POINTS, COL_POSITION, COL_P_TEAM_CODE, COL_ID);

	/**
	 * PLAYERS 테이블 업데이트.
	 * 
	 * @param player 업데이트할 이름, 몸무게, 등 번호, 득점, 포지션, 팀을 가지고 있는 객체.
	 * @return 업데이트한 행의 개수.
	 */
	public int update(Player player) {

		int result = 0;

		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, player.getName());
			stmt.setInt(2, player.getWeight());
			stmt.setInt(3, player.getUniform_number());
			stmt.setInt(4, player.getPoints());
			stmt.setString(5, player.getPosition());
			stmt.setString(6, player.getP_team_code());
			stmt.setInt(7, player.getId());
			result = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt);
		}

		return result;
	}

	// delete(int id) 메서드에서 사용할 SQL: delete from players where id = ?
	private static final String SQL_DELETE = String.format("delete from %s where %s = ?", TBL_PLAYERS, COL_ID);

	/**
	 * 테이블 PLAYERS에서 고유키(PK) id에 해당하는 레코드(행)를 삭제.
	 * 
	 * @param id 삭제하려는 레코드의 고유키.
	 * @return 테이블에서 삭제된 행의 개수.
	 */
	public int delete(int id) {
		int result = 0;

		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, id);
			result = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt);
		}

		return result;
	}

}
