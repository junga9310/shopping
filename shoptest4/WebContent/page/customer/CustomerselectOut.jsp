<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

</head>
<body>




<table align="center" border="0"  width="100%" >
<caption>탈퇴회원리스트 LIST</caption>
	
	<tr>
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
            <p align="center"><b><span style="font-size:9pt;">탈퇴할 회원이 없습니다.</span></b></p>
        </td>
  	  </tr>
    </c:when>
    <c:otherwise>
	<c:forEach items="${requestScope.list}" var="custdto">
		    <tr>
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
	
</body>
</html>