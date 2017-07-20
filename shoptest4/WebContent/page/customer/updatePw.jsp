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
                           <h4 class="panel-title"><a href="${pageContext.request.contextPath}/wm?command=CartSelectByUserId">장바구니</a></h4>
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
               <form  action="${pageContext.request.contextPath}/wm?command=updatePw" method="post"><!-- action은 servlet의 url pattern과 맞춰줘야함. -->
				 <div class="login-form">
				  아이디 : <input type="text" value="${userId}" name="userId" /><br/>
				  비밀번호 : <input type="password" name="oldPwd" /><br/>
				  새 비밀번호 : <input type="password" name="newPwd" /><br/>
				 <input type="submit" value="비번바꾸기" />
				 </div>
				</form>
            </div>
         </div>
      </div>
   </section>

	
<jsp:include page="../view/footer.jsp"/>