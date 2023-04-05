let rootUrl = "http://localhost:8080/EnjoyTrip_BackEnd_seoul_10_CHL_JWJ/article";
let categoryLabel = document.querySelectorAll(".portfolio-label");
let categoryarr = ["전체", "질문", "후기", "추천"];
for (let i = 0; i < categoryLabel.length;i++) {
    categoryLabel[i].addEventListener("click", function () {
        for (let j = 0; j < categoryLabel.length;j++) {
            if (i == j) {
                categoryLabel[j].setAttribute("class", "filter-active portfolio-label");
            } else {
                categoryLabel[j].setAttribute("class", "portfolio-label");
            }
        }
        let bordername = document.getElementById("borader-category-name");
        let nameTn = document.createTextNode(categoryarr[i] + " 게시판");
        bordername.innerText = '';
        bordername.appendChild(nameTn);
        let url = rootUrl + "?action=categoryList&category=" + categoryarr[i];
        fetch(url, { method: "GET" })
        .then((response) => response.json())
        .then((data) => makeArticle(data));
    });
}

function makeArticle(data) {
    let articleList = document.getElementById("board-table-body");
    articleList.innerHTML = ``;
    data.forEach(function (data) {
        content = `                    <tr>
        <td>${data.articleNo}</td>
        <td class="border-category" style="color: #ad7be9">
          ${data.articleCategory }
        </td>
        <td class="border-title">
          <a
            href="${root}/article?action=view&articleNo=${data.articleNo}"
            style="text-decoration: none; color: black; font-weight: bold !important"
            >${data.content}</a
          >
        </td>
        <td>${data.email}</td>
        <td>${data.registTime }</td>
        <td>${data.hit }</td>
        <td>${data.heart }</td>
      </tr>`
        articleList.innerHTML += content;
    });
}
