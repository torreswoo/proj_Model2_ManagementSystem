<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	
	<!-- js경로를 지정해주어야 -->
	<script type="text/javascript" src="../js/checkMemberInfo.js"></script>
</head>
<body>

<h3>register member</h3>

<!-- JSP를 이용한 parameter처리 -->
<%-- <%
	if( request.getParameter("register") !=null){
		String register = request.getParameter("register");
		if(register.equals("fail")){
			out.println("<h5>register fail! try it again!</h5>");
		}
	}
%> --%>

<!-- JSTL를 이용한 parameter처리 -->
<c:if test="${param.register == -1 }" >
	<h5>register fail! try it again!</h5>
</c:if>


<form name="joinForm" method="post" action="../join.do"> <!-- 여기성 주의해야할게 why? "../join.do"? -->
	<table>
		<tr>
			<td>name</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<!-- id중복체크는 DB에서 정보를 불려서해야한다. -->
			<td>id</td>
			<td>
				<input type="text" name="userid">
				<input type="hidden" name="reid"> <!-- id체크를 한지를 체크 -->
				<input type="button" value="중복체크" onclick="idCheck()"> <!-- 일단 js로 넘긴다. -->
			</td>
		</tr>
		<tr>
			<td>email</td>
			<td><input type="text" name="email"></td>
		</tr>
		<tr>
			<td>phone</td>
			<td><input type="text" name="pw"></td>
		</tr>
		<tr>
			<td>admin</td>
			<td>
				<input type="radio" name="admin" value="admin">
				<input type="radio" name="admin" value="member">
			</td>
		</tr>
	</table>
	
	<input type="submit" value="submit" onclick="return joinCheck()">
	<input type="reset" value="reset">
</form>


</body>
</html>