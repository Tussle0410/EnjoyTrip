package com.ssafy.board.model.service;

import java.sql.SQLException;
import java.util.List;
import com.ssafy.board.model.ArticleDto;
import com.ssafy.board.model.ArticleImgDto;
import com.ssafy.board.model.ArticleReviewDto;
import com.ssafy.board.model.dao.ArticleDao;
import com.ssafy.board.model.dao.ArticleDaoImpl;
import com.ssafy.util.PaginationDto;

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
	public List<ArticleDto> BoardFindByAll(PaginationDto pageDto) throws Exception {
		return articleDao.BoardFindByAll(pageDto);
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
	public List<ArticleDto> BoardFindByCategory(String category, PaginationDto paginationDto) throws Exception {
		return articleDao.BoardFindByCategory(category, paginationDto);
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

	@Override
	public void plusArticleHeart(int article_no) throws SQLException {
		articleDao.plusArticleHeart(article_no);
		
	}

	@Override
	public void minusArticleHeart(int article_no) throws SQLException {
		articleDao.minusArticleHeart(article_no);
	}

	@Override
	public void uploadArticleImg(ArticleImgDto articleImgDto) throws Exception {
		articleDao.uploadArticleImg(articleImgDto);
		
	}

	@Override
	public List<ArticleImgDto> loadArticleImg(int article_no) throws Exception {
		return articleDao.loadArticleImg(article_no);
	}

	@Override
	public int articleCntFindByCode() throws Exception {
		return articleDao.articleCntFindByCode();
	}

	@Override
	public int articleCntFindByCategory(String category) throws Exception {
		return articleDao.articleCntFindByCategory(category);
	}

	@Override
	public int articleCntFindBytitle(String title) throws Exception {
		return articleDao.articleCntFindBytitle(title);
	}

	@Override
	public List<ArticleDto> BoardFindByTitle(String title, PaginationDto pageDto) throws Exception {
		// TODO Auto-generated method stub
		return articleDao.BoardFindByTitle(title, pageDto);
	}

}
