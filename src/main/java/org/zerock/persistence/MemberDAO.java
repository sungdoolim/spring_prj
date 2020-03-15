package org.zerock.persistence;

import java.util.List;

import org.zerock.domain.MemberVO;
import org.zerock.domain.ZipcodeVO;

public interface MemberDAO {

	MemberVO idcheck(String id);
	List<ZipcodeVO> zipFind(String dong);
	void insertMember(MemberVO m);
	MemberVO pwdMember(MemberVO m);
	void updatePwd(MemberVO m);
	MemberVO login_Check(String login_id);
	MemberVO getMember(String id);
	void updateMember(MemberVO m);
	void delMem(MemberVO dm);

}











