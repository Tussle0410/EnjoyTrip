package com.ssafy.board.model.service;

import java.util.List;
import com.ssafy.board.model.ArticleDto;
import com.ssafy.board.model.ArticleReviewDto;

public interface ArticleService {

	List<ArticleDto> BoardFindByAll() throws Exception;
	void writeArticle(ArticleDto articleDto) throws Exception;
	ArticleDto ArticleFindByNo(int article_no) throws Exception;
	List<ArticleReviewDto> ReviewFindByNo(int article_no) throws Exception;
}
