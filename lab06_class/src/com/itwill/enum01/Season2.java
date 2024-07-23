package com.itwill.enum01;

public class Season2 { // enum 타입인 Season3와 비교
	
	public static final Season2 SPRING = new Season2("봄"); // SPRING은 객체의 참조값을 저장하는 변수 // ("봄")은 상수
	public static final Season2 SUMMER = new Season2("여름");
	public static final Season2 FALL = new Season2("가을");
	public static final Season2 WINTER = new Season2("겨울");
	// static이라서 메서드 영역에 4바이트 크기의 주소값을 저장
	
	private String name;

	private Season2(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
}
