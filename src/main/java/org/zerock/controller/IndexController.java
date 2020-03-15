package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	//index.jsp 메인화면으로 이동
	@RequestMapping("/main")
	public String index() {
		return "index";
	}//index()
}
