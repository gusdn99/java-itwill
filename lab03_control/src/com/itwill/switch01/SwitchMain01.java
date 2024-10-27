package com.itwill.switch01;

public class SwitchMain01 {

	public static void main(String[] args) {
		// switch-case 구문:
		// 해당 case 위치로 이동해서 break; 문장을 만날 때까지 실행.
		// 해당하는 case가 없으면 default 블록을 실행.
		// default 블록은 switch 구문에서 항상 가장 마지막에 작성.
		// default 블록은 없어도 됨.(case는 1개 이상이어야 함.)
		// switch (변수 또는 식)에서 사용할 수 있는 타입:
		// (1) 정수: byte, short, int, long, char
		// (2) 문자열: String
		// (3) enum 타입:
		// (주의) switch-case 구문에서는 실수(float, double), boolean 타입은 사용 불가!
		
		String season = "겨울";
		switch (season) {
		case "봄": // 콜론(:) = 라벨(label). 코드의 위치를 표시해주는 역할. 실행 문장 아님.
			System.out.println("Spring");
			break; // 실행을 멈추고 싶을 때 사용. (반드시 써야 하는 건 아님)
		case "여름":
			System.out.println("Summer");
			break;
		case "가을":
			System.out.println("Fall");
			break;
		case "겨울":
			System.out.println("Winter");
			break;
		default: // 매칭되는 case가 하나도 없는 경우 실행됨. 제일 마지막에 적음. (반드시 써야 하는 건 아님)
			System.out.println("몰라요~");
		}
		
		int number = 123;
		switch (number % 2) { // 비교 연산 불가 (예) (number % 2 == 0) 안됨
		case 0:
			System.out.println("짝수");
			break;
		case 1: // case 1 대신 default 써도 됨
			System.out.println("홀수");
			break; // default의 break라서 없어도 됨.
		}
		
	}

}
