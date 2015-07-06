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


	
	// 2015/07/06 issue
	// 0. 관리자일때, 관리페이지에서 회원들목록 보기
	// 1. 회원가입후에는 login을 넘어서 바로 main로가야하는것 아닌가? forward
	// 2. DTO에서 admin/member를 나누는 field추가 
	// 3. 아이디를 사용한다고 누르면 EL-> js로 userid정보가 넘어와야하는데..
	
# 계발기능 
- 1. Login기능 (index.jsp -> LoginServlet -> login.jsp)
- 2. Join기능  JoinServlet
- 3. Update기능 UpdateServlet 
- 4. id중복체크기능 추가!
- 5. Logging Framework (log4j)

- * 로그수집 
- * Tomcat/etc 모니터링