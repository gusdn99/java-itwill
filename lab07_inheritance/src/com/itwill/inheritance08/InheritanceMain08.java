package com.itwill.inheritance08;

public class InheritanceMain08 {

	public static void main(String[] args) {
		// Rectangle 타입의 객체 생성
//		Shape rect = new Rectangle(4.0, 3.0); 다형성
		Rectangle rect = new Rectangle(4.0, 3.0);
		rect.draw();

		// Circle 타입의 객체 생성
//		Shape circle = new Circle(5.0); 다형성
		Circle circle = new Circle(5.0);
		circle.draw();

	}

}
