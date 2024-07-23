package com.itwill.variable01;

public class VariableMain01 {

	public static void main(String[] args) {
		// 변수(variable): 프로그램에서 필요한 데이터를 저장하는 메모리 공간.
		// 변수 사용:
		// (1) 변수 선언: 저장하는 데이터의 종류(타입)와 변수 이름을 선언.
		// (2) 변수 초기화: 변수에 값을 처음 저장하는 것.
		
		// 변수 선언할 때 타입을 먼저 써야 함.
		 // 정수(integer)를 저장하는 변수 age
		int age;
		// 변수 age를 16으로 초기화(변수에 정수 16을 저장)
		// '=' 오른쪽에 있는 값을 왼쪽에 있는 변수에 저장
		age = 16;

		System.out.println("나이: " + age);
		
		int x = 100; // 변수를 선언과 동시에 초기화(변수 선언과 초기화를 한 문장으로 작성).
		System.out.println("x = " + x);
		
		// 자바(Java)의 기본 데이터 타입
		// 정수 타입: byte(1Byte), short(2Byte), int(4Byte), long(8Byte), char
		// 실수 타입: float(4Byte), double(8Byte)
		// 논리 타입: boolean(true or false)
		long number = 123_456_789_000L;
		double pi = 3/141592;
		boolean isMarried = false;
		
		// 변수 이름 작성 규칙:
		// - 변수 이름은 알파벳(한글 안 됨), 숫자, _, $만 사용 가능
		// - 변수 이름은 대/소문자를 구분함. (예) x, X는 서로 다른 변수.
		// - 변수 이름은 숫자로 시작할 수 X
		// - 변수 이름으로 자바의 키워드(예약어)는 사용할 수 X (예) int int, int class
		// - 변수 이름은 변수 역할에 어울리는 "의미 있는" 단어를 사용해서 만드는 것을 권장. (예) int age(나이)
		// - 변수 이름을 2개 이상의 단어를 붙여서 만들 경우에는
		// "소문자"로 시작하는 camel 표기법을 권장. (예) userId, userPassword
		// (비교) snake 표기법: user_id, user_password, is_married
		
	}

}
