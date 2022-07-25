<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%> 
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
  function backToList(obj){
    obj.action="${contextPath}/qna/listqna.do";
    obj.submit();
  }
</script>
<title>글 쓰기</title>
</head>
<body>
	<form method="post" action="${contextPath }/qna/addQnA.do">
		<table border ="0" align="center">
			<tr>
				<td align="right">글제목 :</td>
				<td colspan="2"><input type = "text" size="67" maxlength="500" name="content"/></td>
				
			</tr>
			<tr>
				<td align="right">문의 유형</td>
				<td colspan="2"><select name="way">
									<option value='사이즈'>사이즈</option>
									<option value='배송'>배송</option>		
									<option value='상품 상세 문의'>상품 상세 문의</option>	
								</select> 
				</td>
			</tr>
			<tr>
				<td align="right" valign="top"><br>글내용: </td>
				<td colspan=2><textarea rows="10" cols="65" maxlength="4000" name="details"></textarea> </td>
    		 </tr>
			<tr>
	    		<td align="right"> </td>
	    		<td colspan="2">
	    		<input type="hidden" name="answer" value="답변예정" />
	       		<input type="submit" value="글쓰기"/>
	       		<input type=button value="목록보기"onClick="backToList(this.form)" />
	   		 </td>
     		</tr>
     
		</table>
	</form>
	
	
</body>
</html>