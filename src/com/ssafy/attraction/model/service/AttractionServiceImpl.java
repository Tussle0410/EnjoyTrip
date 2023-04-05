package com.ssafy.attraction.model.service;


import java.util.List;

import com.ssafy.attraction.model.dao.AttractionDao;
import com.ssafy.attraction.model.dao.AttractionDaoImpl;
import com.ssafy.attraction.model.dto.AttractionDescDto;
import com.ssafy.attraction.model.dto.AttractionInfoDto;
import com.ssafy.attraction.model.dto.GugunDto;
import com.ssafy.attraction.model.dto.SidoDto;
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
	public List<GugunDto> gugunFindBySido(int sidoCode) throws Exception {
		return attractionDao.gugunFindBySido(sidoCode);
	}

	@Override
	public List<AttractionInfoDto> attractionFindByCode(int sidoCode, int gugunCode, int contentCode) throws Exception {
		return attractionDao.attractionFindByCode(sidoCode, gugunCode, contentCode);
	}

	@Override
	public AttractionDescDto tourViewDetail(int contentId) throws Exception {
		return attractionDao.tourViewDetail(contentId);
	}

}
