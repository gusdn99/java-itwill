package com.itwill.set03;

import java.util.HashSet;

public class SetMain03 {

	public static void main(String[] args) {
		// Score 타입을 저장할 수 있는 HashSet을 선언, 초기화.
		HashSet<Score> scores = new HashSet<>();
		System.out.println(scores);
		
		// scores에 Score 객체들을 저장. // hashCode()로 들어가는 주머니가 같은지 먼저 검토하고, equals()로 같은 객체인지 검토.
		scores.add(new Score()); // 기본값 0, 0, 0이 뜸
		scores.add(new Score(0, 0, 0)); // hashCode() 오버라이드 안 하면, equals() 오버라이드 해도 0, 0, 0이 2개 뜸.
		scores.add(new Score(100, 50, 0));
		scores.add(new Score(50, 0, 100));
		
		System.out.println(scores);

	}

}
