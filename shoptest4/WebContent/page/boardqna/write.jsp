<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<jsp:include page="../view/header.jsp"/>


<div class="container">
			<div class="row">
				<div class="col-sm-12 mb100">




<form name="writeForm" method="post" action="${pageContext.request.contextPath}/wm?command=insert" onSubmit='return checkValid()' enctype="multipart/form-data">
<table align="center" cellpadding="5" cellspacing="2" width="600" border="1" >
    
    <tr>
        <td width="1220" height="20" colspan="2" bgcolor="#fdb45e">
            <p align="center"><font color="white" size="3"><b>Q&A 글 등록 </b></font></p>
        </td>
    </tr>
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">작성자</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="BOARD_NAME" size="30" value="${sessionScope.userId}" readonly="readonly"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">제목</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="BOARD_SUBJECT" size="30"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">내용</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<textarea name="BOARD_CONTENT" cols="50" rows="10"></textarea></span></b></td>
    </tr>
    
     <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">*파일첨부</span></b></p>
        </td>
        <td width="450" height="20">
        	<b><span style="font-size:9pt;">
        		 <input type="file" name="file" maxlength="60" size="40">
        	   </span></b>
        </td>
    </tr>
    
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">비밀번호</span></b></p>
        </td>
        <td width="450" height="20">
        	<b><span style="font-size:9pt;">
        		<input type=password name="BOARD_PASS" size="12">(글 수정, 삭제시 필요합니다.)
        	   </span></b>
        </td>
    </tr>
    <tr>
        <td width="450" height="20" colspan="2" align="center"><b><span style="font-size:9pt;"><input type="submit"  value="글쓰기"> 
        <input type=reset value=다시쓰기></span></b></td>
    </tr>
</table>

</form>

<hr>
<div align=right><span style="font-size:9pt;"><a  class="btn btn-default"   href="../../wm?command=list">리스트로 돌아가기</a></span></div>


</div>
</div>
</div>
<SCRIPT language=javascript>

function checkValid() {
    var f = window.document.writeForm;
		
	  if ( f.BOARD_NAME.value == "") {
	    alert( "로그인을 해주세요." );
	    f.BOARD_NAME.focus();
		return false;
    } 
     if ( f.BOARD_SUBJECT.value == "" ) {
		alert( "제목을 입력해 주세요." );
		f.BOARD_SUBJECT.focus();
		return false;
	}
	if ( f.BOARD_CONTENT.value == "" ) {
		alert( "내용을 입력해 주세요." );
		f.BOARD_CONTENT.focus();
		return false;
	}
	/* if ( f.BOARD_NAME.value == "" ) {
		alert( "작성자를 입력해 주세요." );
		f.BOARD_NAME.focus();
		return false;
	} */
	if ( f.BOARD_PASS.value == "" ) {
        alert( "비밀번호를 입력해 주세요" );
        f.BOARD_PASS.focus();
        return false;
    }
	
    return true;
}
</SCRIPT>

<jsp:include page="../view/footer.jsp"/>