package com.itwill.class05;

public class ClassMain05 {

	public static void main(String[] args) {
		// Subject, Student 클래스 객체  생성과 메서드 호출 결과 테스트.
		
		Subject sub1 = new Subject();
		System.out.println("sub1 sum = " + sub1.sum());
		System.out.println("sub1 average = " + sub1.average());
//		sub1.info();
		System.out.println("======================================");
		
		Subject sub2 = new Subject(80, 90, 75, 85);
		System.out.println("sub2 sum = " + sub2.sum());
		System.out.println("sub2 average = " + sub2.average());
//		sub2.info();
		System.out.println("======================================");

		
//		Student stu1 = new Student(0, null, sub1);
//		stu1.info();
//		System.out.println("======================================");
//		NullPointerException
//		참조값이 없어서 참조할 주소를 찾아갈 객체가 없을 때 뜸.
//		ClassMain05의 Student 객체의 기본생성자에는 참조값 Subject가 없어서 NullPointerException이 뜸
//		if 문을 써서 null값인지 아닌지부터 체크해봐야 함
		
		Student stu1 = new Student();
		stu1.info();
		System.out.println("======================================");
		
		Student stu2 = new Student(20, "홍길동", sub2);
		stu2.info();
		
	}
	
}
