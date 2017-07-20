<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="/page/view/header.jsp"/>
<script type="text/javascript">
$(function(){
	function selectAll(){
		$.ajax({
			type:"post",
			url:"wm",
			data:"command=prodindex",
			dataType:"json",
			success:function(result){
				console.log("1 : " + result);
				//alert(result);
				/*
				<div class="col-sm-4" id="listTable">
							<div class="product-image-wrapper">
								<div class="single-products">
										<div class="productinfo text-center">
											<a href="page/product/product-details.jsp"><img src="item" alt="" /></a>
											<h4>${item.p_price}원</h4>
											<p>헤이즈 - 모르고</p>
											<a href="#" class="btn btn-default">자세히보기</a>
										</div>			
								</div>
							</div>
						</div>		
				*/
				var data="";
				var count =0;
			 	$.each(result, function(index, item){
					data+='<div class="col-sm-4" id="listTable">';
					data+='<div class="product-image-wrapper">';
					data+='<div class="single-products">';
					data+='<div class="productinfo text-center">';
					///wm?command=proddetail
							//mv?command=proddetail&p_id='+item.p_id+
					data+='<a id="next" href="wm?command=proddetail&p_id='+item.p_id+'"><img src="${pageContext.request.contextPath}/save/'+item.p_image+'"/></a>';
					data+='<h4>'+item.p_price+'원</h4>';
					data+='<p>'+item.p_singer+'-'+item.p_name+'</p>';
					data+='<a href="wm?command=proddetail&p_id='+item.p_id+'" class="btn btn-default">자세히보기</a>';
					data+='</div>';
					data+='</div>';
					data+='</div>';
					data+='</div>';
					count++;
					if(count==9){
						count =0;
						return false;
					}
				})
				
				//alert(data); 
			 	
			 	//alert($("div.features_items").children("h2"))
				//$("div.features_items").append(data);
			 	$("div.features_items").children("h2").after(data);
			},
				/* 
				var str="";
				$("#listTable div:gt(0)").remove();
				 */
		   error: function(err){
			   alert("오류발생 : " + err);
			   console.log("오류발생 : " + err);
		   }	
		})		
	} // selectall 종료
 selectAll();
	
})
</script>
	<section id="slider"><!--slider--> 
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div id="slider-carousel" class="carousel slide" data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#slider-carousel" data-slide-to="0" class="active"></li>
							<li data-target="#slider-carousel" data-slide-to="1"></li>
							<li data-target="#slider-carousel" data-slide-to="2"></li>
						</ol>
						
						<div class="carousel-inner">
							<div class="item active">
								<div class="col-sm-3">
									<img src="images/home/logo.png" width="150px" class="" alt="" />
									<h2>레드벨벳 컴백!<h2>
									<p>레드벨벳 (Red Velvet) - 여름 미니앨범 [The Red Summer]</p>
									
								</div>
								<div class="col-sm-8">
									<img src="images/home/mainslide_03.jpg" class="girl img-responsive" alt="" />
								</div>
							</div>
							<div class="item">
								<div class="col-sm-3">
									<img src="images/home/logo.png" width="150px" class="" alt="" />
									<h2>워너원 1st Mini Album 예약판매!!</h2>
									<p>[세트 Sky Ver+Pink Ver] 워너원 (WANNA ONE) - 미니앨범 1st Mini Album</p>
									
								</div>
								<div class="col-sm-8">
									<img src="images/home/mainslide_01.jpg" class="girl img-responsive" alt="" />
								</div>
							</div>
							
							<div class="item">
								<div class="col-sm-8">
									<img src="images/home/mainslide_01.jpg" class="girl img-responsive" alt="" />
								</div>
								<div class="col-sm-3">
									<img src="images/home/logo.png" width="150px" class="" alt="" />
									<h2>워너원 1st Mini Album 예약판매!!</h2>
									<p>[세트 Sky Ver+Pink Ver] 워너원 (WANNA ONE) - 미니앨범 1st Mini Album</p>
									<!--  <button type="button" class="btn btn-default get">바로가기</button> -->
								</div>
							</div>
							
						</div>
						
						<a href="#slider-carousel" class="left control-carousel hidden-xs" data-slide="prev">
							<i class="fa fa-angle-left"></i>
						</a>
						<a href="#slider-carousel" class="right control-carousel hidden-xs" data-slide="next">
							<i class="fa fa-angle-right"></i>
						</a>
					</div>
					
				</div>
			</div>
		</div>
	</section><!--/slider-->
	
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<div class="left-sidebar">
						<h2>장르</h2>
						<div class="panel-group category-products" id="accordian"><!--category-productsr-->
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="wm?command=prodgenre&p_genre=ballad">발라드</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="wm?command=prodgenre&p_genre=dance">댄스</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="wm?command=prodgenre&p_genre=hiphop">랩/힙합</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="wm?command=prodgenre&p_genre=classic">인디음악</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="wm?command=prodgenre&p_genre=rock">록/메탈</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="wm?command=prodgenre&p_genre=ost">OST</a></h4>
								</div>
							</div>
							
						</div><!--/category-products-->
					
					
						<!--shipping -->
						<div class="shipping text-center">
							<img src="images/home/left_3.png" alt="" />
						</div>
						<!--/shipping-->
					
					</div>
				</div>
				
				
				
				
				<div class="col-sm-9 padding-right">
					<div class="features_items"><!--features_items-->
						<h2 class="title text-center">인기음반</h2>
						
						
					</div><!--features_items-->
					
					
					
					
				</div>
			</div>
		</div>
	</section>
	
<jsp:include page="/page/view/footer.jsp"/>