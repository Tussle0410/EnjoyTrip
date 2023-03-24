<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${root}/assets/css/ani.css" />
    <link rel="stylesheet" href="${root}/assets/css/login.css" />
    <title>Document</title>
  </head>
  <body>
    <div id="retrobg">
      <div id="retrobg-sky">
        <div id="retrobg-stars">
          <div class="retrobg-star" style="left: 5%; top: 55%; transform: scale(2)"></div>
          <div class="retrobg-star" style="left: 7%; top: 5%; transform: scale(2)"></div>
          <div class="retrobg-star" style="left: 10%; top: 45%; transform: scale(1)"></div>
          <div class="retrobg-star" style="left: 12%; top: 35%; transform: scale(1)"></div>
          <div class="retrobg-star" style="left: 15%; top: 39%; transform: scale(1)"></div>
          <div class="retrobg-star" style="left: 20%; top: 10%; transform: scale(1)"></div>
          <div class="retrobg-star" style="left: 35%; top: 50%; transform: scale(2)"></div>
          <div class="retrobg-star" style="left: 40%; top: 16%; transform: scale(2)"></div>
          <div class="retrobg-star" style="left: 43%; top: 28%; transform: scale(1)"></div>
          <div class="retrobg-star" style="left: 45%; top: 30%; transform: scale(3)"></div>
          <div class="retrobg-star" style="left: 55%; top: 18%; transform: scale(1)"></div>
          <div class="retrobg-star" style="left: 60%; top: 23%; transform: scale(1)"></div>
          <div class="retrobg-star" style="left: 62%; top: 44%; transform: scale(2)"></div>
          <div class="retrobg-star" style="left: 67%; top: 27%; transform: scale(1)"></div>
          <div class="retrobg-star" style="left: 75%; top: 10%; transform: scale(2)"></div>
          <div class="retrobg-star" style="left: 80%; top: 25%; transform: scale(1)"></div>
          <div class="retrobg-star" style="left: 83%; top: 57%; transform: scale(1)"></div>
          <div class="retrobg-star" style="left: 90%; top: 29%; transform: scale(2)"></div>
          <div class="retrobg-star" style="left: 95%; top: 5%; transform: scale(1)"></div>
          <div class="retrobg-star" style="left: 96%; top: 72%; transform: scale(1)"></div>
          <div class="retrobg-star" style="left: 98%; top: 70%; transform: scale(3)"></div>
        </div>
        <div id="retrobg-mountains">
          <div id="retrobg-mountains-left" class="retrobg-mountain"></div>
          <div id="retrobg-mountains-right" class="retrobg-mountain"></div>
        </div>
        <div id="retrobg-cityWrap">
          <div id="retrobg-city">
            <div style="left: 4%; height: 20%; width: 3%" class="retrobg-building"></div>
            <div style="left: 6%; height: 50%; width: 1.5%" class="retrobg-building"></div>
            <div style="left: 8%; height: 25%; width: 4%" class="retrobg-building"></div>
            <div style="left: 12%; height: 30%; width: 3%" class="retrobg-building"></div>
            <div
              style="left: 13%; height: 55%; width: 3%"
              class="retrobg-building retrobg-antenna"
            ></div>
            <div style="left: 17%; height: 20%; width: 4%" class="retrobg-building"></div>
            <div style="left: 18.5%; height: 70%; width: 1.5%" class="retrobg-building"></div>
            <div style="left: 20%; height: 30%; width: 4%" class="retrobg-building"></div>
            <div
              style="left: 21.5%; height: 80%; width: 2%"
              class="retrobg-building retrobg-antenna"
            ></div>
            <div style="left: 25%; height: 60%; width: 4%" class="retrobg-building"></div>
            <div style="left: 28%; height: 40%; width: 4%" class="retrobg-building"></div>
            <div style="left: 30%; height: 70%; width: 4%" class="retrobg-building"></div>
            <div
              style="left: 35%; height: 65%; width: 4%"
              class="retrobg-building retrobg-antenna"
            ></div>
            <div style="left: 38%; height: 40%; width: 3%" class="retrobg-building"></div>
            <div style="left: 42%; height: 60%; width: 2%" class="retrobg-building"></div>
            <div
              style="left: 43%; height: 85%; width: 4%"
              class="retrobg-building retrobg-antenna"
            ></div>
            <div style="left: 45%; height: 40%; width: 3%" class="retrobg-building"></div>
            <div style="left: 48%; height: 25%; width: 3%" class="retrobg-building"></div>
            <div style="left: 50%; height: 80%; width: 4%" class="retrobg-building"></div>
            <div style="left: 52%; height: 32%; width: 5%" class="retrobg-building"></div>
            <div
              style="left: 55%; height: 55%; width: 3%"
              class="retrobg-building retrobg-antenna"
            ></div>
            <div style="left: 58%; height: 45%; width: 4%" class="retrobg-building"></div>
            <div style="left: 61%; height: 90%; width: 4%" class="retrobg-building"></div>
            <div
              style="left: 66%; height: 99%; width: 4%"
              class="retrobg-building retrobg-antenna"
            ></div>
            <div style="left: 69%; height: 30%; width: 4%" class="retrobg-building"></div>
            <div style="left: 73.5%; height: 90%; width: 2%" class="retrobg-building"></div>
            <div style="left: 72%; height: 70%; width: 4%" class="retrobg-building"></div>
            <div style="left: 75%; height: 60%; width: 4%" class="retrobg-building"></div>
            <div style="left: 80%; height: 40%; width: 4%" class="retrobg-building"></div>
            <div
              style="left: 83%; height: 70%; width: 4%"
              class="retrobg-building retrobg-antenna"
            ></div>
            <div
              style="left: 87%; height: 60%; width: 3%"
              class="retrobg-building retrobg-antenna"
            ></div>
            <div style="left: 93%; height: 50%; width: 3%" class="retrobg-building"></div>
            <div style="left: 91%; height: 30%; width: 4%" class="retrobg-building"></div>
            <div style="left: 94%; height: 20%; width: 3%" class="retrobg-building"></div>
            <div style="left: 98%; height: 35%; width: 2%" class="retrobg-building"></div>
          </div>
        </div>
      </div>
    </div>
    <div id="login-box">
      <header>
        <div id="title-div">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="30"
            height="30"
            fill="#FFFFFF"
            class="bi bi-amd"
            viewBox="0 0 16 16"
          >
            <path
              d="m.334 0 4.358 4.359h7.15v7.15l4.358 4.358V0H.334ZM.2 9.72l4.487-4.488v6.281h6.28L6.48 16H.2V9.72Z"
            />
          </svg>
          <h2 id="login-title">MAMMOTH TRIP</h2>
        </div>
      </header>
      <div id="login-div">
        <h2>Found ID</h2>
        <div id="sign-form">
          <input class="input-text" type="text" placeholder="Your Full Name" />
          <button id="sign-btn">Found ID</button>
          <hr />
          <h2>Found PW</h2>
          <div id="sign-form">
            <input class="input-text" type="text" placeholder="Your Email" />
            <input class="input-text" type="text" placeholder="Your Full Name" />
            <button id="sign-btn">Found PW</button>
          </div>
          <div id="sign-desc">Are you ready to<a href="login.jsp">Login</a></div>
        </div>
      </div>
    </div>
  </body>
</html>
    