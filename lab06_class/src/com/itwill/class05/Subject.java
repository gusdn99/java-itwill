package com.itwill.class05;

public class Subject {

	// field
    int korean;
    int english;
    int math;
    int science;
    
    // 생성자: (1)기본 생성자. (2)아규먼트를 갖는 생성자.
    public Subject () {}
    
    public Subject (int korean, int english, int math, int science) {
    	this.korean = korean;
    	this.english = english;
    	this.math = math;
    	this.science = science;
    }
    // 메서드: (1)총점 리턴. (2) 평균 리턴.
    
    public int sum() { // this.sum() this 생략 가능. 필드 변수 앞에뿐만 아니라 메서드 이름 앞에서도 this. 붙일 수 O
    	return korean + english + math + science; 
    }
    
    public double average() {
    	return (double) sum() / 4;
    }
    
//    public void info() {
//    	System.out.println("korean = " + korean);
//    	System.out.println("english = " + english);
//    	System.out.println("math = " + math);
//    	System.out.println("science = " + science);
//    	System.out.println("sum = " + sum());
//    	System.out.println("average = " + average());
//    }
    	
}
