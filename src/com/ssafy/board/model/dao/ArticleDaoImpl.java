package com.ssafy.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.ArticleDto;
import com.ssafy.util.DBUtil;

public class ArticleDaoImpl implements ArticleDao{
	private DBUtil dbUtil;
	private static ArticleDao instance;
	
	private ArticleDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}
	
	public static ArticleDao getInstance() {
		if(instance == null)
			return new ArticleDaoImpl();
		else
			return instance;
	}
	
	@Override
	public List<ArticleDto> BoardFindByAll() throws SQLException {
		List<ArticleDto> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from article");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ArticleDto articleDto = new ArticleDto();
				articleDto.setArticleNo(rs.getInt("article_no"));
				articleDto.setTitle(rs.getString("title"));
				articleDto.setContent(rs.getString("content"));
				articleDto.setArticleCategory(rs.getString("article_category"));
				articleDto.setEmail(rs.getString("email"));
				articleDto.setHit(rs.getInt("hit"));
				articleDto.setRegistTime(rs.getDate("registtime"));
				articleDto.setLike(rs.getInt("like"));
				result.add(articleDto);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new SQLException("게시글을 불러오는 중에 오류가 발생하였습니다.");
		}finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return result;
	}

}
