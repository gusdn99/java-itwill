package com.itwill.list05;

import java.util.Objects;

public class Member {
	private String id;
	private String password;
	
	public Member (String id, String password) {
		this.id = id;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Member other = (Member) obj;
//		return Objects.equals(id, other.id);
//	}
	
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (this != null && obj instanceof Member) {
			Member m = (Member) obj;
			result = (this.id == m.id) && (this.password == m.password);
		}
		return result;
	}
	
}
