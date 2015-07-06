<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>login! </h3>

<form name="loginForm" method="post" action="./login.do">
	<tr>
		<td>id</td>
		<td><input type="text" name="id"></td>
	</tr>
	<tr>
		<td>pwd</td>
		<td><input type="text" name="pw"></td>
	</tr>
	<input type="submit" value="로그인" onclick="">
	<input type="reset" value="취소" >
	
	<!-- 상당히고민한부분 -->
	<input type="button" value="회원가입" onclick="location.href='./join.do'" > 
</form>

<c:if test="${fail == 1}">
	${sessionScope.message }
</c:if>


</body>
</html>