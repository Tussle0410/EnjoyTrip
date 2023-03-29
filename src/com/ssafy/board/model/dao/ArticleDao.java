package com.ssafy.board.model.dao;

import java.sql.SQLException;
import java.util.List;
import com.ssafy.board.model.ArticleDto;

public interface ArticleDao {
	
	List<ArticleDto> BoardFindByAll() throws SQLException;
	void writeArticle(ArticleDto articleDto) throws SQLException;
}
