package com.springlec.base0701.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.springlec.base0701.dto.BDto;
import com.springlec.base0701dao.BDao;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {
		
		//----
		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
		
		model.addAttribute("list", dtos);
		
	}

}
