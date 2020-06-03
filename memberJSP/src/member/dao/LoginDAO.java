package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		try {
			Class.forName(driver); // 드라이버 생성
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 연결
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, userName, password); // 나의
			System.out.println("오라클 접속 성공"); // 접속
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	  public String checkLogin(String id, String pwd){
	  	String name=null;
	  String sql="select * from member where id=? and pwd=?";
	  getConnection();
	  try{
	  pstmt=conn.prepareStatement(sql);
	  pstmt.setString(1,id);
	  pstmt.setString(2,pwd);
	  
	  rs=pstmt.executeQuery();
	  if(rs.next()){
	  name=rs.getString("name");
	  }
	  } catch(SQLException e) {
	 e.printStackTrace();
	  } 
	  
	  return name;
	  }
	  
//	
//
//	public ArrayList<MemberDTO> checkLogin() {
//		int su = 0;
//		this.getConnection();
//		ArrayList<MemberDTO> ar = new ArrayList<MemberDTO>();
//		String sql = "select * from member";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				MemberDTO memberDTO = new MemberDTO();
//				memberDTO.setName(rs.getString("name"));
//				memberDTO.setId(rs.getString("id"));
//				memberDTO.setPwd(rs.getString("pwd"));
//				memberDTO.setGender(rs.getString("gender"));
//				memberDTO.setEmail1(rs.getString("email1"));
//				memberDTO.setEmail2(rs.getString("email2"));
//				memberDTO.setTel1(rs.getString("tel1"));
//				memberDTO.setTel2(rs.getString("tel2"));
//				memberDTO.setTel3(rs.getString("tel3"));
//				memberDTO.setZipcode(rs.getString("zipcode"));
//				memberDTO.setAddr1(rs.getString("addr1"));
//				memberDTO.setAddr2(rs.getString("addr2"));
//				ar.add(memberDTO);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			ar = null;
//		} finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (pstmt != null)
//					pstmt.close();
//				if (conn != null)
//					conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return ar;
//	}

}
