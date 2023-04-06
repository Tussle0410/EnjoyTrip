package com.ssafy.attraction.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ssafy.attraction.model.dto.AttractionDescDto;
import com.ssafy.attraction.model.dto.AttractionInfoDto;
import com.ssafy.attraction.model.dto.GugunDto;
import com.ssafy.attraction.model.dto.SidoDto;
import com.ssafy.attraction.model.service.AttractionService;
import com.ssafy.attraction.model.service.AttractionServiceImpl;
import com.ssafy.util.PaginationDto;

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
		} else if("tourViewDetail".equals(action)) {
			tourViewDetail(req, resp);
		}
	}
	
	
	private void tourViewDetail(HttpServletRequest req, HttpServletResponse resp) {
		int contentId = Integer.parseInt(req.getParameter("contentId"));
		AttractionDescDto attractionDescDto = null;
		try {
			attractionDescDto = attractionService.tourViewDetail(contentId);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			String jsonStr = gson.toJson(attractionDescDto);
			out.print(jsonStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void attractionFind(HttpServletRequest req, HttpServletResponse resp) {
		try {
			int sidoCode = Integer.parseInt(req.getParameter("sidoCode"));
			int gugunCode = Integer.parseInt(req.getParameter("gugunCode"));
			int contentCode = Integer.parseInt(req.getParameter("contentCode"));
			
			
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			// 페이지에 필요한 정보
			PaginationDto pageDto = new PaginationDto();
			int currentPage = Integer.parseInt(req.getParameter("pageNo"));
			int maxPageCnt = pageDto.getMaxPageCnt();
			int maxViewCnt = pageDto.getMaxViewCnt();
			int pageGroup = (currentPage-1) / maxPageCnt + 1;
			int totalViewCnt = attractionService.attractionTotalCntFindByCode(sidoCode, gugunCode, contentCode);
			int totalPageCnt = (int) Math.ceil(totalViewCnt / maxPageCnt);
			int startPage = (pageGroup-1) * maxPageCnt + 1;
			int endPage = (totalPageCnt-1) / maxPageCnt + 1 == pageGroup ? totalPageCnt : pageGroup * maxPageCnt;
			
			// 페이지 정보 저장
			pageDto.setCurrentPage(currentPage);
			pageDto.setPageGroup(pageGroup);
			pageDto.setStartPage(startPage);
			pageDto.setEndPage(endPage);
			pageDto.setTotalViewCnt(totalViewCnt);
			pageDto.setTotalPageCnt(totalPageCnt);
			
			// 관광지 정보 호출
			List<AttractionInfoDto> attractions = attractionService.attractionFindByCode(sidoCode, gugunCode, contentCode, pageDto);
			
			// 페이지에 보낼 정보 맵에 저장
			Map<String, Object> map = new HashMap<>();
			map.put("attractions", attractions);
			map.put("pageInfo", pageDto);
			String jsonStr = gson.toJson(map);
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
