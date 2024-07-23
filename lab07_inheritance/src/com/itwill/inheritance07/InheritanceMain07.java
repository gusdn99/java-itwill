package com.itwill.inheritance07;

/*
 * 추상 메서드(abstract method):
 * - 메서드의 signature(수식어, 리턴 타입, 메서드 이름, 파라미터 선언)만 선언되어 있고,
 * 메서드의 body(몸통)가 구현되어 있지 않은 메서드. // 중괄호{}가 없음. // 메서드 호출할 수 없음.(body가 있어야 메서드 호출 가능)
 * - 추상 메서드는 반드시 "abstract" 키워드로 수식해야 함.
 * - 추상 메서드 선언은 반드시 세미콜론(;)으로 끝내야 함. // body(중괄호{})가 없으니깐.
 * 
 *  추상 클래스(abstract class):
 *  - "abstract" 수식어가 사용된 클래스.
 *  - 대부분의 경우 추상 클래스는 추상 메서드를 가지고 있는 경우가 많음.
 *  - 클래스가 추상 메서드를 가지고 있는 경우에는 반드시 abstract로 선언해야 함.
 *  - 추상 클래스는 객체를 생성할 수 없음. // new 할 수 없음 // body가 없어서
 *  - 추상 클래스를 상속하는 클래스를 선언하고 모든 추상 메서드를 override한 이후에 객체를 생성할 수 있음.
 *  	body가 없는 추상 메서드는 상속받는 클래스의 메서드에서 body를 만들어 오버라이드해야 함.
 */

//abstract class X{
//	public void test() { // 추상 클래스 안에 꼭 추상 메서드가 있어야 하는 건 아님.
//		System.out.println();
//	}
//}

abstract class Animal {
	public abstract void move(); // 추상 메서드 // body(중괄호{}) 없음. // 메소드 호출 불가
}

class Dog extends Animal {
	@Override
	public void move() { // 오버라이드해서 body가(중괄호{}) 있음. 
		System.out.println("강아지 총총총...");
	}
}

class Fish extends Animal {
	@Override
	public void move() {
		System.out.println("물고기는 스윔스윔...");
	}
}

class Bird extends Animal {
	@Override
	public void move() {
		System.out.println("새는 훨훨~~~");	
	}
}


public class InheritanceMain07 {

	public static void main(String[] args) {
//		Animal animal = new Animal(); 오류 뜸. 추상 클래스라서 객체 생성할 수 없음.
		
		Animal[] animals = {new Dog(), new Fish(), new Bird()}; // 다형성
		
		for (Animal a : animals) {
			a.move();
		}
		// 다형성으로 선언되어 있더라도, 오버라이드된 메서드가 호출됨.
		
	}

}
