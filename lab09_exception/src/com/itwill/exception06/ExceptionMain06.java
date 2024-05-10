package com.itwill.exception06;

public class ExceptionMain06 {

	public static void main(String[] args) {
		// throws 선언문이 있는 메서드들 중에서, 
		// RuntimeException을 상속하는 예외 타입들은 try-catch를 사용하지 않아도 컴파일 에러가 없음.
		// RuntimeException이 아닌 예외 타입들은 반드시
		//	(1) try-catch 문장을 사용하거나
		//	(2) throws 선언문을 추가해야 함.
		
		// Integer.parseInt(""); // -> 반드시 try-catch를 사용할 필요는 없음.
		
		// Calculator 타입 객체 생성
		Calculator calc = new Calculator();
		// thorws Exception 선언문으로 던져서 try-catch로 잡거나, throws Exception 선언문으로 떠넘겨야 함. 사용하지 않으면 오류 뜸. 
		try {
			int result = calc.divide(100, 0);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace(); // 오류가 뜨는 경로를 표시함.
		}
		System.out.println("main 정상 종료");
		
	}

}
