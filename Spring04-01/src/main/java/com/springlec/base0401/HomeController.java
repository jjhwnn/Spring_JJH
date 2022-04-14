package com.springlec.base0401;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

	// STS 3방식
	@RequestMapping("board/confirmId")
	public String confirmId(HttpServletRequest request,Model model) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "board/confirmId";
	}
	
//	// STS 4 방식 (사용자 로그인 할때 사용)
//	@RequestMapping("board/checkId")
//	public String checkId(@RequestParam("id") String id, @RequestParam("pw") int pw, Model model) {
//		
//		model.addAttribute("id", id);
//		model.addAttribute("pw", pw);
//		
//		return "board/contfirmId";
//	}
//	
//	@RequestMapping("member/join")
//	public String joinData(@RequestParam("name") String name,
//							@RequestParam("id") String id,
//							@RequestParam("pw") String pw,
//							@RequestParam("email") String email,
//							Model model) {
//		Member member = new Member();
//		member.setName(name);
//		member.setId(id);
//		member.setPw(pw);
//		member.setEmail(email);
//		
//		model.addAttribute("member", member);
//		
//		
//		return "member/join";
//	}

	@RequestMapping("member/join")
	public String joinData(Member member) {
		return "member/join";
	}
	
	@RequestMapping("student/{studentId}")
							// @PathVariable : url ?뒤에 밸류값만 입력해줘도 입력되게금 해줌
	public String getStudent(@PathVariable String studentId, Model model) {
		
		model.addAttribute("studentId", studentId);
		
		return "student/studentView";
	}
	
	
	@RequestMapping("login/loginForm")
	public String loginForm() {
		
		return "login/loginForm";
	}
	
//  //1번째 방식	
//	@RequestMapping("login/loginCheck")
//	public String loginCheck(HttpServletRequest request, Model model) {
//	
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		
//		model.addAttribute("id", id);
//		model.addAttribute("pw", pw);
//		
//		return "login/loginCheck";
//	}
	
//	// 2번째 방식	
//	@RequestMapping("login/loginCheck")
//	public String loginCheck(@RequestParam("id") String id,
//							@RequestParam("pw") String pw,
//							Model model){
//		
//		User user = new User();
//		
//		user.setId(id);
//		user.setPw(pw);
//		
//		model.addAttribute("user", user);
//		
//		return "login/loginCheck";
//	}
	
	@RequestMapping("/login/loginCheck")
							// loginForm의 입력받는 순서와 dto에 선언된 필드의 순서와 같아야 한다
	public String loginCheck(User user) {
		
		return "login/loginCheck";
	}
	
}
