package com.ssafy.attraction.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.attraction.model.dto.GugunDto;
import com.ssafy.attraction.model.dto.SidoDto;

public interface AttractionService {
	List<SidoDto> sidoFindByAll() throws Exception;
	List<GugunDto> gugunFindBySido(SidoDto sidoDto) throws Exception;
}
