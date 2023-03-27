package com.ssafy.attraction.controller;

import java.io.IOException;
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
			path = sidoFind(req, resp);
			forward(req, resp, path);
		}else if("gugunFind".equals(action)) {
			
		}
	}
	
	
	private String sidoFind(HttpServletRequest req, HttpServletResponse resp) {
		try {
			List<SidoDto> sidos = attractionService.sidoFindByAll();
			req.setAttribute("sidos", sidos);
		}catch(Exception e) {
			e.printStackTrace();
			return "/view/error/error.jsp";
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
