<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<form name="joinForm" method="post" action="../join.do"> <!-- 여기성 주의해야할게 why? "../join.do"? -->
	<table>
		<tr>
			<td>name</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>id</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>email</td>
			<td><input type="text" name="email"></td>
		</tr>
		<tr>
			<td>phone</td>
			<td><input type="text" name="pw"></td>
		</tr>
	</table>
	
	<input type="submit" value="submit" onclick="return joinCheck()">
	<input type="reset" value="reset">
</form>


</body>
</html>