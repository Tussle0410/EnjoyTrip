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
	public ArticleDto ArticleFindByNo(int article_no) throws Exception {
		return articleDao.ArticleFindByNo(article_no);
	}

	@Override
	public List<ArticleReviewDto> ReviewFindByNo(int article_no) throws Exception {
		return articleDao.ReviewFindByNo(article_no);
	}

}
