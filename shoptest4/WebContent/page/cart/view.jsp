<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../view/header.jsp"/>

<div class="container">
			<div class="row">
				<div class="col-sm-12">

				<table class="table table-condensed" align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
				
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
			    
					<thead>
						<tr class="cart_menu">
							<td class="image">상품이름</td>
							<td class="description">상품번호</td>
							<td class="quantity">이미지</td>
							<td class="price">수량</td>
							<td class="total">가격</td>
							<td class="total">총가격</td>
							
						</tr>
					</thead>
					
					<td>
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
							
							<td class="cart_quantity">
								<div class="cart_quantity_button">
									<a class="cart_quantity_up" href="${pageContext.request.contextPath}/wm?command=CartInsertAtCart&&prodId=${elecDto.prodId}"> + </a>
									<input class="cart_quantity_input" type="text" name="quantity" value="${elecDto.cartQtt}">
									<a class="cart_quantity_down" href="${pageContext.request.contextPath}/wm?command=CartDelete&&prodId=${elecDto.prodId}"> - </a>
								</div>
							</td>
						<td class="cart_total">
								<p class="cart_total_price">${elecDto.prodPrice}</p>
							</td>
							<td class="cart_delete">
								<p class="cart_total_price">${elecDto.totPrice}</p>
							</td>

						
						
	    </c:forEach>
				      </c:otherwise>
				    </c:choose>
				    <tr>
							<td colspan="4">&nbsp;</td>
							<td colspan="2">
								<table class="table table-condensed total-result">
									<tbody><tr>
										<td>총 가격 :</td>
										<td>${total}</td>
									</tr>
									<tr>
										<td>주문고객 :</td>
										<td>${custDTO.u_name }</td>
									</tr>
									<tr class="shipping-cost">
										<td>우편번호 :</td>
										<td> ${custDTO.u_post }</td>										
									</tr>
									<tr>
										<td>주소 : </td>
										<td><span>${custDTO.u_addr } - ${custDTO.u_addr_detail }</span></td>
									</tr>
									
								</tbody></table>
							</td>
						</tr>
					
				</table>
				<hr>
				
				
				<div align=right>
				 	<span style="font-size:9pt;"><a class="btn btn-default" href="${pageContext.request.contextPath}/wm?command=buycart">구매하기</a></span>
				   <span style="font-size:9pt;"><a class="btn btn-default" href="${pageContext.request.contextPath}/index.jsp">메인 페이지로 가기</a></span>
				</div>
</div>
</div>
</div>

<jsp:include page="../view/footer.jsp"/>






