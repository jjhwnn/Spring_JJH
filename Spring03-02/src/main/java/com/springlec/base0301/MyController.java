package com.springlec.base0301;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	@RequestMapping("/content")
	public String content(Model model) {
		model.addAttribute("id", "tester");
		
		return "content";
	}
}
