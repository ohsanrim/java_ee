package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import borad.bean.BoardDTO;

public class BoardDAO {
	private static BoardDAO instance; 
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String userName = "c##java";
	private String password = "bit";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	public static BoardDAO getInstance() {
		if (instance == null) { // null인 경우는 맨 처음 생성될 때 딱 한번이기 때문에 한번만 생성되게 된다.
			synchronized (BoardDAO.class) { // 스레드가 많이 들어와도 순차적으로 진행하게 됨
				instance = new BoardDAO(); // 메모리에 한번 생성
			}
		}
		return instance;
	}
	public BoardDAO() {
		try {
			Class.forName(driver); // 드라이버 생성
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, userName, password); // 나의
			System.out.println("오라클 접속 성공"); // 접속
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int insertBoard(BoardDTO boardDTO) {
		int su=0;
		String sql= "insert into board values(?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";
		this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardDTO.getSeq());
			pstmt.setString(2, boardDTO.getId());
			pstmt.setString(3, boardDTO.getName());
			pstmt.setString(4, boardDTO.getEmail());
			pstmt.setString(5, boardDTO.getSubject());
			pstmt.setString(6, boardDTO.getContent());
			pstmt.setInt(7, boardDTO.getSeq());
			pstmt.setInt(8, boardDTO.getLev());
			pstmt.setInt(9, boardDTO.getStep());
			pstmt.setInt(10, boardDTO.getPseq());
			pstmt.setInt(11, boardDTO.getReply());
			pstmt.setInt(12, boardDTO.getHit());
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
	
	public int seq() {
		int seq=0;
		String sql="select seq_board.nextval from dual";
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

}
