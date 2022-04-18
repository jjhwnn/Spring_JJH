package com.springlec.base0801.command;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.springlec.base0801.dao.IDao;

public class BListCommand implements BCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		// IDao의 데이터 가져오기
		IDao dao = sqlSession.getMapper(IDao.class); 
		model.addAttribute("list", dao.listDao());
		
	}

}
