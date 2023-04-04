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
    <div class="container-fluid pt-5 mt-5">
      <div class="col-md-6 m-auto text-center">
        <h1 class="h1">여행지 월드컵</h1>
        <hr id="board-title-bottomline" />
      </div>
    </div>
    <!-- End Banner Hero -->

    <!-- Start Categories of The Month -->
    <section class="container py-5">
      <div class="row text-center pt-3">
        <div class="col-lg-12 m-auto">
          <div class="col-lg--12 mt-5">
            <div class="card">
              <h1 class="h1" id="title" style="margin-top: 1.5rem">test</h1>
              <div class="card-body row col-md-12" id="main-view">
                <div class="row justify-content-center">
                  <a href="#" class="row col-md-5">
                    <img src="${root}/assets/img/accom/busan_comodo_hotel.jpg" alt="" />
                  </a>
                  <div class="row col-md-1"><p class="vs-text">VS</p></div>
                  <a href="#" class="row col-md-5">
                    <img src="${root}/assets/img/accom/busan_hotel1_hotel.jpg" alt="" />
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- End Categories of The Month -->

    <!-- Start Footer -->
    <%@ include file="/view/include/footer.jsp" %>
    <!-- End Footer -->
    
    <!-- Start Script -->
    <script src="${root}/assets/js/worldcup.js"></script>
    <!-- End Script -->
  </body>
</html>
    