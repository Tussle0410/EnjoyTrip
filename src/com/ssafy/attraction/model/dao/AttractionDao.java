package com.ssafy.attraction.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.attraction.model.dto.GugunDto;
import com.ssafy.attraction.model.dto.SidoDto;

public interface AttractionDao {
	List<SidoDto> sidoFindByAll() throws SQLException;
	List<GugunDto> gugunFindBySido(SidoDto sidoDto) throws SQLException;
	
}
