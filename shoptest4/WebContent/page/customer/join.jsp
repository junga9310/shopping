<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../view/header.jsp"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
  $(function(){
	  //아이디중복체크
	  $("#id").keyup(function(){
		  $.ajax({
			  type:"post",
			   url: "${pageContext.request.contextPath}/wm?command=idcheck",
			   data: "id="+$(this).val() ,
			   dataType:"text" , //text, html, xml, json
			   success: function(result){
				 $("span").text(result);
			   },
			   error: function(err){
				   console.log("오류발생 : " + err);
			   }
			  
		  })
	  });
  })//아이디체크 끝
</script>
	
	<section id="form"><!--form-->
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-sm-6 col-sm-offset-3 col-md-offset-4">
					<div class="signup-form"><!--sign up form-->
						<h2>회원가입</h2>
						<form action="${pageContext.request.contextPath}/wm?command=join" method="post">
							<input type="text" name="userId" id="id" placeholder="userId" pattern="[A-Za-z0-9]{5,16}" title="영어와 숫자를 섞어 5~16의 길이로 작성하시오" required/><span>중복여부</span>
							<input type="text" name="userName"  placeholder="userName" required/>
							<input type="password" name="userPwd"  placeholder="Password" pattern="[A-Za-z0-9]{5,16}" title="영어와 숫자를 섞어 5~16의 길이로 작성하시오" required/>
							<input type="email" name="userEmail"  placeholder="userEmail" required/>
							<input type="radio" id="chk1" name="userErec" value="1"><label for="chk1">수신확인</label>
							<input type="radio" id="chk2" name="userErec" value="0"><label for="chk2">수신거절</label></br/>
							연락처:<input type="tel" name="userPhone" pattern="[0-9]{11}"  title="핸드폰번호 11자리를 입력하시오" maxlength=11 required></br/>
						   우편번호: <input type="text" name="userpost" pattern="[0-9]{5}"  title="우편번호 5자리를 입력하시오"required></br/>
						   주소: <input type="text" name="userAddr" required></br/>
						   상세주소:<input type="text" name="userAddrDetail" required></br/>
						   
						   <button type="submit"  class="btn btn-default" value="">가입</button>
						</form>
						
					</div><!--/sign up form-->
				</div>
			</div>
		</div>
	</section><!--/form-->
	
	
<jsp:include page="../view/footer.jsp"/>