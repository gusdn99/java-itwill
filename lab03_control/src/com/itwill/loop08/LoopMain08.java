package com.itwill.loop08;

public class LoopMain08 {

	public static void main(String[] args) {
		// while 반복문
		
		System.out.println("----- [1] -----");
		int n = 1;
		while (n <= 5) {
			System.out.print(n + " ");
			n++; // n += 1; n = n + 1;
		}
		System.out.println();
		System.out.println(n);
		
		System.out.println("----- [2] -----");
		// 5 4 3 2 1 출력
		n = 5;
		while (n >= 1) {
			System.out.print(n + " "); // System.out.print(n-- + " "); => 5	4 3 2 1 결과 값 같음
			n--; // --n; 다른 연산자 없으므로 결과 값 같음
		}
		System.out.println();
		
		System.out.println("----- [3] -----");
		// 1 3 5 7 9 출력
		n = 1;
		while (n <= 9) {
			if (n % 2 == 1) {
				System.out.print(n + " ");
				// n++; if문 안에 넣으면 정수 1만 무한루프로 뜸
			}
			n++;
		}
		System.out.println();
		
		/* while (n <= 9) {
		 * System.out.print(n + " ");
			n += 2; n = n + 2
		}
		System.out.println();
		 */
		
		System.out.println("----- [4] -----");
		// while문을 사용해서 구구단 9단을 출력.
		int x = 9;
		n = 1;
		while (n < 10) {
			System.out.println(x + " x " + n + " = " + x * n);
			n++;
		}
		
	}

}
