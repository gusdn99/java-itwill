package com.itwill.array06;

public class ArrayMain06 {

	public static void main(String[] args) {
		// 다차원 배열: 배열들을 원소로 갖는 배열.
		// 2차원 배열: 1차원 배열들을 원소로 갖는 배열.
		// - 2차원 배열은 인덱스를 2개를 갖음.
		
		// 2차원 배열 선언 & 초기화 방법1:
		// 2차원 배열이 갖는 모든 원소들을 나열하면서 배열을 선언하고 초기화.
		// 타입[][] 변수이름 = new 타입[][] { {...}, {...}, ...}; // [][] 안에 숫자 안 적음
		// 타입[][] 변수이름 = { {...}, {...}, ... };
		int[][] array = {
				{1, 2, 3, 4},
				{5, 6, 7},
				{8, 9, 10, 11, 12}, // 마지막 쉼표는 생략 가능
		};
		
		System.out.println(array); // -> [[I
		System.out.println(array.length); // -> 2차원 배열의 원소: 1차원 배열. 1차원 배열 개수: 3개 // 행의 개수 => 3 { {1, 2, 3, 4}, {5, 6, 7}, {8, 9, 10, 11, 12} }
		System.out.println(array[0]); // -> [I
		System.out.println(array[0].length); // 열의 개수 =>  4 {1, 2, 3, 4}
		
		// 인덱스를 사용한 2차원 배열 원소 출력
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + "\t");
			}
			System.out.println();
		}
		
		 // 향상된 for 구문을 사용한 2차원 배열 원소 출력
		for (int[] a : array) { // 2차원 배열의 원소 - 1차원 배열(a) // => a는 행 { {1, 2, 3, 4}, {5, 6, 7}, {8, 9, 10, 11, 12} }

			for (int x : a) { // 1차원 배열(a)의 원소 - int 변수(x) // => x는 열 // 1열 - {1, 2, 3, 4} // 2열 - {5, 6, 7} // 3열 - {8, 9, 10, 11, 12}
				System.out.print(x + "\t");
			}
			System.out.println();
		}

	}

}
