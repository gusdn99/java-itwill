package com.itwill.singleton;

public enum Singleton { // enum 타입
	INSTANCE; // public static final Singleton INSTANCE = new Singleton(); // 변수를 1개 선언해서 싱글턴임.
	
	private String name;
	
	// enum 타입의 생성자는 private만 가능. private 수식어는 생략 가능.
	Singleton() {
		this.name = "헐크";
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
