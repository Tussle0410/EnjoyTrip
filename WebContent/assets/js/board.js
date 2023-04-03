window.onload = function () {
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
        });
    }
}
