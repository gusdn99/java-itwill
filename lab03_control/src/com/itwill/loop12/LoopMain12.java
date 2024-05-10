package com.itwill.loop12;

public class LoopMain12 {

	public static void main(String[] args) {
		// 교재 연습문제 3(183페이지)
		// 주사위 2개를 던졌을 때 결과를 (x, y) 형식으로 출력
		// 주사위 2개의 눈의 합이 5가 되면 실행을 멈춤.
		int sum = 0;
		
		while (true) {
			int a = (int) (Math.random() * 6) + 1;
			int b = (int) (Math.random() * 6) + 1;
			System.out.println("(" + a + ", " + b + ")");
			sum = a + b;
			if (sum == 5) {
				break;
			}
		}
		System.out.println("종료");
		
		/*
		 * Random random = new Random();
        
        // for ( ; ; ) { ... }
        while (true) { // 무한 루프
            int x = random.nextInt(1, 7); // 1 <= x < 7 범위의 난수.
            int y = random.nextInt(1, 7);
            System.out.printf("(%d, %d)\n", x, y);
            if (x + y == 5) {
                break; // 무한 루프를 멈춤.
            }
        }
        
        System.out.println("----------");
        
        int x;
        int y;
        do {
            x = random.nextInt(1, 7);
            y = random.nextInt(1, 7);
            System.out.printf("(%d, %d)\n", x, y);
        } while (x + y != 5);
		 */

		// 교재 연습문제 4(183페이지)
		// 4x + 5y = 60 방정식을 만족하는 x와 y를 찾기.
		// 단, x와 y는 10 이하의 자연수
		
		for (int x = 1; x <= 10; x++) {
			for (int y = 1; y <= 10; y++) {
				sum = (4*x)+(5*y);
				if (sum == 60) {
					//System.out.println("(" + x + ", " + y + ")");
					System.out.printf("(%d, %d)\n", x , y);
				}
			}
		}
		
		/*
		 * for (x = 1; x <= 10; x++) {
            for (y = 1; y <= 10; y++) {
                if (4 * x + 5 * y == 60) {
                    System.out.printf("(x=%d, y=%d)", x, y);
                }
            }
        }
		 */
		
	}

}
