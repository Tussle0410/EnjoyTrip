let serviceKey = "hcKdeTIk7zLMkYbUAHEOcXhKRdrDIV4vUXgKVg31qeqB6eJaWfmjQ9SHI6OzGN3p7qI37SfxIbPrLPp15Iglug%3D%3D";
let rootUrl = "http://localhost:8080/EnjoyTrip_BackEnd_seoul_10_CHL_JWJ/attraction?action=";
let sidoUrl = rootUrl + "sidoFind";
let gugunUrl = rootUrl + "gugunFind&sidoCode=";
let attractionUrl = rootUrl + "attractionFind&sidoCode="
let urlParams = new URL(location.href).searchParams;
let areaCode = urlParams.get("areaCode");   // 시/도 코드
let sigunguCode = urlParams.get("sigunguCode"); // 군/구 코드
let contentCode = urlParams.get("contentCode"); // 관광지 유형
let pageNo = urlParams.get("pageNo");   // 현재 페이지 번호
var positions = [];	// 마커를 표시할 위치와 title 객체 배열입니다

window.onload = () => {
    // 지역별 여행지 처음 이동 시 시/군구 selecBox 목록 얻기
    fetch(sidoUrl, { method: "GET" })
        .then((response) => response.json())
        .then((data) => makeOption(data));

    // 주소값에 파라미터 받을 경우에 초기화 실행
    let param = window.location.search;
    if (param) {
        makeGugun(areaCode, true);
        // 관광지 유형 미리 표시
        if (contentCode) {
            // let areaSel = document.getElementById("search-area");
            // var value = areaSel.options[document.getElementById("search-area").selectedIndex].value;
            // areaSel.options[document.getElementById("search-area").selectedIndex].selected = false;
            let contentSel = document.getElementById("search-content-id");
            for (let i = 0; i < contentSel.childElementCount; i++) {
                if (contentSel.options[i].value == contentCode) {
                    contentSel.value = contentSel.options[i].value;
                }
            }
        }
        let searchUrl = attractionUrl + areaCode + "&gugunCode=" + sigunguCode + "&contentCode=" + contentCode + "&pageNo=" + pageNo;
        fetch(searchUrl, { method: "GET" })
            .then(res => res.json())
            .then(data => showTripList(data));
    } else {
        // 카카오맵 실행
        let startPosition = {
            latlng: {
                Ma: 37.5012767241426,
                La: 127.039600248343
            }
        };
        positions.push(startPosition);
        kakaoMapInit(0, true);
    }

    document.getElementById("search-area").addEventListener("change", function () {
        makeGugun(this.value, false);
    });
};

// 도시 코드 얻어서 selectBox목록 생성
function makeOption(data) {
    let sel = document.getElementById("search-area");
    if (data.length > 0) {
        data.forEach(function (data) {
            let opt = document.createElement("option");
            opt.setAttribute("value", data.sidoCode);
            if (areaCode == data.sidoCode) {
                opt.setAttribute("selected", "selected");
            }
            opt.appendChild(document.createTextNode(data.sidoName));
            sel.appendChild(opt);
        });
    }
};

// selectBox 도시 선택 후 해당 도시의 군,구 selectBox목록 생성
function makeGugun(target, isFirst) {
    let url = gugunUrl + target;
    fetch(url, { method: "GET" })
        .then((response) => response.json())
        .then((data) => makeGugunOption(data, isFirst));
}

function makeGugunOption(data, isFirst) {
    let sel = document.getElementById("search-gungu");
    // 이전 값 존재하면 제거
    for (let i = sel.options.length - 1; i > 0; i--) {
        sel.remove(i);
    }

    if (data.length > 0) {
        data.forEach(function (data) {
            let opt = document.createElement("option");
            opt.setAttribute("value", data.gugunCode);
            if (isFirst && sigunguCode == data.gugunCode) {
                opt.setAttribute("selected", "selected");
            }
            opt.appendChild(document.createTextNode(data.gugunName));
            sel.appendChild(opt);
        });
    }
}

// 지역별 유형별 검색
document.getElementById("btn-search").addEventListener("click", () => {
    let sidoCode = document.getElementById("search-area").value;
    let gngunCode = document.getElementById("search-gungu").value;
    let contentCode = document.getElementById("search-content-id").value;
    if (sidoCode == 0) {
        alert("지역을 선택하세요");
        return;
    }
    if (gngunCode == 0) {
        alert("군/구를 선택하세요");
        return;
    }
    if (contentCode == 0) {
        alert("관광지 유형을 선택하세요");
        return;
    }

    let searchUrl = attractionUrl + sidoCode + "&gugunCode=" + gngunCode + "&contentCode=" + contentCode;
    fetch(searchUrl, { method: "GET" })
        .then(res => res.json())
        .then(data => showTripList(data));

});

