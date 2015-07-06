<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	
	<!-- js경로를 지정해주어야 -->
	<script type="text/javascript" src="./js/checkMemberInfo.js"></script>
</head>
<body>

<form action="./idCheck.do" method="get" name="frm">
	<!-- 중복인 아이디일때! -->
	<input type="text" name="userid">	
	<input type="submit" value="중복체크"><br>
	
	<c:if test="${result == 1}">
		${userid}은 이미 사용중인 아이디입니다.</br>		
		<!-- 부모의 입력부분의 아이디를 지운다. -->
		<script type="text/javascript">
			opener.document.frm.userid.value="";
		</script>			
	</c:if>
	
	<!-- 중복인 아이디가 아닐때! -->
	<c:if test="${result == -1 }">
		${userid}은 사용가능 아이디입니다.</br>
		<%-- <c:set var="userid" value="${userid}" /> --%>
		<input type="button" value="사용" class="cancel" onclick="idOk()">
	</c:if>
</form>

</body>
</html>