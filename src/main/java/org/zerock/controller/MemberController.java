package org.zerock.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.domain.MemberVO;
import org.zerock.domain.ZipcodeVO;
import org.zerock.domain.ZipcodeVO2;
import org.zerock.service.MemberService;

import pwdconv.PwdChange;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	//사용자 회원관리 로그인 폼 페이지 
	@RequestMapping("/member_login")
	public String member_login() {
		return "member/member_login";
		// /WEB-INF/views/member/member_login.jsp로 이동
	}
	
	//사용자 회원가입 폼
	@RequestMapping("/member_join")
	public String member_join(Model m) {
		String[] phone= {"010","011","019"};
		String[] email= {"naver.com","daum.net","nate.com",
				"google.com","직접입력"};
		m.addAttribute("phone",phone);
		m.addAttribute("email",email);
		return "member/member_join";
	}//member_join()
	
	//아이디 중복검색
	@RequestMapping("/member_idcheck")
	public String member_idcheck(@RequestParam("id")
	String id,HttpServletResponse response) throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
MemberVO db_id=this.memberService.idcheck(id);//회원아이디
//중복검색
        int re=-1;//중복 아이디가 없을때는 -1을 반환
        if(db_id != null) {//중복 아이디가 있다면
        	re=1;
        }
        out.println(re);//값이 반환
		return null;
	}//member_idcheck()
	
	//우편검색 폼
	@RequestMapping("/zip_find")
	public String zip_find() {
		return "member/zip_find";
	}
	
	//우편검색 결과 
	@RequestMapping("/zip_find_ok")
	public String zip_find_ok(
			@RequestParam("dong") String dong,
			Model zm) {
		List<ZipcodeVO> zlist=
				this.memberService.zipFind("%"+dong+"%");
		//%는 오라클 와일드 카드로 하나이상의 임의의 문자와 매핑
		//대응한다.
		List<ZipcodeVO2> zlist2=new ArrayList<>();
		
		for(ZipcodeVO z:zlist) {
			ZipcodeVO2 z2=new ZipcodeVO2();
			
			z2.setZipcode(z.getZipcode());//우편번호
z2.setAddr(z.getSido()+" "+z.getGugun()+" "+z.getDong());
//시도 구군 동을 저장
zlist2.add(z2);//컬렉션에 추가
		}
		zm.addAttribute("zipcodelist",zlist2);//zipcodelist
		//키이름에 가공된 주소목록이 저장됨.
		zm.addAttribute("dong",dong);
		return "member/zip_find";
	}//zip_find_ok()
	
	//회원저장
	@RequestMapping("/member_join_ok")
	public String member_join_ok(MemberVO m,
			HttpServletResponse response)
	throws Exception{
		m.setMem_pwd(PwdChange.getPassWordToXEMD5String(
				m.getMem_pwd()));//입력 비번 암호화
		this.memberService.insertMember(m);//회원저장
		/* 문제풀이)
		 *  1.탈퇴사유와 탈퇴날짜만 빼고 회원저장되게 만든다.
		 */
		return "redirect:/member_login";//로그인 페이지로 이동
	}//member_join_ok
	
	//비번 찾기 폼
	@RequestMapping("/pwd_find")
	public String pwd_find() {
		return "member/pwd_find";
	}
	
	//비번찾기 결과
	@RequestMapping("/pwd_find_ok")
	public String pwd_find_ok(
			@RequestParam("pwd_id") String pwd_id,
			@RequestParam("pwd_name") String pwd_name,
			HttpServletResponse response,
			HttpServletRequest request,
			@ModelAttribute MemberVO m,
			Model fm) throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		m.setMem_id(pwd_id); m.setMem_name(pwd_name);
		MemberVO pm=this.memberService.pwdMember(m);
		//아이디와 회원이름을 기준으로 디비로 부터 회원정보 검색
		if(pm==null) {
			out.println("<script>");
		out.println("alert('회원정보를 찾을 수 없습니다!');");
		out.println("history.back();");
		out.println("</script>");
		}else {
			Random r=new Random();
			int pwd_random=r.nextInt(100000);
			//임의의 정수 난수를 발생
String ran_pwd=Integer.toString(pwd_random);//임시 정수 비번
//을 문자열로 바꿈
m.setMem_pwd(PwdChange.getPassWordToXEMD5String(ran_pwd));
//임시 비번 암호화
this.memberService.updatePwd(m);//임시비번 수정

     fm.addAttribute("ran_pwd",ran_pwd);
     return "member/pwd_find_ok";
		}
		return null;
	}//pwd_find_ok()
	
	//로그인 인증
	@RequestMapping("/member_login_ok")
	public String member_login_ok(
			@RequestParam("login_id") String login_id,
			@RequestParam("login_pwd") String login_pwd,
			HttpServletResponse response,
			HttpServletRequest request)
	throws Exception{
	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out=response.getWriter();
	HttpSession session=request.getSession();
	
	MemberVO dm=this.memberService.login_check(login_id);
	//가입회원 1만 로그인되고,탈퇴회원 2는 로그인 인증못함.
	
	if(dm ==null) {
		out.println("<script>");
		out.println("alert('가입 안된 회원입니다!');");
		out.println("history.back();");
		out.println("</script>");
	}else {
		if(!dm.getMem_pwd().equals(
	PwdChange.getPassWordToXEMD5String(login_pwd))) {
			out.println("<script>");
			out.println("alert('비번이 다릅니다!');");
			out.println("history.go(-1);");
			out.println("</script>");
		}else {
			session.setAttribute("id",login_id);
			return "redirect:/index";//메인화면으로 이동
		}
	}
	return null;
	}//member_login_ok()
	
	//로그인 인증후 메인화면
	@RequestMapping("/index")
	public String index(HttpServletRequest request,
			HttpServletResponse response)
	throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		String id=(String)session.getAttribute("id");
		if(id==null) {
			out.println("<script>");
			out.println("alert('다시 로그인 하세요!');");
			out.println("location='member_login';");
			out.println("</script>");
		}else {
           return "member/member_login";
           // /WEB-INF/views/member/member_login.jsp 뷰페이지
           //로 이동.
		}
		return null;
	}//index()
	
	//로그아웃
	@RequestMapping("/member_logout")
	public String member_logout(
			HttpServletResponse response,
			HttpServletRequest request) throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		session.invalidate();//세션 만료
		
		out.println("<script>");
		out.println("alert('로그아웃 되었습니다!');");
		out.println("location='member_login';");
		out.println("</script>");
		
		return null;
	}//member_logout()
	
	//정보수정 폼
	@RequestMapping("/member_edit")
	public ModelAndView member_edit(
			HttpServletResponse response,
			HttpServletRequest request)
	throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		
		if(id == null) {
			out.println("<script>");
			out.println("alert('다시 로그인 하세요!');");
			out.println("location='member_login';");
			out.println("</script>");
		}else {
	String[] phone= {"010","011","019"};
	String[] email= {"naver.com","daum.net","nate.com",
					"google.com","직접입력"};
	MemberVO m=this.memberService.getMember(id);//오라클로 부
	//터 회원정보를 가져옴.
	
	ModelAndView em=new ModelAndView("member/member_edit");
	em.addObject("m",m);
	em.addObject("phone",phone); 
	em.addObject("email",email);
	return em;
		}
		return null;
	}//member_edit()
	
	//정보수정 완료
	@RequestMapping("/member_edit_ok")
	public String member_edit_ok(MemberVO m,
			HttpServletResponse response,
			HttpServletRequest request)
	throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		if(id==null) {
			out.println("<script>");
			out.println("alert('다시 로그인 하세요!');");
			out.println("location='member_login';");
			out.println("</script>");
		}else {
			m.setMem_id(id);
m.setMem_pwd(PwdChange.getPassWordToXEMD5String(
		m.getMem_pwd()));//정식비번 암호화
        this.memberService.updateMember(m);//정보수정
        /* 문제 풀이)
         * 1. 아이디를 기준으로 비번,이름,우편번호,주소,폰번호,
         * 전자멜주소를 수정되게 한다.
         */
        out.println("<script>");
        out.println("alert('정보 수정했습니다!');");
        out.println("location='member_edit';");
        out.println("</script>");
		}
		return null;
	}//member_edit_ok()
	
	//회원탈퇴 폼
	@RequestMapping("/member_del")
	public ModelAndView member_del(
			HttpServletRequest request,
			HttpServletResponse response)
	throws Exception{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        HttpSession session=request.getSession();
        String id=(String)session.getAttribute("id");
        if(id==null) {
        	out.println("<script>");
        	out.println("alert('다시 로그인 하세요!');");
        	out.println("location='member_login';");
        	out.println("</script>");
        }else {
        	MemberVO m=this.memberService.getMember(id);
        	ModelAndView dm=
        			new ModelAndView("member/member_del");
        	dm.addObject("m",m);
        	return dm;
        }
		return null;
	}//member_del()
	
	/*회원탈퇴 완료*/
	@RequestMapping("/member_del_ok")
	public String member_del_ok(
			HttpServletResponse response,
			HttpServletRequest request,
			@RequestParam("del_pwd") String del_pwd,
			@RequestParam("del_cont") String del_cont)
	throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		
		if(id == null) {
			out.println("<script>");
			out.println("alert('다시 로그인 하세요!');");
			out.println("location='member_login';");
			out.println("</script>");
		}else {
	del_pwd=PwdChange.getPassWordToXEMD5String(del_pwd);
	//비번을 암호화
	MemberVO db_pwd=this.memberService.getMember(id);
	if(!db_pwd.getMem_pwd().equals(del_pwd)) {
		out.println("<script>");
		out.println("alert('비번이 다릅니다!');");
		out.println("history.back();");
		out.println("</script>");
	}else {
		MemberVO dm=new MemberVO();
		dm.setMem_id(id); dm.setMem_delcont(del_cont);
		this.memberService.delMem(dm);//회원탈퇴
/* 문제풀이) 1. 아이디를 기준으로 탈퇴사유,mem_state=2,
 * mem_deldate 탈퇴날짜를 수정되게 한다.(update) 		
 */
		session.invalidate();//세션만료
		
		out.println("<script>");
		out.println("alert('회원 탈퇴 했습니다!');");
		out.println("location='member_login';");
		out.println("</script>");
	}
		}
		return null;
	}//member_del_ok()	
}






























































































































