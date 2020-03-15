package org.zerock.domain;

public class MemberVO {
 /*
  *  컬럼명과 일치하는 변수명을 정의한다.
  */
	private String mem_id;
	private String mem_pwd;
	private String mem_name;
	private String mem_zip;
	private String mem_zip2;
	private String mem_addr;
	private String mem_addr2;
	private String mem_phone01;
	private String mem_phone02;
	private String mem_phone03;
	private String mail_id;
	private String mail_domain;
	private String mem_date;
	private int mem_state;//가입회원이면 1,탈퇴 회원이면 2
	private String mem_delcont;//탈퇴사유
	private String mem_deldate;//탈퇴 날짜
	
	/* 관리자 회원목록 페이징 변수*/
	private int startrow;//시작행번호
	private int endrow;//끝행번호
	
	/*관리자 회원 목록 검색필드와 검색어 저장변수*/
    private String find_name;//검색어
    private String find_field;//검색필드
    
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pwd() {
		return mem_pwd;
	}
	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_zip() {
		return mem_zip;
	}
	public void setMem_zip(String mem_zip) {
		this.mem_zip = mem_zip;
	}
	public String getMem_zip2() {
		return mem_zip2;
	}
	public void setMem_zip2(String mem_zip2) {
		this.mem_zip2 = mem_zip2;
	}
	public String getMem_addr() {
		return mem_addr;
	}
	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
	}
	public String getMem_addr2() {
		return mem_addr2;
	}
	public void setMem_addr2(String mem_addr2) {
		this.mem_addr2 = mem_addr2;
	}
	public String getMem_phone01() {
		return mem_phone01;
	}
	public void setMem_phone01(String mem_phone01) {
		this.mem_phone01 = mem_phone01;
	}
	public String getMem_phone02() {
		return mem_phone02;
	}
	public void setMem_phone02(String mem_phone02) {
		this.mem_phone02 = mem_phone02;
	}
	public String getMem_phone03() {
		return mem_phone03;
	}
	public void setMem_phone03(String mem_phone03) {
		this.mem_phone03 = mem_phone03;
	}
	public String getMail_id() {
		return mail_id;
	}
	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
	}
	public String getMail_domain() {
		return mail_domain;
	}
	public void setMail_domain(String mail_domain) {
		this.mail_domain = mail_domain;
	}
	public String getMem_date() {
		return mem_date;
	}
	public void setMem_date(String mem_date) {
		this.mem_date = mem_date.substring(0,10);
		//0이상 10미만 사이의 년월일을 반환
	}
	public int getMem_state() {
		return mem_state;
	}
	public void setMem_state(int mem_state) {
		this.mem_state = mem_state;
	}
	public String getMem_delcont() {
		return mem_delcont;
	}
	public void setMem_delcont(String mem_delcont) {
		this.mem_delcont = mem_delcont;
	}
	public String getMem_deldate() {
		return mem_deldate;
	}
	public void setMem_deldate(String mem_deldate) {
		this.mem_deldate = mem_deldate.substring(0,10);
	}
	public int getStartrow() {
		return startrow;
	}
	public void setStartrow(int startrow) {
		this.startrow = startrow;
	}
	public int getEndrow() {
		return endrow;
	}
	public void setEndrow(int endrow) {
		this.endrow = endrow;
	}
	public String getFind_name() {
		return find_name;
	}
	public void setFind_name(String find_name) {
		this.find_name = find_name;
	}
	public String getFind_field() {
		return find_field;
	}
	public void setFind_field(String find_field) {
		this.find_field = find_field;
	}    
}

















