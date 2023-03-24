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
          <form class="d-flex my-3" onsubmit="return false;" role="search">
            <div id="trip-selecter-form">
              <select
                id="search-area"
                class="form-select me-2 select-box"
                onchange="makeGunGu(this)"
              >
                <option value="0" selected>지역 선택</option>
              </select>
              <select id="search-gungu" class="form-select me-2 select-box">
                <option value="0" selected>시군구 선택</option>
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
              <button id="btn-search" class="btn btn-outline-primary" type="submit">검색</button>
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
    </section>
    <!-- End Categories of The Month -->

    <!-- Start Footer -->
	<%@ include file="/view/include/footer.jsp" %>
    <!-- End Footer -->

    <!-- Start Script -->
	<script src="${root}/assets/js/kakaoMap.js"></script>
    <script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=bd2a3494477a9c7735642bac8ac8bcbe&libraries=services,clusterer,drawing"
    ></script>
    <script>
      var container = document.getElementById("map"); //지도를 담을 영역의 DOM 레퍼런스
      var options = {
        //지도를 생성할 때 필요한 기본 옵션
        center: new kakao.maps.LatLng(37.5012767241426, 127.039600248343), //지도의 중심좌표.
        level: 13, //지도의 레벨(확대, 축소 정도)
      };

      var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

      // 마커 이미지의 이미지 주소입니다
      var imageSrc = "./assets/img/marker/location.png";

      if (positions.length > 0) {
        for (var i = 0; i < positions.length; i++) {
          // 마커 이미지의 이미지 크기 입니다
          var imageSize = new kakao.maps.Size(24, 35);

          // 마커 이미지를 생성합니다
          var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

          // 마커를 생성합니다
          var marker = new kakao.maps.Marker({
            map: map, // 마커를 표시할 지도
            position: positions[i].latlng, // 마커를 표시할 위치
            title: positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
            image: markerImage, // 마커 이미지
          });
          maker.setMap(map);
        }
      }

      // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
      var mapTypeControl = new kakao.maps.MapTypeControl();

      // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
      // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
      map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

      // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
      var zoomControl = new kakao.maps.ZoomControl();
      map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

      // 마커가 지도 위에 표시되도록 설정합니다

      // 아래 코드는 지도 위의 마커를 제거하는 코드입니다
      // marker.setMap(null);
    </script>
    <script></script>
    <!-- End Script -->
  </body>
</html>
