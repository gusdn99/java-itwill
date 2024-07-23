package com.itwill.inheritance01;

// 스마트TV은 기본TV를 확장(상속)함.
// 상위(super), 부모(parent), 기본(base) 클래스 - BasicTv
// 하위(sub), 자식(child), 유도(derived) 클래스 - SmartTv
// 모든 클래스의 최상위 클래스는 java.lang.Object 클래스.
// 상위클래스가 java.lang.Object인 경우 extends Object는 생략 가능.

public class SmartTv extends BasicTv { // 하위클래스가 확장한다 상위클래스를

	private String ip;
	
	public void webBrowsing() {
		System.out.println("인터넷 연결");
	}
	
	public void checkChannel() {
//		System.out.println(channel); 채널 필드는 private이라 접근 불가
		System.out.println(getChannel()); // 요건 public이라 가능. private 필드에 접근하는 방법임.
		
	}
}