package com.ssafy.attraction.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.attraction.model.dto.SidoDto;
import com.ssafy.attraction.model.service.AttractionService;
import com.ssafy.attraction.model.service.AttractionServiceImpl;

@WebServlet("/attraction")
public class AttractionController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private AttractionService attractionService;
	@Override
	public void init() throws ServletException {
		super.init();
		attractionService = AttractionServiceImpl.getInstance();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		String path = "";
		if("sidoFind".equals(action)) {
			sidoFind(req, resp);
		}else if("gugunFind".equals(action)) {
			gugunFind(req, resp);
		}
	}
	
	
	private void gugunFind(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("따랑");
	}

	private void sidoFind(HttpServletRequest req, HttpServletResponse resp) {
		try {
			List<SidoDto> sidos = attractionService.sidoFindByAll();
			req.setAttribute("sidos", sidos);
	        PrintWriter out = resp.getWriter();
	        resp.setContentType("application/json");
	        resp.setCharacterEncoding("utf-8");
	        System.out.println(resp.getCharacterEncoding());
	        out.append("{\r\n" + 
	        		"\"response\": {\r\n" + 
	        		"\"header\": {\r\n" + 
	        		"\"resultCode\": \"0000\",\r\n" + 
	        		"\"resultMsg\": \"OK\"\r\n" + 
	        		"},\r\n" + 
	        		"\"body\": {\r\n" + 
	        		"\"items\": {\r\n" + 
	        		"\"item\": [\r\n" + 
	        		"{\r\n" + 
	        		"\"rnum\": 1,\r\n" + 
	        		"\"code\": \"1\",\r\n" + 
	        		"\"name\": \"서울\"\r\n" + 
	        		"},\r\n" + 
	        		"{\r\n" + 
	        		"\"rnum\": 2,\r\n" + 
	        		"\"code\": \"2\",\r\n" + 
	        		"\"name\": \"인천\"\r\n" + 
	        		"},\r\n" + 
	        		"{\r\n" + 
	        		"\"rnum\": 3,\r\n" + 
	        		"\"code\": \"3\",\r\n" + 
	        		"\"name\": \"대전\"\r\n" + 
	        		"},\r\n" + 
	        		"{\r\n" + 
	        		"\"rnum\": 4,\r\n" + 
	        		"\"code\": \"4\",\r\n" + 
	        		"\"name\": \"대구\"\r\n" + 
	        		"},\r\n" + 
	        		"{\r\n" + 
	        		"\"rnum\": 5,\r\n" + 
	        		"\"code\": \"5\",\r\n" + 
	        		"\"name\": \"광주\"\r\n" + 
	        		"},\r\n" + 
	        		"{\r\n" + 
	        		"\"rnum\": 6,\r\n" + 
	        		"\"code\": \"6\",\r\n" + 
	        		"\"name\": \"부산\"\r\n" + 
	        		"},\r\n" + 
	        		"{\r\n" + 
	        		"\"rnum\": 7,\r\n" + 
	        		"\"code\": \"7\",\r\n" + 
	        		"\"name\": \"울산\"\r\n" + 
	        		"},\r\n" + 
	        		"{\r\n" + 
	        		"\"rnum\": 8,\r\n" + 
	        		"\"code\": \"8\",\r\n" + 
	        		"\"name\": \"세종특별자치시\"\r\n" + 
	        		"},\r\n" + 
	        		"{\r\n" + 
	        		"\"rnum\": 9,\r\n" + 
	        		"\"code\": \"31\",\r\n" + 
	        		"\"name\": \"경기도\"\r\n" + 
	        		"},\r\n" + 
	        		"{\r\n" + 
	        		"\"rnum\": 10,\r\n" + 
	        		"\"code\": \"32\",\r\n" + 
	        		"\"name\": \"강원도\"\r\n" + 
	        		"},\r\n" + 
	        		"{\r\n" + 
	        		"\"rnum\": 11,\r\n" + 
	        		"\"code\": \"33\",\r\n" + 
	        		"\"name\": \"충청북도\"\r\n" + 
	        		"},\r\n" + 
	        		"{\r\n" + 
	        		"\"rnum\": 12,\r\n" + 
	        		"\"code\": \"34\",\r\n" + 
	        		"\"name\": \"충청남도\"\r\n" + 
	        		"},\r\n" + 
	        		"{\r\n" + 
	        		"\"rnum\": 13,\r\n" + 
	        		"\"code\": \"35\",\r\n" + 
	        		"\"name\": \"경상북도\"\r\n" + 
	        		"},\r\n" + 
	        		"{\r\n" + 
	        		"\"rnum\": 14,\r\n" + 
	        		"\"code\": \"36\",\r\n" + 
	        		"\"name\": \"경상남도\"\r\n" + 
	        		"},\r\n" + 
	        		"{\r\n" + 
	        		"\"rnum\": 15,\r\n" + 
	        		"\"code\": \"37\",\r\n" + 
	        		"\"name\": \"전라북도\"\r\n" + 
	        		"},\r\n" + 
	        		"{\r\n" + 
	        		"\"rnum\": 16,\r\n" + 
	        		"\"code\": \"38\",\r\n" + 
	        		"\"name\": \"전라남도\"\r\n" + 
	        		"},\r\n" + 
	        		"{\r\n" + 
	        		"\"rnum\": 17,\r\n" + 
	        		"\"code\": \"39\",\r\n" + 
	        		"\"name\": \"제주도\"\r\n" + 
	        		"}\r\n" + 
	        		"]\r\n" + 
	        		"},\r\n" + 
	        		"\"numOfRows\": 17,\r\n" + 
	        		"\"pageNo\": 1,\r\n" + 
	        		"\"totalCount\": 17\r\n" + 
	        		"}\r\n" + 
	        		"}\r\n" + 
	        		"}");
	        out.close();
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "시도 코드 가져올 수 없습니다.");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		doGet(req, resp);
	}
	private void forward(HttpServletRequest req, HttpServletResponse resp, String path) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		dispatcher.forward(req, resp);
	}
	private void redirect(HttpServletRequest req, HttpServletResponse resp, String path) throws IOException {
		resp.sendRedirect(req.getContextPath() + path);
	}
}
