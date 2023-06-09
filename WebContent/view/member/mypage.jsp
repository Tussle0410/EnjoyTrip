<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Mammoth Trip</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
</head>

<body>
	<!-- Header -->
	<%@ include file="/view/include/header.jsp"%>
	<!-- Close Header -->

	<!-- Start Banner Hero -->
	<div class="container-fluid pt-5 mt-5">
		<div class="col-md-6 m-auto text-center">
			<h1 class="h1">마이 페이지</h1>
			<hr id="board-title-bottomline" />
		</div>
	</div>
	<!-- End Banner Hero -->

	<!-- Start Categories of The Month -->
	<section class="container py-5">
		<div class="row text-center pt-3">
			<div class="col-lg-12 m-auto">
				<div class="col-lg--12 mt-5">
					<div class="card">
						<h1 class="h1" style="margin-top: 1.5rem">내 정보</h1>
						<div class="card-body" style="height: 300px">
							<div class="row col-md-12 justify-content-center"
								style="padding: 50px">
								<div class="row col-md-2" class="profile">
									<img src="${root}/assets/img/etc/noimg.png" alt="" />
								</div>
								<div class="row col-md-7">
									<form action="${root}/member" id="userinfo-form" method="POST">
										<input type="hidden" name="action" value="edit" />
										<div class="input-group mb-3">
											<span class="input-group-text" id="inputGroup-sizing-default">이메일</span>
											<input type="text" class="form-control"
												aria-label="Sizing example input"
												aria-describedby="inputGroup-sizing-default" name="email"
												value="${userInfo.email}" readonly />
										</div>
										<div class="input-group mb-3">
											<span class="input-group-text" id="inputGroup-sizing-default">이름</span>
											<input type="text" class="form-control"
												aria-label="Sizing example input"
												aria-describedby="inputGroup-sizing-default" name="name"
												value="${userInfo.name }" />
										</div>
										<div class="row mt-2 justify-content-center">
											<input class="mypage-btn mypage-update col-md-2 p-2" type="submit" value="수정" /> 
											<a href="${root}/view/main.jsp" class="mypage-btn mypage-back col-md-2 p-2" >돌아가기</a>
										</div>
									</form>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- End Categories of The Month -->

	<!-- Start Footer -->
	<%@ include file="/view/include/footer.jsp"%>
	<!-- End Footer -->

</body>
</html>
