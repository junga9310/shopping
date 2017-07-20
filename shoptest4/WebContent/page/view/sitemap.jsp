<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../view/header.jsp"/>
	
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<div class="left-sidebar ">
						<h2>메뉴</h2>
						<div class="panel-group category-products  text-center" >
							
							<div class="panel panel-default ">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="${pageContext.request.contextPath}/index.jsp">홈</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="${pageContext.request.contextPath}/page/view/info.jsp">음반</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="${pageContext.request.contextPath}/wm?command=list">QNA</a></h4>
								</div>
							</div>
							
						</div><!--/category-products-->
					
					
					</div>
				</div>
				<div class="col-sm-3">
					<div class="left-sidebar">
						<h2>서비스</h2>
						<div class="panel-group category-products  text-center" >
							
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="${pageContext.request.contextPath}/page/view/shopinfo.jsp">쇼핑몰 소개</a></h4>
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
				
								
				<div class="col-sm-3">
					<div class="left-sidebar">
						<h2>회원</h2>
						<div class="panel-group category-products text-center" >
							
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="${pageContext.request.contextPath}/page/customer/login.jsp">로그인</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="${pageContext.request.contextPath}/page/customer/join.jsp">회원가입</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="${pageContext.request.contextPath}/page/view/sitemap.jsp">장바구니</a></h4>
								</div>
							</div>
							
						</div><!--/category-products-->
					
					
					</div>
				</div>
				
				<div class="col-sm-3">
					<div class="left-sidebar">
						<h2>마이페이지</h2>
						<div class="panel-group category-products text-center" >
							
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a onclick="login_chk()" href="#">마이페이지</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a onclick="login_chk1()" href="#">정보수정</a></h4>
								</div>
							</div>
							
						</div><!--/category-products-->
					
					
					</div>
				</div>
			</div>
		</div>
	</section>
	
<script type="text/javascript">
  
    function login_chk(){
    	if(${userId!=null}){
    		window.location.href="${pageContext.request.contextPath}/page/customer/mypage.jsp";
     	}else{
     		alert("로그인 하셔야 이동이 가능합니다.");
     	}
    	
    }
    function login_chk1(){
    	if(${userId!=null}){
    		window.location.href="${pageContext.request.contextPath}/wm?command=selectByUser";
     	}else{
     		alert("로그인 하셔야 이동이 가능합니다.");
     	}
    	
    }
</script>
	
<jsp:include page="../view/footer.jsp"/>