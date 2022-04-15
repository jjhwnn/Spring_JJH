package com.springlec.base0701.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.springlec.base0701dao.BDao;

public class BDeleteCommand implements BCommand {

	@Override
	public void execute(Model model) {
		
		BDao dao = new BDao();
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String bId = request.getParameter("bId");
		
		dao.delete(bId);

	}

}
