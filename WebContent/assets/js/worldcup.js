window.onload = function () {
    let urlParams = new URL(location.href).searchParams;
    let type = urlParams.get("type");
    if (type == null) {
        type = 'accom';
    }
    let title;
    let content;
    if (type == 'accom') {
        title = document.createTextNode('숙소');
        content = `
        <div class="row justify-content-center">
        <a href="#" class="row col-md-5">
          <img src="${root}/assets/img/accom/busan_comodo_hotel.jpg" alt="" />
        </a>
        <div class="row col-md-1"><p class="vs-text">VS</p></div>
        <a href="#" class="row col-md-5">
          <img src="${root}/assets/img/accom/busan_hotel1_hotel.jpg" alt="" />
        </a>
      </div>
        `;
    } else if (type == 'restaurant') {
        title = document.createTextNode('맛집');
        content = `
        <div class="row justify-content-center">
        <a href="#" class="row col-md-5">
          <img src="${root}/assets/img/restaurant/res1.png" alt="" />
        </a>
        <div class="row col-md-1"><p class="vs-text">VS</p></div>
        <a href="#" class="row col-md-5">
          <img src="${root}/assets/img/restaurant/res2.png" alt="" />
        </a>
      </div>
        `;
    } else if (type == 'festival') {
        title = document.createTextNode('축제');
        content = `
        <div class="row justify-content-center">
        <a href="#" class="row col-md-5">
          <img src="${root}/assets/img/festival/fes1.png" alt="" />
        </a>
        <div class="row col-md-1"><p class="vs-text">VS</p></div>
        <a href="#" class="row col-md-5">
          <img src="${root}/assets/img/festival/fes2.png" alt="" />
        </a>
      </div>
        `;
    }

    document.getElementById("title").innerText = '';
    document.getElementById("title").appendChild(title);
    document.getElementById("main-view").innerHTML = content;
}