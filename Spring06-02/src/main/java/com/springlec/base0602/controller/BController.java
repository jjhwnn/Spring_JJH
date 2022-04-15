package com.springlec.base0602.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base0602.command.BCommand;
import com.springlec.base0602.command.BContentViewCommand;
import com.springlec.base0602.command.BDeleteCommand;
import com.springlec.base0602.command.BListCommand;
import com.springlec.base0602.command.BModifyCommand;
import com.springlec.base0602.command.BWriteCommand;
import com.springlec.base0602.dto.BDto;



@Controller
public class BController {

	BCommand command = null;
	private BCommand listCommand = null;
	private BCommand writeCommand = null;
	private BCommand contentCommand = null;
	private BCommand modifyCommand = null;
	private BCommand deleteCommand = null;
	
	@Autowired
	public void auto(BCommand list, BCommand write, BCommand content, BCommand modify, BCommand delete) {
		this.listCommand = list;
		this.writeCommand = write;
		this.contentCommand  = content;
		this.modifyCommand = modify;
		this.deleteCommand = delete;
	}
	
	
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		// -----
		listCommand.execute(model);
		
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String writeForm() {
		
		return "write_view";
	}

	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		writeCommand.execute(model);
		
		return "redirect:list";
	}
	 
	
	@RequestMapping("/content_view")
	public String contentView(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		contentCommand.execute(model);

		return "content_view";
	}
	
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		modifyCommand.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping String delete(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		deleteCommand.execute(model);
		
		
		return "redirect:list";
	}
	
	
	
	
	
}
