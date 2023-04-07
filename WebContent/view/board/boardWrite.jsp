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
    <%@ include file="/view/include/header.jsp"%>
    <!-- Close Header -->

    <!-- Open Content -->
    <section class="container py-5" id="open-content-main">
      <div class="row text-center pt-3">
        <div class="col-lg-12 m-auto">
          <h1 class="h1">글쓰기</h1>
          <hr id="board-title-bottomline" />
          <div class="col-lg--12 mt-5">
            <div class="card" style="width: 75%; margin: 0px auto">
              <div class="card-body" style="height: 600px">
                <div class="row col-md-12 justify-content-center" style="padding: 50px">
                  <div class="row col-md-12">
                    <form
                      id="article-form"
                      method="POST"
                      action="${root}/article?action=write"
                      enctype="multipart/form-data"
                    >
                      <div
                        id="board-write-category-selectbox"
                        style="display: flex; margin: 1rem 0"
                      >
                        <select
                          id="board-write-category-select"
                          name="category"
                          style="width: 100px; text-align: center; padding: 3px"
                        >
                          <option value="질문" selected="selected">질문</option>
                          <option value="후기">후기</option>
                          <option value="추천">추천</option>
                        </select>
                      </div>
                      <div class="input-group mb-3">
                        <span class="input-group-text" id="inputGroup-sizing-default">제목</span>
                        <input
                          type="text"
                          name="title"
                          class="form-control"
                          aria-label="Sizing example input"
                          aria-describedby="inputGroup-sizing-default"
                          placeholder="제목을 입력해주세요"
                          required="required"
                        />
                      </div>
                      <div class="input-group mb-3">
                        <span class="input-group-text" id="inputGroup-sizing-default">내용</span>
                        <textarea
                          class="form-control"
                          name="content"
                          aria-label="Sizing example input"
                          aria-describedby="inputGroup-sizing-default"
                          name=""
                          id=""
                          cols="30"
                          rows="10"
                          style="resize: none"
                          required="required"
                        ></textarea>
                      </div>
                      <div style="display: flex; justify-content: flex-end">
                        <div class="filebox" style="display: flex; justify-content: flex-end">
                          <input class="upload-name" placeholder="첨부파일" />
                          <label for="file">파일찾기</label>
                          <input type="file" id="file" name="file" multiple />
                        </div>
                      </div>
                      <div style="margin-top: 1rem">
                        <input id="article-write-btn" type="submit" value="작성" />
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- Close Content -->

    <!-- Start Footer -->
    <%@ include file="/view/include/footer.jsp"%>
    <!-- End Footer -->

    <!-- Start Script -->
    <script src="${root}/assets/js/write.js"></script>
    <!-- End Script -->
  </body>
</html>
