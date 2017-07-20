<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>WaterMelon</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/prettyPhoto.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/price-range.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
    
    <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${pageContext.request.contextPath}/images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageContext.request.contextPath}/images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageContext.request.contextPath}/images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->

<body>
	<header id="header"><!--header-->
		
		
		<div	 class="header-middle"><!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
							<a href="${pageContext.request.contextPath}/index.jsp"><img src="${pageContext.request.contextPath}/images/home/logo.png" alt="" /></a>
						</div>
						
					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
						<c:choose>
							<c:when test="${sessionScope.userId!=null }">
								<ul class="nav navbar-nav">
									<li><a href="#"> ${sessionScope.userId} 님</a></li>
									<li><a href="${pageContext.request.contextPath}/page/customer/mypage.jsp"><i class="fa fa-user"></i> 마이페이지</a></li>
									<li><a href="${pageContext.request.contextPath}/wm?command=CartSelectByUserId""><i class="fa fa-shopping-cart"></i> 장바구니</a></li>
									<li><a href="${pageContext.request.contextPath}/wm?command=logout">로그아웃</a></li>
									<c:if test="${sessionScope.userId=='admin' }">
										<li><a href="${pageContext.request.contextPath}/page/admin/admin.jsp">관리페이지</a></li>
									</c:if>
								</ul>
							</c:when>
							<c:otherwise>
								<ul class="nav navbar-nav">
									<li><a href="${pageContext.request.contextPath}/page/customer/login.jsp"><i class="fa fa-user"></i> 마이페이지</a></li>
									<li><a href="${pageContext.request.contextPath}/page/customer/login.jsp""><i class="fa fa-shopping-cart"></i> 장바구니</a></li>
									<li><a href="${pageContext.request.contextPath}/page/customer/login.jsp" class="active"><i class="fa fa-lock"></i> Login</a></li>
								</ul>
							</c:otherwise>
						</c:choose>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->
	
		<div class="header-bottom"><!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
						<div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
								<li><a href="${pageContext.request.contextPath}/wm?command=prodall">음반</a></li>
                                <li><a href="${pageContext.request.contextPath}/wm?command=list">Q&A</a></li>
                                <!-- <li><a href="${pageContext.request.contextPath}/page/view/contact.jsp">문의하기</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="search_box pull-right">
							<input type="text" placeholder="Search"/>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-bottom-->
	</header><!--/header-->