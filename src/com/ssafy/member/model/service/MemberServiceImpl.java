package com.ssafy.member.model.service;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.dao.MemberDao;
import com.ssafy.member.model.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService {
	
	private static MemberService memberService = new MemberServiceImpl();
	
	public static MemberService getMemberService() {
		return memberService;
	}
	
	private static MemberDao memberDao;
	
	public MemberServiceImpl() {
		memberDao = MemberDaoImpl.getMemberDao();
	}
	
	@Override
	public MemberDto login(MemberDto member) throws Exception {
		return memberDao.login(member);
	}

}
