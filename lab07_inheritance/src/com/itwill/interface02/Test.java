package com.itwill.interface02;

/*
 * 인터페이스가 가질 수 있는 멤버들 - Java 8 버전 이후 변경 사항
 * 1. [public static final] 필드 // 대괄호[] 부분은 생략 가능한 수식어
 * 2. [public abstract] 메서드
 * 3. [public] static 메서드 - Java 8 버전부터
 * 		- > 객체 생성 없이, 인터페이스 이름을 접두사로 써서 호출할 수 있는 메서드.
 * 		- > body가 구현된 메서드. 중괄호{} 사용.
 * 4. [public] default 메서드 - Java 8 버전부터
 * 		- > body가 구현된 메서드. 중괄호{} 사용.
 * 		- > 인터페이스를 구현한 하위 타입의 객체를 생성한 후에 호출할 수 있는 메서드.
 * 5. private static 메서드 - Java 9 버전부터 // private 생략 불가
 * 		- > body가 구현된 메서드.
 * 		- > static 또는 dafault 메서드에서만 호출할 목적으로 만드는 메서드.
 * 6. private 메서드 - Java 9 버전부터
 * 		- > body가 구현된 메서드.
 * 		- > 오로지 dafault 메서드에서만 호출할 목적으로 만드는 메서드.
 */

public interface Test {
	// 1. [public static final] 필드
	int VERSION = 1;
	
	// 2. [public abstract] 메서드
	void test(); // body(중괄호{}) 없음. body가 없어서 메서드 호출 못함.
	
	// 3. [public] static 메서드
	static void staticMethod() { // body가 구현됨(중괄호{}). // 인터페이스 타입 이름으로 호출.
		System.out.println("공개 정적(public static) 메서드");
		privateStaticMethod(); // 이탤릭체(static 메서드라서)
//		defaultMethod(); (4번) static 메서드에 인스턴스 메서드는 안 뜸. 오류 뜸.
//		privateMethod(); (6번) static 메서드에 인스턴스 메서드는 안 뜸. 오류 뜸.
		System.out.println("-------------------------------");
	}
	
	// 4. [public] default 메서드
	default void defaultMethod() { // body가 구현됨(중괄호{}). // 객체 생성하고 생성된 객체 이름으로 호출.
		System.out.println("공개 기본(public default) 메서드");
		privateStaticMethod(); // (5번) 인스턴스 메서드에도 static 메서드 부를 수 있음.
		privateMethod(); // (6번) 인스턴스 메서드에 당연히 인스턴스 메서드 부를 수 있음.
	}
	
	// 5. private static 메서드
	private static void privateStaticMethod() { // private 생략 불가 // body가 구현됨(중괄호{}).
		System.out.println("비공개 정적 메서드 호출");
	}
	
	// 6. private default 메서드
	private void privateMethod() { // body가 구현됨(중괄호{}).
		System.out.println("비공개 구현된 메서드");
	}
	
}
