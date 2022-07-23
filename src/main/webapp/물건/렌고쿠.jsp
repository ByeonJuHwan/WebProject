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
<meta charset="UTF-8">
<title>렌고쿠 피규어</title>
</head>
<body>
	<img src="/WebProject/image/렌고쿠.png"
     alt="MDN logo"> <Br>
    <b>가격 : 100원</b> <br><br>
    <h4>QnA</h4>
   <input type="button" value="작성하기" onClick="location.href='http://localhost:8080/WebProject/%EB%AC%BC%EA%B1%B4/QnAform.jsp'"> 

    <table align="center" border="1">
    	<tr align = "center" bgcolor="skyblue">
    		<td width="7%"><b>글 번호</b></td>
    		<td width="7%"><b>답변 여부</b></td>
    		<td width="7%"><b>구분</b></td>
    		<td width="7%"><b>내용</b></td>
    		<td width="7%"><b>아이디</b></td>
    		<td width="7%"><b>작성 일자</b></td>
    	</tr>
    	
    	<c:choose>
    		<c:when test="${empty qnalist}">
    			<tr>
    				<td colspan="6">
    					<b><span style="font-size:9pt;">등록된 글이 없습니다.</span></b>
    				</td>
    			</tr>		
    		</c:when>
    		<c:when test="${!empty qnalist }">
    			<c:forEach var="qna" items="${qnalist }" varStatus="qnaNum">
    				<tr align="center">
    					<td width="2%">${qna.articleNO }</td>
    					<td width="5%">${qna.answer }</td>
    					<td width="7%">${qna.way }</td>
    					<td width="9%"><a href="${contextPath }/qna/viewQnA.do?articleNO=${qna.articleNO }">${qna.content }</a></td>
    					<td width="7%">${qna.id }</td>
    					<td width="7%">${qna.writeDate }</td>
    				</tr>	
    			</c:forEach>
    			
    		</c:when>
    		
    	</c:choose>
    
    
    </table>
    
</body>
</html>