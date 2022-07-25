<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%-- 커스텀태그 사용시 무조건 써야하는 코드 --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <%--JSTL 표준 라이브러리 태그 노션 확인해볼것 --%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/> <%-- 링크 이동시 코드의불필요함을 줄일 contextPath 코드 --%>
<%
  request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
<script type="text/javascript" >
function backToList(obj){
    obj.action="${contextPath}/qna/listqna.do";
    obj.submit();
 }
function fn_modify_qna(obj){
	obj.action="${contextPath}/qna/modifyqna.do";
	obj.submit();
}
</script>
<meta charset="UTF-8">
<title>글 상세창</title>
</head>
<body>
<form name="frmQnA" method = "post" action="${contextPath }">
	<table align ="center" border=0>
		<tr>
			<td width="200" align="center" bgcolor="yellow">
				글번호
			</td>
			<td>
				<input type="text" value="${qnavo.articleNO }" disabled/>
				<input type="hidden" name="articleNO" value="${qnavo.articleNO }"/>
			</td>
		<tr>
			<td width="200" align="center" bgcolor="yellow">
				답변여부
			</td>
			<td> 
				<input type="text" value="${qnavo.answer }" name="answer" disabled/>
			</td>
		</tr>
		<tr>
			<td width="200" align="center" bgcolor="yellow">
				구분
			</td>
			<td>
				<select name="way">
					<option value='사이즈'>사이즈</option>
					<option value='배송'>배송</option>		
					<option value='상품 상세 문의'>상품 상세 문의</option>	
				</select> 
			</td>
		</tr>
		<tr>
			<td width="200" align="center" bgcolor="yellow">
				글 제목		
			</td>
			<td>
    			<input type="text" name="content" value="${qnavo.content }" />
   			</td>  
		</tr>
		<tr>
			<td width="200" align="center" bgcolor="yellow">
				글 상세내용
			</td>
			<td>
    			<textarea rows="20" cols="60"  name="details"  id="i_details">${qnavo.details }</textarea>
   			</td>
   		</tr>
   		<tr>
   			<td width="200" align="center" bgcolor="yellow">
   				아이디  
			</td>
			<td>
				<input type="text" value="${qnavo.id }" disabled/>
			</td>
		</tr>
		<tr>
			<td width="200" align="center" bgcolor="yellow">
   				작성일자  
			</td>
			<td>
				<input type="text" value="${qnavo.writeDate }" disabled/>
			</td>
		</tr>	
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="수정하기" onClick="fn_modify_qna(frmQnA)"/> 
				<input type="button" value="돌아가기" onClick=" backToList(frmQnA)"/>
			</td>
		</tr>		
	</table>
</form>
</body>
</html>