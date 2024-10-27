package com.itwill.ver02;

import java.util.Scanner;
import com.itwill.ver01.Contact;

// MVC 아키텍쳐에서 View 역할.
public class ContactMain02 {
	private Scanner scan = new Scanner(System.in);
	private ContactDao dao = ContactDaoImpl.getInstance();

	public static void main(String[] args) {
		System.out.println("*** 연락처 프로그램 v0.2 ***");
		ContactMain02 app = new ContactMain02();
		boolean run = true;
		while (run) {
			int menu = app.selectMainMenu();
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
		System.out.println(">>> 프로그램 종료 >>>");

	}

	private void updateContactByIndex() {
		System.out.println("\n --- 연락처 수정 ---");
		System.out.print("인덱스 입력>> ");

		int index = inputIndex();

		if (!((ContactDaoImpl) dao).isValidIndex(index)) {
			System.out.println("해당 인덱스에는 수정할 정보가 없습니다...");
			return;
		}
		
		Contact contact = dao.read(index);
		System.out.println("수정전: " + "[" + index + "]" + "번째 연락처 목록 = " + contact);

		System.out.print("이름 수정>> ");
		String name = scan.nextLine();
		contact.setName(name);

		System.out.print("전화번호 수정>> ");
		String phone = scan.nextLine();
		contact.setPhone(phone);

		System.out.print("이메일 수정>> ");
		String email = scan.nextLine();
		contact.setEmail(email);

//		Contact updated = new Contact(name, phone, email);
//		int result = dao.update(index, updated);

		int result = dao.update(index, contact);
		if (result == 1) {
			System.out.println("연락처 수정 성공");
		} else {
			System.out.println("연락처 수정 실패");
		}

	}

	private void readContactByIndex() {
		System.out.println("\n --- 인덱스 검색 ---");
		System.out.print("인덱스 입력>> ");

		int index = inputIndex();
		
		if (!((ContactDaoImpl) dao).isValidIndex(index)) {
			System.out.println("해당 인덱스에는 연락처 정보가 없습니다.");
			return;
		}

	}

	private void readAllContacts() {
		System.out.println("\n --- 연락처 목록 ---");
		Contact[] contacts = dao.read();

//		int index = 0;
//		for (Contact c : contacts) {
//			if (c != null) {
//				System.out.println("[" + index + "] " + c);
//				index++;
//			}
//		}

		for (int i = 0; i < contacts.length; i++) {
			if (contacts[i] == null) {
				return;
			} else {
				System.out.println("[" + i + "]번째 연락처 목록" + contacts[i]);
			}

		}

	}

	private void saveNewContact() {
		System.out.println("\n --- 새 연락처 저장 ---");
		ContactDaoImpl daoImpl = ((ContactDaoImpl) dao);
		if (daoImpl.isStorageFull()) {
			System.out.println("저장 공간이 부족합니다.");
			return;
		}

		System.out.print("이름 입력>> ");
		String name = scan.nextLine();

		System.out.print("전화번호 입력>> ");
		String phone = scan.nextLine();

		System.out.print("이메일 입력>> ");
		String email = scan.nextLine();

		Contact contact = new Contact(name, phone, email);
		int result = daoImpl.create(contact);

		if (result == 1) {
			System.out.println("연락처 저장을 성공했습니다.");
		} else {
			System.out.println("연락처 저장을 실패했습니다.");
		}
	}

	private int selectMainMenu() {
		System.out.println("\n----------------------------------------------");
		System.out.println("[0]종료 [1]저장 [2]목록 [3]인덱스검색 [4]수정");
		System.out.println("----------------------------------------------");
		System.out.print("선택> ");

		int menu = inputMenu();

		return menu;
	}
	
	private int inputIndex() {
		int index = 0;

        while (true) {
            try {
                index = Integer.parseInt(scan.nextLine());
                Contact contact = dao.read(index);
                System.out.println(contact);
                break;
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.print("인덱스 입력>> ");
            }
        }
        return index;
	}

	private int inputMenu() {
		int result = 0;

		while (true) {
			try {
				result = Integer.parseInt(scan.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("입력값은 정수여야 합니다.");
				System.out.println(e.getMessage());
				System.out.print("정수를 입력하세요.>> ");
			}
		}

		return result;
	}

}
