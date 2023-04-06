<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Mammoth Trip</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
</head>

<body>
	<!-- Header -->
	<%@ include file="/view/include/header.jsp"%>
	<!-- Close Header -->

	<!-- Start Banner Hero -->
	<div class="container-fluid mt-5 py-5">
		<div class="col-md-6 m-auto text-center">
			<h1 class="h1">게시판 목록</h1>
			<hr id="board-title-bottomline" />
		</div>
	</div>
	<!-- End Banner Hero -->

	<!-- Start Categories of The Month -->
	<section class="container pb-5">
		<div class="row text-center pt-3">
			<div class="col-lg-12 m-auto">
				<section id="portfolio" class="portfolio">
					<div class="row" data-aos="fade-up" data-aos-delay="100">
						<div class="col-lg-12 d-flex justify-content-center">
							<ul id="portfolio-flters">
								<c:if test="${categoryidx == 0}">
									<li data-filter="*" class="filter-active portfolio-label">전체</li>
								</c:if>
								<c:if test="${categoryidx != 0}">
									<li data-filter="*" class="portfolio-label">전체</li>
								</c:if>
								<c:if test="${categoryidx == 1}">
									<li data-filter="*" class="filter-active portfolio-label">질문</li>
								</c:if>
								<c:if test="${categoryidx != 1}">
									<li data-filter="*" class="portfolio-label">질문</li>
								</c:if>
								<c:if test="${categoryidx == 2}">
									<li data-filter="*" class="filter-active portfolio-label">후기</li>
								</c:if>
								<c:if test="${categoryidx != 2}">
									<li data-filter="*" class="portfolio-label">후기</li>
								</c:if>
								<c:if test="${categoryidx == 3}">
									<li data-filter="*" class="filter-active portfolio-label">추천</li>
								</c:if>
								<c:if test="${categoryidx != 3}">
									<li data-filter="*" class="portfolio-label">추천</li>
								</c:if>
							</ul>
						</div>
					</div>
				</section>
				<div id="board-search-div" class="mt-5">
					<c:if test="${categoryidx == 0}">
						<div id="borader-category-name">전체 게시판</div>
					</c:if>
					<c:if test="${categoryidx == 1}">
						<div id="borader-category-name">질문 게시판</div>
					</c:if>
					<c:if test="${categoryidx == 2}">
						<div id="borader-category-name">후기 게시판</div>
					</c:if>
					<c:if test="${categoryidx == 3}">
						<div id="borader-category-name">추천 게시판</div>
					</c:if>
					<div id="board-searchBar" class="row">
						<div>
							<div class="input-group mb-3">
								<input type="text" class="form-control input-text"
									placeholder="제목을 입력해주세요." aria-label="Recipient's username"
									aria-describedby="basic-addon2" id="search-title-text" />
								<div class="input-group-append">
									<button class="btn btn-outline-warning btn-lg" type="button"
										id="search-title_btn">
										<i class="fa fa-search"></i>
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>
				<table class="table">
					<thead>
						<tr>
							<th>No.</th>
							<th>카테고리</th>
							<th>제목</th>
							<th>글쓴이</th>
							<th>작성시간</th>
							<th>조회수</th>
							<th>좋아요</th>
						</tr>
					</thead>
					<tbody id="board-table-body">
						<c:choose>
							<c:when test="${not empty articles}">
								<c:forEach var="article" items="${articles}">
									<tr>
										<td>${article.articleNo }</td>
										<td class="border-category" style="color: #ad7be9">
											${article.articleCategory }</td>
										<td class="border-title"><a
											href="${root}/article?action=view&articleNo=${article.articleNo}"
											style="text-decoration: none; color: black; font-weight: bold !important">${article.title}</a>
										</td>
										<td>${article.email}</td>
										<td>${article.registTime }</td>
										<td>${article.hit }</td>
										<td>${article.heart }</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="7">등록된 게시글이 없습니다.</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
				<div id="board-article-write-div">
					<button
						onClick="location.href='${root}/view/board/boardWrite.jsp';"
						id="article-write-mvbtn" class="btn btn-outline-warning btn-lg">
						글쓰기</button>
				</div>
			</div>
		</div>
		<nav class="row">
			<ul class="pagination justify-content-center" id="pageBody">
				<c:if test="${pageInfo.currentPage == 1}">
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
				</c:if>
				<c:if test="${pageInfo.currentPage > 1}">
					<li class="page-item"><a class="page-link"
						href="${root}/article?action=${action}&categoryidx=${categoryidx}&pageNo=${pageInfo.currentPage-1}&title=${title}"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
				</c:if>
				<c:if test="${pageInfo.totalViewCnt == 0}">
					<li class="page-item active"><a class="page-link" href="#">1</a></li>
				</c:if>
				<c:if test="${pageInfo.totalViewCnt != 0}">
					<c:forEach var="i" begin="${pageInfo.startPage}"
						end="${pageInfo.endPage}">
						<li class="page-item ${pageInfo.currentPage == i ? "active" : ""} "><a
							class="page-link"
							href="${root}/article?action=${action}&categoryidx=${categoryidx}&pageNo=${i}&title=${title}">${i}</a></li>
					</c:forEach>
				</c:if>
				<c:if test="${pageInfo.currentPage >= pageInfo.endPage}">
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</c:if>
				<c:if test="${pageInfo.currentPage < pageInfo.endPage}">
					<li class="page-item"><a class="page-link"
						href="${root}/article?action=${action}&categoryidx=${categoryidx}&pageNo=${pageInfo.currentPage+1}&title=${title}"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</c:if>
			</ul>
		</nav>
	</section>
	<!-- End Categories of The Month -->

	<!-- Start Footer -->
	<%@ include file="/view/include/footer.jsp"%>
	<!-- End Footer -->

	<!-- Start Script -->
	<script src="${root}/assets/js/board.js"></script>
	<!-- End Script -->
</body>
</html>
