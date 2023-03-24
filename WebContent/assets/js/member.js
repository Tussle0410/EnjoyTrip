function logout() {
    localStorage.removeItem("userInfo");
    location.href = location.host + "/EnjoyTrip_BackEnd_seoul_10_CHL_JWJ/view/member/login.jsp";
}