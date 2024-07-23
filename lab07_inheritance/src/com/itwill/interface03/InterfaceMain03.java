package com.itwill.interface03;

class A {}
class B {}
class C extends A {} // 클래스 C는 클래스 A를 확장(상속).
// class D extends A, C {} // 다중 상속 - 자바는 클래스의 다중 상속을 허용하지 않음.

interface I {}
interface J {}
class E implements I {} // 클래스 E는 인터페이스 I를 구현.
class F implements I, J {} // 클래스가 구현하는 인터페이스의 개수는 제한이 없음.
class G extends B implements I {} // 클래스 G는 클래스 B를 확장하고, 인터페이스 I를 구현.

interface K extends I, J {} // 인터페이스 K는 인터페이스 I와 J를 확장. 인터페이스는 다중 상속이 가능. 인터페이스는 body가 없어서 구현할 수 없음.

//interface L extends A {} // 인터페이스는 클래스를 확장할 수 없음.

interface Clickable {
	void click(); // public abstract
}

interface Scrollable {
	void scroll();
}

class Mouse implements Clickable, Scrollable {

	@Override
	public void click() {
		System.out.println("마우스 클릭");
		
	}
	
	@Override
	public void scroll() {
		System.out.println("마우스 휠 스크롤");
		
	}

}

public class InterfaceMain03 {

	public static void main(String[] args) {
		Mouse m1 = new Mouse();
		m1.click();
		m1.scroll();
		
		Clickable m2 = new Mouse(); // 다형성
		m2.click();
		((Scrollable) m2).scroll(); // 캐스팅 // Clickable타입의 메서드만 보여서 Scrollable 타입으로 캐스팅해야 scroll 메서드가 보임.
		((Mouse) m2).scroll(); // 캐스팅 // Mouse 클래스는 하위클래스라서 click, scroll 메서드 둘 다 보임.
		
		Scrollable m3 = new Mouse(); // 다형성
		
	}

}
