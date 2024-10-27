package com.itwill.inheritance08;

public class Circle extends Shape {
	// field
	private double radius;
	
	public Circle (double radius) {
		super("원"); // 상위클래스의 아규먼트를 갖는 생성자를 안 만들면 오류 뜸.
		this.radius = radius;
	}
	
	@Override
	public double area() {
		return  radius * radius * Math.PI;
	}
	
	@Override
	public double perimeter() {
		return radius * 2 * Math.PI;
	}
	
}
