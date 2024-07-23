package com.itwill.class04;

public class ClassMain04 {

	public static void main(String[] args) {
		// 기본생성자를 사용해서 Rectangle 객체  생성, 메서드 호출
		Rectangle rec1 = new Rectangle();
		System.out.println("rec1: " + rec1);
		System.out.println("rec1 width = " + rec1.width);
		System.out.println("rec1 height = " + rec1.height);
		
		rec1.width = 13.0;
		rec1.height = 24.0;
		
		System.out.println("rec1 area = " + rec1.area());
		System.out.println("rec1 perimeter = " + rec1.perimeter());
		
		// 아규먼트를 갖는 생성자를 사용:
		Rectangle rec2 = new Rectangle(20.2, 17.7);
		System.out.println("rec2: " + rec2);
		System.out.println("rec2 area = " + rec2.area());
		System.out.println("rec2 perimeter = " + rec2.perimeter());
		
		rec2 = new Rectangle(4, 3);
		System.out.println("rec2 = " + rec2);
		
	}
	
}
