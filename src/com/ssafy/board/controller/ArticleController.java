package com.ssafy.board.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.core.ApplicationContext;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
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
    private static final String CHARSET = "utf-8";
    private static final int LIMIT_SIZE_BYTES = 1024 * 1024;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		articleService = ArticleServiceImpl.getBoardService();
		gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String path = "";
		
		if ("list".equals(action)) {
			path = list(request, response);
			forward(request, response, path);
		} else if ("view".equals(action)) {
			path = view(request, response);
			forward(request, response, path);
		} else if ("getReview".equals(action)) {
			getReview(request, response);
		} else if ("categoryList".equals(action)) {
			categorySearch(request, response);
		} else if ("deleteArticle".equals(action)) {
			path = delete(request, response);
			redirect(request, response, path);
		} else if ("write".equals(action)) {
			path = write(request, response);
			redirect(request, response, path);
		}else if ("writeReview".equals(action)) {
			writeReview(request, response);
		}else if("heartUp".equals(action)) {
			heartUp(request, response);
		}else if("heartDown".equals(action)){
			heartDown(request,response);
		}
	}

	private void heartUp(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		int article_no = Integer.parseInt(request.getParameter("articleNo"));
		try {
			articleService.heartUp(article_no, memberDto.getEmail());
			articleService.plusArticleHeart(article_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void heartDown(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		int article_no = Integer.parseInt(request.getParameter("articleNo"));
		try {
			articleService.headrDown(article_no, memberDto.getEmail());
			articleService.minusArticleHeart(article_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private String delete(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		int article_no = Integer.parseInt(request.getParameter("articleNo"));
		try {
			articleService.deleteArticle(article_no);
			return "/article?action=list";
		} catch (Exception e) {
			e.printStackTrace();
			return "/view/error/error.jsp";
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(CHARSET);
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

	private void categorySearch(HttpServletRequest request, HttpServletResponse response) {
	
		try {
			String category = request.getParameter("category");
			List<ArticleDto> list = articleService.BoardFindByCategory(category);
			String jsonArticles = gson.toJson(list);
			response.setContentType("html/text;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(jsonArticles);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void writeReview(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		BufferedReader br = request.getReader();
		StringBuilder sb = new StringBuilder();
		sb.append(br.readLine());
		Map<String, Object> map = gson.fromJson(sb.toString(), Map.class);
		ArticleReviewDto articleReviewDto = new ArticleReviewDto();
		articleReviewDto.setArticleNo(Integer.parseInt((String) map.get("articleNo")));
		articleReviewDto.setContent((String) map.get("content"));
		articleReviewDto.setEmail(memberDto.getEmail());
		try {
			articleService.writeReview(articleReviewDto);
			response.setContentType("html/text;charset=utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void getReview(HttpServletRequest request, HttpServletResponse response) {
		try {
			int article_no = Integer.parseInt(request.getParameter("articleNo"));
			List<ArticleReviewDto> reviews = articleService.ReviewFindByNo(article_no);
			String jsonReviews = gson.toJson(reviews);
			response.setContentType("html/text;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(jsonReviews);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		try {
			int article_no = Integer.parseInt(request.getParameter("articleNo"));
			ArticleDto articleDto = articleService.ArticleFindByNo(article_no, memberDto.getEmail());
			articleService.plusArticleHit(article_no);
			articleDto.plusHit();
			request.setAttribute("articleInfo", articleDto);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "게시글을 불러오는데 실패하였습니다.");
			return "view/error/error/jsp";
		}
		return "/view/board/boardView.jsp";
	}

	private String write(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		response.setContentType("text/html; charset=UTF-8");
		
		String ATTACHES_DIR = request.getRealPath("/imgs");
        File attachesDir = new File(ATTACHES_DIR);
        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        fileItemFactory.setRepository(attachesDir);
        fileItemFactory.setSizeThreshold(LIMIT_SIZE_BYTES);
        ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
        
		ArticleDto articleDto = new ArticleDto();
		articleDto.setEmail(memberDto.getEmail());

		try {
            RequestContext requestContext = new ServletRequestContext(request);
            List<FileItem> items = fileUpload.parseRequest(requestContext);
            Random random = new Random();
            for (FileItem item : items) {
                if (item.isFormField()) {
                	if("title".equals(item.getFieldName())) {
                		articleDto.setTitle(item.getString(CHARSET));
                	}else if("content".equals(item.getFieldName())) {
                		articleDto.setContent(item.getString(CHARSET));
                	}else if("category".equals(item.getFieldName())) {
                		articleDto.setArticleCategory(item.getString(CHARSET));
                	}
                } else {
                    if (item.getSize() > 0) {
                        String separator = File.separator;
                        int index =  item.getName().lastIndexOf(separator);
                        String fileName = random.nextInt() + item.getName().substring(index  + 1);
                        File uploadFile = new File(ATTACHES_DIR +  separator + fileName);
                        item.write(uploadFile);
                    }
                }
            }
			articleService.writeArticle(articleDto);
			return "/article?action=list";
		} catch (Exception e) {
			e.printStackTrace();
			return "/view/error/error.jsp";
		}

	}
}
