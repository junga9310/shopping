<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../view/header.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
 
<script type="text/javascript" charset="UTF-8">
</script>

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
							<img src="images/home/left_3.png" alt="" />
						</div>
						<!--/shipping-->
					
					</div>
				</div>
				
				<div class="col-sm-9 padding-right">
					<div class="features_items"><!--features_items-->
						 <h2 class="title text-center">검색(장르)음반</h2> 
					<c:forEach items="${requestScope.list}" var="prod">		

						<!--  -->
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
										<div class="productinfo text-center">
											<a id="p_image" href="wm?command=proddetail&p_id=${prod.p_id}"><img src="${pageContext.request.contextPath}/save/${prod.p_image}" alt="" /></a>
											<h4 id="p_price">${prod.p_price}원</h4>
											<p id="p_singer">${prod.p_singer} - ${prod.p_name}</p>
											<a href="wm?command=proddetail&p_id='${prod.p_id}'" class="btn btn-default">자세히보기</a>
										</div>			
								</div>
							</div>
						</div>		
					</c:forEach>	
						
						<!--  -->
						
						
											
					</div><!--features_items-->
				</div>
			</div>
		</div>
	</section>
	
<jsp:include page="../view/footer.jsp"/>