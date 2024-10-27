package com.itwill.variable04;

public class VariableMain04 {

	public static void main(String[] args) {
		// 문자(character) 타입 변수 char
		// char 타입: 문자 1개의 유니코드 값(2바이트 정수)을 저장하는 타입.
		// 문자(char)는 작은따옴표를 사용('a' 문자 1개), 문자열(string)은 큰따옴표를 사용("abc" 문자들로 이루어진 집합)
		
		char ch1 = 'B';
		System.out.println(ch1);
		System.out.println((int) ch1); // 타입 변환
		
		// char는 문자의 유니코드를 저장하는 특별한 종류의 정수 타입.
		// -> 사칙연산이 가능. 크기 비교도 가능.
		char ch2 = (char) (ch1 + 1); // (char)괄호 없으면 안 됨
		System.out.println(ch2);
		
		char ch3 = (char) (ch1 - 1);
		System.out.println(ch3);
		
		// 1. 변수는 같은 타입의 값만 저장할 수 O (예) int i = 1; i = 1.0;
		// 2. 큰 범위의 타입에는 작은 범위 타입의 값을 저장할 수 O (자동 캐스팅)
		// 3. 작은 범위의 타입에 큰 범위 값을 저장하려고 하면 에러가 발생.
		// 4. (3번의 예외)정수 리터럴(literal, 상수)은 범위를 넘지 않으면 byte, short, char에 저장 가능. (예) short s = 123;
		// 강제 타입 변환(casting): 변수의 타입을 강제로 바꿈. (예) char ch3 = (char) (ch1 - 1);
		double x = 1; // (2번 예)자동 타입 변환
		float y = 1.0F;
		
	}

}
