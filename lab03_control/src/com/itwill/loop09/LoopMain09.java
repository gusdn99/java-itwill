package com.itwill.loop09;

public class LoopMain09 {

	public static void main(String[] args) {
		// 중첩 while 문장을 사용해서 구구단 1단부터 12단까지 출력.
		int a = 1;

		while (a < 13) {
			System.out.println("====== " + a + "단 ======");	
			int b = 1;
			while (b < 13) {
				System.out.printf("%d * %d = %d\n", a, b, a * b);
				b++; 
			}
			a++;

		}	
		
	}

}
