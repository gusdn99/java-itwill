package com.itwill.lambda03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class LambdaMain03 {

	public static void main(String[] args) {
		// Stream 클래스 & 메서드
		
		Random rand = new Random();
		
		ArrayList<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			numbers.add(rand.nextInt(100));
		}
		System.out.println(numbers);
		
		// numbers의 원소들 중에서 짝수들만 선택(필터링)한 새로운 리스트를 만들고, 출력.
		ArrayList<Integer> evens = new ArrayList<>();
		for (Integer x : numbers) {
			if (x % 2 == 0) {
				evens.add(x);
			}
		}
		System.out.println(evens);
		
//		List<Integer> evens2 = numbers.stream().filter(new Predicate<Integer>() { // numbers가 Integer타입이라 Predicate<Integer>
//			@Override
//			public boolean test(Integer t) {
//				return t % 2 == 0;
//			}
//		}).toList();
//		System.out.println(evens2);
		
		List<Integer> evens2 = numbers.stream().filter((n) -> n % 2 == 0).toList(); // 마지막 메서드(toList())는 변수 타입으로
		System.out.println(evens2);
		
		// Stream을 사용해서, numbers의 원소들 중에서 홀수들만 선택한 리스트를 만들고 출력.
		List<Integer> odds = numbers.stream().filter(new Predicate<Integer>() { // filter()는 원소들 중 몇 개만 출력할 때
			@Override
			public boolean test(Integer t) {
				return t % 2 == 1;
			}
		}).toList();
		System.out.println(odds);
		
		// Stream을 사용해서, numbers의 원소들의 제곱을 저장하는 리스트를 만들고 출력.
		List<Integer> squares = numbers.stream().map((x) -> x * x).toList(); // map()은 원소들의 값을 변경할 때
		System.out.println(squares);
		
		// Stream을 사용해서, numbers의 원소들 중 홀수들의 제곱을 저장하는 리스트를 만들고 출력.
		List<Integer> oddsSquares = numbers.stream().filter((x) -> x % 2 == 1).map((x) -> x * x).toList();
		System.out.println(oddsSquares);
		
//		List<Integer> result = new ArrayList<>();
//		for (Integer x : numbers) {
//			if (x % 2 == 1) {
//				result.add(x * x);
//			}
//		}
//		System.out.println(result);
		
		List<String> languages = Arrays.asList("java", "javascript", "python", "c", "kotlin", "swift");
		System.out.println(languages);
		
		// languages의 원소들 중 문자열 길이가 5글자 이상인 원소들의 리스트 filter
		List<String> lengths = languages.stream().filter((s) -> s.length() >= 5).toList();
		System.out.println(lengths);
		
		// languages의 문자열을 대문자로 변환한 리스트 map
		List<String> upperCases = languages.stream().map((s) -> s.toUpperCase()).toList();
		System.out.println(upperCases);
				
		// languages의 원소들 중 길이 5글자 이상인 문자열을 대문자로 변환한 리스트
//		List<String> lengthsUppers = languages.stream().filter((s) -> s.length() >= 5).map((s) -> s.toUpperCase()).toList();
//		System.out.println(lengthsUppers);
		
		List<String> lengthsUppers = languages.stream().filter((s) -> s.length() >= 5).map(String::toUpperCase).toList();
		System.out.println(lengthsUppers);
		
		/*
		 * 람다: (파라미터 선언) -> 리턴값
		 * "메서드 참조(method reference)"를 사용한 람다 표현식 // 메서드 참조: 메서드 이름만으로 참조하는 것
		 * (1) 람다가 아규먼트를 1개만 갖고,
		 * 		람다의 리턴값이 그 아규먼트에서 "파라미터가 없는 메서드"를 호출한 경우:
		 * 			x -> x.toUpperCase() // 파라미터가 없는 toUpperCase() 메서드가 String 클래스에 속함. // x가 String 클래스의 객체
		 * 			String::toUpperCase
		 * (2) 람다가 아규먼트를 1개만 갖고.
		 * 		람다의 구현부가 메서드 1개 호출이고, 그 메서드가 람다의 아규먼트를 전달받는 경우:
		 * 			x -> System.out.println(x); // 구현부 - System.out.println();
		 * 			System.out::println
		 */
		languages.forEach((x) -> System.out.println(x)); // 한 줄에 languages의 원소 1개씩 // 구현부 - System.out.println();
		languages.forEach(System.out::println);
			
	}

}
