<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Mammoth Trip</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
  </head>

  <body>
    <!-- Header -->
    <%@ include file="/view/include/header.jsp" %>
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
                  <li data-filter="*" class="filter-active portfolio-label">전체</li>
                  <li data-filter=".filter-app" class="portfolio-label">질문</li>
                  <li data-filter=".filter-card" class="portfolio-label">후기</li>
                  <li data-filter=".filter-web" class="portfolio-label">추천</li>
                </ul>
              </div>
            </div>
          </section>
          <div id="board-search-div" class="mt-5">
            <div id="borader-category-name">전체 게시판</div>
            <div id="board-searchBar" class="row">
              <div>
                <div class="input-group mb-3">
                  <input
                    type="text"
                    class="form-control input-text"
                    placeholder="Search"
                    aria-label="Recipient's username"
                    aria-describedby="basic-addon2"
                  />
                  <div class="input-group-append">
                    <button class="btn btn-outline-warning btn-lg" type="button">
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
                        ${article.articleCategory }
                      </td>
                      <td class="border-title">
                        <a
                          href="${root}/article?action=view&articleNo=${article.articleNo}"
                          style="text-decoration: none; color: black; font-weight: bold !important"
                          >${article.title}</a
                        >
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
              id="article-write-mvbtn"
              class="btn btn-outline-warning btn-lg"
            >
              글쓰기
            </button>
          </div>
        </div>
      </div>
    </section>
    <!-- End Categories of The Month -->

    <!-- Start Footer -->
    <%@ include file="/view/include/footer.jsp" %>
    <!-- End Footer -->

    <!-- Start Script -->
    <script src="${root}/assets/js/board.js"></script>
    <!-- End Script -->
  </body>
</html>