function showTripList(data) {
    positions = new Array();
    let tbody = document.getElementById("trip-list");
    let tbodyContents = ``;
    if (data.length == 0) {
        tbodyContents += `
        <tr>
            <td colspan="3">데이터가 없습니다.</td>
        </tr>`;
    } else {
        let idx = 0;
        data.forEach(data => {
            var position = {};
            tbodyContents += `
            <tr>
                <td><img src="${data.firstImage == '' ? root + "/assets/img/etc/ssafy_logo.png" : data.firstImage}" class="tripListImage" /></td>
                <td><a href="javascript:moveMarker(${idx});">${data.title}</a></td>
                <td>${data.addr1} ${data.addr2}</td>
            </tr>`;
            position = {
                title: data.title,
                latlng: new kakao.maps.LatLng(data.latitude, data.longitude),
                addr1: data.addr1,
                addr2: data.addr2,
                firstImage: data.firstImage
            };
            positions.push(position);
            idx++;
        });
    }
    tbody.innerHTML = tbodyContents;
    kakaoMapInit(0, false);
}

/* ----------------------------------------- 카카오맵 API 구문 ----------------------------------------- */
// 카카오맵 초기 생성
var map;
function kakaoMapInit(idx, isFirst) {
    var container = document.getElementById("map"); // 지도를 담을 영역의 DOM 레퍼런스
    var options = {
        // 지도를 생성할 때 필요한 기본 옵션
        center: new kakao.maps.LatLng(positions[idx].latlng.Ma, positions[idx].latlng.La), // 지도의 중심좌표.																				
        level: isFirst ? 13 : 3, // 지도의 레벨(확대, 축소 정도)
    };

    map = new kakao.maps.Map(container, options); // 지도 생성 및 객체 리턴
    // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
    var mapTypeControl = new kakao.maps.MapTypeControl();

    // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
    // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
    map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

    // 지도 확대 축소를 제어할 수 있는 줌 컨트롤을 생성합니다
    var zoomControl = new kakao.maps.ZoomControl();
    map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

    // 마커 생성
    if (!isFirst) showMarker();
}

// 마커 생성
function showMarker() {
    // 마커 이미지의 이미지 주소입니다
    var imageSrc = root + "/assets/img/marker/location.png";
    var marker;

    for (var i = 0; i < positions.length; i++) {
        // 마커 이미지의 이미지 크기 입니다
        var imageSize = new kakao.maps.Size(24, 35);

        // 마커 이미지를 생성합니다
        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

        // 마커를 생성합니다
        marker = new kakao.maps.Marker({
            map: map, // 마커를 표시할 지도
            position: positions[i].latlng, // 마커를 표시할 위치
            title: positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
            image: markerImage, // 마커 이미지

        });
        // 커스텀 오버레이 생성
        showCustomOverlay(marker, i);
    }

}

//해당 위치로 맵 이동
function moveMarker(idx) {
    let moveLatLon = new kakao.maps.LatLng(positions[idx].latlng.Ma, positions[idx].latlng.La);
    map.panTo(moveLatLon);
}

// 커스텀 오버레이 생성
let overlays = [];
function showCustomOverlay(marker, idx) {
    // 커스텀 오버레이에 표시할 컨텐츠 입니다
    // 커스텀 오버레이는 아래와 같이 사용자가 자유롭게 컨텐츠를 구성하고 이벤트를 제어할 수 있기 때문에
    // 별도의 이벤트 메소드를 제공하지 않습니다

    var content = `
    <div class="wrap">
        <div class="info">
            <div class="title"> ${positions[idx].title}
            <div class="close" onclick="closeOverlay(${idx})" title="닫기"></div>
            </div>
            <div class="body">
                <div class="img">
                    <img src="${positions[idx].firstImage}" width="73" height="70">
                </div>
                <div class="desc">
                <div class="ellipsis">${positions[idx].addr1}</div>
                        <div class="jibun ellipsis">${positions[idx].addr2}</div>
                   </div>
                </div>
           </div> 
        </div>;
    `;

    // 마커 위에 커스텀오버레이를 표시합니다
    // 마커를 중심으로 커스텀 오버레이를 표시하기위해 CSS를 이용해 위치를 설정했습니다
    var customOverlay = new kakao.maps.CustomOverlay({
        content: content,
        map: map,
        position: marker.getPosition()
    });

    overlays.push(customOverlay);

    //마커를 클릭했을 때 커스텀 오버레이를 표시합니다
    kakao.maps.event.addListener(marker, 'click', function () {
        customOverlay.setMap(map);
    });
}

//커스텀 오버레이를 닫기 위해 호출되는 함수입니다
function closeOverlay(idx) {
    overlays[idx].setMap(null);
}




