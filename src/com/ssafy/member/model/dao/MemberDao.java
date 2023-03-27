package com.ssafy.member.model.dao;

import com.ssafy.member.model.MemberDto;

public interface MemberDao {

	MemberDto login(MemberDto member) throws Exception;
}
