package com.ssafy.board.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.board.model.ArticleDto;

public interface ArticleService {

	List<ArticleDto> BoardFindByAll() throws Exception;
	void writeArticle(ArticleDto articleDto) throws Exception;
}
