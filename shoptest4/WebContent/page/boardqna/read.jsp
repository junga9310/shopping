<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../view/header.jsp"/>

<SCRIPT language=javascript>
function sendUpdate(){
	document.requestForm.command.value ="updateForm";
	document.requestForm.submit();
}

function sendDelete(){
	document.requestForm.command.value ="delete";
	document.requestForm.submit();
}


//버튼
function reply(){
	document.requestForm.command.value ="writeReply";
//document.requestForm.BOARD_NUM.value="${qna.BOARD_NUM}"
 //location.href="${pageContext.request.contextPath}/page/boardqna/writereply.jsp";
document.requestForm.submit();//폼전송
}
</script>


<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<table align="center" cellpadding="5" cellspacing="2" width="600" border='1'>
					    <tr>
					        <td width="1220" height="20" colspan="4" bgcolor="#fdb45e">
					            <p align="center"><font color="white" size="3"><b>
					             Q&A 글 보기</b></font></p>
					        </td>
					    </tr>
					    <tr>
					        <td width="100" height="20" >
					            <p align="right"><b><span style="font-size:9pt;">작성자</span></b></p>
					        </td>
					        <td width="450" height="20" colspan="3">
					        	<span style="font-size:9pt;"><b>${qna.BOARD_NAME}</b></span>
					        </td>
					    </tr>
					    <tr>
					        <td width="100" height="20" >
					            <p align="right"><b><span style="font-size:9pt;">등록일</span></b></p>
					        </td>
					        <td width="300" height="20">
					        	<span style="font-size:9pt;"><b>${requestScope.qna.BOARD_DATE}</b></span>
					        </td>
					        <td width="100" height="20" >
								<p align="right"><b><span style="font-size:9pt;">조회수</span></b></p>
							</td>
					        <td width="100" height="20">
								<p><b><span style="font-size:9pt;"></span>${requestScope.qna.BOARD_READNUM}</b></p>
							</td>
					    </tr>
					    <tr>
					        <td width="100" height="20">
					            <p align="right"><b><span style="font-size:9pt;">제목</span></b></p>
					        </td>
					        <td width="450" height="20" colspan="3">
					        	<span style="font-size:9pt;"><b>${requestScope.qna.BOARD_SUBJECT}</b></span>
					        </td>
					    </tr>
					    <tr>
							<td width="100" height="200" valign="top">
					            <p align="right"><b><span style="font-size:9pt;">설명</span></b></p>
					        </td>
							<!-- 브라우저에 글 내용을 뿌려줄 때는 개행문자(\n)가 <br>태그로 변환된 문자열을 보여줘야 한다. -->
					        <td width="450" height="200" valign="top" colspan="3">
					        <span style="font-size:9pt;"><b>${requestScope.qna.BOARD_CONTENT}</b><br />
					        						        	
					        	<c:choose>
									<c:when test="${qna.BFILE!=null }">
										<img width="200px" height="" src='${pageContext.request.contextPath}/save/${qna.BFILE}' alt="${qna.BFILE}">
									</c:when>
									<c:otherwise>
										
									</c:otherwise>
								</c:choose>
					        </span></td>
					    </tr>
					    
					      <c:if test="${qna.BFILE!=null}">
					       <tr>
					        <td width="100" height="20">
					            <p align="right"><b><span style="font-size:9pt;">다운로드</span></b></p>
					        </td>
					        <td width="450" height="20" colspan="3">
					        	<span style="font-size:9pt;"><b>
					        	<a href='downLoad?BOARD_FILE=${qna.BFILE}'>
					    			${qna.BFILE} 
					      		</a>
					      		  ( <fmt:formatNumber value="${qna.BFSIZE}"/> byte)
					        </b></span>
					        </td> 
					    </tr>
					    </c:if>
					    
					    <tr>
					    <td width="100" height="20">
					           <p align="right"><b><span style="font-size:9pt;">비밀번호</span></b></p>
					        </td>
					        
					        <form name="requestForm" method=post action="wm">
					        <td height="20" colspan="3" align="left" valign="middle">
									<input type=password name="BOARD_PASS" value="">		
							</td>
					    </tr>
					    
					    
					    <tr>
					        <td height="20" colspan="4" align="center" valign="middle">
								<!-- 수정시 필요한 데이터들을 hidden으로 숨겨놓고 폼 데이터로 보내준다. -->
									<input type=hidden name="BOARD_NUM" value="${qna.BOARD_NUM}">
									<input type=hidden name="command" value="">
									<input type=button value="수정하기" onClick="sendUpdate()">
									<input type=button value="삭제하기" onClick="sendDelete()">
									<input type=button value="답변달기" onClick="reply()">
								</form>
								
							</td>
					    </tr>
					</table>
					<hr>
					<div align=right><span style="font-size:9pt;"><a class="btn btn-default"  href="wm?command=list">리스트로 돌아가기</a></span></div>

