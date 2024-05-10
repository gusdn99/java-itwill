package com.itwill.inheritance01;

public class InheritanceMain01 {

	public static void main(String[] args) {
		// BasicTv 타입 객체 생성
		BasicTv tv1 = new BasicTv();
		
		tv1.powerOnOff();
		System.out.println("----------------------");
		
		System.out.println("CH: " + tv1.channelUp());
		System.out.println("CH: " + tv1.channelUp());
		System.out.println("CH: " + tv1.channelUp());
		System.out.println("CH: " + tv1.channelUp());
		System.out.println("----------------------");
		
		System.out.println("CH: " + tv1.channelDown());
		System.out.println("CH: " + tv1.channelDown());
		System.out.println("CH: " + tv1.channelDown());
		System.out.println("CH: " + tv1.channelDown());
		System.out.println("----------------------");
		
		System.out.println("VOL: " + tv1.volumeUp());
		System.out.println("VOL: " + tv1.volumeUp());
		System.out.println("VOL: " + tv1.volumeUp());
		System.out.println("VOL: " + tv1.volumeUp());
		System.out.println("----------------------");
		
		System.out.println("VOL: " + tv1.volumeDown());
		System.out.println("VOL: " + tv1.volumeDown());
		System.out.println("VOL: " + tv1.volumeDown());
		System.out.println("VOL: " + tv1.volumeDown());
		System.out.println("----------------------");
		
		tv1.powerOnOff();
		System.out.println("----------------------");
		
		// SmartTv 타입 객체 생성
		SmartTv tv2 = new SmartTv();
		tv2.powerOnOff(); // 상위클래스에서 상속받은 메서드를 호출.
		tv2.webBrowsing();

	}

}
