package com.itwill.loop11;

public class LoopMain11 {

	public static void main(String[] args) {
		// Ex1. 1부터 10까지 자연수들의 합을 계산하고 출력
		int n = 1;
		int sum = 0;
		while (n < 11) {
			sum += n;
			n++;
		}
		System.out.println("1부터 10까지의 합" + " = " + sum);
		
		// Ex2. 1부터 100까지 자연수들중에서 짝수들의 합을 계산하고 출력
		sum = 0;
		for (int even = 2; even <= 100; even+=2) {
			sum += even;
		}
		System.out.println("1부터 100까지 숫자들 중 짝수들의 합" + " = " + sum);
		
		// Ex3. 1부터 100까지 자연수들중에서 홀수들의 합을 계산하고 출력
		int odd = 1;
		sum = 0;
		while (odd < 101) {
			sum += odd;
			odd += 2;
		}
		System.out.println("1부터 100까지 숫자들 중 홀수들의 합" + " = " + sum);
	}

}
