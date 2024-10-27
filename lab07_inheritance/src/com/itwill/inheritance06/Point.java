package com.itwill.inheritance06;

// 2차원 평면의 점의 좌표를 표현
public class Point {
	// field
	private int x;
	private int y;
	
	// constructor
	public Point() {}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override // Object의 클래스에서 상속받은 toString() 재정의
	public String toString() {
		return "Point(x = " + x + ", y = " + y + ")";
	}

	@Override // Object에서 상속받은 equals를 재정의
	// p1, p2의 필드값 비교
	public boolean equals(Object obj) { // Object obj는 p2
		boolean result = false;
		
		if (obj instanceof Point) { // 만약 (오브젝트 타입의) 변수 obj가 포인트 타입의 객체(인스턴스)라면
			Point pt = (Point) obj; // 안전한 캐스팅 // pt는 p2
			
			result = (this.x == pt.x) && (this.y == pt.y); // x, y는 int 타입이라서 비교 연산자(==) 사용
			// this는 p1
			// pt는 p2
		}
		
		return result;
	}
    
	@Override // Object 클래스의 hashCode() 메서드를 재정의 // equals() 메서드를 오버라이드하면, hashCode() 메서드도 오버라이드해야 함.
	public int hashCode() {
		return x + y; // 이것만 되는 건 아님
		// x * y; 이것도 가능
	}
	
}
