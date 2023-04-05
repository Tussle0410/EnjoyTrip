package com.ssafy.board.model.service;

import java.sql.SQLException;
import java.util.List;
import com.ssafy.board.model.ArticleDto;
import com.ssafy.board.model.ArticleReviewDto;

public interface ArticleService {

	List<ArticleDto> BoardFindByAll() throws Exception;
	void writeArticle(ArticleDto articleDto) throws Exception;
	ArticleDto ArticleFindByNo(int article_no) throws Exception;
	List<ArticleReviewDto> ReviewFindByNo(int article_no) throws Exception;
	void plusArticleHit(int article_no) throws Exception;
	void writeReview(ArticleReviewDto reviewDto) throws Exception;
	void heartUp(int article_no, String email) throws Exception;
	void headrDown(int article_no, String email) throws Exception;
	List<ArticleDto> BoardFindByCategory(String category) throws Exception;
	void deleteArticle(int article_no) throws Exception;
}
