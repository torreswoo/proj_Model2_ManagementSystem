package com.skplanet.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;


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
	
	public boolean checkMember(MemberVO member){
		
		return true;
	}
	
}
