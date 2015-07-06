package com.skplanet.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.skplanet.dto.MemberVO;

public class MemberDAO {

	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO(){}
	public static MemberDAO getInstance(){	
		return instance;
	}
	
	public Connection getConnection() throws Exception {
		Context initCtx = new InitialContext(); 
		Context envCtx = (Context)initCtx.lookup("java:comp/env"); 
		DataSource ds = (DataSource)envCtx.lookup("jdbc/test");
		Connection conn = ds.getConnection();
		return conn;
	}

	// join.do 회원정보를 DB에 추가하기위한 메소드 
	public int insertMember(MemberVO mVo) {
		int result = -1;
		String sql = "insert into member values(?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getName());
			pstmt.setString(2, mVo.getId());
			pstmt.setString(3, mVo.getPw());
			pstmt.setString(4, mVo.getEmail());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//	result = -1;// session test를 위해 join.jsp->JoinServlet.java->join.jsp
		return result;
	}
	
	// idCheck.do : id중복을 DB에서 체
	public int idCheck(String userid){
		int result = -1;
		String sql = "select userid from member where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				result = 1; // 중복된 id가존재 
			}
			else{
				result = -1;// 중복된 id가 없다 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)	pstmt.close();
				if (conn != null)	conn.close();
				if (rs != null)	rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public int LoginMember(String id, String pw) {
		int result = 0;
		String sql = "select pwd from member where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				String pwd = rs.getString("pwd");
				if (pwd.equals(pw)){
					result = 1;// 성공 
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)	pstmt.close();
				if (conn != null)	conn.close();
				if (rs != null)	rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public MemberVO getMember(String id){
		MemberVO member=new MemberVO();
		String sql = "select * from member where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				String userid = id;
				String name = rs.getString("name");
				String pwd = rs.getString("pwd");
				String email = rs.getString("email");
				String admin = rs.getString("admin");
				member.getMemberVO(name, userid, email, pwd, admin);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)	pstmt.close();
				if (conn != null)	conn.close();
				if (rs != null)	rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return member;
		
	}
}
