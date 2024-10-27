package com.itwill.loop13;

public class LoopMain13 {

	public static void main(String[] args) {

		// 교재 연습문제 5 (183페이지)
		System.out.println("교재 연습문제 5");
		for (int x = 1; x < 5; x++) {
			for (int y = 0; y < x; y++) {
				System.out.print("*");
			}
			System.out.println("");
		}

		// 교재 연습문제 6 (183페이지)
		System.out.println("교재 연습문제 6-1");
		for (int x = 1; x <= 4; x++) {
			for (int y = 1; y <= 4; y++) {
				if (y <= 4 - x) { 
					System.out.print(" ");
				} else {  
					System.out.print("*");
				}
			}
			System.out.println("");
		}

		System.out.println("교재 연습문제 6-2");
		for (int x = 1; x <= 4; x++) {
			for (int y = 4; y >= 1; y--) {
				if (y > x) { // 4>1, 3>1, 2>1 // 4>2, 3>2 // 4>3 
					System.out.print(" ");
				} else { // 1>1 // 2>2,1>2 // 3>3,2>3,1>3 //
					System.out.print("*");
				}
			}
			System.out.println("");
		}

		System.out.println("교재 연습문제 6-3");
		for (int x = 1; x <= 4; x++) {
			for (int y = 1; y <= 4 - x; y++) {
				System.out.print(" ");
			}
			for (int y = 1; y <= x; y++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

}
