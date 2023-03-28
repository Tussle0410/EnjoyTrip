let serviceKey = "hcKdeTIk7zLMkYbUAHEOcXhKRdrDIV4vUXgKVg31qeqB6eJaWfmjQ9SHI6OzGN3p7qI37SfxIbPrLPp15Iglug%3D%3D";
let sidoUrl ="http://localhost:8080/EnjoyTrip_BackEnd_seoul_10_CHL_JWJ/attraction?action=sidoFind";
let gugunUrl ="http://localhost:8080/EnjoyTrip_BackEnd_seoul_10_CHL_JWJ/attraction?action=gugunFind&sidoCode=";

window.onload = () => {
    // 지역별 여행지 페이지 들어갈 떄 selectBox 도시 목록 얻기
    fetch(sidoUrl, { method: "GET"})
        .then((response) => response.json())
        .then((data) => makeOption(data));

    // 주소값에 파라미터 받을 경우에 초기화 실행
    let param = window.location.search;
    if (param) {
        init(param);
        setSelectBox();
    }
    document.getElementById("search-area").addEventListener("change", function () {
    	makeGugun(this.value);
    });
};

function init(param) {
    let tmpParam = param.replace('?', '&');
    let searchUrl = `https://apis.data.go.kr/B551011/KorService1/areaBasedList1?serviceKey=${serviceKey}&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json&listYN=Y&arrange=A&contentTypeId=12${tmpParam}`;
    fetch(searchUrl, { method: "GET" })
        .then(res => res.json())
        .then(data => showTripList(data));
    let urlParams = new URL(location.href).searchParams;
    let areaCode = urlParams.get("areaCode");
    let gunGuUrl = `https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey=hcKdeTIk7zLMkYbUAHEOcXhKRdrDIV4vUXgKVg31qeqB6eJaWfmjQ9SHI6OzGN3p7qI37SfxIbPrLPp15Iglug%3D%3D&numOfRows=100&pageNo=1&MobileOS=ETC&MobileApp=AppTest&areaCode=${areaCode}&_type=json`;
    fetch(gunGuUrl, { method: "GET" })
        .then((response) => response.json())
        .then((data) => makeGunGuOption(data));
};

function setSelectBox() {
    let urlParams = new URL(location.href).searchParams;
    let areaCode = urlParams.get("areaCode");
    let sigunguCode = urlParams.get("sigunguCode");
    document.getElementById("search-area").value = areaCode;
    document.getElementById("search-gungu").value = sigunguCode;
    document.getElementById("search-content-id").value = 12;    // default: 관광지
}



// 도시 코드 얻어서 selectBox목록 생성
function makeOption(data) {
    let sel = document.getElementById("search-area");
    data.forEach(function (data) {
        let opt = document.createElement("option");
        opt.setAttribute("value", data.sidoCode);
        opt.appendChild(document.createTextNode(data.sidoName));
        sel.appendChild(opt);
    });
};

// selectBox 도시 선택 후 해당 도시의 군,구 selectBox목록 생성
function makeGugun(target) {
    let url = gugunUrl + target;
    fetch(url, { method: "GET" })
        .then((response) => response.json())
        .then((data) => makeGugunOption(data));
}

function makeGugunOption(data) {
    let sel = document.getElementById("search-gungu");
    // 이전 값 존재하면 제거
    for (let i = sel.options.length - 1; i > 0; i--) {
        sel.remove(i);
    }

    data.forEach(function (data) {
        let opt = document.createElement("option");
        opt.setAttribute("value", data.gugunCode);
        opt.appendChild(document.createTextNode(data.gugunName));
        sel.appendChild(opt);
    });
}

// 지역별 유형별 검색
document.getElementById("btn-search").addEventListener("click", () => {
    let areaCode = document.getElementById("search-area").value;
    let sigunguCode = document.getElementById("search-gungu").value;
    let category = document.getElementById("search-content-id").value;
    // console.log(areaCode + ", " + sigunguCode + ", " + category);
    if (areaCode == 0) {
        alert("지역을 선택하세요");
        return;
    }
    if (sigunguCode == 0) {
        alert("군/구를 선택하세요");
        return;
    }
    if (category == 0) {
        alert("관광지 유형을 선택하세요");
        return;
    }

    let searchUrl = `https://apis.data.go.kr/B551011/KorService1/areaBasedList1?serviceKey=${serviceKey}&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json&listYN=Y&arrange=A&contentTypeId=${category}&areaCode=${areaCode}&sigunguCode=${sigunguCode}`;
    fetch(searchUrl, { method: "GET" })
        .then(res => res.json())
        .then(data => showTripList(data));

});

// 마커를 표시할 위치와 title 객체 배열입니다 
var positions = [];
function showTripList(data) {
    positions = new Array();
    // console.log(data)
    let tbody = document.getElementById("trip-list");
    let tbodyContents = ``;
    if (data.response.body.totalCount == 0) {
        alert("데이터가 없습니다.");
        return;
    }
    data.response.body.items.item.forEach(location => {
        var position = {};
        tbodyContents += `
        <tr>
            <td><img src="${location.firstimage == "" ? './assets/img/etc/ssafy_logo.png' : location.firstimage}" class="tripListImage" /></td>
            <td>${location.title}</td>
            <td>${location.addr1} ${location.addr2}</td>
        </tr>`;
        position = {
            title: location.title,
            latlng: new kakao.maps.LatLng(location.mapy, location.mapx)
        };
        positions.push(position);
    });
    tbody.innerHTML = tbodyContents;

    // console.log(positions);
    var container = document.getElementById("map"); //지도를 담을 영역의 DOM 레퍼런스
    var options = {
        //지도를 생성할 때 필요한 기본 옵션
        center: new kakao.maps.LatLng(positions[0].latlng.Ma, positions[0].latlng.La), //지도의 중심좌표.
        level: 3, //지도의 레벨(확대, 축소 정도)
    };

    var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

    // 마커 이미지의 이미지 주소입니다
    var imageSrc = "./assets/img/marker/location.png";

    if (positions.length > 0) {
        for (var i = 0; i < positions.length; i++) {
            // 마커 이미지의 이미지 크기 입니다
            var imageSize = new kakao.maps.Size(24, 35);

            // 마커 이미지를 생성합니다
            var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

            // 마커를 생성합니다
            var marker = new kakao.maps.Marker({
                map: map, // 마커를 표시할 지도
                position: positions[i].latlng, // 마커를 표시할 위치
                title: positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
                image: markerImage, // 마커 이미지

            });
            marker.setMap(map);
        }
    }

    // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
    var mapTypeControl = new kakao.maps.MapTypeControl();

    // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
    // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
    map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

    // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
    var zoomControl = new kakao.maps.ZoomControl();
    map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

    // 마커가 지도 위에 표시되도록 설정합니다

    // 아래 코드는 지도 위의 마커를 제거하는 코드입니다
    // marker.setMap(null);
}