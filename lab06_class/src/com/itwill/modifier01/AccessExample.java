package com.itwill.modifier01;

public class AccessExample {
	// field
	private int a; // private
	int b; // package
	protected int c; // protected
	public int d; // public
	
	// constructor
	public AccessExample(int a, int b, int c, int d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	// method
	public void info() {
		System.out.printf("a = %d, b = %d, c = %d, d = %d\n", a, b, c, d);
	}

}
