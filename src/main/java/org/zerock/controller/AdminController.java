package org.zerock.controller;

import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.domain.AdminVO;
import org.zerock.service.AdminService;

import pwdconv.PwdChange;

@Controller //관리자 컨트롤러 애너테이션
public class AdminController {

	@Inject
	private AdminService adminService;
	
	//관리자 로그인 폼*/
	@RequestMapping("/admin_index")
	public ModelAndView admin_index() {
		return new ModelAndView("admin/admin_index");
// /WEB-INF/views/admin/admin_index.jsp		
	}
	
	//관리자 로그인 인증과 관리자 비번 암호화 */
	@RequestMapping("/admin_login_ok")
	public String admin_login_ok(
			@ModelAttribute AdminVO  ab,
			HttpServletResponse response,
			HttpServletRequest request,
			HttpSession session) throws Exception{
		response.setContentType("text/html;charset=UTF-8");
//웹브라우저로 출력되는 파일형태와 언어코딩 타입을 지정
		PrintWriter out=response.getWriter();
		session=request.getSession();//세션객체 생성
		
		ab.setAdmin_pwd(
PwdChange.getPassWordToXEMD5String(ab.getAdmin_pwd()));
//관리자 비번 암호화
		//ab.setAdmin_name("관리자");
		//this.adminService.insertAdmin(ab);//관리자 아이디,
//비번,관리자 이름 저장	
AdminVO admin_pwd=
this.adminService.adminLogin(ab.getAdmin_id());//관리자 아이디
//를 기준으로 관리자 비번을 가져옴.
        if(admin_pwd  == null) {
        	out.println("<script>");
        	out.println("alert('관리자 정보가 없습니다!');");
        	out.println("history.go(-1);");
        	out.println("</script>");
        }else {
         if(!admin_pwd.getAdmin_pwd().equals(
        		 ab.getAdmin_pwd())) {
        	 out.println("<script>");
        	 out.println("alert('관리자 비번이 다릅니다!');");
        	 out.println("history.back();");
        	 out.println("</script>");
         }else {
       	 session.setAttribute("admin_id",ab.getAdmin_id());
       	 //admin_id 세션키이름에 아이디를 저장
       	 session.setAttribute("admin_name",
       			 admin_pwd.getAdmin_name());
       	 //관리자 이름을 저장
       	 return "redirect:/admin_main";//관리자 메인화면으로
       	 //이동
         }
        }
		return null;
	}//admin_login_ok()
	
	//관리자 메인
    @RequestMapping("/admin_main")
    public String admin_main(
	HttpServletResponse response,
	HttpServletRequest request,
	HttpSession session) throws Exception{
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out=response.getWriter();
    session=request.getSession();//세션 객체 생성
    
    String admin_id=(String)session.getAttribute("admin_id");
    //관리자 세션 아이디는 Object 타입으로 반환된다. 다운캐스팅
    if(admin_id == null) {
    	out.println("<script>");
    	out.println("alert('다시 로그인 하세요!');");
        out.println("location='admin_index';");
        out.println("</script>");
    }else {
    	return "admin/admin_main";//WEB-INF/admin/admin_main
    	//.jsp로 이동
    }
    return null;
    }//admin_main()
    
    //관리자 로그아웃
    @RequestMapping("/admin_logout")
    public String admin_logout(
    		HttpServletResponse response,
    		HttpServletRequest request)
    throws Exception{
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out=response.getWriter();
    	HttpSession session=request.getSession();
    	
    	session.invalidate();//세션 만료
    	
    	out.println("<script>");
    	out.println("alert('관리자 로그아웃 되었습니다');");
    	out.println("location='admin_index';");
    	out.println("</script>");
    	
    	return null;
    }
}





































































