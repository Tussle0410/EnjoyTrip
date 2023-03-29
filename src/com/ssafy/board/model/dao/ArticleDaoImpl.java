package com.ssafy.board.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
			sql.append("select article_no, title, content, article_category, email, hit, registtime, heart \n");
			sql.append("from article");
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
				articleDto.setHeart(rs.getInt("heart"));
				result.add(articleDto);
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return result;
	}

	@Override
	public void writeArticle(ArticleDto articleDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into article(title, content, article_category, email, hit, registtime, heart) \n");
			sql.append("values(?, ?, ?, ?, ?, ?, ?) \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, articleDto.getTitle());
			pstmt.setString(2, articleDto.getContent());
			pstmt.setString(3, articleDto.getArticleCategory());
			pstmt.setString(4, articleDto.getEmail());
			pstmt.setInt(5, 0);
//			pstmt.setDate(6, new java.sql.Date(new Date().getDate()));
			pstmt.setInt(7, 0);
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}

}
