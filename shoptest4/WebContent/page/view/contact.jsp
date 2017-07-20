<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../view/header.jsp"/>

 <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=EiSEz5lz3_qfwjj1alQw&submodules=geocoder"></script>
	 <div id="contact-page" class="container">
    	<div class="bg">
	    	<div class="row">    		
	    		<div class="col-sm-12">    			   			
					 <div id="map" style="width:100%;height:400px;"></div>
			    <script>
			      var map = new naver.maps.Map('map');
			      var myaddress = '경기도 성남시 분당구 대왕판교로 645번길 12';// 도로명 주소나 지번 주소만 가능 (건물명 불가!!!!)
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
			              content: '<h4> [네이버 개발자센터]</h4><a href="https://developers.naver.com" target="_blank"><img src="https://developers.naver.com/inc/devcenter/images/nd_img.png"></a>'
			          });
			      });
			      </script>
				</div>			 		
			</div>    	
    		<div class="row">  	
	    		<div class="col-sm-8">
	    			<div class="contact-form">
	    				<h2 class="title text-center">Get In Touch</h2>
	    				<div class="status alert alert-success" style="display: none"></div>
				    	<form id="main-contact-form" class="contact-form row" name="contact-form" method="post">
				            <div class="form-group col-md-6">
				                <input type="text" name="name" class="form-control" required="required" placeholder="Name">
				            </div>
				            <div class="form-group col-md-6">
				                <input type="email" name="email" class="form-control" required="required" placeholder="Email">
				            </div>
				            <div class="form-group col-md-12">
				                <input type="text" name="subject" class="form-control" required="required" placeholder="Subject">
				            </div>
				            <div class="form-group col-md-12">
				                <textarea name="message" id="message" required="required" class="form-control" rows="8" placeholder="Your Message Here"></textarea>
				            </div>                        
				            <div class="form-group col-md-12">
				                <input type="submit" name="submit" class="btn btn-primary pull-right" value="Submit">
				            </div>
				        </form>
	    			</div>
	    		</div>
	    		<div class="col-sm-4">
	    			<div class="contact-info">
	    				<h2 class="title text-center">Contact Info</h2>
	    				<address>
	    					<p>E-Shopper Inc.</p>
							<p>935 W. Webster Ave New Streets Chicago, IL 60614, NY</p>
							<p>Newyork USA</p>
							<p>Mobile: +2346 17 38 93</p>
							<p>Fax: 1-714-252-0026</p>
							<p>Email: info@e-shopper.com</p>
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
    </div><!--/#contact-page-->
	
<jsp:include page="../view/footer.jsp"/>