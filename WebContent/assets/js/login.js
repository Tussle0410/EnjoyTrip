window.onload = function () {
  document.querySelector("#retrobg-sun").onclick = () => {
    document.querySelector("#retrobg").classList.toggle("retrobg-shutdown");
  };

  document.getElementById("sign-btn").addEventListener("click", () => {
    let email = document.getElementById("email-input").value;
    let pw = document.getElementById("pw-input").value;
    if (!email) {
      alert("이메일을 적어주세요");
      return;
    }
    if (!pw) {
      alert("비밀번호를 적어주세요");
      return;
    }

    // email : ssafy@ssafy.com
    // pw : 1234
    if (email != "ssafy@ssafy.com" || pw != "1234") {
      alert("이메일 또는 비밀번호가 다릅니다.");
      return;
    }

    let userInfo = {
      "email": email,
      "pw": pw
    }
    localStorage.setItem("userInfo", JSON.stringify(userInfo));
    location.href = location.origin + "/EnjoyTrip_BackEnd_seoul_10_CHL_JWJ/view/main.jsp";
  });
};

