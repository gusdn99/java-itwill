package com.itwill.inheritance04;

/*
 * final: 변경할 수 없는.
 * final 지역변수: 값을 초기화한 이후에 그 값을 변경할 수 없는(재할당할 수 없는) 지역 변수.
 * final 필드: 반드시 한 번은 명시적으로 초기화해야 하고, 이후에는 값을 변경할 수 없는 필드.
 * 	(1) final 필드를 선언과 동시에 초기화
 * 	(2) final 필드를 초기화할 수 있는 아규먼트를 갖는 생성자를 작성.
 * final 메서드: 변경할 수 없는 메서드. 재정의(override)할 수 없는 메서드.
 * final 클래스: 변경할 수 없는 클래스. 상속받을 수 없는 클래스.
 * 	(예) java.lang.System, java.lang.String, ...
 */

//class MySting extends String {} 오류 뜸. // final 클래스를 상속하는 새로운 클래스는 선언할 수 없음.

class C{}
class E extends C {}

final class D {} // final 클래스
//class F extends D {}

class A {
	public void test1() {
		System.out.println("test1");
	}
	
	public final void test2() { // final 메서드
		System.out.println("test2");
	}
}

class B extends A {
	@Override // 상위 클래스의 final이 아닌 메서드는 override할 수 있음.
	public void test1() {
		System.out.println("B test1");
	}
	
	// 상위 클래스에서 final로 선언된 메서드는 하위 클래스에서 override할 수 없음.
//	@Override
//	public void test2() { final 메서드라서 하위 클래스에서 오버라이드할 수 없음.
//		System.out.println("B test2");
//	}
}

public class InheritanceMain04 {

	public static void main(String[] args) { // 파라미터에 final 쓸 수 있음. (예) (final String[] args)

	}

}
