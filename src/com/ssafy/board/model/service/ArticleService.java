package com.ssafy.board.model.service;

import java.sql.SQLException;
import java.util.List;
import com.ssafy.board.model.ArticleDto;
import com.ssafy.board.model.ArticleImgDto;
import com.ssafy.board.model.ArticleReviewDto;
import com.ssafy.util.PaginationDto;

public interface ArticleService {

	List<ArticleDto> BoardFindByAll(PaginationDto pageDto) throws Exception;
	void writeArticle(ArticleDto articleDto) throws Exception;
	ArticleDto ArticleFindByNo(int article_no, String email) throws Exception;
	List<ArticleReviewDto> ReviewFindByNo(int article_no) throws Exception;
	void plusArticleHit(int article_no) throws Exception;
	void writeReview(ArticleReviewDto reviewDto) throws Exception;
	void heartUp(int article_no, String email) throws Exception;
	void headrDown(int article_no, String email) throws Exception;
	List<ArticleDto> BoardFindByCategory(String category, PaginationDto paginationDto) throws Exception;
	void deleteArticle(int article_no) throws Exception;
	void plusArticleHeart(int article_no) throws Exception;
	void minusArticleHeart(int article_no) throws Exception;
	void uploadArticleImg(ArticleImgDto articleImgDto) throws Exception;
	List<ArticleImgDto> loadArticleImg(int article_no) throws Exception;
	int articleCntFindByCode() throws Exception;
	int articleCntFindByCategory(String category) throws Exception;
	int articleCntFindBytitle(String title) throws Exception;
	List<ArticleDto> BoardFindByTitle(String title, PaginationDto pageDto) throws Exception;
}
