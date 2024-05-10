package com.itwill.singleton;

public class SingletonMain {

	public static void main(String[] args) {
		// Captain 타입의 객체 생성
//		Captain captain = new Captain(); // 생성자가 private이라서 오류 뜸.
		Captain captain = Captain.getInstance(); // captain - 지역 변수
		System.out.println(captain); // stack 영역에 주소값을 저장.
		
		Captain captain2 = Captain.getInstance();
		System.out.println(captain2); // 주소값 똑같음. // 주소값이 이미 있어서 객체 생성하지 x.
		System.out.println(captain2.getName());
		
		captain2.setName("아이언맨");
		System.out.println(captain.getName()); // 객체가 1개밖에 없어서 똑같은 결과가 나옴.
		System.out.println(captain2.getName());
		
//		Singleton s1 = new Singleton(); 오류 뜸.
		Singleton s1 = Singleton.INSTANCE;
		System.out.println(s1); // enum 타입은 toString() 메서드를 override하고 있어서 주소값을 볼 수 없음.
		System.out.println(s1.getName());
		s1.setName("블랙위도우");
		System.out.println(s1.getName());
		
		Singleton s2 = Singleton.INSTANCE;
		System.out.println(s2.getName()); // 객체가 1개밖에 없어서 똑같은 결과가 나옴.
	}

}
