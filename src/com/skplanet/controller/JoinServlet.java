package com.skplanet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.skplanet.dao.MemberDAO;
import com.skplanet.dto.MemberVO;

/**
 * Servlet implementation class JoinServlet
 */
//@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String email= request.getParameter("email");
		String pw = request.getParameter("pw");
		
		MemberVO member = new MemberVO(name, id, email, pw);
		MemberDAO dao = MemberDAO.getInstance();

		int result = dao.insertMember(member); // [DAO]insert Member to DB
		HttpSession session = request.getSession(); //[SESSION] HttpSession
		if (result == 1 ){ // insert가능 
			session.setAttribute("userid", id);
			session.setAttribute("message", "회원가입을 성공하였습니다");
			
			//forward
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/main.jsp");
			dispatcher.forward(request, response);
		}
		else{
			session.setAttribute("message", "회원가입을 실패하였습니다");
			
			//redirect
			response.sendRedirect("./jsp/join.jsp?register=-1");// why? ./jsp...로해야하는지..
		}
		
		
		
		
	}

}
