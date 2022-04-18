package com.springlec.base0701.command;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.springlec.base0701.dao.BDao;


public class BListCommand implements BCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		//----
		BDao dao = sqlSession.getMapper(BDao.class);
		
		model.addAttribute("list", dao.listDao());
		
	}

}
