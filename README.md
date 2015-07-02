# proj_Model2_ManagementSystem

- View : JSP, js -> Controller : Servlet
- Servlet설정 : web.xml 

- DAO,DTO & DBCP : http://cyzest.tistory.com/5
- DBCP설정 : 1. tomcat server.xml , 2. web.xml, 3.사용: Java/JSP
- JDBC프로그래밍 

- Session처리 
	- servlet : HttpSession session = request.getSession() / session.setAttribute()
	- jsp : <%=session.getAttribute("message") %>
	
- EL/JSTL 
	- EL : ${} page, request, session, application
	- JSTL : <c:if test="조건식">~</c:if>
	
	
	// 2015/07/01 issue
	// 1. js에서 id중복등을 체크해야하는가?
	// 2. 회원가입후에는 login을 넘어서 바로 main로가야하는것 아닌가?
	// 3. DTO에서 admin/member를 나누는 field추가 
	
# 계발기능 
- 1. Login기능 (index.jsp -> LoginServlet -> login.jsp)
- 2. Join기능  JoinServlet
- 3. Update기능 UpdateServlet 
	