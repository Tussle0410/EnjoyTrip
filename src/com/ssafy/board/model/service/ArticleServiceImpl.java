package com.ssafy.board.model.service;

import java.util.List;
import com.ssafy.board.model.ArticleDto;
import com.ssafy.board.model.ArticleReviewDto;
import com.ssafy.board.model.dao.ArticleDao;
import com.ssafy.board.model.dao.ArticleDaoImpl;

public class ArticleServiceImpl implements ArticleService{
	
	private static ArticleService articleService = new ArticleServiceImpl();
	private static ArticleDao articleDao;
	
	public static ArticleService getBoardService() {
		return articleService;
	}
	
	public ArticleServiceImpl() {
		articleDao = ArticleDaoImpl.getInstance();
	}

	@Override
	public List<ArticleDto> BoardFindByAll() throws Exception {
		return articleDao.BoardFindByAll();
	}

	@Override
	public void writeArticle(ArticleDto articleDto) throws Exception {
		articleDao.writeArticle(articleDto);
	}

	@Override
	public ArticleDto ArticleFindByNo(int article_no, String email) throws Exception {
		return articleDao.ArticleFindByNo(article_no, email);
	}

	@Override
	public List<ArticleReviewDto> ReviewFindByNo(int article_no) throws Exception {
		return articleDao.ReviewFindByNo(article_no);
	}

	@Override
	public void plusArticleHit(int article_no) throws Exception {
		articleDao.plusArticleHit(article_no);
		
	}

	@Override
	public void writeReview(ArticleReviewDto reviewDto) throws Exception {
		articleDao.writeReview(reviewDto);
		
	}

	@Override
	public List<ArticleDto> BoardFindByCategory(String category) throws Exception {
		return articleDao.BoardFindByCategory(category);
	}

	@Override
	public void deleteArticle(int article_no) throws Exception {
		articleDao.deleteArticle(article_no);
	}

	@Override
	public void heartUp(int article_no, String email) throws Exception {
		articleDao.heartUp(article_no, email);
		
	}

	@Override
	public void headrDown(int article_no, String email) throws Exception {
		articleDao.headrDown(article_no, email);
	}

}
