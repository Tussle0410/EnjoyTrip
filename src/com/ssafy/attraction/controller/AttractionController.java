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

import com.google.gson.Gson;
import com.ssafy.attraction.model.dto.GugunDto;
import com.ssafy.attraction.model.dto.SidoDto;
import com.ssafy.attraction.model.service.AttractionService;
import com.ssafy.attraction.model.service.AttractionServiceImpl;

@WebServlet("/attraction")
public class AttractionController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private AttractionService attractionService;
	private Gson gson;
	@Override
	public void init() throws ServletException {
		super.init();
		attractionService = AttractionServiceImpl.getInstance();
		gson = new Gson();
		
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
		try {
			int sidoCode = Integer.parseInt(req.getParameter("sidoCode"));
			List<GugunDto> guguns = attractionService.gugunFindBySido(sidoCode);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			String jsonStr = gson.toJson(guguns);
			out.print(jsonStr);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void sidoFind(HttpServletRequest req, HttpServletResponse resp) {
		try {
			List<SidoDto> sidos = attractionService.sidoFindByAll();
			req.setAttribute("sidos", sidos);
	        resp.setContentType("text/html;charset=utf-8");
	        PrintWriter out = resp.getWriter();
	        String jsonStr = gson.toJson(sidos);
	        out.print(jsonStr);
		}catch(Exception e) {
			e.printStackTrace();
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
