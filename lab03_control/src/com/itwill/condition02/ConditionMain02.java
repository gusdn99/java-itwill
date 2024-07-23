package com.itwill.condition02;

import java.util.Scanner; // import 문장 - 패키지 선언문과 클래스 선언문 사이

public class ConditionMain02 {

	public static void main(String[] args) {
		// 콘솔 창에서 정수 1개를 입력받고, int 타입 변수에 저장
		
		// 만약 입력받은 정수가 0보다 크면 "positive"라고 출력. if
		// 0이면, "zero"라고 출력. else if
		// 그렇지 않으면, "negative"라고 출력 else
		
		Scanner scanner = new Scanner(System.in); // 입력 도구를 만들어서 변수에 저장.
		
		System.out.println("정수를 입력하세요");
		int num = scanner.nextInt(); // 콘솔에서 입력받은 정수를 변수에 저장
		
		
		if (num > 0) {
			System.out.println("positive");
			
		} else if (num == 0) {
			System.out.println("zero");
			
		} else {
			System.out.println("negative");
		}
			
	}

}
