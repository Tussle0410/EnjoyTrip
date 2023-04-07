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

    <main style="height: 650px">
      <div class="container-fluid pt-5 mt-5">
        <div class="col-md-6 m-auto text-center">
          <h1 class="h1">여행지 월드컵</h1>
          <hr id="board-title-bottomline" />
        </div>
      </div>

      <section class="container pb-5 mt-5" style="margin-top: 10rem !important">
        <div id="board-searchBar" class="row;">
          <div style="display: flex; justify-content: center; width: 1300px">
            <div
              class="input-group mb-3"
              style="width: 1000px !important; max-width: 1000px !important"
            >
              <input
                type="text"
                class="form-control input-text"
                placeholder="주제를 입력해주세요."
                aria-label="Recipient's username"
                aria-describedby="basic-addon2"
                id="worldcup-search-text"
                style="text-align: center"
                value="<%= request.getParameter("word") %>"
              />
              <div class="input-group-append">
                <button
                  class="btn btn-outline-warning btn-lg"
                  type="button"
                  id="worldcup-search-btn"
                >
                  <i class="fa fa-search"></i>
                </button>
              </div>
            </div>
          </div>
        </div>
      </section>
    </main>

    <!-- Start Footer -->
    <%@ include file="/view/include/footer.jsp" %>
    <!-- End Footer -->

    <!-- Start Script -->
    <script src="${root}/assets/js/worldcup.js"></script>
    <!-- End Script -->
  </body>
</html>
