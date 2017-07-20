<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../view/header.jsp"/>

<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<table  align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
					<caption><h2>Q&A</h2></caption>
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
					        
					        <td bgcolor="#fdb45e">
					            <p align="center"><font color="white"><b><span style="font-size:9pt;">첨부파일</span></b></font></p>
					        </td>
					        <td bgcolor="#fdb45e">
					            <p align="center"><font color="white"><b><span style="font-size:9pt;">날짜</span></b></font></p>
					        </td>
					        <td bgcolor="#fdb45e">
					            <p align="center"><font color="white"><b><span style="font-size:9pt;">조 회 수</span></b></font></p>
					        </td>
					    </tr>
					    
					    <c:choose>
					    <c:when test="${empty requestScope.list}">
						   <tr>
					        <td colspan="5">
					            <p align="center"><b><span style="font-size:9pt;">등록된 글이 없습니다.</span></b></p>
					        </td>
					    </tr>
					    </c:when>
					    <c:otherwise>
						<c:forEach items="${requestScope.list}" var="qnaDto" varStatus="state">
							    <tr onmouseover="this.style.background='#eaeaea'"
							        onmouseout="this.style.background='white'">
							        <td bgcolor="" >
							            <p align="center"><span style="font-size:9pt;">
							            <fmt:formatNumber value="${state.count}"/></span></p>
							        </td>
							        <td bgcolor="" style="display:none">
							            <p align="center"><span style="font-size:9pt;">
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
							            ${qnaDto.BFILE}</span></p>
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
					
					
					
					<hr>
					<div align=right>
					<span style="font-size:9pt;"><button class="btn btn-default" onclick="id_chk()" >글쓰기</button></span></div>
</div>
</div>
</div>

<script type="text/javascript">
  
    function id_chk(){
    	if(${userId!=null}){
    		window.location.href="${pageContext.request.contextPath}/page/boardqna/write.jsp";
     	}else{
     		alert("로그인 하셔야 글쓰기가 가능합니다.");
     	}
    	
    }
    function id_chk2(){
    	if(${userId!=null}){
    		window.location.href="wm?command=detailView&BOARD_NUM=${qnaDto.BOARD_NUM}";
     	}else{
     		alert("로그인 하셔야 글보기가 가능합니다.");
     	}
    	
    }
    
</script>

<jsp:include page="../view/footer.jsp"/>
