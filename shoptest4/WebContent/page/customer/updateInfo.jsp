<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../view/header.jsp"/>

	<section>
      <div class="container">
         <div class="row">
            <div class="col-sm-3">
               <div class="left-sidebar">
                  <h2>마이페이지</h2>
                  <div class="panel-group category-products" id="">
                     
                     <div class="panel panel-default">
                        <div class="panel-heading">
                           <h4 class="panel-title"><a href="${pageContext.request.contextPath}/wm?command=CartSelectByUserId"">장바구니</a></h4>
                        </div>
                     </div>
                     <div class="panel panel-default">
                        <div class="panel-heading">
                           <h4 class="panel-title"><a href="#">구매목록</a></h4>
                        </div>
                     </div>
                    <div class="panel panel-default">
					 	<div class="panel-heading">
					 		<h4 class="panel-title"><a href="${pageContext.request.contextPath}/wm?command=selectByUser">정보수정</a></h4>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
								<h4 class="panel-title"><a href="${pageContext.request.contextPath}/page/customer/updatePw.jsp">비밀번호 변경</a></h4>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title"><a href="${pageContext.request.contextPath}/wm?command=updateOutdate">탈퇴하기</a></h4>
						</div>
					</div>
                     
                     
                  </div><!--/category-products-->
               
               
               </div>
            </div>
            
            <div class="col-sm-8">
               <form action="${pageContext.request.contextPath}/wm?command=custUpdateInfo" method="post">
				<!-- action은 servlet의 url pattern과 맞춰줘야함. -->
				<table>
					<tr>
						<td>ID</td>
						<td><input type="text" value="${custdto.u_id}"
							name="userId" readonly required/></td>
					</tr>
					<tr>
						<td>회원이름</td>
						<td><input type="text" name="userName" value="${custdto.u_name}"
						 required/></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input type="email" value="${custdto.u_email}"
							name="userEmail" required></td>
					</tr>
					<tr>
						<td>이메일 수신체크</td>
						<td>:<input type="radio" name="userErec" value="1">수신확인
							<input type="radio" name="userErec" value="0">수신거절</td>
					</tr>
					<tr>
						<td>연락처</td>
						<td><input type="text" value="${custdto.u_phone}"
							name="userPhone" maxlength=11 required></td>
					</tr>
					<tr>
						<td>우편번호</td>
						<td><input type="text" value="${custdto.u_post}"
							name="userpost" required></td>
					</tr>
					<tr>
						<td>주소</td>
						<td><input type="text" value="${custdto.u_addr}"
							name="userAddr" required></td>
					</tr>
					<tr>
						<td>상세주소</td>
						<td><input type="text" value="${custdto.u_addr_detail}"
							name="userAddrDetail"></td>
					</tr>
				</table>
		
				<input type="submit" value="정보 바꾸기" />
			</form>

            </div>
         </div>
      </div>
   </section>

	
<jsp:include page="../view/footer.jsp"/>