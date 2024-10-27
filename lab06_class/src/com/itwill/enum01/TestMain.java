package com.itwill.enum01;

public class TestMain {

	public static void main(String[] args) {
//		Math m = new Math(); private이라서 안 보임
		
		int season = Season1.SPRING;
		
		switch (season) {
		case Season1.SPRING:
			System.out.println("봄");
			break;
		case Season1.SUMMER:
			System.out.println("여름");
			break;
		case Season1.FALL:
			System.out.println("가을");
			break;
		case Season1.WINTER:
			System.out.println("겨울");
			break;
		default:
			System.out.println("이상기후");
		}

//		Season2 season2 = new Season2(); 생성자가 private라서 생성자를 만들 수 없음.
//		Season2 클래스는 static 수식어가 있어서 클래스 이름으로 접근 가능.
		Season2 season2 = Season2.SPRING; // 봄
		System.out.println(season2); // com.itwill.enum01.Season2@54bedef2 
		if (season2 == Season2.SPRING) {
			System.out.println("봄");
		} else if (season2 == Season2.SUMMER) {
			System.out.println("여름");
		} else {
			System.out.println("...");
		}
		
//		Season3 season3 = new Season3();
//		enum 타입의 Season3은 private으로 생성자가 감추어져 있어서 객체를 사용할 수 없음.
		Season3 season3 = Season3.SPRING;
		System.out.println(season3); // SPRING
		System.out.println(season3.getName()); // 봄
			
	}
	
}
