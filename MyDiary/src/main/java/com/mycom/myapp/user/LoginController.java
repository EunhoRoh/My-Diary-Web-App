package com.mycom.myapp.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//로그인과 로그아웃 기능을 구현한 컨트롤러
@Controller 
@RequestMapping(value="/login") 
public class LoginController {
	
	@Autowired
	UserDAO userDAO;
	
	//"/login" 경로를 기준으로 매핑되며, login() 메소드는 GET 요청이 들어오면 "login"을 반환하여 로그인 페이지를 보여줍니다.
	@RequestMapping(value = "/login", method = RequestMethod.GET) 
	public String login() {
		// 로그인 페이지를 보여주기 위해 "login"을 반환합니다.
		return "login"; 
	}
	
	@RequestMapping(value="/loginOk", method = RequestMethod.POST)
	//loginCheck() 메소드는 로그인을 처리하고 성공 또는 실패에 따라 적절한 동작을 수행합니다.
	public String loginCheck(HttpSession session, UserVO vo) {
		String returnURL = "";
		
		if (session.getAttribute("login") != null) {
			session.removeAttribute("login");
		}
		
		UserVO loginvo = userDAO.getUser(vo); 
		if (loginvo != null) { 
			//만약 로그인에 성공하면 세션에 로그인 정보를 저장하고 "/list"로 리다이렉트합니다.
			// 로그인 성공 
			System.out.println("로그인 성공!");
			session.setAttribute("login", loginvo);
			returnURL = "redirect:/list"; 
		} 
		else {
			// 로그인 실패
			//로그인에 실패하면 다시 로그인 페이지로 리다이렉트합니다
			System.out.println("로그인 실패!");
			returnURL = "redirect:/login/login";
		}
		
		return returnURL; 
	}
	
	// 로그아웃 하는 부분 
	//logout() 메소드는 로그아웃을 처리하고 세션을 무효화한 후 로그인 페이지로 리다이렉트
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		// 로그아웃 후 로그인 페이지로 리다이렉트합니다.
		return "redirect:/login/login"; 
	}
}