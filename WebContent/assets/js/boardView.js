let rootUrl = "http://localhost:8080/EnjoyTrip_BackEnd_seoul_10_CHL_JWJ/article";
document.getElementById("article-comment-btn").addEventListener("click", getReview());

document.getElementById("artilce-modal-comment-write-btn").addEventListener("click", function () {
    let reviewContent = document.getElementById("article-modal-comment-textarea");
    if (reviewContent.value == "")
        return;
    let url = rootUrl + "?action=writeReview";
    fetch(url, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            articleNo: getArticleNo(),
            content: reviewContent.value
        })
    })
        .then((response) => {
            if (response.ok) {
                reviewContent.value = '';
                getReview();
            }
        });

})


document.getElementById("article-heart-btn").addEventListener("click", function () {
    let flag = this.value;
    console.log(flag);
    let url = rootUrl;
    if (flag == "false") {
        url += "?action=heartUp&articleNo="+getArticleNo();
        fetch(url, { method: "GET" })
        this.setAttribute("value", true);
        this.setAttribute("class", "btn flex-shrink-0 bg-success bg-gradient");
    } else {
        url += "?action=heartDown&articleNo=" + getArticleNo();
        fetch(url, { method: "GET" })
        this.setAttribute("value", false);
        this.setAttribute("class", "btn btn-outline-dark flex-shrink-0");
    }
})


document.getElementById("article-delete-btn").addEventListener("click", function () {
    location.href = rootUrl + "?action=deleteArticle&articleNo=" + getArticleNo();
})



function getArticleNo() {
    let urlParams = new URL(location.href).searchParams;
    let article_no = urlParams.get("articleNo");
    return article_no;
}

function getReview() {
    let url = rootUrl + "?action=getReview&articleNo=" + getArticleNo();
    fetch(url, { method: "GET" })
        .then((response) => response.json())
        .then((data) => makeReview(data));
}


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