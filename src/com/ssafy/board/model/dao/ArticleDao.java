package com.ssafy.board.model.dao;

import java.sql.SQLException;
import java.util.List;
import com.ssafy.board.model.ArticleDto;
import com.ssafy.board.model.ArticleReviewDto;

public interface ArticleDao {
	
	List<ArticleDto> BoardFindByAll() throws SQLException;
	void writeArticle(ArticleDto articleDto) throws SQLException;
	ArticleDto ArticleFindByNo(int article_no) throws SQLException;
	List<ArticleReviewDto> ReviewFindByNo(int article_no) throws SQLException;
	void plusArticleHit(int article_no) throws SQLException;
	void writeReview(ArticleReviewDto reviewDto) throws SQLException;
	void heartUp(int article_no, String email) throws SQLException;
	void headrDown(int article_no, String email) throws SQLException;
}
