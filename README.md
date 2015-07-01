# proj_Model2_ManagementSystem

- View : JSP, js -> Controller : Servlet
- Servlet설정 : web.xml 
- DAO,DTO & DBCP : http://cyzest.tistory.com/5
- DBCP설정 : 1. tomcat server.xml , 2. web.xml, 3.사용: Java/JSP
- JDBC프로그래밍 
- Session처리 
	- servlet : HttpSession session = request.getSession() / session.setAttribute()
	- jsp : <%=session.getAttribute("message") %>
	