package org.zerock.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.AdminVO;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Inject
	private SqlSession sqlSession;//자동의존성 주입
	//sqlSession은 mybatis 쿼리문 실행 객체

	@Override
	public void insertAdmin(AdminVO ab) {
		this.sqlSession.insert("admin_in",ab);
		//admin_in이 insert 아이디명
	}//관리자 정보 저장

	@Override
	public AdminVO adminLogin(String admin_id) {
		return this.sqlSession.selectOne("admin_login",
				admin_id);
	}//관리자 로그인 인증
}








