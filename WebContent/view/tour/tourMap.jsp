<%@page import="com.ssafy.attraction.model.dto.SidoDto"%> <%@page import="java.util.List"%> <%@ page
language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        <h1 class="h1">지역별 여행지</h1>
        <hr id="board-title-bottomline" />
      </div>
    </div>
    <!-- End Banner Hero -->

    <!-- Start Categories of The Month -->
    <section class="container py-5">
      <div class="row text-center pt-3">
        <div class="col-lg-12" style="display: flex; justify-content: center">
          <form>
            <!--  <form class="d-flex my-3" onsubmit="return false;" role="search">-->
            <div id="trip-selecter-form">
              <input type="hidden" name="action" value="sidoFind" />
              <select id="search-area" class="form-select me-2 select-box">
                <option value="0">지역 선택</option>
              </select>
              <select id="search-gungu" class="form-select me-2 select-box">
                <option value="0">시군구 선택</option>
              </select>
              <select id="search-content-id" class="form-select me-2 select-box">
                <option value="0" selected>관광지 유형</option>
                <option value="12">관광지</option>
                <option value="14">문화시설</option>
                <option value="15">축제공연행사</option>
                <option value="25">여행코스</option>
                <option value="28">레포츠</option>
                <option value="32">숙박</option>
                <option value="38">쇼핑</option>
                <option value="39">음식점</option>
              </select>
              <button id="btn-search" class="btn btn-outline-primary" type="button">검색</button>
            </div>
          </form>
        </div>
        <div class="col-lg-6">
          <!-- 관광지 검색 start -->
          <div class="col-lg--12 mt-5">
            <div class="card">
              <div class="card-body" style="padding: 0">
                <!-- 카카오맵 -->
                <div id="map" style="width: 100%; height: 700px"></div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-lg-6">
          <table class="table table-striped">
            <thead>
              <tr>
                <th>대표이미지</th>
                <th>관광지명</th>
                <th>주소</th>
              </tr>
            </thead>
            <tbody id="trip-list"></tbody>
          </table>
        </div>
      </div>
      <%@ include file="/view/include/pagination.jsp" %>
    </section>
    
    <!-- End Categories of The Month -->

    <!-- Start Footer -->
    <%@ include file="/view/include/footer.jsp" %> 
    <%@ include file="/view/include/tourViewModal.jsp" %>
    <!-- End Footer -->

    <!-- Start Script -->
    <script src="${root}/assets/js/kakaoMap.js"></script>
    <script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=bd2a3494477a9c7735642bac8ac8bcbe&libraries=services,clusterer,drawing"
    ></script>
    <!-- End Script -->
  </body>
</html>
