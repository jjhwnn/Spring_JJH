package com.springlec.base0601.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BController {

	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		// -----
		
		return null;
	}
	
}
