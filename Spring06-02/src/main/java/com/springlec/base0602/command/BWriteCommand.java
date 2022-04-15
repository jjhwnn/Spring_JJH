package com.springlec.base0602.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.springlec.base0602.dao.BDao;

public class BWriteCommand implements BCommand {

	private BDao dao = null;
	
	@Autowired
	public void setDao(BDao dao) {
		this.dao = dao;
	}
	
	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		dao.write(bName, bTitle, bContent);

	}

}
