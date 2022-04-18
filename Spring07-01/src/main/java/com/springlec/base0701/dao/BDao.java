package com.springlec.base0701.dao;

import java.util.ArrayList;

import com.springlec.base0701.dto.BDto;

public interface BDao {
	
	public ArrayList<BDto> listDao();
	
	public BDto contentViewDao(int bId);
	
	public void writeDao(String bName, String bTitle, String bContent);
	
	public void modifyDao(int bId, String bName, String bTitle, String bContent);
	
	public void deleteDao(int bId);
	
}
