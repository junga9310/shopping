<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../view/header.jsp"/>


<div class="container">
			<div class="row">
			
				<div class="col-sm-3">
					<div class="left-sidebar">
						<h2>관리페이지</h2>
						<div class="panel-group category-products" >
							
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="${pageContext.request.contextPath}/wm?command=selectCustAll">회원관리(리스트)</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="${pageContext.request.contextPath}/wm?command=selectoutdate">탈퇴회원리스트</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="${pageContext.request.contextPath}/page/product/productInput.jsp">상품등록하기</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="${pageContext.request.contextPath}/wm?command=prodselectall">상품리스트</a></h4>
								</div>
							</div>
						</div><!--/category-products-->
					
					
					</div>
				</div>
				<div class="col-sm-8">
					<table align="center" border="0"  width="100%" >
					<caption><h3>탈퇴회원리스트 LIST</h3></caption>
						
						<tr bgcolor="#fdb45e" style="text-align:center;color:#FFF;font-size:15px;">
					       <td>회원아이디</td>
					       <td>회원이름</td>
					       <td>회원등급</td>
					       <td>회원가입날짜</td>
					       <td>회원탈퇴날짜</td>
					       <td>삭제</td>
					       
					    </tr>
					    
					    <c:choose>
					    <c:when test="${empty requestScope.list}">
						   <tr>
					        <td colspan="5">
					            <p align="center"><b><span style="font-size:9pt;">탈퇴한 회원이 없습니다.</span></b></p>
					        </td>
					  	  </tr>
					    </c:when>
					    <c:otherwise>
						<c:forEach items="${requestScope.list}" var="custdto">
							   <tr style="text-align:center;" onmouseover="this.style.background='#eaeaea'" onmouseout="this.style.background='white'" style="background: white;" >
							       <td>${custdto.u_id}</td>
							       <td>${custdto.u_name} </td>
							       <td> ${custdto.u_level}</td>
							       <td> ${custdto.u_indate}</td>
							       <td> ${custdto.u_outdate}</td>
							       <td><a href="wm?command=customerDelete&&userID=${custdto.u_id}">삭제</a></td>
							    </tr>
					    </c:forEach>
						</c:otherwise>
					    </c:choose>
					</table>
	
				</div>
			</div>
		</div>
	</section>
	
	
<jsp:include page="../view/footer.jsp"/>