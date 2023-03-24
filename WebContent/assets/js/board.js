window.onload = function () {
    let categoryLabel = document.querySelectorAll(".portfolio-label");
    let categoryarr = ["전체", "질문", "후기", "추천"];
    for (let i = 0; i < categoryLabel.length;i++) {
        console.log(categoryLabel[i]);
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
            console.log(nameTn);
            bordername.innerText = '';
            bordername.appendChild(nameTn);
        })
    }
    let articles = document.querySelectorAll(".border-title");
    for (const title of articles) {
        title.addEventListener("click", function () {
            location.href = "article.html";
        })
    }
    document.getElementById("article-write-mvbtn").addEventListener("click", function () {
        location.href = "articlewrite.html";
    })
}