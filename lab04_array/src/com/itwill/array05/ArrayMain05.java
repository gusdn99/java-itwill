package com.itwill.array05;

import java.util.Random;

public class ArrayMain05 {

    public static void main(String[] args) {
        // 과제:
        // 정수(int) 5개를 저장할 수 있는 배열을 선언하고, 기본값으로 초기화.
    	int[] numbers = new int[5];
    	
        // 배열에 0 이상 10 이하의 난수 5개를 저장.
    	Random random = new Random();
    	for (int i = 0; i < numbers.length; i++) {
    		numbers[i] = random.nextInt(11);
    		System.out.print(numbers[i] + " ");
    	}
    	System.out.println();
    	
        // 배열 원소들 중 최댓값을 찾아서 출력.
    	int max = numbers[0];  // 배열의 첫 번째 원소를 최댓값이라고 가정.
//    	for (int i = 0; i < numbers.length; i++) {
//			if(numbers[i] > max) {
//    			max = numbers[i];
//    		}
//    	}
//    	System.out.println("최댓값: " + max);
    	
    	for (int i : numbers) { // 배열의 모든 원소를 순서대로 하나씩 꺼내면서 반복
			if(i > max) {  // 배열에서 꺼낸 값이 (현재까지의) 최댓값보다 크다면
    			max = i; // 최댓값을 배열에서 꺼낸 값으로 변경
    		}
    	}
    	System.out.println("최댓값: " + max);
 
        // 배열 원소들 중 최솟값을 찾아서 출력.
//    	int min = numbers[0];
//    	for (int i = 0; i < numbers.length; i++) {
//    		if(numbers[i] < min) {
//    			min = numbers[i];
//    		}
//    	}
//    	System.out.println("최솟값: " + min);

        int min = numbers[0];
        for (int x : numbers) {
            if (x < min) {
                min = x;
            }
        }
        System.out.println("min = " + min);
    }

}