</div>

<!-- 답변리스트 -->
 <div class="container">
			<div class="row">
				<div class="col-sm-12">
					<table  align="center" border="0" cellpadding="5" cellspacing="2" width="80%" bordercolordark="white" bordercolorlight="black">
					<caption><h5>REPLY</h5></caption>
						<colgroup>
							<col width="10%"/>
							<col width="40%"/>
							<col width="15%"/>
							<col width="15%"/>
							<col width="10%"/>
							<col width="10%"/>
						</colgroup>
						<tr>
					        <td bgcolor="#fdb45e">
					            <p align="center">
					            <font color="white"><b><span style="font-size:9pt;">글번호</span></b></font></p>
					        </td>
					        <td bgcolor="#fdb45e">
					            <p align="center"><font color="white"><b><span style="font-size:9pt;">제목</span></b></font></p>
					        </td>
					        <td bgcolor="#fdb45e">
					            <p align="center"><font color="white"><b><span style="font-size:9pt;">작성자</span></b></font></p>
					        </td>
					        
					      <!--   <td bgcolor="#fdb45e">
					            <p align="center"><font color="white"><b><span style="font-size:9pt;">첨부파일</span></b></font></p>
					        </td>
					        --> 
					        <td bgcolor="#fdb45e">
					            <p align="center"><font color="white"><b><span style="font-size:9pt;">날짜</span></b></font></p>
					        </td>
					        <td bgcolor="#fdb45e">
					            <p align="center"><font color="white"><b><span style="font-size:9pt;">조 회 수</span></b></font></p>
					        </td>
					    </tr>
					    
					    <c:choose>
					    <c:when test="${empty requestScope.replylist}">
						   <tr>
					        <td colspan="5">
					            <p align="center"><b><span style="font-size:9pt;">등록된 글이 없습니다.</span></b></p>
					        </td>
					    </tr>
					    </c:when>
					    <c:otherwise>
						<c:forEach items="${requestScope.replylist}" var="qnaDto" varStatus="state">
							    <tr onmouseover="this.style.background='#eaeaea'"
							        onmouseout="this.style.background='white'">
							        <td bgcolor="" >
							            <p align="center"><span style="font-size:9pt;">
							            <fmt:formatNumber value="${state.count}"/></span></p>
							        </td>
							        <td bgcolor="" style="display:none">
							            <fmt:formatNumber value="${qnaDto.BOARD_NUM}"/></span></p>
							        </td>
							        
							        <td bgcolor="">
							            <p align="center"><span style="font-size:9pt;">
							            <a href="wm?command=detailView&BOARD_NUM=${qnaDto.BOARD_NUM}">
										  ${qnaDto.BOARD_SUBJECT}
										</a></span></p>
							        </td>
							        
							        <td bgcolor="">
										<p align="center"><span style="font-size:9pt;">
										  ${qnaDto.BOARD_NAME}
										</span></p>
							        </td>
							       
							         <td bgcolor="">
							            <p align="center"><span style="font-size:9pt;">
							            ${qnaDto.BOARD_DATE}</span></p>
							        </td>
							        <td bgcolor="">
							            <p align="center"><span style="font-size:9pt;">
							            ${qnaDto.BOARD_READNUM}</span></p>
							        </td>
							    </tr>
					    </c:forEach>
						</c:otherwise>
					    </c:choose>
					</table>
					

</div>
</div>


<jsp:include page="../view/footer.jsp"/>




