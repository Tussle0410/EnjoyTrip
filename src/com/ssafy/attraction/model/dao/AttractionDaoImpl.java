package com.ssafy.attraction.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.attraction.model.dto.GugunDto;
import com.ssafy.attraction.model.dto.SidoDto;
import com.ssafy.board.model.ArticleDto;
import com.ssafy.board.model.dao.ArticleDao;
import com.ssafy.board.model.dao.ArticleDaoImpl;
import com.ssafy.util.DBUtil;

public class AttractionDaoImpl implements AttractionDao {

	private DBUtil dbUtil;
	private static AttractionDao instance;
	
	private AttractionDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}
	
	public static AttractionDao getInstance() {
		if(instance == null)
			return new AttractionDaoImpl();
		else
			return instance;
	}
	@Override
	public List<SidoDto> sidoFindByAll() throws SQLException {
		List<SidoDto> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from sido");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SidoDto sidoDto = new SidoDto();
				sidoDto.setSidoCode(rs.getInt("sido_code"));
				sidoDto.setSidoName(rs.getString("sido_name"));
				result.add(sidoDto);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new SQLException("시도를 불러오는 중에 오류가 발생하였습니다.");
		}finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return result;
	}

	@Override
	public List<GugunDto> gugunFindBySido(SidoDto sidoDto) throws SQLException {
		List<GugunDto> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from sido where sido_code = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, sidoDto.getSidoCode());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GugunDto gugunDto = new GugunDto();
				gugunDto.setGugunCode(rs.getInt("gugun_code"));
				gugunDto.setGugunName(rs.getString("gugun_name"));
				gugunDto.setSidoCode(rs.getInt("sido_code"));
				result.add(gugunDto);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new SQLException("시도를 불러오는 중에 오류가 발생하였습니다.");
		}finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return result;
	}
}
