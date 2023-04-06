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
    <div id="template-mo-zay-hero-carousel" class="carousel slide" data-bs-ride="carousel">
      <ol class="carousel-indicators">
        <li
          data-bs-target="#template-mo-zay-hero-carousel"
          data-bs-slide-to="0"
          class="active"
        ></li>
        <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="1"></li>
        <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="2"></li>
      </ol>
      <div class="carousel-inner">
        <div class="carousel-item active">
          <div class="container">
            <div class="row p-5">
              <div
                class="mx-auto col-md-8 col-lg-6 order-lg-last carousel-background"
                style="background-image: url(${root}/assets/img/carousel/main1.jpg)"
              ></div>
            </div>
          </div>
        </div>
        <div class="carousel-item">
          <div class="container">
            <div class="row p-5">
              <div
                class="mx-auto col-md-8 col-lg-6 order-lg-last carousel-background"
                style="background-image: url(${root}/assets/img/carousel/main2.jpg)"
              ></div>
            </div>
          </div>
        </div>
        <div class="carousel-item">
          <div class="container">
            <div class="row p-5">
              <div
                class="mx-auto col-md-8 col-lg-6 order-lg-last carousel-background"
                style="background-image: url(${root}/assets/img/carousel/main3.jpg)"
              ></div>
            </div>
          </div>
        </div>
      </div>
      <!-- <a
        class="carousel-control-prev text-decoration-none w-auto ps-3"
        href="#template-mo-zay-hero-carousel"
        role="button"
        data-bs-slide="prev"
      >
        <i class="fas fa-chevron-left"></i>
      </a>
      <a
        class="carousel-control-next text-decoration-none w-auto pe-3"
        href="#template-mo-zay-hero-carousel"
        role="button"
        data-bs-slide="next"
      >
        <i class="fas fa-chevron-right"></i>
      </a> -->
    </div>
    <!-- End Banner Hero -->

    <!-- Start Categories of The Month -->
    <section class="container py-5">
      <div class="row text-center pt-3">
        <div class="col-lg-6 m-auto">
          <h1 class="h1">전국 관광지 TOP3</h1>
        </div>
      </div>
      <div class="row">
        <div class="col-12 col-md-4 p-5 mt-3">
          <img
            src="${root}/assets/img/location_top3/seoul_landmark.jpg"
            class="rounded-circle img-fluid border popular-place"
          />
          <h5 class="text-center mt-3 mb-3">서울</h5>
          <p class="text-center">
            <a href="${root}/view/tour/tourMap.jsp?areaCode=1&sigunguCode=1&contentCode=12&pageNo=1" class="btn btn-success">살펴보기</a>
          </p>
        </div>
        <div class="col-12 col-md-4 p-5 mt-3">
          <a href="#"
            ><img
              src="${root}/assets/img/location_top3/busan_landmark.jpg"
              class="rounded-circle img-fluid border popular-place"
          /></a>
          <h2 class="h5 text-center mt-3 mb-3">부산</h2>
          <p class="text-center">
            <a href="${root}/view/tour/tourMap.jsp?areaCode=6&sigunguCode=16&contentCode=12&pageNo=1" class="btn btn-success">살펴보기</a>
          </p>
        </div>
        <div class="col-12 col-md-4 p-5 mt-3">
          <a href="#"
            ><img
              src="${root}/assets/img/location_top3/jeju_landmark.jpeg"
              class="rounded-circle img-fluid border popular-place"
          /></a>
          <h2 class="h5 text-center mt-3 mb-3">제주도</h2>
          <p class="text-center">
            <a href="${root}/view/tour/tourMap.jsp?areaCode=39&sigunguCode=4&contentCode=12&pageNo=1" class="btn btn-success">살펴보기</a>
          </p>
        </div>
      </div>
    </section>
    <!-- End Categories of The Month -->

    <!-- Start Featured Product -->
    <section class="bg-light">
      <div class="container py-5">
        <div class="row text-center py-3">
          <div class="col-lg-6 m-auto">
            <h1 class="h1">여행지 월드컵</h1>
            <p>어디로 어떤 여행을 갈지 고민 된다면 아래의 여행지 월드컵을 이용해 보세요!!</p>
          </div>
        </div>
        <div class="row">
          <div class="col-12 col-md-4 mb-4">
            <div class="card h-100">
              <a href="${root}/view/worldcup/tourWorldcup.jsp?word=숙소">
                <img
                  src="${root}/assets/img/best_top3/accommodation.jpg"
                  class="card-img-top worldcup-main"
                  alt="..."
                />
              </a>
              <div class="card-body">
                <a href="${root}/view/worldcup/tourWorldcup.jsp?word=숙소" class="h2 text-decoration-none text-dark"
                  >숙소</a
                >
                <p class="card-text">전국 유명 관광지 숙소에 대해 추천 받아 볼 수 있습니다.</p>
              </div>
            </div>
          </div>
          <div class="col-12 col-md-4 mb-4">
            <div class="card h-100">
              <a href="${root}/view/worldcup/tourWorldcup.jsp?word=식당">
                <img
                  src="${root}/assets/img/best_top3/restaurant.jpg"
                  class="card-img-top worldcup-main"
                  alt="..."
                />
              </a>
              <div class="card-body">
                <a
                  href="${root}/view/worldcup/tourWorldcup.jsp?word=식당"
                  class="h2 text-decoration-none text-dark"
                  >맛집</a
                >
                <p class="card-text">전국 유명 관광지 맛집에 대해 추천 받아 볼 수 있습니다.</p>
              </div>
            </div>
          </div>
          <div class="col-12 col-md-4 mb-4">
            <div class="card h-100">
              <a href="${root}/view/worldcup/tourWorldcup.jsp?word=축제">
                <img
                  src="${root}/assets/img/best_top3/festival.jpg"
                  class="card-img-top worldcup-main"
                  alt="..."
                />
              </a>
              <div class="card-body">
                <a
                  href="${root}/view/worldcup/tourWorldcup.jsp?word=축제"
                  class="h2 text-decoration-none text-dark"
                  >축제</a
                >
                <p class="card-text">전국 유명 관광지 축제에 대해 추천 받아 볼 수 있습니다.</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- End Featured Product -->

    <!-- Start Footer -->
   	<%@ include file="/view/include/footer.jsp" %>
    <!-- End Footer -->
  </body>
</html>