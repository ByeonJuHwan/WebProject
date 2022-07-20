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
<title>관리자 페이지</title>
<style>
  .cls1{
    
    text-align: center;
  }
  
</style>
</head>
<body>
<h1 class="cls1">회원정보창</h1>
<table align="center" border="1">
  <tr align="center" bgcolor="skyblue">
    <td width="7%"><b>아이디</b></td>
    <td width="7%"><b>비밀번호</b></td>
    <td width="7%"><b>이름</b></td>
    <td width="7%"><b>이메일</b></td>
    <td width="7%"><b>가입일</b></td>
    <td width="7%"><b>수정</b></td>
    <td width="7%"><b>삭제</b></td>
  </tr>
  <c:choose>
    <c:when test="${empty memberList}">
      <tr>
        <td colspan="7"><b class="cls1">등록된 회원이 없습니다.</b></td>
      </tr>
    </c:when>
    <c:when test="${!empty memberList}" >
      <c:forEach var="mem" items="${memberList}">
        <tr align="center">
          <td>${mem.id}</td>
          <td>${mem.pw}</td>
          <td>${mem.name}</td>
          <td>${mem.email}</td>
          <td>${mem.joinDate}</td>
          <td><a href="${contextPath}/member/modMemberForm.do?id=${mem.id}">수정</a></td>
          <td><a href="${contextPath}/member/delMember.do?id=${mem.id}">삭제</a></td>
        </tr>
      </c:forEach>
    </c:when>
  </c:choose>
</table>


</body>
</html>