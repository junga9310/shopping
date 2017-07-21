<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../view/header.jsp"/>
	
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<div class="left-sidebar">
						<h2>관리페이지</h2>
						<div class="panel-group category-products" >
							
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="${pageContext.request.contextPath}/wm?command=selectCustAll">회원관리(리스트)</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="${pageContext.request.contextPath}/wm?command=selectoutdate">탈퇴회원리스트</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="${pageContext.request.contextPath}/page/product/productInput.jsp">상품등록하기</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="${pageContext.request.contextPath}/wm?command=prodselectall">상품리스트</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="#"></a></h4>
								</div>
							</div>
							
						</div><!--/category-products-->
					
					
					</div>
				</div>
				
				<div class="col-sm-8">
					<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
						<caption>상품 LIST</caption>
						   <colgroup>
						      <col width="20%"/>
						      <col width="10%"/>
						      <col width="10%"/>
						      <col width="8%"/>
						      <col width="8%"/>
						      <col width="10%"/>
						      <col width="7%"/>
						   </colgroup>
						   <tr>
						      <td bgcolor="#fdb45e">
						            <p align="center">
						            <font color="white"><b><span style="font-size:9pt;">사진</span></b></font></p>
						        </td>
						        <td bgcolor="#fdb45e">
						            <p align="center">
						            <font color="white"><b><span style="font-size:9pt;">상품 아이디</span></b></font></p>
						        </td>
						        <td bgcolor="#fdb45e">
						            <p align="center"><font color="white"><b><span style="font-size:9pt;">상품 이름</span></b></font></p>
						        </td>
						        <td bgcolor="#fdb45e">
						            <p align="center"><font color="white"><b><span style="font-size:9pt;">가수 명</span></b></font></p>
						        </td>
						        <td bgcolor="#fdb45e">
						            <p align="center"><font color="white"><b><span style="font-size:9pt;">가격</span></b></font></p>
						        </td>
						        
						        <td bgcolor="#fdb45e">
						            <p align="center"><font color="white"><b><span style="font-size:9pt;">상품 설명</span></b></font></p>
						        </td>
						        <td bgcolor="#fdb45e">
						            <p align="center"><font color="white"><b><span style="font-size:9pt;">조회 수</span></b></font></p>
						        </td>
						        <td bgcolor="#fdb45e">
						            <p align="center"><font color="white"><b><span style="font-size:9pt;">장르</span></b></font></p>
						        </td>
						   <td bgcolor="#fdb45e">
						            <p align="center"><font color="white"><b><span style="font-size:9pt;">수량</span></b></font></p>
						        </td>
						   <td bgcolor="#fdb45e">
						            <p align="center"><font color="white"><b><span style="font-size:9pt;">출시 날짜</span></b></font></p>
						        </td>
						    <td bgcolor="#fdb45e">
						            <p align="center"><font color="white"><b><span style="font-size:9pt;">삭제</span></b></font></p>
						        </td>
						    <td bgcolor="#fdb45e">
						            <p align="center"><font color="white"><b><span style="font-size:9pt;">수정</span></b></font></p>
						        </td>
						    </tr>
						   
						    <c:choose>
						    <c:when test="${empty requestScope.list}">
						      <tr>
						        <td colspan="5">
						            <p align="center"><b><span style="font-size:9pt;">등록된 상품이 없습니다.</span></b></p>
						        </td>
						    </tr>
						    </c:when>
						    <c:otherwise>
						   <c:forEach items="${requestScope.list}" var="prod">
						          <tr onmouseover="this.style.background='#eaeaea'"
						              onmouseout="this.style.background='white'">
						               <td bgcolor="">
						                  <p align="center"><span style="font-size:9pt;">
						                 <img width="100px" src= "${pageContext.request.contextPath}/save/${prod.p_image}"/></span></p>
						              </td>
						              <td bgcolor="">
						                  <p align="center"><span style="font-size:9pt;">
						                  ${prod.p_id}
						                  </span></p>
						              </td>
						              <td bgcolor="">
						               <p><span style="font-size:9pt;">
						               <a href="">
						                 ${prod.p_name}
						               </a>
						               </span></p>
						              </td>
						              
						              <td bgcolor="">
						                  <p align="center"><span style="font-size:9pt;">
						                  "${prod.p_singer}"</span></p>
						              </td>
						              <td bgcolor="">
						                  <p align="center"><span style="font-size:9pt;">
						                  ${prod.p_price}</span></p>
						              </td>
						               
						               <td bgcolor="">
						                  <p align="center"><span style="font-size:9pt;overflow:hidden;word-wrap: break-word;display: -webkit-box;-webkit-line-clamp: 2;-webkit-box-orient: vertical;" >
						                  ${prod.p_desc}</span></p>
						              </td>
						               <td bgcolor="">
						                  <p align="center"><span style="font-size:9pt;">
						                  <fmt:formatNumber value="${prod.p_hit}"/> </span></p>
						              </td>
						              <td bgcolor="">
						                  <p align="center"><span style="font-size:9pt;">
						                  ${prod.p_genre}</span></p>
						              </td>
						         <td bgcolor="">
						                  <p align="center"><span style="font-size:9pt;">
						                  ${prod.p_qtt}</span></p>
						              </td>
						         <td bgcolor="">
						                  <p align="center"><span style="font-size:9pt;">
						                  ${prod.p_date}</span></p>
						              </td>
						         <td bgcolor="">
						                  <p align="center"><span style="font-size:9pt;">
						                  <a href ="${pageContext.request.contextPath}/wm?command=proddelete&p_id=${prod.p_id}">삭제</a></span></p>
						              </td>
						         <td bgcolor="">
						                  <p align="center"><span style="font-size:9pt;">
						                  <a href="${pageContext.request.contextPath}/wm?command=prodselectone&p_id=${prod.p_id}">수정</a></span></p>
						              </td>                            
						          </tr>
						    </c:forEach>
						   </c:otherwise>
						    </c:choose>
						</table>

				</div>
			</div>
		</div>
	</section>
	
	
<jsp:include page="../view/footer.jsp"/>











