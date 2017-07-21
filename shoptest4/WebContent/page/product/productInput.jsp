<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
					<div class="form-two">
				      <form action="${pageContext.request.contextPath}/wm?command=prodinsert" method="post" enctype="multipart/form-data"><!-- action은 servlet의 url pattern과 맞춰줘야함. -->
				         <div class="form-group">
				         <div>
				             <label for="p_id">상품 번호</label>
				               <input type="text" name="p_id"><br>
				            </div>      
				         
				         <div>
				             <label for="p_name">상품 이름</label>
				               <input type="text" name="p_name"><br>
				            </div>      
				         
				         <div>
				             <label for="p_singer">가수 정보</label>
				               <input type="text" name="p_singer"><br>
				            </div>      
				         
				            <div>
				             <label for="p_price">가격 정보</label>
				               <input type="text" name="p_price"><br>
				            </div>      
				         
				           
				           <div>
				             <label for="p_desc">상세 정보</label>
				               <input type="text" name="p_desc"><br>
				            </div>      
				         
				         
				            <div>
				             <label for="p_hit">판매 수량 </label>
				               <input type="text" name="p_hit"><br>
				            </div>     
				         
				         <div>
				         <label for="genre">장르 선택 </label>
				         <select name="genre" size="1" style="border:1px solid #696763">
				         <option value="ballad">Ballad</option>
				         <option value="ballad">Classic</option>
				         <option value="ballad">Hiphop</option>
				         <option value="ballad">Dance</option>
				         <option value="ballad">Rock</option>
				         <option value="ballad">트로트</option>
				         </select>
				         </div>
				                 
				         <div>
				             <label for="file">상품 재고</label>
				               <input type="text" name="p_qtt"><br>
				            </div>       
				            <div>
				               <label for="file">이미지 가져오기</label>
				               <input type="file" id="file" name="p_image" multiple>
				          </div>       
				        </div>
				        <input class="btn btn-default" type="submit" value="추가하기" >
				      </form>
				      
				      
				      
				      
				      
				</div>

				</div>
			</div>
		</div>
	</section>
	
	
<jsp:include page="../view/footer.jsp"/>

