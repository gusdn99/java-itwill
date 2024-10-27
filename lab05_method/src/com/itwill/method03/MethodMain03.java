package com.itwill.method03;

public class MethodMain03 {

	public static void main(String[] args) {
		// 반환값이 없는 메서드 작성, 호출 연습 // void
		countdown(4); // static 메서드라서 이탤릭체(기울어짐).
	}
	
	public static void countdown(int x) { // void 메서드
		if (x <= 0) {
			System.out.println("카운트다운 시작값은 양의 정수여야 함");
			return; // 메서드를 중간에 종료시킬 때 사용 // 아래 반복문을 실행하지 x
			// return 문장의 의미:
			// (1) 메서드를 종료.
			// (2) return 문장에 값이 있으면, 메서드를 호출한 곳으로 값을 반환.
			// (3) void 메서드는 값이 없는 return 문만 사용 가능. // return 2; 이렇게 하면 안됨. return; 이렇게 해야 함.
				// return 문은 메서드 안에서 한 번만 실행됨. (2번 이상 실행되지 x)

		}
		
		for (int n = x; n >= 0; n--) {
			 System.out.println(n);	
		}
	}
	
}
