<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>입력값 받기</title>

<link rel="stylesheet" href="css/bootstrap.css">
<script type="text/javascript">
    function oneCheckbox(a){
        var obj = document.getElementsByName("payment");
        for(var i=0; i<obj.length; i++){
            if(obj[i] != a){
                obj[i].checked = false;
            }
        }
    }
</script>

<script type="text/javascript">
  
</script> 

</head>
<body>
<%-- 
<c:choose>
  <c:when test="${sessionScope.id==null}">
     <script type="text/javascript">
       alert("로그인하고 다시 들어오세요.")
      location.href="index.html";
     </script>
  </c:when>

 <c:otherwise> --%>
 <div >
      <form role ="form" method="post" action="${pageContext.request.contextPath}/wm?command=buy" onsubmit="return check()" class ="form-inline"><!-- action은 servlet의 url pattern과 맞춰줘야함. -->
		   <div class="form-group">
		   <label  for = "uid">User Id</label>
		   <label  for = "uid" class="form-control">${sessionScope.id}</label>
		   <label  for = "pid">상품번호</label>
		  		    <select name="p_Id"  class="form-control">
		                                    <c:forEach begin="1" end="12" var="i">
		                                        <option value="${i}">${i}</option>
		                                    </c:forEach>
		                                </select>&nbsp;
		    <label  for = "pid">상품가격 : 자동</label>
		   상품수량 : <select name="p_amount" class="form-control">
		                                    <c:forEach begin="1" end="200" var="i">
		                                        <option value="${i}">${i}</option>
		                                    </c:forEach>
		                                </select>&nbsp;개
		     
		     <label  for = "pid">결제방법:</label>                        
		   <label  for = "pid">현금결제</label> <input type="checkbox" id="payment" value="1" name="payment" onclick="oneCheckbox(this)" class="form-control">
		   				  	<label  for = "pid">카드결제</label><input type="checkbox" id="payment" value="2" name="payment" onclick="oneCheckbox(this)" class="form-control">
		    
		  <button type="submit" class="btn btn-sm btn-danger">구매하기</button>
		</div>
		</form>
	</div>
<%--  </c:otherwise>
</c:choose> --%>


<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>