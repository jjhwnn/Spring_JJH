package com.springlec.base0501;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping("studentOK")
	public String studentOK() {
		
		return "student/studentOK";
	}
	
	
	@RequestMapping("studentNG")
	public String studentNG() {
		
		return "student/studentNG";
	}
	
	@RequestMapping("studentConfirm")
	public String studentOK2(HttpServletRequest request) {
		
		// 리턴이 여러 조건에 따라 다를 경우 변수화하여 변수에 대입 후 마지막에 해당 변수를 넘겨주는 것이 좋
		String returnStatement = null;
		
		String id = request.getParameter("id");
		
		if(id.equals("abc")) {
			returnStatement = "studentOK";
		}else {
			returnStatement = "studentNG";
		}
		
		// redirect방식
		return "redirect:" + returnStatement;
	}
	
	
	
}
