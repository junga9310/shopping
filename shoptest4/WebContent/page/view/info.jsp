<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../view/header.jsp"/>
	
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<div class="left-sidebar">
						<h2>서비스</h2>
						<div class="panel-group category-products">
							
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a class="active" href="${pageContext.request.contextPath}/page/view/shopinfo.jsp">쇼핑몰 소개</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="${pageContext.request.contextPath}/page/view/info.jsp">개인정보취급방침</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="${pageContext.request.contextPath}/page/view/sitemap.jsp">사이트맵</a></h4>
								</div>
							</div>
							
						</div><!--/category-products-->
					
					
					</div>
				</div>
				
				<div class="col-sm-8">
					<div class="service_wrap">
						<!-- service_head -->
						<div class="service_head">
							<div class="wrap">
								<h2><span class="bg_service sp_title title2">WaterMelon 개인정보취급방침</span></h2>
								
							</div>
						</div>
						<!-- //service_head -->
						<!-- service_con -->		
						<iframe src="http://www.gmarket.co.kr/challenge/neo_help/TermsPolicy/ifrTermsPolicy29.html" id="targetFrame" name="targetFrame" title="개인정보취급방침" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" style="width:100%" height="6619"></iframe>
						<!-- //service_con -->		
						<a href="#top" class="agree_top" style="top: 500px;"><span class="bg_service btn_top">TOP</span></a>
				
					</div>

				</div>
			</div>
		</div>
	</section>
	
	
<jsp:include page="../view/footer.jsp"/>