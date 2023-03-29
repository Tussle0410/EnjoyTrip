package com.ssafy.attraction.model.dao;

import java.sql.SQLException;
import java.util.List;
import com.ssafy.attraction.model.dto.AttractionInfoDto;
import com.ssafy.attraction.model.dto.GugunDto;
import com.ssafy.attraction.model.dto.SidoDto;

public interface AttractionDao {
	List<SidoDto> sidoFindByAll() throws SQLException;
	List<GugunDto> gugunFindBySido(int sidoCode) throws SQLException;
	List<AttractionInfoDto> attractionFindByCode(int sidoCode, int gugunCode, int contentCode) throws SQLException;
	
}
