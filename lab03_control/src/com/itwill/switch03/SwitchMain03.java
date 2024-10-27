package com.itwill.switch03;

public class SwitchMain03 {

	public static void main(String[] args) {
		// switch-case 구문에서 enum 사용 방법
		
		Rsp choice = Rsp.PAPER; // 변수 타입 이름(Rsp)은 Enum의 이름을 사용. Enum이름.상수이름
		switch(choice) {
		case SCISSORS: // 여기서는 상수이름만
			System.out.println("가위");
			break;
		case ROCK:
			System.out.println("바위");
			break;
		case PAPER:
			System.out.println("보");
			break;
		}

	}

}
