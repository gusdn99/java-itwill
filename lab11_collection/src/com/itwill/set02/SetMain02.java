package com.itwill.set02;

import java.util.HashSet;
import java.util.Random;

public class SetMain02 {

	public static void main(String[] args) {
		// 정수를 저장하는 HashSet을 선언, 초기화
		HashSet<Integer> numbers = new HashSet<Integer>();

		// 집합(Set)에 [0, 10) 범위의 (서로 다른) 난수 5개를 저장.
		Random ran = new Random();

//		while (numbers.size() < 5) {
//			int x = ran.nextInt(10);
//			System.out.println("x = " + x);
//			
//			numbers.add(x);
//			System.out.println(numbers);
//		}

		for (int i = 0; numbers.size() < 5; i++) {
			i = ran.nextInt(0, 10);
			numbers.add(i);
			System.out.println("i = " + i);
		}
		System.out.println(numbers);
	
		System.out.println("size = " + numbers.size());
		
//		for (Integer x : numbers) {
//			if (numbers.size() < 5) {
//				System.out.println("x = " + x);
//			}
//			System.out.println(numbers);
//		}
//		System.out.println(numbers);
//		System.out.println("size = " + numbers.size());
//		
//		// 향상된 for 문장을 사용해서 집합의 내용을 출력.
//		for (Integer x : numbers) {
//			System.out.print(x + " ");
//		}
//		System.out.println();
		
	}
    
}
