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

    <!-- Open Content -->
    <section class="container py-5" id="open-content-main">
      <div class="row text-center pt-3">
        <div class="col-lg-12 m-auto">
          <h1 class="h1">글쓰기</h1>
          <hr id="board-title-bottomline" />
          <div class="col-lg--12 mt-5">
            <div class="card" style="width: 75%; margin: 0px auto">
              <div class="card-body" style="height: 500px">
                <div class="row col-md-12 justify-content-center" style="padding: 50px">
                  <div class="row col-md-12">
                    <form action="" id="article-form" method="POST">
                      <div class="input-group mb-3">
                        <span class="input-group-text" id="inputGroup-sizing-default">제목</span>
                        <input
                          type="text"
                          class="form-control"
                          aria-label="Sizing example input"
                          aria-describedby="inputGroup-sizing-default"
                          placeholder="제목을 입력해주세요"
                        />
                      </div>
                      <div class="input-group mb-3">
                        <span class="input-group-text" id="inputGroup-sizing-default">내용</span>
                        <textarea
                          class="form-control"
                          aria-label="Sizing example input"
                          aria-describedby="inputGroup-sizing-default"
                          name=""
                          id=""
                          cols="30"
                          rows="10"
                          style="resize: none"
                        ></textarea>
                      </div>
                      <div style="display: flex; justify-content: flex-end">
                        <div class="filebox" style="display: flex; justify-content: flex-end">
                          <input class="upload-name" value="첨부파일" placeholder="첨부파일" />
                          <label for="file">파일찾기</label>
                          <input type="file" id="file" multiple />
                        </div>
                      </div>
                      <div style="margin-top: 1rem">
                        <input id="article-write-btn" type="button" value="작성" />
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="row"></div>
    </section>
    <!-- Close Content -->

    <!-- Start Footer -->
	<%@ include file="/view/include/footer.jsp" %>
    <!-- End Footer -->

    <!-- Start Script -->
    <script src="${root}/assets/js/write.js"></script>
    <!-- End Script -->
  </body>
</html>
    