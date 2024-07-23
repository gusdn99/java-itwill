package com.itwill.datetime;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class DateTimeEx {

	public static void main(String[] args) {
		// Java 8 버전부터 새로 생긴 java.time 패키지의 날짜/시간 클래스
		
		LocalDate today = LocalDate.now(); // now();는 LocalDate 타입
		System.out.println(today); // LocalDate타입이 toString() 메서드를 오버라이딩해서 주소값이 안 뜸.
		System.out.println(today.getYear());
		System.out.println(today.getMonth()); // Month는 enum 타입
		System.out.println(today.getMonthValue()); // Value는 int 타입
		System.out.println(today.getDayOfMonth());
		System.out.println(today.getDayOfWeek()); // DayOfWeek는 enum 타입
		System.out.println(today.plusDays(1)); // 아규먼트는 long타입으로 입력
		System.out.println(today.minusWeeks(1)); // 아규먼트는 long타입으로 입력
		
		LocalDate birthday = LocalDate.of(2000, 12, 31); // of();는 LocalDate 타입
		// LocalDate.of(2000, Month.DECEMBER, 31);
		System.out.println(birthday);
		
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		
		LocalDateTime time = LocalDateTime.of(2024, 3, 14, 9, 30, 10, 999999999);
		System.out.println(time);
		
		// Timestamp: 1970-01-01 00:00:00를 기준으로 해서 1/1000초(milli-second)마다
		// 1씩 증가하는 정수(long 타입)를 기반으로 날짜와 시간 정보를 저장하는 클래스(타입).
		
		// LocalDateTime --> Timestamp 변환
		Timestamp ts = Timestamp.valueOf(now); // now가 LocalDateTime 타입
		System.out.println(ts);
		System.out.println(ts.getTime());
		
		// Timestamp --> LocalDateTime 변환
		LocalDateTime dt = ts.toLocalDateTime();
		System.out.println(dt);

	}

}
