package com.ssafy.board.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.board.model.ArticleDto;
import com.ssafy.board.model.service.ArticleService;
import com.ssafy.board.model.service.ArticleServiceImpl;
import com.ssafy.member.model.MemberDto;

@WebServlet("/article")
public class ArticleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ArticleService articleService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		articleService = ArticleServiceImpl.getBoardService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String path = "";
		
		if("list".equals(action)) {
			path = list(request, response);
			forward(request, response, path);
		} else if("view".equals(action)) {
			path = view(request, response);
			forward(request, response, path);
		} else if("write".equals(action)) {
			path = write(request, response);
			redirect(request, response, path);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
	private void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
	
	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		response.sendRedirect(request.getContextPath() + path);
	}
	
	private String list(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<ArticleDto> list = articleService.BoardFindByAll();
			request.setAttribute("articles", list);
			return "/view/board/boardList.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "게시글 호출에 실패했습니다.");
			return "/view/error/error.jsp";
		}
	}
	
	private String view(HttpServletRequest request, HttpServletResponse response) {
		return "/view/board/boardView.jsp";
	}
	
	private String write(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		ArticleDto articleDto = new ArticleDto();
		articleDto.setTitle(request.getParameter("title"));
		articleDto.setContent(request.getParameter("content"));
		articleDto.setArticleCategory("전체");
		articleDto.setEmail(memberDto.getEmail());
		
		try {
			articleService.writeArticle(articleDto);
			return "/article?action=list";
		} catch (Exception e) {
			e.printStackTrace();
			return "/view/error/error.jsp";
		}
		
	}
}
