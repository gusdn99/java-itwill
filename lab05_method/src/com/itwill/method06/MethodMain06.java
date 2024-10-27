package com.itwill.method06;

public class MethodMain06 {

	public static void main(String[] args) {
		// 메서드 오버로딩(method overloading):
		// 필요성: 비슷한 기능들은 굳이 다른 이름으로 메서드를 생성할 필요가 없어서 오버로딩을 함.
		// 메서드의 파라미터가 다르면 같은 이름으로 메서드를 여러개 선언(정의)할 수 있음.
			// => 파라미터의 개수가 다르거나, 파라미터의 타입이 달라야 함. (둘 다 똑같으면 안됨)
		// (주의) 메서드의 파라미터는 동일하고 리턴 타입만 다르게는 오버로딩할 수 없음
		System.out.println("안녕하세요"); // println(String x)
		System.out.println(100); // println(int x)
		System.out.println(); // println()
		System.out.println(true); // println(boolean x)
		
		newLine();
		newLine(3);
		System.out.println("=========");
		
	}
	
	/**
	 * 콘솔에 빈 줄 하나를 출력하는 메서드.
	 */
	public static void newLine() { // 메서드 이름: newLine
		System.out.println();
	}
	
	/**
	 * 콘솔에 n개의 빈 줄을 출력하는 메서드.
	 * @param n 콘솔에 출력할 빈 줄의 개수. 양의 정수. 만약 0 또는 음수이면 아무것도 출력하지 않음.
	 */
	public static void newLine(int n) { // 메서드 이름: newLine
		for (int i = 0; i < n; i++) {
			System.out.println();
		}
	
	}

}
