package com.ssafy.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;
import com.ssafy.member.model.service.MemberServiceImpl;

@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static MemberService memberService;
      
	@Override
	public void init() throws ServletException {
		super.init();
		memberService = MemberServiceImpl.getMemberService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		String path = "";
		if("login".equals(action)) {
			path = login(request, response);
			forward(request, response, path);
		} else if("logout".equals(action)) {
			path = logout(request, response);
			redirect(request, response, path);
		} else if("regist".equals(action)) {
			path = regist(request, response);
			redirect(request, response, path);
		} else if("edit".equals(action)) {
			path = edit(request, response);
			forward(request, response, path);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
	private void forward(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		response.sendRedirect(request.getContextPath() + path);
	}

	private String login(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		MemberDto member = new MemberDto();
		member.setEmail(email);
		member.setPwd(pwd);
		try {
			MemberDto result = memberService.login(member);
			if(result != null) {
				HttpSession session = request.getSession();
				session.setAttribute("userInfo", result);
				return "/view/main.jsp";
			} else {
				request.setAttribute("msg", "회원 정보가 없습니다.");
				return "/view/member/login.jsp";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "로그인 중 에러 발생!!!");
			return "/view/error/error.jsp";
		}
	}
	
	private String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "";
	}
	
	private String regist(HttpServletRequest request, HttpServletResponse response) {
		MemberDto memberDto = new MemberDto();
		memberDto.setEmail(request.getParameter("email"));
		memberDto.setName(request.getParameter("name"));
		memberDto.setPwd(request.getParameter("pwd"));
		try {
			memberService.regist(memberDto);
			return "/view/member/login.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "회원 등록 실패!!!");
			return "/view/error/error.jsp";
		}	
	}
	
	private String edit(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto userInfo = (MemberDto) session.getAttribute("userInfo");
		if(userInfo == null) {
			return "/view/member/login.jsp";
		}
		
		MemberDto memberDto = new MemberDto();
		memberDto.setEmail(request.getParameter("email"));
		memberDto.setName(request.getParameter("name"));
		memberDto.setPwd(userInfo.getPwd());
		try {
			memberService.edit(memberDto);
			session.setAttribute("userInfo", memberDto);
			request.setAttribute("msg", "회원정보를 수정했습니다.");
			return "/view/member/mypage.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "회원정보 수정 실패!!!");
			return "/view/error/error.jsp";
		}
	}
}
