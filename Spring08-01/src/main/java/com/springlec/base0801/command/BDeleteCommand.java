package com.springlec.base0801.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.springlec.base0801.dao.IDao;

public class BDeleteCommand implements BCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap(); // model의 메서드 암호화 풀어주는 메서드
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.deleteDao(Integer.parseInt(request.getParameter("mId")));

	}

}
