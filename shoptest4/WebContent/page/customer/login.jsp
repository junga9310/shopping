<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../view/header.jsp"/>
	
	<section id="form"><!--form-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-4">
					<div class="login-form"><!--login form-->
						<h2>로그인</h2>
						<form action="${pageContext.request.contextPath}/wm?command=login" method="post">
							<input type="text" name="userId" placeholder="ID" />
							<input type="password" name="userPwd" placeholder="PASSWORD" />
							
							
							<div class="text-right">
								<a href="join.jsp">Signup</a>
							</div>
							<button type="submit" class="btn btn-default">Login</button>
						</form>
					</div><!--/login form-->
				</div>
				
			</div>
		</div>
	</section><!--/form-->
	
	
	
<jsp:include page="../view/footer.jsp"/>