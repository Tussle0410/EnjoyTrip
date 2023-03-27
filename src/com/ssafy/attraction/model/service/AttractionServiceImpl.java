package com.ssafy.attraction.model.service;


import java.util.List;

import com.ssafy.attraction.model.dao.AttractionDao;
import com.ssafy.attraction.model.dao.AttractionDaoImpl;
import com.ssafy.attraction.model.dto.GugunDto;
import com.ssafy.attraction.model.dto.SidoDto;
import com.ssafy.board.model.dao.ArticleDao;
import com.ssafy.board.model.dao.ArticleDaoImpl;
import com.ssafy.util.DBUtil;

public class AttractionServiceImpl implements AttractionService{
	
	private AttractionDao attractionDao;
	private static AttractionService instance;
	
	private AttractionServiceImpl() {
		attractionDao = AttractionDaoImpl.getInstance();
	}
	
	public static AttractionService getInstance() {
		if(instance == null)
			return new AttractionServiceImpl();
		else
			return instance;
	}
	
	
	@Override
	public List<SidoDto> sidoFindByAll() throws Exception {
		return attractionDao.sidoFindByAll();
	}

	@Override
	public List<GugunDto> gugunFindBySido(SidoDto sidoDto) throws Exception {
		return attractionDao.gugunFindBySido(sidoDto);
	}

}
