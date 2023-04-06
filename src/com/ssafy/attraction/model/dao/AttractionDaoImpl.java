package com.ssafy.attraction.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.attraction.model.dto.AttractionDescDto;
import com.ssafy.attraction.model.dto.AttractionInfoDto;
import com.ssafy.attraction.model.dto.GugunDto;
import com.ssafy.attraction.model.dto.SidoDto;
import com.ssafy.board.model.ArticleDto;
import com.ssafy.board.model.dao.ArticleDao;
import com.ssafy.board.model.dao.ArticleDaoImpl;
import com.ssafy.util.DBUtil;
import com.ssafy.util.PaginationDto;

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
	public List<GugunDto> gugunFindBySido(int sidoCode) throws SQLException {
		List<GugunDto> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from gugun where sido_code = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, sidoCode);
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

	@Override
	public List<AttractionInfoDto> attractionFindByCode(int sidoCode, int gugunCode, int contentCode, PaginationDto pageDto) throws SQLException {
		List<AttractionInfoDto> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int currentPage = pageDto.getCurrentPage();
		int maxViewCnt = pageDto.getMaxViewCnt();
		int startIdx = (currentPage-1) * maxViewCnt;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from attraction_info \n");
			sql.append("where sido_code= ? and gugun_code = ? and content_type_id = ? \n");
			sql.append("limit ? offset ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, sidoCode);
			pstmt.setInt(2, gugunCode);
			pstmt.setInt(3, contentCode);
			pstmt.setInt(4, maxViewCnt);
			pstmt.setInt(5, startIdx);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				AttractionInfoDto attractionInfoDto = new AttractionInfoDto();
				attractionInfoDto.setContentId(rs.getInt("content_id"));
				attractionInfoDto.setContentTypeId(rs.getInt("content_type_id"));
				attractionInfoDto.setTitle(rs.getString("title"));
				attractionInfoDto.setAddr1(rs.getString("addr1"));
				attractionInfoDto.setAddr2(rs.getString("addr2"));
				attractionInfoDto.setZipcode(rs.getString("zipcode"));
				attractionInfoDto.setTel(rs.getString("tel"));
				attractionInfoDto.setFirstImage(rs.getString("first_image"));
				attractionInfoDto.setFirstImage2(rs.getString("first_image2"));
				attractionInfoDto.setReadCount(rs.getInt("readcount"));
				attractionInfoDto.setSidoCode(rs.getInt("sido_code"));
				attractionInfoDto.setGugunCode(rs.getInt("gugun_code"));
				attractionInfoDto.setLatitude(rs.getDouble("latitude"));
				attractionInfoDto.setLongitude(rs.getDouble("longitude"));
				attractionInfoDto.setMlevel(rs.getString("mlevel"));
				result.add(attractionInfoDto);
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
	public AttractionDescDto tourViewDetail(int contentId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AttractionDescDto result = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from attraction_description \n");
			sql.append("where content_id = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, contentId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new AttractionDescDto();
				result.setContentId(rs.getInt("content_id"));
				result.setHomepage(rs.getString("homepage"));
				result.setOverview(rs.getString("overview"));
				result.setTelname(rs.getString("telname"));
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
	public int attractionTotalCntFindByCode(int sidoCode, int gugunCode, int contentCode) throws SQLException {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select count(*) as totalCnt \n");
			sql.append("from attraction_info \n");
			sql.append("where sido_code=? and gugun_code=? and content_type_id=?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, sidoCode);
			pstmt.setInt(2, gugunCode);
			pstmt.setInt(3, contentCode);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("totalCnt");
			}

		}catch(Exception e){
			e.printStackTrace();
			throw new SQLException("관광지의 총 개수를 불러오는데 실패했습니다.");
		}finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return result;
	}
}
