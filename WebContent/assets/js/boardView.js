let rootUrl = "http://localhost:8080/EnjoyTrip_BackEnd_seoul_10_CHL_JWJ/article?action=getReview";
document.getElementById("article-comment-btn").addEventListener("click", function () {
    let urlParams = new URL(location.href).searchParams;
    let article_no = urlParams.get("articleNo");
    let url = rootUrl + "&articleNo=" + article_no;
    fetch(url, { method: "GET" })
        .then((response) => response.json())
        .then((data) => makeReview(data));
});
function makeReview(data) {
    let reviewList = document.getElementById("review-list");
    while (reviewList.firstChild) {
        reviewList.removeChild(reviewList.firstChild);
    }
    data.forEach(function (data) {
        let liEl = document.createElement("li");
        let contentEl = document.createElement("div");
        let dateEl = document.createElement("div");
        let contentText = document.createTextNode(data.content);
        let dateText = document.createTextNode(data.registtime + " " + data.email);
        contentEl.setAttribute("class", "article-modal-comment-text");
        dateEl.setAttribute("class", "article-modal-writer");
        contentEl.appendChild(contentText);
        dateEl.appendChild(dateText);
        liEl.appendChild(contentEl);
        liEl.appendChild(dateEl);
        reviewList.appendChild(liEl);
    });
}