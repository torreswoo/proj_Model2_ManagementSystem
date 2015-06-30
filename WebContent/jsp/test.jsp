<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.Context" %>   
<%@ page import="com.skplanet.dao.MemberDAO" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<%-- <%
	Context initContext = new InitialContext();
	Context envContext = (Context)initContext.lookup("java:/comp/env");
	DataSource ds = (DataSource)envContext.lookup("jdbc/test");
	Connection conn = ds.getConnection();
	out.println("DBCP연동");
%>  --%>

<%
	MemberDAO memberDAO = MemberDAO.getInstance();
	Connection conn = memberDAO.getConnection();
	out.println("DBCP 연동성공");
%>

</body>
</html>