<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../view/header.jsp"/>
	
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<div class="left-sidebar">
						<h2>서비스</h2>
						<div class="panel-group category-products">
							
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="${pageContext.request.contextPath}/page/view/shopinfo.jsp">쇼핑몰 소개</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="${pageContext.request.contextPath}/page/view/info.jsp">개인정보취급방침</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="${pageContext.request.contextPath}/page/view/sitemap.jsp">사이트맵</a></h4>
								</div>
							</div>
							
						</div><!--/category-products-->
					
					
					</div>
				</div>
				
				<div class="col-sm-8">
				<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=EiSEz5lz3_qfwjj1alQw&submodules=geocoder"></script>
				 <div id="contact-page">
			    	<div class="bg">
				    	<div class="row">    		
				    		   			   			
							<div id="map" style="width:100%;height:400px;"></div>
						    <script>
						      var map = new naver.maps.Map('map');
						      var myaddress = '경기도 성남시 분당구 판교로 289 번길 20 스타트업캠퍼스';// 도로명 주소나 지번 주소만 가능 (건물명 불가!!!!)
						      naver.maps.Service.geocode({address: myaddress}, function(status, response) {
						          if (status !== naver.maps.Service.Status.OK) {
						              return alert(myaddress + '의 검색 결과가 없거나 기타 네트워크 에러');
						          }
						          var result = response.result;
						          // 검색 결과 갯수: result.total
						          // 첫번째 결과 결과 주소: result.items[0].address
						          // 첫번째 검색 결과 좌표: result.items[0].point.y, result.items[0].point.x
						          var myaddr = new naver.maps.Point(result.items[0].point.x, result.items[0].point.y);
						          map.setCenter(myaddr); // 검색된 좌표로 지도 이동
						          // 마커 표시
						          var marker = new naver.maps.Marker({
						            position: myaddr,
						            map: map
						          });
						          // 마커 클릭 이벤트 처리
						          naver.maps.Event.addListener(marker, "click", function(e) {
						            if (infowindow.getMap()) {
						                infowindow.close();
						            } else {
						                infowindow.open(map, marker);
						            }
						          });
						          // 마크 클릭시 인포윈도우 오픈
						          var infowindow = new naver.maps.InfoWindow({
						              content: '<h4> [한국데이터진흥원] </h4>'
						          });
						      });
						      </script>
						
						
							<div class="contact-info">
			    				<h2 class="title text-center">Company Info</h2>
			    				<address>
			    					<p>WaterMelon-Shoppingmall Inc.</p>
									<p>경기도 성남시 분당구 판교로 289 번길 20 스타트업캠퍼스</p>
									<p>김민기, 공혜림, 원정아, 이수빈, 이윤재, 김현수</p>
									<p>Mobile: +2 3462 1738</p>
									<p>Fax: 1-714-252-0026</p>
									<p>WaterMelon@Shoppingmall.com</p>
			    				</address>
			    				<div class="social-networks">
			    					<h2 class="title text-center">Social Networking</h2>
									<ul>
										<li>
											<a href="#"><i class="fa fa-facebook"></i></a>
										</li>
										<li>
											<a href="#"><i class="fa fa-twitter"></i></a>
										</li>
										<li>
											<a href="#"><i class="fa fa-google-plus"></i></a>
										</li>
										<li>
											<a href="#"><i class="fa fa-youtube"></i></a>
										</li>
									</ul>
			    				</div>
		    				</div>  	
						</div>
					</div>
				</div>
			</div>
			</div>
		</div>
	</section>
	
	
<jsp:include page="../view/footer.jsp"/>