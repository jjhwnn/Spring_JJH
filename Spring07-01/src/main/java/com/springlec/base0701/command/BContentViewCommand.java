package com.springlec.base0701.command;

import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.springlec.base0701.dto.BDto;
import com.springlec.base0701dao.BDao;

public class BContentViewCommand implements BCommand {

	@Override
	public void execute(Model model) {
		
		BDao dao = new BDao();
		BDto dto = new BDto();
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		int bId = Integer.parseInt(request.getParameter("bId"));

		dto = dao.contentView(bId);
		
		model.addAttribute("content_view", dto);
		
	}

}
