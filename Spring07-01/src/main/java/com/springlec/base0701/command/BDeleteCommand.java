package com.springlec.base0701.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.springlec.base0701.dao.BDao;
import com.springlec.base0701.dao.BDao_;

public class BDeleteCommand implements BCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		BDao dao = sqlSession.getMapper(BDao.class);
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		
		dao.deleteDao(bId);

	}

}
