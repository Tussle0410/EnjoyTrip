window.onload = function () {
  document.getElementById("worldcup-search-btn").addEventListener("click", function () {
    let word = document.getElementById("worldcup-search-text").value;
    let url = "https://www.piku.co.kr/w/search/order=hot&keyword=" + word;
    window.open(url);
  });

};
