package com.ssafy.attraction.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.ssafy.attraction.model.dto.AttractionInfoDto;
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
		if("sidoFind".equals(action)) {
			sidoFind(req, resp);
		}else if("gugunFind".equals(action)) {
			gugunFind(req, resp);
		}else if("attractionFind".equals(action)) {
			attractionFind(req, resp);
		}
	}
	
	
	private void attractionFind(HttpServletRequest req, HttpServletResponse resp) {
		try {
			int sidoCode = Integer.parseInt(req.getParameter("sidoCode"));
			int gugunCode = Integer.parseInt(req.getParameter("gugunCode"));
			int contentCode = Integer.parseInt(req.getParameter("contentCode"));
			List<AttractionInfoDto> attractions = attractionService.attractionFindByCode(sidoCode, gugunCode, contentCode);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			String jsonStr = gson.toJson(attractions);
			out.print(jsonStr);
		}catch(Exception e) {
			e.printStackTrace();
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
}
