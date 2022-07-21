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
<title>메인페이지</title>
</head>
<style type="text/css">
	.cls1{
		text-align:center;
	}

</style>

<body>
	<h1 class="cls1">귀멸의 집</h1>
	<button>
		<a href="${contextPath }/member/loginpage.do">로그인</a>					<%--가운데로 옮겨서 크기 맞추기] --%>
	</button>
	<button>
		<a href="${contextPath }/member/memberin.do">회원가입</a>					<%--가운데로 옮겨서 크기 맞추기] --%>
	</button>
		
	
</body>
</html>