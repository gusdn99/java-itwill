package com.itwill.exception04;

/*
 * 예외 클래스들의 상속 관계:
 * Object
 * |__ Throwable
 * 		|__ Exception
 * 			|__ RuntimeException
 * 				|__ ArithmeticException, NumberFormatException, NullPointerException, ...
 * 
 * catch 블록이 여러 개인 경우, 하위 타입의 예외를 먼저 catch하고,
 * 상위 타입의 예외를 나중에 catch해야 함.
 */

public class ExceptionMain04 {
	public static void main(String[] args) {
		try {

		} catch (ArithmeticException e) { // catch가 여러 개일때 하위 타입을 먼저 적어야 함.

		} catch (Exception e) { // 만약 상위 타입을 위에 적으면 오류 뜸.
			// 다형성: SuperType var = new SubType();
			// Exception 클래스를 상속하는 모든 종류의 예외를 잡을 수 있음.
		}

		// finally: 예외 상황 발생 여부와 상관 없이 항상 실행되는 블록.
		// try 또는 catch 블록에 return 문장이 있어도,
		// finally 블록이 실행된 후에 return 문장이 실행됨.

		try {
			int x = 100;
			int y = 0;
			System.out.println("몫 = " + (x / y));
			System.out.println("end try");
		} catch (Exception e) { // 다형성 // Exception > ArithmeticException
			System.out.println(e.getMessage());
			System.out.println("end catch");
			return; // main 메서드 종료 // end main 실행 안 됨.
		} finally { // return 문장이 실행되기 전에 반드시 실행됨.
			System.out.println("언제 출력될까요?");
		}

		System.out.println("end main");

	}

}
