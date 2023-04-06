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
import com.ssafy.board.model.ArticleReviewDto;
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
			sql.append("values(?, ?, ?, ?, ?, current_date(), ?) \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, articleDto.getTitle());
			pstmt.setString(2, articleDto.getContent());
			pstmt.setString(3, articleDto.getArticleCategory());
			pstmt.setString(4, articleDto.getEmail());
			pstmt.setInt(5, 0);
			pstmt.setInt(6, 0);
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}

	@Override
	public ArticleDto ArticleFindByNo(int article_no, String email) throws SQLException {
		ArticleDto result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select a.article_no, title, content, article_category, b.email, hit, registtime, heart, b.heart_code \n");
			sql.append("from article a left outer join article_heart b \n");
			sql.append("on a.article_no = b.article_no and b.email= ? \n");
			sql.append("where a.article_no = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, email);
			pstmt.setInt(2, article_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new ArticleDto();
				result.setArticleNo(rs.getInt("article_no"));
				result.setTitle(rs.getString("title"));
				result.setContent(rs.getString("content"));
				result.setArticleCategory(rs.getString("article_category"));
				result.setEmail(rs.getString("email"));
				result.setHit(rs.getInt("hit"));
				result.setRegistTime(rs.getDate("registtime"));
				result.setHeart(rs.getInt("heart"));
				if(rs.getString("heart_code") == null)
					result.setHeartFlag(false);
				else
					result.setHeartFlag(true);
			}
			return result;
		} catch(Exception e){
			e.printStackTrace();
			throw new SQLException("게시글 정보를 불러오는 중에 에러가 발생하였습니다.");
		}finally {
			dbUtil.close(rs, pstmt, conn);
		}

	}

	@Override
	public List<ArticleReviewDto> ReviewFindByNo(int article_no) throws SQLException {
		List<ArticleReviewDto> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select review_no, article_no, content, registtime, email \n");
			sql.append("from article_review where article_no = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, article_no);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ArticleReviewDto articleReviewDto = new ArticleReviewDto();
				articleReviewDto.setReviewNo(rs.getInt("review_no"));
				articleReviewDto.setArticleNo(rs.getInt("article_no"));
				articleReviewDto.setContent(rs.getString("content"));
				articleReviewDto.setRegisttime(rs.getDate("registtime"));
				articleReviewDto.setEmail(rs.getString("email"));
				result.add(articleReviewDto);
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return result;
	}

	@Override
	public void plusArticleHit(int article_no) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("update article set hit = hit+1 \n");
			sql.append("where article_no = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, article_no);
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}

	@Override
	public void writeReview(ArticleReviewDto reviewDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into article_review(article_no, content, email, registtime) \n");
			sql.append("values(?, ?, ?, current_date()) \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, reviewDto.getArticleNo());
			pstmt.setString(2, reviewDto.getContent());
			pstmt.setString(3, reviewDto.getEmail());
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}

	@Override
	public void heartUp(int article_no, String email) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into article_heart(article_no, email) value(?, ?) \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, article_no);
			pstmt.setString(2, email);
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
		
	}

	@Override
	public void headrDown(int article_no, String email) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("delete from article_heart \n");
			sql.append("where article_no = ? and email = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, article_no);
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}

	@Override
	public List<ArticleDto> BoardFindByCategory(String category) throws SQLException {
		List<ArticleDto> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select article_no, title, content, article_category, email, hit, registtime, heart \n");
			if(category.equals("전체"))
				sql.append("from article");
			else 
				sql.append("from article where article_category = ?");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			if(!category.equals("전체"))
				pstmt.setString(1, category);

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
	public void deleteArticle(int article_no) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("delete from article \n");
			sql.append("where article_no = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, article_no);
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}
}
