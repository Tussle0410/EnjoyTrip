let rootUrl = "http://localhost:8080/EnjoyTrip_BackEnd_seoul_10_CHL_JWJ/article";
let categoryLabel = document.querySelectorAll(".portfolio-label");
for (let i = 0; i < categoryLabel.length; i++) {
  categoryLabel[i].addEventListener("click", function () {
    let url =
      rootUrl + "?action=categoryList&pageNo=1&categoryidx=" + i;
    location.href = url;
  });
}
document.getElementById("search-title_btn").addEventListener("click", function () {
  let txt = document.getElementById("search-title-text").value;
  if (txt == "") return;
  location.href = rootUrl + "?action=titleList&title=" + txt + "&pageNo=1";
});
