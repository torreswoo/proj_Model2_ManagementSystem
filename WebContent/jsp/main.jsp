<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<%=session.getAttribute("message") %></br>
<%=session.getAttribute("userid") %>님 here is main page</br>

<%
//	MemberVO admin = new MemberVO();
//	admin = request.getAttribute("admin_person");
%>

${admin_person.getId()}


</body>
</html>