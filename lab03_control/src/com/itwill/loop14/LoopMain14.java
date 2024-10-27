package com.itwill.loop14;

import java.util.Scanner;

public class LoopMain14 {

	public static void main(String[] args) {
		// 교재 연습문제 7 (183페이지)
			
		Scanner sc = new Scanner(System.in);
		int bal = 0;

		while (true) {
			System.out.println("-----------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-----------------------------");
			System.out.print("선택> ");
			int choice = sc.nextInt();

			if (choice == 1) {
				System.out.print("얼마 예금하시겠습니까? ");
				int money1 = sc.nextInt();
				System.out.println("예금액> " + money1);
				bal += money1;
			} else if (choice == 2) {
				System.out.print("얼마 출금하시겠습니까?> ");
				int money2 = sc.nextInt();
				System.out.println("출금액> " + money2);
				bal -= money2;	
			} else if (choice == 3) {
				System.out.println("잔고는 " + bal);
			} else if (choice == 4){
				System.out.println("프로그램 종료>");
				break;
			} else {
				System.out.println("1~4 중에서 선택하세요!");
			}
			
			// if 문의 break;는 반복문을 종료시킴
			// switch 문의 break;는 swtich 문장만 종료시키고, 반복문을 종료시키지는 않음
		}
		
	/*
	 *boolean run = true; // 프로그램을 계속 실행할 지, 종료할 지를 결정하기 위한 변수.
        int balance = 0; // 은행 계좌의 잔고를 저장하기 위한 변수.
        Scanner scanner = new Scanner(System.in); // 콘솔 입력을 위해서.
        
        while (run) {
            System.out.println("---------------------------------");
            System.out.println("1.입금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.println("---------------------------------");
            System.out.print("선택> ");
            int menu = scanner.nextInt();
            switch (menu) {
            case 1:
                System.out.print("입금액>> ");
                int deposit = scanner.nextInt();
                balance += deposit;
                System.out.printf("입금: %d, 잔고: %d\n", deposit, balance);
                break;
            case 2:
                System.out.print("출금액>> ");
                int withdraw = scanner.nextInt();
                balance -= withdraw;
                System.out.printf("출금: %d, 잔고: %d\n", withdraw, balance);
                break;
            case 3:
                System.out.println("잔고: " + balance);
                break;
            case 4:
                run = false; // while 문을 종료하기 위한 조건 변경.
                System.out.println("안녕히 가세요~");
                break; // switch 문장을 종료.
            default:
                System.out.println("1~4 중에서 선택하세요!");
            }
            
        }
        
        System.out.println("프로그램 종료"); 
	 */
		
	}

}
