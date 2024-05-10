package com.itwill.oracle;

import com.itwill.database.Database;

public class OracleDatabase implements Database { // "implements" 키워드 (인터페이스 구현)
	
	@Override
	public int select() { // 추상 메서드가 public이라서 public을 적어야 함.(생략 불가)
		System.out.println("Oracle 테이블 검색");
		return 0;
	}
	
	@Override
	public int insert() {
		System.out.println("Oracle 테이블 데이터 추가");
		return 0;
	}

}
