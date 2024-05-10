package com.itwill.condition07;

import java.util.Random;

public class ConditionMain07 {

	public static void main(String[] args) {
		// 조건문, 비교/논리 연산자 연습
		
		// 난수(random number)를 생성할 수 있는 타입의 변수를 선언, 초기화.
		Random rand = new Random(); // 괄호 안에 아무것도 안 적음
		
		// rand.nextInt(x): 0 이상 x보다 작은 정수 난수를 반환.
		// rand.nextInt(x, y): x 이상 y 미만의 정수 난수를 반환.
		int java = rand.nextInt(101); // 0이상, 101미만 정수.(0~100) rand.nextInt(1, 3); 1이상, 3미만
		System.out.println("Java 점수: " + java);
		
		int sql = rand.nextInt(101);
		System.out.println("SQL 점수: " + sql);
		
		int javascript = rand.nextInt(101);
		System.out.println("JavaScript: " + javascript);
		
		int sum = java + sql + javascript;
		System.out.println("총점 : " + sum);
		double ave = (double)sum / 3;
		System.out.println("평균 : " + ave);
		
		// 세 과목이 모두 40점 이상이고, 평균이 60점 이상이면 "합격",
		// 그렇지 않으면 "불합격"을 출력.
		
		if (java >= 40 && sql >= 40 && javascript >= 40 && ave >= 60) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
		// String result = (java >= 40 && sql >= 40 && javascript >= 40 && ave >= 60) ? "합격" : "불합격";
		// System.out.println(result);
		
		if (java >= 40 && sql >= 40 && javascript >= 40) {
			if (ave >= 60) {
				System.out.println("합격");
			} else {
				System.out.println("평균 과락");
			}
		} else {
			System.out.println("불합격");
		}
	}

}
