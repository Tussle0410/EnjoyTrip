package com.ssafy.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ssafy.board.model.ArticleDto;
import com.ssafy.board.model.ArticleReviewDto;
import com.ssafy.board.model.service.ArticleService;
import com.ssafy.board.model.service.ArticleServiceImpl;
import com.ssafy.member.model.MemberDto;

@WebServlet("/article")
public class ArticleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson;
	ArticleService articleService;
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		articleService = ArticleServiceImpl.getBoardService();
		gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
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
		} else if("getReview".equals(action)) {
			getReview(request, response);
		}
	}

	private void getReview(HttpServletRequest request, HttpServletResponse response){
		try {
			int article_no = Integer.parseInt(request.getParameter("articleNo"));
			List<ArticleReviewDto> reviews = articleService.ReviewFindByNo(article_no);
			String jsonReviews = gson.toJson(reviews);
			response.setContentType("html/text;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(jsonReviews);
		}catch (Exception e) {
			e.printStackTrace();
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
		try {
			int article_no = Integer.parseInt(request.getParameter("articleNo"));
			ArticleDto articleDto = articleService.ArticleFindByNo(article_no);
			System.out.println(articleDto);
			request.setAttribute("articleInfo", articleDto);
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "게시글을 불러오는데 실패하였습니다.");
			return "view/error/error/jsp";
		}
		return "/view/board/boardView.jsp";
	}
	
	private String write(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		ArticleDto articleDto = new ArticleDto();
		articleDto.setTitle(request.getParameter("title"));
		articleDto.setContent(request.getParameter("content"));
		articleDto.setArticleCategory(request.getParameter("category"));
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
