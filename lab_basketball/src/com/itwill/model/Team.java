package com.itwill.model;

public class Team {
	public static final class Entity {
		// 데이터베이스 테이블 이름을 상수로 선언.
		public static final String TBL_TEAM = "TEAM";

		// 데이터베이스 TEAM 테이블의 컬럼 이름들을 상수로 선언.
		public static final String COL_TEAM_ID = "TEAM_ID";
		public static final String COL_T_TEAM_CODE = "TEAM_CODE";
		public static final String COL_TEAM_NAME = "TEAM_NAME";
		public static final String COL_COACH = "COACH";
	}

	private int team_id; // 팀 아이디
	private String t_team_code; // 팀 코드
	private String team_name; // 팀 이름
	private String coach; // 감독

	public Team() {}

	public Team(int team_id, String t_team_code, String team_name, String coach) {
		this.team_id = team_id;
		this.t_team_code = t_team_code;
		this.team_name = team_name;
		this.coach = coach;
	}

	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}

	public String getT_team_code() {
		return t_team_code;
	}

	public void setT_team_code(String t_team_code) {
		this.t_team_code = t_team_code;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	@Override
	public String toString() {
		return "Team [team_id=" + team_id + ", t_team_code=" + t_team_code + ", team_name=" + team_name + ", coach="
				+ coach + "]";
	}


}
