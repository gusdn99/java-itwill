package com.itwill.enum01; 

public enum Season3 { // 클래스 타입이 아니라 enum 타입임. (클래스 타입인 Season2와 비교)
	SPRING("봄"),  // name이라는 변수의 생성자를 호출하는 코드. SPRING은 선언된 변수. ("봄")은 상수
	SUMMER("여름"),
	FALL("가을"),
	WINTER("겨울");
	
//	SPRING(); 기본 생성자 // public static final Season3 SPRING = new Season3();랑 같은 의미
	
	private String name;
	private Season3() {} // 기본 생성자가 없으면 4~7번 줄이 에러 뜸
	
	// enum의 생성자의 접근 수식어는 private만 사용 가능. private은 생략 가능.
	Season3(String name) { // 앞에 private 생략
		this.name = name;
	}
	// enum 클래스의 생성자는 public으로 공개할 수 없음. 자신의 클래스 안에서만 생성자를 활용할 수 있게 하기 위해
	
	public String getName() {
		return this.name;
	}
	
//	private 필드에 접근하려면 public 메서드로 만들어진 getters and setters를 통해 접근해야 함

}
