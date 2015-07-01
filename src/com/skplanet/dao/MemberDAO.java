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
	

	
	// 회원정보를 DB에 추가하기위한 메소드 
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
	
}
