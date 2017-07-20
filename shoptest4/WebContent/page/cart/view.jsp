<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../view/header.jsp"/>

<div class="container">
			<div class="row">
				<div class="col-sm-12">

				<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
				<caption><h3>장바구니</h3></caption>
				   <colgroup>
				      <col width="15%"/>
				      <col width="30%"/>
				      <col width="16%"/>
				      <col width="16%"/>
				      <col width="7%"/>
				      <col width="7%"/>
				      <col width="7%"/>
				   </colgroup>
				   <tr>
				        <td bgcolor="#fdb45e">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">상품이름</span></b></font></p>
				        </td>
				        <td bgcolor="#fdb45e">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">상품번호</span></b></font></p>
				        </td>
				        <td bgcolor="#fdb45e">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">사진</span></b></font></p>
				        </td>
				         <td bgcolor="#fdb45e">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">추가하기</span></b></font></p>
				        </td>
				        <td bgcolor="#fdb45e">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">상품수량</span></b></font></p>
				        </td>
				        <td bgcolor="#fdb45e">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">삭제하기</span></b></font></p>
				        </td>
				        <td bgcolor="#fdb45e">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">상품가격</span></b></font></p>
				        </td>
				        <td bgcolor="#fdb45e">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">상품가격</span></b></font></p>
				        </td>
				                    <p align="center"><font color="white"><b><span style="font-size:9pt;">서브총가격</span></b></font></p>
				    </tr>
				    <%! int tot = 0; %>
				    <c:choose>
				       <c:when test="${empty requestScope.list}"> <!-- 등록 된 상품없을때 -->
				         <tr>
				           <td colspan="5">
				               <p align="center"><b><span style="font-size:9pt;">등록된 상품이 없습니다.</span></b></p>
				           </td>
				       </tr>
				       </c:when>
				       
				       <c:otherwise>
				     	<c:forEach items="${requestScope.list}" var="elecDto"> <!-- onmouseover 마우스 갖다대면 색깔 바뀌도록 -->
			    <tr onmouseover="this.style.background='#eaeaea'" 
			        onmouseout="this.style.background='white'">
			      	<td bgcolor="">
			            <p align="center"><span style="font-size:9pt;">
			            ${elecDto.prodName}</span></p>
			        </td>		        
			        <td bgcolor="">
			            <p align="center"><span style="font-size:9pt;">
			            ${elecDto.prodId}</span></p>
			        </td>
			        <td bgcolor="">
			            <p align="center"><span style="font-size:9pt;">
			            ${elecDto.cartImage}</span></p>
			        </td>
			        <td bgcolor="">
			            <p align="center"><span style="font-size:9pt;">
			            <a href="${pageContext.request.contextPath}/wm?command=CartInsertAtCart&&prodId=${elecDto.prodId}">추가</a></span></p>
			        </td>
			         <td bgcolor="">
			            <p align="center"><span style="font-size:9pt;">
			            ${elecDto.cartQtt}</span></p>
			        </td>
			        <td bgcolor="">
			            <p align="center"><span style="font-size:9pt;">
			            <a href="${pageContext.request.contextPath}/wm?command=CartDelete&&prodId=${elecDto.prodId}">삭제</a></span></p>
			        </td>
			        <td bgcolor="">
			            <p align="center"><span style="font-size:9pt;">
			            ${elecDto.prodPrice}</span></p>
			        </td>
			        <td bgcolor="">
			            <p align="center"><span style="font-size:9pt;">
			            ${elecDto.totPrice}</span></p>
			        </td>
			    </tr>
	    </c:forEach>
				      </c:otherwise>
				    </c:choose>
				
				</table>
				<hr>
				
				총 가격 : ${total}
				<p>주문고객 : ${custDTO.u_name }</p>
<p>우편번호 : ${custDTO.u_post }</p>
<p>주소 : ${custDTO.u_addr }</p>
<p>상세주소: ${custDTO.u_addr_detail }</p>
				<div align=right>
				   <span style="font-size:9pt;"><a class="btn btn-default" href="${pageContext.request.contextPath}/index.jsp">메인 페이지로 가기</a></span>
				</div>
				<a href="${pageContext.request.contextPath}/wm?command=buycart">구매하러가기</a>
</div>
</div>
</div>

<jsp:include page="../view/footer.jsp"/>










