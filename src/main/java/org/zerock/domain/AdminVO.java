package org.zerock.domain;

public class AdminVO {
	/*
	 * 테이블 컬럼명과 빈클래스 변수명을 일치시킨다.
	 */
	private int admin_no;
	private String admin_id;//관리자 아이디
	private String admin_pwd;//관리자 비번
	private String admin_name;//관리자 이름
	private String admin_date;//등록날짜
	
	public int getAdmin_no() {
		return admin_no;
	}
	public void setAdmin_no(int admin_no) {
		this.admin_no = admin_no;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_pwd() {
		return admin_pwd;
	}
	public void setAdmin_pwd(String admin_pwd) {
		this.admin_pwd = admin_pwd;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_date() {
		return admin_date;
	}
	public void setAdmin_date(String admin_date) {
		this.admin_date = admin_date;
	}	
}
