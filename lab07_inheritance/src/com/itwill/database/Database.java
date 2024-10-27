package com.itwill.database;

public interface Database { // 인터페이스
	// field
	int DB_VERSION = 1; // public static final 필드 // 생략 가능
	
	/**
	 * 데이터베이스의 테이블에서 자료들을 검색하고 검색된 자료 개수를 리턴.
	 * @return 검색된 자료 개수.
	 */
	
	int select(); // 추상 메서드 (public abstract 생략 가능) // 생략되어 있으면 public임.
	
	/**
	 * 데이터베이스의 테이블에 자료를 추가하고, 성공이면 1, 실패면 0을 리턴.
	 * @return 성공이면 1, 실패면 0
	 */
	
	int insert();

}
