package com.springlec.base0801;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springlec.base0801.command.BCommand;
import com.springlec.base0801.command.BDeleteCommand;
import com.springlec.base0801.command.BListCommand;
import com.springlec.base0801.command.BWriteCommand;
import com.springlec.base0801.dao.IDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	// ---------
	@Autowired
	private SqlSession sqlSession;
	
	private BCommand list = null;
	private BCommand write = null;
	private BCommand delete = null;
	
	@Autowired
	public void auto(BCommand list, BCommand write, BCommand delete) {
		this.list = list;
		this.write = write;
		this.delete = delete;
	}

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		
		list.execute(sqlSession, model);
	
		return "/list";
	}
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		
		return "/writeForm";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		write.execute(sqlSession, model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
	
		model.addAttribute("request", request);
		
		delete.execute(sqlSession, model);
	
		return "redirect:list";
	}
	
	
	
	
	
	
	
	
}
