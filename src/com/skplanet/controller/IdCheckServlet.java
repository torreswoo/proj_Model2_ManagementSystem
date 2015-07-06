package com.skplanet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.skplanet.dao.MemberDAO;

/**
 * Servlet implementation class IdCheckServlet
 */
@WebServlet("/IdCheckServlet")
public class IdCheckServlet extends HttpServlet {
	
	/* Logging :Log4j*/
	private final Logger logger = Logger.getLogger(IdCheckServlet .class);
	
	/**/
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdCheckServlet() {
        super();
        

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parameter = request.getParameter("userid");
		if(logger.isDebugEnabled()){
			logger.debug("This is debug : " + parameter);
		} 
		if(logger.isInfoEnabled()){
			logger.info("This is info : " + parameter);
		}
		logger.warn("This is warn : " + parameter);
		logger.error("This is error : " + parameter);
		logger.fatal("This is fatal : " + parameter);
		
		String userid = null;
		int result = 0;
		MemberDAO dao = MemberDAO.getInstance();
		
		userid = request.getParameter("userid");
		result = dao.idCheck(userid); //  result=1:이미사용중/ -1:중복이없다.
		
		request.setAttribute("userid", userid);// send id
		request.setAttribute("result", result);// send result
		RequestDispatcher dispatcher = request.getRequestDispatcher("./jsp/idCheck.jsp");
		dispatcher.forward(request, response);	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
