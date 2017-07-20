<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>입력값 받기</title>


<link rel="stylesheet" href="css/bootstrap.css">

<script type="text/javascript">
  
</script> 

</head>
<body>


 <div >
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
         <select name="genre" size="1" >
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
        <input type="submit" value="추가하기">
      </form>
</div>



<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>