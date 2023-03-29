package com.ssafy.member.model.dao;

import java.sql.SQLException;

import com.ssafy.member.model.MemberDto;

public interface MemberDao {

	MemberDto login(MemberDto member) throws SQLException;
	void regist(MemberDto member) throws SQLException;
	void edit(MemberDto member) throws SQLException;
}
