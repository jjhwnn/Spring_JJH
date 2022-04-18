package com.springlec.base0701.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
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

	SqlSession sqlSession;
	
	BCommand command = null;
	private BCommand list = null;
	private BCommand contentView = null;
	private BCommand write = null;
	private BCommand modify = null;
	private BCommand delete = null;
	
	@Autowired
	public void auto(BCommand list, BCommand contentView, BCommand write, BCommand modify, BCommand delete) {
		this.list = list;
		this.contentView = contentView;
		this.write = write;
		this.modify = modify;
		this.delete = delete;
	}
	
	// JDBC
	private JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	
	@RequestMapping("/list")
	public String list(Model model) {

		list.execute(sqlSession, model);

		return "list";
	}
	
	@RequestMapping("/write_view")
	public String writeForm() {
		
		return "write_view";
	}

	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		write.execute(sqlSession, model);
		return "redirect:list";
	}
	 
	
	@RequestMapping("/content_view")
	public String contentView(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		contentView.execute(sqlSession, model);
		
		return "content_view";
	}
	
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		modify.execute(sqlSession, model);
		
		return "redirect:list";
	}
	
	@RequestMapping String delete(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		delete.execute(sqlSession, model);
		
		return "redirect:list";
	}
	
	
	
	
	
}
