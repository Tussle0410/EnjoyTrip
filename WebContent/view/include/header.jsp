<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="${root}/assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${root}/assets/css/templatemo.css" />
    <link rel="stylesheet" href="${root}/assets/css/custom.css" />

    <!-- Load fonts style after rendering the layout styles -->
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap"
    />
    <link rel="stylesheet" href="${root}/assets/css/fontawesome.min.css" />
    <!-- Slick -->
    <link rel="stylesheet" type="text/css" href="${root}/assets/css/slick.min.css" />
    <link rel="stylesheet" type="text/css" href="${root}/assets/css/slick-theme.css" />
    <c:if test="${userInfo eq null}" >
    	<script>
    		alert("로그인이 필요한 페이지 입니다.");
    		location.href = "${root}/view/member/login.jsp";
    	</script>
	</c:if>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light shadow">
      <div class="container d-flex justify-content-between align-items-center">
        <a class="navbar-brand text-success logo h1 align-self-center" href="${root}/view/main.jsp">
          Mammoth Trip
        </a>

        <div
          class="align-self-center collapse navbar-collapse flex-fill d-lg-flex justify-content-lg-between"
          id="templatemo_main_nav"
        >
          <div class="flex-fill">
            <ul class="nav navbar-nav d-flex justify-content-between mx-lg-auto">
              <li class="nav-item">
                <a class="nav-link" href="${root}/attraction?action=sidoFind">지역별 여행지</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="${root}/article?action=list">게시판</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="${root}/view/worldcup/tourWorldcup.jsp">여행지 월드컵</a>
              </li>
            </ul>
          </div>
          <div class="navbar align-self-center d-flex">
            <a class="nav-icon d-none d-lg-inline" href="${root}/member?action=logout">
              <svg
                xmlns="http://www.w3.org/2000/svg"
                fill="none"
                viewBox="0 0 24 24"
                stroke-width="1.5"
                stroke="currentColor"
                class="w-6 h-6"
                style="width: 20px"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  d="M15.75 9V5.25A2.25 2.25 0 0013.5 3h-6a2.25 2.25 0 00-2.25 2.25v13.5A2.25 2.25 0 007.5 21h6a2.25 2.25 0 002.25-2.25V15M12 9l-3 3m0 0l3 3m-3-3h12.75"
                />
              </svg>
            </a>
            <a class="nav-icon position-relative text-decoration-none" href="${root}/view/member/mypage.jsp">
              <i class="fa fa-fw fa-user text-dark mr-3"></i>
            </a>
          </div>
        </div>
      </div>
    </nav>
</body>
</html>