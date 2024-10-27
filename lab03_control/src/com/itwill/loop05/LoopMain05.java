package com.itwill.loop05;

public class LoopMain05 {

	public static void main(String[] args) {
		// 반복문에서 break와 continue 문장:
		
		// (1) break: 반복문 블록을 실행 중에 break 문장을 만나면,
		// break가 포함된 가장 가까운 반복문 블록을 끝냄.
		for (int x = 0; x < 5; x++) {
			if (x == 3) {
				break; // 3에서 멈추므로, 3 이전 정수까지 뜸.
			}
			System.out.println(x);
		}
		
		System.out.println("------------");
		
		// (2) continue: 반복문 블록을 실행 중에 continue 문장을 만나면,
		// continue 아래의 코드들은 실행하지 않고, 그 다음 반복 과정을 계속 수행.
		for (int x = 0; x < 5; x++) {
			if (x == 3) {
				continue; // 3을 만족하면 3을 실행하지 않고 넘어가서 계속 실행.
			}
			System.out.println(x);
		}
		
		System.out.println("------------");
		
		// break 문장의 용도: 무한 반복문 실행 중에 특정 조건을 만족하면 반복문을 종료.
		for (int x = 1; ; x++) {
			System.out.println(x);
			if (x == 5) {
				break; // 위에서 출력을 먼저 하므로, 5도 출력됨.
			}
		}

	}

}
