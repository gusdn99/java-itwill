package com.itwill.model;

public class Player {
	public static final class Entity {
		// 데이터베이스 테이블 이름을 상수로 선언.
		public static final String TBL_PLAYERS = "PLAYERS";

		// 데이터베이스 PLAYERS 테이블의 컬럼 이름들을 상수로 선언.
		public static final String COL_ID = "ID";
		public static final String COL_NAME = "NAME";
		public static final String COL_HEIGHT = "HEIGHT";
		public static final String COL_WEIGHT = "WEIGHT";
		public static final String COL_UNIFORM_NUMBER = "UNIFORM_NUMBER";
		public static final String COL_POINTS = "POINTS";
		public static final String COL_POSITION = "POSITION";
		public static final String COL_P_TEAM_CODE = "TEAM_CODE";
	}

	private int id; // 고유키
	private String name; // 이름 (최대 20글자)
	private int height; // 키(cm) (0이상의 3자리 정수)
	private int weight; // 몸무게(kg) (0이상의 3자리 정수)
	private int uniform_number; // 등번호 (0이상의 2자리 정수)
	private int points; // 득점 (0이상의 2자리 정수)
	private String position; // 포지션
	private String p_team_code; // 팀 코드
	private int playersRank; // 선수별 순위
	private String team_name; // 팀 이름
	private int pointsSum; // 팀별 득점 합계
	private int teamRank; // 팀별 순위
	private String coach; // 감독

	public Player() {
	}

	// 선수별 득점 순위
	public Player(int id, String name, String team_name, int points, int playersRank) {
		this.id = id;
		this.name = name;
		this.team_name = team_name;
		this.points = points;
		this.playersRank = playersRank;
	}

	// 팀별 검색 정보
	public Player(String p_team_code, String team_name, String name, int uniform_number, int points, String position) {
		this.p_team_code = p_team_code;
		this.team_name = team_name;
		this.name = name;
		this.uniform_number = uniform_number;
		this.points = points;
		this.position = position;
	}

	// 팀별 득점 순위
	public Player(String p_team_code, String team_name, int pointsSum, int teamRank, String coach) {
		this.p_team_code = p_team_code;
		this.team_name = team_name;
		this.pointsSum = pointsSum;
		this.teamRank = teamRank;
		this.coach = coach;
	}

	// 선수 등록
	public Player(int id, String name, int height, int weight, int uniform_number, int points, String position,
			String p_team_code) {
		this.id = id;
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.uniform_number = uniform_number;
		this.points = points;
		this.position = position;
		this.p_team_code = p_team_code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getUniform_number() {
		return uniform_number;
	}

	public void setUniform_number(int uniform_number) {
		this.uniform_number = uniform_number;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getP_team_code() {
		return p_team_code;
	}

	public void setP_team_code(String p_team_code) {
		this.p_team_code = p_team_code;
	}

	public int getPlayersRank() {
		return playersRank;
	}

	public void setPlayersRank(int playersRank) {
		this.playersRank = playersRank;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public int getPointsSum() {
		return pointsSum;
	}

	public void setPointsSum(int pointsSum) {
		this.pointsSum = pointsSum;
	}

	public int getTeamRank() {
		return teamRank;
	}

	public void setTeamRank(int teamRank) {
		this.teamRank = teamRank;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", height=" + height + ", weight=" + weight + ", uniform_number="
				+ uniform_number + ", points=" + points + ", position=" + position + ", p_team_code=" + p_team_code
				+ "]";
	}

}
