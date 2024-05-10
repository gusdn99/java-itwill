package com.itwill.condition03;

import java.util.Scanner;

public class ConditionMain03 {

	public static void main(String[] args) {
		// Scanner 타입의 변수를 선언, 초기화
		
		// 콘솔 창에서 Java 과목 점수(0 ~ 100 정수)를 입력받고 저장.
		
		// 콘솔 창에서 SQL 과목 점수(0 ~ 100 정수)를 입력받고 저장.
		
		// 콘솔 창에서 JavaScript 과목 점수(0 ~ 100 정수)를 입력받고 저장.
		
		// 세 과목의 총점(정수)을 계산하고 출력.
		
		// 세 과목의 평균(소수점까지 계산)을 계산하고 출력.
		
		// 세 과목 평균이 90점 이상이면, "A"
		// 세 과목 평균이 80점 이상이면, "B"
		// 세 과목 평균이 70점 이상이면, "C"
		// 세 과목 평균이 70점 미만이면, "F"라고 출력
		
		Scanner sc = new Scanner(System.in); // Scanner 변수는 한 번만!
		System.out.print("Java 점수 = ");
		int java = sc.nextInt();
		
		System.out.print("SQL 점수 = ");
		int sql = sc.nextInt();
		
		System.out.print("JavaScript 점수 = ");
		int js = sc.nextInt();
		
		int sum = java + sql + js;
		System.out.println("총점 = " + sum);
		
		double ave = (double) sum / 3; // (double) (sum / 3); 이건 안 됨. 나누기보다 타입을 먼저 변환해야 함.
		System.out.println("평균 = " + ave);
		
		if (ave >= 90) {
			System.out.println("A");
		} else if (ave >= 80) {
			System.out.println("B");
		} else if (ave >= 70) {
			System.out.println("C");
		} else {
			System.out.println("F");
		}
			
	}

}
