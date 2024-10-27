package com.itwill.rsp;

import java.util.Random;
import java.util.Scanner;

public class Rsp {

    public static void main(String[] args) {
        // 가위/바위/보 (Rock-Scissors-Paper) 게임:
        // 가위 - 0, 바위 - 1, 보 - 2
        
        // Random 타입 변수를 선언, 초기화.
        // Scanner 타입 변수를 선언, 초기화.

        System.out.println("가위바위보 게임");
        System.out.println("---------------");
        System.out.println("[0] 가위");
        System.out.println("[1] 바위");
        System.out.println("[2] 보");
        System.out.println("---------------");
        System.out.print("선택>>> ");
        
        // 사용자가 콘솔창에서 입력한 정수를 변수(user)에 저장. int user = ;
        // 0 이상 3 미만의 정수 난수 1개를 변수(computer)에 저장. int com
        // 가위바위보 게임 결과(User win/Computer win/Tie)를 출력.
        
        Random r = new Random();
    	int com = r.nextInt(3);
    	Scanner sc = new Scanner(System.in);
    	int user = sc.nextInt();
 	  	
    	
        if (user == 0 && com == 0) {
        	System.out.println("user: " + user);
        	System.out.println("com: " + com);
        	System.out.println("결과: tie");
        } else if (user == 0 && com == 1) {
        	System.out.println("user: " + user);
        	System.out.println("com: " + com);
        	System.out.println("결과: Computer win");
        } else if (user == 0 && com == 2) {
        	System.out.println("user: " + user);
        	System.out.println("com: " + com);
        	System.out.println("결과: User win");
        } else if (user == 1 && com == 0) {
        	System.out.println("user: " + user);
        	System.out.println("com: " + com);
        	System.out.println("결과: User win");
        } else if (user == 1 && com == 1) {
        	System.out.println("user: " + user);
        	System.out.println("com: " + com);
        	System.out.println("결과: tie");
        } else if (user == 1 && com == 2) {
        	System.out.println("user: " + user);
        	System.out.println("com: " + com);
        	System.out.println("결과: Computer win");
        } else if (user == 2 && com == 0) {
        	System.out.println("user: " + user);
        	System.out.println("com: " + com);
        	System.out.println("결과: Computer win");
        } else if (user == 2 && com == 1) {	
        	System.out.println("user: " + user);
        	System.out.println("com: " + com);
        	System.out.println("결과: User win");
        } else {
        	System.out.println("user: " + user);
        	System.out.println("com: " + com);
        	System.out.println("결과: tie");
        }
        
    }

}
