<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>

	<div class="container text-center">
		
		<div class="content-404">
			
			<script type="text/javascript">
			 alert("${requestScope.errorMsg}");
			 location.href="${redirectPath}";
			</script> 
			<!-- 
			<h5>
				죄송합니다. 문제가 발생하였습니다.<br>
			발생된 문제 : ${requestScope.errorMsg}<br>
			</h5>
			<a href="wm?command=list"> 리스트로 돌아가기</a>
			 <a href="javascript:history.back()">뒤로가기</a>
			<img src="${pageContext.request.contextPath}/images/404/404.png" class="img-responsive" alt="" />
			
			-->
			<!-- <h3><a href="${pageContext.request.contextPath}/index.jsp">Bring me back Home</a></h3>  -->
		</div>
	</div>


<jsp:include page="footer.jsp"/>