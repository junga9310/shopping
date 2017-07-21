<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

</head>
<body>
<!-- 회워이름,주소,전화번호, 결제수단, -->
	<div class="col-sm-8">
               <form action="${pageContext.request.contextPath}/wm?command=buycart" method="post">
				<!-- action은 servlet의 url pattern과 맞춰줘야함. -->
				<table>
					<tr>
						<td>ID</td>
						<td><input type="text" value="${custdto.u_id}"
							name="userId" readonly /></td>
					</tr>
					<tr>
						<td>회원이름</td>
						<td><input type="text" name="userName" value="${custdto.u_name}"
						 readonly/></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input type="email" value="${custdto.u_email}"
							name="userEmail" readonly></td>
					</tr>
					
					<tr>
						<td>연락처</td>
						<td><input type="text" value="${custdto.u_phone}"
							name="userPhone" maxlength=11 readonly></td>
					</tr>
					<tr>
						<td>우편번호</td>
						<td><input type="text" value="${custdto.u_post}"
							name="userpost" readonly></td>
					</tr>
					<tr>
						<td>주소</td>
						<td><input type="text" value="${custdto.u_addr}"
							name="userAddr" readonly></td>
					</tr>
					<tr>
						<td>상세주소</td>
						<td><input type="text" value="${custdto.u_addr_detail}"
							name="userAddrDetail" readonly></td>
					</tr>
					<tr>
						<td>결제수단</td>
						<td>
						<input type="radio" id="chk1" name="payment" value="1"><label for="chk1">카드결제</label>
							<input type="radio" id="chk2" name="payment" value="0"><label for="chk2">현금결제</label></br/>
						</td>
					
					</tr>
					
				</table>
		
				<input type="submit" value="결제하기" />
			</form>

            </div>
</body>
</html>