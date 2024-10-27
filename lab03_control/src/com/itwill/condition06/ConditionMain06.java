package com.itwill.condition06;

public class ConditionMain06 {

	public static void main(String[] args) {
		// 삼항 연산자 연습
		
		// 1. number 변수가 짝수인지, 홀수인지를 저장하는 변수 evenOrodd:
		int number = 213;
		String evenOrOdd = (number % 2 == 0) ? "짝수" : "홀수";
		// String evenOrOdd = (number % 2 != 1) ? "짝수" : "홀수";
		// String evenOrOdd = (number % 2 == 1) ? "홀수" : "짝수";
		// String evenOrOdd = (number % 2 != 0) ? "홀수" : "짝수";
		System.out.println(evenOrOdd);

		// 2. genderCode 변수의 값이 1 또는 3이면, "남성", 그렇지 않으면 "여성"
		int genderCode = 4;
		String gender = (genderCode == 1) || (genderCode == 3) ? "남성" : "여성";
		System.out.println(gender);
		
	}

}
