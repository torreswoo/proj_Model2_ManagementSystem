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
	
	public int checkMember(MemberVO member){
		
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String userid = member.getId();
		String pwd = member.getPw();
		// SQL : SELECT 
		String sql = "select pwd from member where userid=?";
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()){
				if(rs.getString("pwd")!=null && rs.getString("pwd").equals(pwd) ){
					System.out.println("result 1");
					result = 1;
				}
				else{
					System.out.println("result 0");
					result = 0;
				}
			}
			else{
				System.out.println("result -1");
				result = -1;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try {
				if(rs !=null) rs.close();
				if(pstmt !=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
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
			return result;
		}
	
}
