<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<jsp:include page="../view/header.jsp"/>
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<div class="left-sidebar">
						<h2>장르</h2>
						<div class="panel-group category-products" id="accordian"><!--category-productsr-->
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="wm?command=prodgenre&p_genre=ballad">발라드</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="wm?command=prodgenre&p_genre=dance">댄스</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="wm?command=prodgenre&p_genre=hiphop">랩/힙합</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="wm?command=prodgenre&p_genre=classic">인디음악</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="wm?command=prodgenre&p_genre=rock">록/메탈</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="wm?command=prodgenre&p_genre=ost">OST</a></h4>
								</div>
							</div>
							
						</div><!--/category-products-->
					
						<!--shipping -->
						<div class="shipping text-center">
							<img src="${pageContext.request.contextPath}/images/home/left_2.png" alt="" />
						</div>
						<!--/shipping-->
					
					</div>
				</div>

			<c:forEach items="${requestScope.list}" var="prod">		
				<div class="col-sm-9 padding-right">
					<div class="product-details"><!--product-details-->
						<div class="col-sm-5">
							<div class="view-product">
								<img id="p_image" class="img-responsive" src="${pageContext.request.contextPath}/save/${prod.p_image}" alt="" />
								<!--  여기에 image를 받아서 p_id에 해당하는 ! -->
							</div>
							
						</div>
						<div class="col-sm-7">
							<div class="product-information"><!--/product-information-->
								<img src="${pageContext.request.contextPath}/images/product-details/new.jpg" class="newarrival" alt="" />
								<h2 id="p_name">${prod.p_name}</h2>
								<!-- p_id에 해당하는 상품 명 -->
								<p id="p_singer">${prod.p_singer}</p>
								<!-- p_id에 해당하는 상품 명 -->
								<span>
									<span id="p_price">${prod.p_price}</span>
								<!-- p_id에 해당하는 상품 가격-->	
									<button type="button" class="btn btn-fefault cart">
										<i class="fa fa-shopping-cart"></i>
										<a href="${pageContext.request.contextPath}/wm?command=CartInsert&prodId=${prod.p_id}&cartImage=${prod.p_image}">장바구니</a>
									</button>
									</button>
								</span>
								<p><b>장르:</b> ${prod.p_genre}</p>
								<p><b>소속사:</b> ${prod.p_comp}</p>
							</div><!--/product-information-->
						</div>
					</div><!--/product-details-->
				
					<div class="category-tab shop-details-tab"><!--category-tab-->
						<div class="col-sm-12">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#details" data-toggle="tab">음반 설명</a></li>
								
								<li><a href="#reviews" data-toggle="tab">음반 구성</a></li>
							</ul>
						</div>
						<div class="tab-content">
							<div class="tab-pane fade active in" id="details" >
							<!-- 상세 설명 우쩔까!!  -->
								<p>${prod.p_desc}</p>
							</div>
									
							
							<div class="tab-pane fade in" id="reviews" >
								<div class="col-sm-12">
									<img class="img-responsive" src="${pageContext.request.contextPath}/images/product-details/def.jpg" alt="" />
								</div>
							</div>
							
						</div>
					</div><!--/category-tab-->
					
				</div>
			</c:forEach>	
			</div>
		</div>
	</section>
	
<jsp:include page="../view/footer.jsp"/>