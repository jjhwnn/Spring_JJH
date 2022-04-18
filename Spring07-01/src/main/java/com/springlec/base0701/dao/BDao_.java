package com.springlec.base0701.dao;

import java.beans.BeanProperty;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.springlec.base0701.dto.BDto;
import com.springlec.base0701.util.Constant;

public class BDao_ {

	JdbcTemplate template;
	
	public BDao_() {
		
		this.template = Constant.template;
		
	}
	
	public ArrayList<BDto> list() {

		String query = "select bId, bName, bTitle, bContent, bDate from mvc_board";
		
		ArrayList<BDto> dtos = (ArrayList<BDto>)template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
		
		return dtos;
	}
					
					//데이터를 바꾸지 않게 하기 위해ㅐ final로 설정
	public void write(final String bName, final String bTitle, final String bContent) {
		
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				String query = "insert into mvc_board(bName, bTitle, bContent, bDate) values(?, ?, ?, now())";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContent);
				return pstmt;
			}
		});

	}

	public BDto contentView(int strID) {
		
		String query = "select * from mvc_board where bId = " + strID;
		
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
		
	}

	public void modify(final String bId, final String bName, final String bTitle, final String bContent) {
		
		String query = "update mvc_board set bName=?, bTitle=?, bContent=? where bId=? ";
		
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setInt(4, Integer.parseInt(bId));
			}
		});

	}

	public void delete(final String bId) {
		
		String query = "delete from mvc_board where bId = ?";
		
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(bId));
				
			}
		});
		
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			String query = "delete from mvc_board where bId = ?";
//			
//			preparedStatement = connection.prepareStatement(query);
//			
//			preparedStatement.setInt(1, Integer.parseInt(bId));
//			
//			preparedStatement.executeUpdate();
//			
//			
//
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			
//			try {
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//			
//		}
//		
	}
	


	
	
} // end
