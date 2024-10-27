package com.itwill.modifier03;

public class Person {
	private String name; // 읽기 전용 필드 getter
	private int age; // 읽기/쓰기 필드 setter

	public Person(String name, int age) {
		if (name != null && age != 0) {
			this.name = name;
			this.age = age;
		} else {
			throw new IllegalArgumentException();
		}

	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age != 0) {
			this.age = age;
		}

	}
}
