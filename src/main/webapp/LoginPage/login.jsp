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
  <style>
    h1{
      text-align: center;
      display: block;
      font-size: 2em;
      margin-block-start: 0.67em;
      margin-block-end: 00.67em;
      margin-inline-start: 0px;
      margin-inline-end: 0px;
      font-weight: bold;
    }
    .idpw{
      display: block;
      width:30%;
      margin: auto;
    }
    .btn{
      width: 20%;
      margin: auto;
      color: skyblue;
    }
    .box{
      position: relative;
    }

  </style>
<meta charset="UTF-8">
<title>로그인창</title>
</head>
<body>
	<h1>
    <a href="${contextPath}/MainPage/Main.jsp">귀멸의 집</a>
  </h1><br><br>
  <form method="post" action="&{contextPath}/member/login.do">
    <div class="box">
      <input type="text" class="idpw" placeholder="아이디" id="id"/> <br><br>
    </div> 
    <div class="box">
      <input type="password" class="idpw" placeholder="비밀번호" id="pw"/><br><br>
    </div>
    
      <button type="submit" class="btn">로그인</button> <Br><br>                        <%--가운데로 옮겨서 크기 맞추기] --%>
      <button>
      	<a href="${contextPath }/MemberForm/memberform.jsp">회원가입</a>					<%--가운데로 옮겨서 크기 맞추기] --%>
      </button>
    

  </form>
  
  
  
	
	
</body>
</html> 