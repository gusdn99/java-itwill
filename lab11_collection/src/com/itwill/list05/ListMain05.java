package com.itwill.list05;

import java.util.ArrayList;

public class ListMain05 {

	public static void main(String[] args) {
		// Member 타입 객체들을 저장하는 ArrayList를 선언, 초기화
		ArrayList<Member> members = new ArrayList<Member>();
		
		// members에 원소들을 저장
		members.add(new Member("admin", "1111")); // 멤버 객체 생성 및 저장
		members.add(new Member("guest", "guest"));
		members.add(new Member("itwill", "0410"));
		members.add(new Member("TEST", "test"));
		members.add(new Member("guest", "0000"));
		
		// 향상된 for 문장을 사용해서 members의 원소들을 출력.
		for (Member m : members) {
			System.out.println(m);
		}
			
		// 회원 아이디에 "est"가 포함된 회원 정보를 다른 리스트에 저장하고 출력.
		// 영문자의 대/소문자는 구분하지 않음.
		ArrayList<Member> list = new ArrayList<Member>();
		for (Member m : members) {
			if (m.getId().toLowerCase().contains("est")) {
				list.add(m);;
			}
		}
		System.out.println(list);
	
		// members에서 첫번째로 등장하는 id가 "guest"인 회원 삭제
//		members.remove(new Member("guest", null));
//		System.out.println(members);
		
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getId().equals("guest")) {
				members.remove(i);
				break; // 첫 번째로 등장하는 것만 지우는 거라서 // 없으면 마지막에 등장하는 것도 지워짐.
			}
		}
		System.out.println(members);	
	}

}
