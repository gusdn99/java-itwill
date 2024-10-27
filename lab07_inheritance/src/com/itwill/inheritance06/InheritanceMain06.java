package com.itwill.inheritance06;

public class InheritanceMain06 {

	public static void main(String[] args) {
		// 기본 생성자를 사용해서 Point  타입 객체 생성
		Point p1 = new Point();
		System.out.println(p1); // p1.toString(); 같은 결과
		
		// 아규먼트를 갖는 생성자를 사용해서 Point 타입 객체 생성
		Point p2 = new Point(0, 0);
		System.out.println(p2); // p2.toString();
			
		// 객체의 동등비교에서는 비교 연산자(==, !=)를 사용하면 안됨! 기본타입에서만 써야 함.
		System.out.println("비교 연산자 == 결과: " + (p1 == p2)); // 스택의 주소값 비교 // 비교 연산자
		System.out.println("eqauls() 메서드 결과: " + p1.equals(p2)); // 힙에 생성된 객체의 주소 비교 // equals 메서드
		
		System.out.println("p1 hashCode = " + p1.hashCode());
		System.out.println("p2 hashCode = " + p2.hashCode());
		
		// String 객체의 동등(equals) 비교
		String s1 = new String("hello");
		String s2 = new String("hello");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println("s1 == s2 결과: " + (s1 == s2));
		System.out.println("s1.equals(s2) 결과: " + s1.equals(s2)); // String 클래스에서는 (Object의 equals와 다르게) 문자끼리 비교
		
		
		User user1 = new User("itwill", "1234");
		User user2 = new User("itwill", "0000");
		User user3 = new User();
		
		System.out.println(user1);
		System.out.println(user2);
		System.out.println(user3);
		
		System.out.println("user1 == user2: " + (user1 == user2));
		System.out.println("user1.equals(user2): " + user1.equals(user2));
		System.out.println("user1.equals(user3): "+ user1.equals(user3));
		System.out.println("user3.equals(user1): " + user3.equals(user1));
		
		System.out.println("user1.hashCode(): " + user1.hashCode());
		System.out.println("user2.hashCode(): " + user2.hashCode());
		System.out.println("user3.hashCode(): " + user3.hashCode());
	
	}

}
