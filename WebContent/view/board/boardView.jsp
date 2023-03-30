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

	<!-- Open Content -->
	<section class="bg-light" id="open-content-main">
		<div class="container pb-5">
			<div class="row">
				<div class="col-lg-5 mt-5 article-main-div">
					<div class="card mb-3">
						<img class="card-img img-fluid card-main-img"
							src="${root}/assets/img/festival/fes1.png" alt="Card image cap"
							id="product-detail" />
					</div>
					<div class="row">
						<!--Start Controls-->
						<div class="col-1 align-self-center">
							<a href="#multi-item-example" role="button" data-bs-slide="prev">
								<i class="text-dark fas fa-chevron-left"></i> <span
								class="sr-only">Previous</span>
							</a>
						</div>
						<!--End Controls-->
						<!--Start Carousel Wrapper-->
						<div id="multi-item-example"
							class="col-10 carousel slide carousel-multi-item"
							data-bs-ride="carousel">
							<!--Start Slides-->
							<div class="carousel-inner product-links-wap" role="listbox">
								<!--First slide-->
								<div class="carousel-item active">
									<div class="row">
										<div class="col-4">
											<a href="#"> <img
												class="card-img img-fluid card-slide-img"
												src="${root}/assets/img/festival/fes1.png"
												alt="Product Image 1" />
											</a>
										</div>
										<div class="col-4">
											<a href="#"> <img
												class="card-img img-fluid card-slide-img"
												src="${root}/assets/img/festival/fes2.png"
												alt="Product Image 2" />
											</a>
										</div>
										<div class="col-4">
											<a href="#"> <img
												class="card-img img-fluid card-slide-img"
												src="${root}/assets/img/festival/fes3.png"
												alt="Product Image 3" />
											</a>
										</div>
									</div>
								</div>
								<!--/.First slide-->

								<!--Second slide-->
								<div class="carousel-item">
									<div class="row">
										<div class="col-4">
											<a href="#"> <img
												class="card-img img-fluid card-slide-img"
												src="${root}/assets/img/festival/fes5.png"
												alt="Product Image 4" />
											</a>
										</div>
										<div class="col-4">
											<a href="#"> <img
												class="card-img img-fluid card-slide-img"
												src="${root}/assets/img/festival/fes6.png"
												alt="Product Image 5" />
											</a>
										</div>
										<div class="col-4">
											<a href="#"> <img
												class="card-img img-fluid card-slide-img"
												src="${root}/assets/img/festival/fes7.png"
												alt="Product Image 6" />
											</a>
										</div>
									</div>
								</div>
								<!--/.Second slide-->
							</div>
							<!--End Slides-->
						</div>
						<!--End Carousel Wrapper-->
					</div>
				</div>
				<!-- col end -->

				<div class="col-lg-7 mt-5">
					<div class="card" style="background-color: inherit; border: 0">
						<div card-body pt-5 pb-5>
							<div class="small mb-3" id="article-category">[추천]</div>
							<h1 class="display-5 fw-bolder">축제 추천입니다.</h1>
							<div>
								<div class="fs-5 mb-5" id="comment-text">조회수 : 0</div>
							</div>

							<p id="article-content-div" class="lead mb-5">Lorem ipsum
								dolor sit amet consectetur adipisicing elit. Praesentium at
								dolorem quidem modi. Nam sequi consequatur obcaecati excepturi
								alias magni, accusamus eius blanditiis delectus ipsam minima ea
								iste laborum vero? Lorem ipsum dolor sit amet consectetur
								adipisicing elit. Praesentium at dolorem quidem modi. Nam sequi
								consequatur obcaecati excepturi alias magni, accusamus eius
								blanditiis delectus ipsam minima ea iste laborum vero?</p>
							<div class="d-flex" style="justify-content: space-between;">
								<div>
									<button class="btn btn-outline-dark flex-shrink-0"
										type="button">
										<i class="bi bi-hand-thumbs-up me-1"></i> 좋아요!
									</button>
									<svg id="article-comment-btn"
										xmlns="http://www.w3.org/2000/svg" fill="none"
										viewBox="0 0 24 24" stroke-width="1" stroke="currentColor"
										style="width: 50px; height: 50px; margin-left: 1rem"
										data-bs-toggle="modal" data-bs-target="#myModal">
                    <path stroke-linecap="round" stroke-linejoin="round"
											d="M7.5 8.25h9m-9 3H12m-9.75 1.51c0 1.6 1.123 2.994 2.707 3.227 1.129.166 2.27.293 3.423.379.35.026.67.21.865.501L12 21l2.755-4.133a1.14 1.14 0 01.865-.501 48.172 48.172 0 003.423-.379c1.584-.233 2.707-1.626 2.707-3.228V6.741c0-1.602-1.123-2.995-2.707-3.228A48.394 48.394 0 0012 3c-2.392 0-4.744.175-7.043.513C3.373 3.746 2.25 5.14 2.25 6.741v6.018z" />
                  </svg>
								</div>

								<div>
									<button class="btn flex-shrink-0"
										type="button" style="background: red;color: white;font-weight: bold">삭제</button>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Close Content -->

	<!-- Start Footer -->
	<%@ include file="/view/include/footer.jsp"%>
	<!-- End Footer -->

	<!-- Start Modal -->
	<div class="modal fade" id="myModal">
		<div class="modal-dialog modal-xl">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">댓 글</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<ul style="list-style: none; padding: 0px">
						<li>
							<div class="article-modal-comment-text">
								쏼라쏼라고고고고고마마마마마마마스스스스스스스습습니니니니니니니다다다다다다다다추추추추추추추추추처처처처처처천드드드듣드드드리리리릴리립니니니니니니니니다다다다다다다다다다
							</div>
							<div class="article-modal-writer">2022-08-11 김싸피</div>
						</li>
						<li>
							<div class="article-modal-comment-text">쏠라쏠라</div>
							<div class="article-modal-writer">2022-08-23 이싸피</div>
						</li>
						<li>
							<div class="article-modal-comment-text">쑬라쑬라</div>
							<div class="article-modal-writer">2022-08-29 전싸피</div>
						</li>
					</ul>
					<div style="display: flex; flex-direction: column">
						<textarea name="" id="article-modal-comment-textarea" cols="10"
							rows="10"></textarea>
						<button id="artilce-modal-comment-write-btn">댓글 작성</button>
					</div>
				</div>
				<!-- Modal footer -->
			</div>
		</div>
	</div>
	<!-- End Modal-->

	<!-- Start Slider Script -->
	<script src="${root}/assets/js/slick.min.js"></script>
	<script>
		$("#carousel-related-product").slick({
			infinite : true,
			arrows : false,
			slidesToShow : 4,
			slidesToScroll : 3,
			dots : true,
			responsive : [ {
				breakpoint : 1024,
				settings : {
					slidesToShow : 3,
					slidesToScroll : 3,
				},
			}, {
				breakpoint : 600,
				settings : {
					slidesToShow : 2,
					slidesToScroll : 3,
				},
			}, {
				breakpoint : 480,
				settings : {
					slidesToShow : 2,
					slidesToScroll : 3,
				},
			}, ],
		});
	</script>
	<!-- End Slider Script -->
</body>
</html>
