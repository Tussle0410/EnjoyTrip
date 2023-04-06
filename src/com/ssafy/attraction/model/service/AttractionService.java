package com.ssafy.attraction.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.attraction.model.dto.AttractionDescDto;
import com.ssafy.attraction.model.dto.AttractionInfoDto;
import com.ssafy.attraction.model.dto.GugunDto;
import com.ssafy.attraction.model.dto.SidoDto;
import com.ssafy.util.PaginationDto;

public interface AttractionService {
	List<SidoDto> sidoFindByAll() throws Exception;
	List<GugunDto> gugunFindBySido(int sidoCode) throws Exception;
	List<AttractionInfoDto> attractionFindByCode(int sidoCode, int gugunCode, int contentCode, PaginationDto pageDto) throws Exception;
	AttractionDescDto tourViewDetail(int contentId) throws Exception;
	int attractionTotalCntFindByCode(int sidoCode, int gugunCode, int contentCode) throws Exception;
}
