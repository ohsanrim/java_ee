package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.bean.MemberDTO;

public class MemberDAO {
	private static MemberDAO instance;  //싱글톤이기 때문에 선언할 때 instance라고 많이 선언함
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String userName = "c##java";
	private String password = "bit";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	//싱글톤
	public static MemberDAO getInstance() {
		if(instance==null) { //null인 경우는 맨 처음 생성될 때 딱 한번이기 때문에 한번만 생성되게 된다. 
			synchronized(MemberDAO.class) {   //스레드가 많이 들어와도 순차적으로 진행하게 됨
				instance = new MemberDAO();  //메모리에 한번 생성
			}
		}
		return instance;
	}
	public int writeMember(MemberDTO memberDTO) {
		int su =0;
		String sql= "insert into member values(?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";
		this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getId());
			pstmt.setString(3,memberDTO.getPwd());
			pstmt.setString(4,memberDTO.getGender());
			pstmt.setString(5,memberDTO.getEmail1());
			pstmt.setString(6,memberDTO.getEmail2());
			pstmt.setString(7,memberDTO.getTel1());
			pstmt.setString(8,memberDTO.getTel2());
			pstmt.setString(9,memberDTO.getTel3());
			pstmt.setString(10,memberDTO.getZipcode());
			pstmt.setString(11,memberDTO.getAddr1());
			pstmt.setString(12,memberDTO.getAddr2());
			su=pstmt.executeUpdate();  //실행
			System.out.println(su+"개의 행이 만들어졌습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return su;
	}
	//생성자
	public MemberDAO(){
		try {
			Class.forName(driver); // 드라이버 생성
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//연결
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, userName, password); // 나의
			System.out.println("오라클 접속 성공");  // 접속
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
