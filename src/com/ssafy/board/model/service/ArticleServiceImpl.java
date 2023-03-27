package com.ssafy.board.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.board.model.ArticleDto;
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
	public List<ArticleDto> BoardFindByAll() throws SQLException {
		return articleDao.BoardFindByAll();
	}

}
