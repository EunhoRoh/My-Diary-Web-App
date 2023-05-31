package com.mycom.myapp.board;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
//애플리케이션의 홈 페이지 요청을 처리하는 역할을 합니다

@Controller
public class HomeController {
	//Logger를 사용하여 클라이언트의 로케일 정보를 로그로 출력
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//"/" 경로로 GET 요청이 들어오면 실행되며
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		//현재 시간을 가져와서 home.html에 전달
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		//현재 시간을 포맷팅하여 "serverTime"이라는 속성으로 모델에 추가
		model.addAttribute("serverTime", formattedDate );
		// "home"이라는 뷰 페이지를 렌더링
		return "home";
	}
	
}