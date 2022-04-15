package com.springlec.base0701.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base0701.command.BCommand;
import com.springlec.base0701.command.BContentViewCommand;
import com.springlec.base0701.command.BDeleteCommand;
import com.springlec.base0701.command.BListCommand;
import com.springlec.base0701.command.BModifyCommand;
import com.springlec.base0701.command.BWriteCommand;
import com.springlec.base0701.dto.BDto;
import com.springlec.base0701.util.Constant;

@Controller
public class BController {

	BCommand command = null;
	
	// JDBC
	private JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	
	@RequestMapping("/list")
	public String list(Model model) {

		command = new BListCommand();
		command.execute(model);

		return "list";
	}
	
	@RequestMapping("/write_view")
	public String writeForm() {
		
		return "write_view";
	}

	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		command = new BWriteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	 
	
	@RequestMapping("/content_view")
	public String contentView(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		command = new BContentViewCommand();
		command.execute(model);

		return "content_view";
	}
	
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		command = new BModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping String delete(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		command = new BDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	
	
	
	
}
