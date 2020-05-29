package guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import guestbook.bean.GuestbookDTO;


public class GuestbookDAO {
private static GuestbookDAO instance;  //싱글톤이기 때문에 선언할 때 instance라고 많이 선언함
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String userName = "c##java";
	private String password = "bit";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs; 
	
	public static GuestbookDAO getInstance() {
		if(instance==null) { //null인 경우는 맨 처음 생성될 때 딱 한번이기 때문에 한번만 생성되게 된다. 
			synchronized(GuestbookDAO.class) {   //스레드가 많이 들어와도 순차적으로 진행하게 됨
				instance = new GuestbookDAO();  //메모리에 한번 생성
			}
		}
		return instance;
	}
	public int seq() {
		int seq=0;
		String sql="select seq_guestbook.nextval from dual";
		this.getConnection();
		try{
			  pstmt=conn.prepareStatement(sql);
			  rs=pstmt.executeQuery();
			  if(rs.next()){
			  seq=rs.getInt("nextval");
			  }
			  } catch(SQLException e) {
			 e.printStackTrace();
			  } 
		return seq;
	}
	public int writeMember(GuestbookDTO guestbookDTO) {
		int su =0;
		String sql= "insert into guestbook values(?,?,?,?,?,?,sysdate)";
		this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, guestbookDTO.getSeq());
			pstmt.setString(2, guestbookDTO.getName());
			pstmt.setString(3, guestbookDTO.getEmail());
			pstmt.setString(4, guestbookDTO.getHomepage());
			pstmt.setString(5, guestbookDTO.getSubject());
			pstmt.setString(6, guestbookDTO.getContent());
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
	public ArrayList <GuestbookDTO> selectAll() {
		String sql="select seq,name,email,homepage,subject,content, to_char(logtime,'YYYY.MM.DD') as logtime from guestbook order by seq desc";
		ArrayList <GuestbookDTO> ar = new ArrayList<GuestbookDTO>();
		this.getConnection();
		try{
			  pstmt=conn.prepareStatement(sql);
			  rs=pstmt.executeQuery();
			  while(rs.next()){
				  GuestbookDTO guestbookDTO = new GuestbookDTO();
				  guestbookDTO.setSeq(rs.getInt("seq"));
				  guestbookDTO.setName(rs.getString("name"));
				  guestbookDTO.setEmail(rs.getString("email"));
				  guestbookDTO.setHomepage(rs.getString("homepage"));
				  guestbookDTO.setSubject(rs.getString("subject"));
				  guestbookDTO.setContent(rs.getString("content"));
				  guestbookDTO.setLogtime(rs.getString("logtime"));
				  ar.add(guestbookDTO);
			  }
			  } catch(SQLException e) {
			 e.printStackTrace();
			  } 
		return ar;
	}
	//생성자
	public GuestbookDAO(){
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
