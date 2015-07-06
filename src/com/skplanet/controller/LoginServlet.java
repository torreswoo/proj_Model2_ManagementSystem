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
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/login.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		
		// DAO를 통해 DB에 회워정보가 있는지 체크해야한다.
		MemberDAO mDao = MemberDAO.getInstance();
		HttpSession session = request.getSession(); //[SESSION] HttpSessions
		if(mDao.LoginMember(id, pw) == 1){// login성공
			
			session.setAttribute("userid", id);
			session.setAttribute("message", "로그인을 성공하였습니다");
			
			MemberVO member = mDao.getMember(id);
			request.setAttribute("admin_person", member);		
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/main.jsp");
			dispatcher.forward(request, response);
			
		}		
		else{// login실패 
			request.setAttribute("fail", 1);
			session.setAttribute("message", "로그인을 실패하였습니다.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
