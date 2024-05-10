package com.itwill.singleton;

// 싱글턴(singleton): 힙에 오직 한 개만 존재하는 객체. // 주소를 한 개만 만들 수 있음.
// 싱글턴 디자인 패턴(singleton design pattern):
// 클래스를 설계할 때 객체를 오직 하나만 생성할 수 있도록 작성하는 디자인 패턴.
// (1) private static field
// (2) private constructor(생성자)
// (3) public static method

public class Captain {
	// (1)
	private static Captain instance = null; // 타입 이름은 자기 자신의 클래스 이름.
	
	private String name;
	
	// (2)
	private Captain() {
		this.name = "캡틴 아메리카";
	}
	
	// (3)
	public static Captain getInstance() {
		if (instance == null) { // 캡틴 타입의 인스턴스 변수에 주소값이 있나 없나 검사
			instance = new Captain(); // 주소값이 없으면 객체를 생성함. 주소값이 있으면 객체 생성하지 않음. 기존의 주소값 그대로 있음.
		}
		return instance; // 주소값 리턴
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
