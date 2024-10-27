package com.itwill.modifier03;

public class Member {
	// field
	private String memberId; // 읽기 전용 필드
	private String memberPassword; // 읽기/쓰기 필드

	// constructor
	public Member(String memberId, String memberPassword) {
		if (memberId != null && memberPassword != null) { 
			this.memberId = memberId;
			this.memberPassword = memberPassword;
		} else {
			throw new IllegalArgumentException(); // 무결성(null이라면 에러가 뜬다는 가정.)
		}
	}

	// method
	// getter 메서드(리턴), 읽기 전용, 파라미터 필요하지 x
	public String getMemberId() { // 필드의 변수 이름 앞에 get만 붙여서 적음.
		return memberId; // 필드 변수
	}

	public String getMemberPassword() {
		return memberPassword; // 필드 변수
	}

	// setter 메서드(값 변경), 읽기/쓰기, 파라미터 필요함
	public void setMemberPassword(String passowrd) { // 필드의 변수 이름 앞에 set만 붙여서 적음.
		if (passowrd != null) { // 무결성(비밀번호를 null로 변경하면 안된다는 가정.)
			System.out.println(memberPassword); // 필드 변수
//			this.memberPassword = password;
		}
	}

}
