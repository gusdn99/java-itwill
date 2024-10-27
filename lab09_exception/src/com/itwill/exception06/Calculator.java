package com.itwill.exception06;

public class Calculator {

	public int divide(int x, int y) throws Exception { // thorws Exception 선언문으로 던짐. throws(선언문에 s 붙음)
		if (y != 0) {
			return x / y;
		}
		
		throw new Exception("y는 0이 될 수 없음."); // throw(s 안 붙음)
		
	}
}
