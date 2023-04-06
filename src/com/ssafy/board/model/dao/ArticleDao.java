package com.ssafy.board.model.dao;

import java.sql.SQLException;
import java.util.List;
import com.ssafy.board.model.ArticleDto;
import com.ssafy.board.model.ArticleImgDto;
import com.ssafy.board.model.ArticleReviewDto;
import com.ssafy.util.PaginationDto;

public interface ArticleDao {
	
	List<ArticleDto> BoardFindByAll(PaginationDto pageDto) throws SQLException;
	void writeArticle(ArticleDto articleDto) throws SQLException;
	ArticleDto ArticleFindByNo(int article_no, String email) throws SQLException;
	List<ArticleReviewDto> ReviewFindByNo(int article_no) throws SQLException;
	void plusArticleHit(int article_no) throws SQLException;
	void writeReview(ArticleReviewDto reviewDto) throws SQLException;
	void heartUp(int article_no, String email) throws SQLException;
	void headrDown(int article_no, String email) throws SQLException;
	List<ArticleDto> BoardFindByCategory(String category, PaginationDto paginationDto) throws SQLException;
	void deleteArticle(int article_no) throws SQLException;
	void plusArticleHeart(int article_no) throws SQLException;
	void minusArticleHeart(int article_no) throws SQLException;
	void uploadArticleImg(ArticleImgDto articleImgDto) throws SQLException;
	List<ArticleImgDto> loadArticleImg(int article_no) throws SQLException;
	int articleCntFindByCode() throws SQLException;
	int articleCntFindByCategory(String category) throws SQLException;
	int articleCntFindBytitle(String title) throws SQLException;
	List<ArticleDto> BoardFindByTitle(String title, PaginationDto pageDto) throws SQLException;
}
