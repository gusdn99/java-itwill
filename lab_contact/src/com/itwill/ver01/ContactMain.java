package com.itwill.ver01;

import java.util.Scanner;

public class ContactMain {
	private static final int MAX_LENGTH = 3; // 연락처 배열의 최대길이(원소 개수)

	private Scanner scanner = new Scanner(System.in);
	private Contact[] contacts = new Contact[MAX_LENGTH]; // 연락처를 저장하기 위한 배열
	private int count = 0; // 현재까지 연락처 배열에 저장된 개수.
	// 배열에 새로운 연락처 저장될 때마다 count++을 실행.

	public static void main(String[] args) {
		System.out.println("*** 연락처 프로그램 v0.1");

		ContactMain app = new ContactMain();

		// 프로그램 계속 실행(run = true) 또는 종료(run = false) 여부를 저장하기 위한 변수.
		boolean run = true;
		while (run) {
			int menu = app.showMainMenu();
			switch (menu) {
			case 0:
				run = false;
				break;
			case 1:
				app.saveNewContact();
				break;
			case 2:
				app.readAllContacts();
				break;
			case 3:
				app.readContactByIndex();
				break;
			case 4:
				app.updateContactByIndex();
				break;
			default:
				System.out.println("메뉴 번호(0 ~ 4)를 확인하세요.");
			}
		}

		System.out.println("*** 프로그램 종료 ***");

	}

	private void updateContactByIndex() {

		System.out.println("\n --- 연락처 수정 ---");
		System.out.print("인덱스 입력>> ");

		int index = Integer.parseInt(scanner.nextLine());
		
//		if (index < 0 || index >= count) {
//			System.out.println("해당 인덱스에는 수정할 정보 없음");
//			return; // else 문을 실행하지 않고 바로 메서드 종료하겠다는 의미
//		}
		
		if (index >= 0 && index < count) {
			System.out.println("수정전: " + "[" + index + "]" + "번째 연락처 목록 = "+ contacts[index].toString());
			// contacts는 배열 타입.
			// contacts[index]는 배열에서 원소를 꺼냈으므로 Contact 클래스 타입.
			
			System.out.print("이름 수정>> ");
			String name = scanner.nextLine();
			contacts[index].setName(name);
//			 contacts[index]는 Contact 클래스 타입이라서 Contact 클래스에서 setter를 찾을 수 있음.

			System.out.print("전화번호 수정>> ");
			String phone = scanner.nextLine();
			contacts[index].setPhone(phone);

			System.out.print("이메일 수정>> ");
			String email = scanner.nextLine();
			contacts[index].setEmail(email);

			System.out.println("수정후: " + "[" + index + "]" + "번째 연락처 목록 = "+ contacts[index].toString());
			
			contacts[index] = new Contact(name, phone, email);
			
			System.out.println("연락처 수정 성공");
			
//			Contact contact = new Contact();
//			contact.setName(name);
//			contact.setPhone(phone);
//			contact.setEmail(email);
//			
//			contacts[index] = contact;
//			
//			System.out.println("수정후: " + "[" + index + "]" + "번째 연락처 목록 = "+ contact.toString());
		} else {
			System.out.println("저장된 연락처 없음");
		}

	}

	private void readContactByIndex() {
		System.out.println("\n --- 인덱스 검색 ---");
		System.out.print("인덱스 입력>> ");
		int index = Integer.parseInt(scanner.nextLine());

		// 해당 인덱스의 연락처를 출력
		if (index >= 0 && index < count) {
			System.out.println("[" + index + "]" + "번째 연락처 목록 = "+ contacts[index].toString());
//			System.out.println("[" + index + "]" + "번째 연락처 목록 = "+ contacts[index]); toString() 없애도 주소값 안나옴
		} else {
			System.out.println("해당 인덱스에 저장된 연락처 없음");
		}
		
		}
			
	private void readAllContacts() {
		System.out.println("\n --- 연락처 목록 ---");
		// 인덱스 0번부터 현재 저장된 연락처 개수보다 작을 때까지
		for (int i = 0; i < count; i++) {
			System.out.println("[" + i + "]" + "번째 연락처 목록 = " + contacts[i].toString());
		}
	}
	
	private void saveNewContact() {
//		배열에 저장된 연락처 개수가 배열 최대 길이와 같다면 저장 기능을 종료
//		if (count == MAX_LENGTH) {
//			System.out.println("저장 공간이 부족합니다...");
//			return; else 문을 실행하지 않고 바로 메서드 종료하겠다는 의미
//		}
		
		if (count < MAX_LENGTH) {
			System.out.println("\n --- 새 연락처 저장 ---");
			System.out.print("이름 입력>> ");
			String name = scanner.nextLine();

			System.out.print("전화번호 입력>> ");
			String phone = scanner.nextLine();

			System.out.print("이메일 입력>> ");
			String email = scanner.nextLine();

			Contact contact = new Contact(name, phone, email);

			// Contact 타입 객체를 연락처 배열 인덱스 count에 저장
			contacts[count] = contact;
			// 배열에 저장 후에는 연락처 저장 개수(인덱스)를 증가
			count++;
			
			System.out.println("연락처 저장 성공");
			
		} else {
			System.out.println("저장 범위 초과");
	
		} 

	}

	private int showMainMenu() {
		System.out.println("\n----------------------------------------------");
		System.out.println("[0]종료 [1]저장 [2]목록 [3]인덱스검색 [4]수정");
		System.out.println("----------------------------------------------");
		System.out.print("선택> ");
		int menu = Integer.parseInt(scanner.nextLine());

		return menu;
	}

}
