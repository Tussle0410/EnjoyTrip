package com.ssafy.member.model.service;

import com.ssafy.member.model.MemberDto;

public interface MemberService {

	MemberDto login(MemberDto member) throws Exception;
	void regist(MemberDto member) throws Exception;
	void edit(MemberDto member) throws Exception;
}
