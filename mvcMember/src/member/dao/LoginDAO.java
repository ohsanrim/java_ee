package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import member.bean.LoginDTO;
import member.bean.MemberDTO;

public class LoginDAO {
	private static LoginDAO instance; // 싱글톤이기 때문에 선언할 때 instance라고 많이 선언함

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String userName = "c##java";
	private String password = "bit";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;

	public static LoginDAO getInstance() {
		if (instance == null) { // null인 경우는 맨 처음 생성될 때 딱 한번이기 때문에 한번만 생성되게 된다.
			synchronized (MemberDAO.class) { // 스레드가 많이 들어와도 순차적으로 진행하게 됨
				instance = new LoginDAO(); // 메모리에 한번 생성
			}
		}
		return instance;
	}

	// 생성자
	public LoginDAO() {
		
		Context ctx;
		try {
			ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	  public MemberDTO loginMember(String id, String pwd){
		  MemberDTO memberDTO= new MemberDTO();
	  String sql="select * from member where id=? and pwd=?";
	  
	  try{
		  conn=ds.getConnection();
	  pstmt=conn.prepareStatement(sql);
	  pstmt.setString(1,id);
	  pstmt.setString(2,pwd);
	  
	  rs=pstmt.executeQuery();
	  if(rs.next()){
		  memberDTO.setName(rs.getString("name"));
		  memberDTO.setId(rs.getString("id"));
		  memberDTO.setPwd(rs.getString("pwd"));
		  memberDTO.setGender(rs.getString("gender"));
		  memberDTO.setEmail1(rs.getString("email1"));
		  memberDTO.setEmail2(rs.getString("email2"));
		  memberDTO.setTel1(rs.getString("tel1"));
		  memberDTO.setTel2(rs.getString("tel2"));
		  memberDTO.setTel3(rs.getString("tel3"));
		  memberDTO.setZipcode(rs.getString("zipcode"));
		  memberDTO.setAddr1(rs.getString("addr1"));
		  memberDTO.setAddr2(rs.getString("addr2"));
	  }
	  } catch(SQLException e) {
	 e.printStackTrace();
	  } 
	  return memberDTO;
	  }
	  

}
