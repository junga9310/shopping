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
				<div class="col-sm-10 col-sm-push-1">

					<div class="blog-post-area">
						<h2 class="title text-center mt10"> Q&A 글 보기</h2>
						<div class="single-blog-post">
							<h3>${requestScope.qna.BOARD_SUBJECT}</h3>
							<div class="post-meta">
								<ul>
									<li><i class="fa fa-user"></i>${qna.BOARD_NAME}</li>
									<li><i class="fa fa-eye"></i> ${requestScope.qna.BOARD_READNUM}</li>
									<li><i class="fa fa-calendar"></i> ${requestScope.qna.BOARD_DATE}</li>
								</ul>
							</div>
							<p>
							<span style="font-size:9pt;"><b>${requestScope.qna.BOARD_CONTENT}</b><br />
					        						        	
					        	<c:choose>
									<c:when test="${qna.BFILE!=null }">
										<img width="200px" height="" src='${pageContext.request.contextPath}/save/${qna.BFILE}' alt="${qna.BFILE}">
									</c:when>
									<c:otherwise>
										
									</c:otherwise>
								</c:choose>
					        </span>
							</p>
							<div class="pager-area">
								<ul class="pager pull-right">
								
									<li>
										<c:if test="${qna.BFILE!=null}">
									            <!-- <p align="right"><b><span style="font-size:9pt;">다운로드</span></b></p> -->
									        
									        	<span style="font-size:9pt;"><b>
									        	<a href='downLoad?BOARD_FILE=${qna.BFILE}'>
									    			${qna.BFILE} 
									      		</a>
									      		  ( <fmt:formatNumber value="${qna.BFSIZE}"/> byte)
									        </b></span>
									    
									    </c:if>


									</li>
								</ul>
							</div>
							
							<div class="pager-area mb10">
								<div class="pull-right">
									<a class="btn btn-default"  href="#" onClick="sendUpdate()">수정하기</a>
									<a class="btn btn-default"  href="#" onClick="reply()">답변달기</a>
								</div>	
							</div>
							
						<div class="panel-group category-products bga" id="accordian"><!--category-productsr-->
							
							
							
							
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian" href="#del" class="collapsed">
											<span class="badge pull-right"><i class="fa fa-plus"></i></span>
											삭제하기
										</a>
									</h4>
								</div>
								<div id="del" class="panel-collapse collapse" style="height: 0px;">
									<div class="panel-body">
										<table align="center" cellpadding="5" cellspacing="2" width="600" border='1'>
					    
										  <form name="requestForm" method=post action="wm" >
											<input type=password name="BOARD_PASS" value="" placeholder="비밀번호 입력">		
											<input type=hidden name="BOARD_NUM" value="${qna.BOARD_NUM}">
											<input type=hidden name="command" value="">
											<input type=button value="삭제하기" onClick="sendDelete()">
														
										  </form>
													
										    
										    
										    
										</table>
									</div>
								</div>
							</div>
							
							
						</div>
							
									
							
							<div align=right><span style="font-size:9pt;"><a class="btn btn-default"  href="wm?command=list">리스트로 돌아가기</a></span></div>
							
						</div>
					</div><!--/blog-post-area-->
	
</div>
</div>
</div>
<!-- 답변리스트 -->
 <div class="container">
			<div class="row">
				<div class="col-sm-12 mb150">
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
</div>

<jsp:include page="../view/footer.jsp"/>




