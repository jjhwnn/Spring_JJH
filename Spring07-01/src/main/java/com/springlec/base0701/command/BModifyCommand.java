package com.springlec.base0701.command;	

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.springlec.base0701.dao.BDao;
import com.springlec.base0701.dao.BDao_;

public class BModifyCommand implements BCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		BDao dao = sqlSession.getMapper(BDao.class);
		
		Map<String , Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		dao.modifyDao(bId, bName, bTitle, bContent);
		
	}

}
