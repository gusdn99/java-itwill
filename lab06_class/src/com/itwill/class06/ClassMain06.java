package com.itwill.class06;

import java.util.Scanner;

public class ClassMain06 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		int balance = 0;
		Account account1 = new Account(175826, balance);
		Account account2 = new Account(224373, balance);

		while (run) {
			System.out.print("계좌번호 1. 계좌번호 2. " + "계좌번호 입력>> ");
			int accNo = scanner.nextInt();
			if (accNo == 1) {
				account1 = new Account(175826, balance);
				System.out.print("(1. 입금 " + "2. 출금 " + "3. 이체 " + "4. 정보) " + "선택>> ");
				int select = scanner.nextInt();
				if (select == 1) {
					System.out.print("입금액>> ");
					int amount = scanner.nextInt();
					System.out.println("입금액>> " + amount + ", " + "잔고>> " + account1.deposit(amount));
					balance += amount;
				} else if (select == 2) {
					System.out.print("출금액>> ");
					int amount = scanner.nextInt();
					System.out.println("출금액>> " + amount + ", " + "잔고>> " + account1.withdraw(amount));
					balance -= amount;
				} else if (select == 3) {
					System.out.println(account1.transfer(account2, 15000));
				} else if (select == 4) {
					account1.info();
				} else {

				}
			} else if (accNo == 2) {
				account2 = new Account(224373, balance);
				System.out.print("(1. 입금 " + "2. 출금 " + "3. 이체 " + "4. 정보) " + "선택>> ");
				int select = scanner.nextInt();
				if (select == 1) {
					System.out.print("입금액>> ");
					int amount = scanner.nextInt();
					System.out.println("입금액>> " + amount + ", " + "잔고>> " + account2.deposit(amount));
					balance += amount;
				} else if (select == 2) {
					System.out.print("출금액>> ");
					int amount = scanner.nextInt();
					System.out.println("출금액>> " + amount + ", " + "잔고>> " + account2.withdraw(amount));
					balance -= amount;
				} else if (select == 3) {
					System.out.println(account2.transfer(account1, 15000));
				} else if (select == 4) {
					account2.info();
				} else {

				}
			}

		}

//		// Account 타입 객체 생성
//        Account account1 = new Account(123456, 1000);
//        account1.info();
//        
//        Account account2 = new Account(123789, 10000);
//        account2.info();
//        
//        // account1 계좌에 10,000원 입금
//        int result = account1.deposit(10_000);
//        System.out.println("입금 후 잔액: " + result);
//        
//        // account1 계좌에서 5,000원 출금
//        account1.withdraw(5_000);
//        account1.info();
//        
//        // account1에서 account2으로 2,000원 이체
//        account1.transfer(account2, 2_000);
//        account1.info();
//        account2.info();
//        
//        // account2에서 account1으로 10,000원 이체
//        account2.transfer(account1, 10_000);
//        account1.info();
//        account2.info();
		
	}
	
}
