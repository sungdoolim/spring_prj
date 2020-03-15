package org.zerock.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zerock.domain.MemberVO;
import org.zerock.domain.ZipcodeVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession sqlSession;//자동의존성 주입해서 mybatis
	//쿼리문 실행 객체 생성

	@Override
	public MemberVO idcheck(String id) {
		return this.sqlSession.selectOne("m_check",id);
		//m_check가 select 아이디명
	}//중복아이디 검색	

	@Override
	public List<ZipcodeVO> zipFind(String dong) {
		return this.sqlSession.selectList("m_zip",dong);
	}//우편검색

	@Override
	public void insertMember(MemberVO m) {
		this.sqlSession.insert("m_in",m);		
	}//회원저장

	@Override
	public MemberVO pwdMember(MemberVO m) {
		return this.sqlSession.selectOne("p_find",m);
	}//회원검색

	@Override
	public void updatePwd(MemberVO m) {
		this.sqlSession.update("p_edit", m);		
	}//임시비번 수정

	@Override
	public MemberVO login_Check(String login_id) {
		return this.sqlSession.selectOne("login_ck",login_id);
	}

	@Override
	public MemberVO getMember(String id) {
		return this.sqlSession.selectOne("m_edit",id);
	}

	@Override
	public void updateMember(MemberVO m) {
		this.sqlSession.update("edit_ok",m);		
	}

	@Override
	public void delMem(MemberVO dm) {
		this.sqlSession.update("m_del",dm);		
	}
}


























