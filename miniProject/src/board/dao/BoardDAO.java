package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

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
	private DataSource ds;
	public static BoardDAO getInstance() {
		if (instance == null) { // null인 경우는 맨 처음 생성될 때 딱 한번이기 때문에 한번만 생성되게 된다.
			synchronized (BoardDAO.class) { // 스레드가 많이 들어와도 순차적으로 진행하게 됨
				instance = new BoardDAO(); // 메모리에 한번 생성
			}
		}
		return instance;
	}
	public BoardDAO() {
		Context ctx;
		try {
			ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public int insertBoard(BoardDTO boardDTO) {
		int su=0;
		String sql= "insert into board values(?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";
		
		try {
			conn=ds.getConnection();
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
		
		try{
			conn=ds.getConnection();
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
	
	public ArrayList <BoardDTO> selectAll(int startNum , int endNum) {
		String sql="select * from (select rownum rn, tt.* from (select seq,id,name,email,subject,content,ref,lev,step,pseq,reply,hit,logtime from board order by ref desc, step asc)tt) where rn>=? and rn<=?";
		
		
		ArrayList <BoardDTO> ar = new ArrayList<BoardDTO>();
		try{
			conn=ds.getConnection();
			  pstmt=conn.prepareStatement(sql); 
			  pstmt.setInt(1,startNum);
			  pstmt.setInt(2,endNum);
			  rs=pstmt.executeQuery();
			  if(rs.next()) {
				  while(rs.next()){
					  BoardDTO boardDTO = new BoardDTO();
					  boardDTO.setSeq(rs.getInt("seq"));
					  boardDTO.setId(rs.getString("id"));
					  boardDTO.setName(rs.getString("name"));
					  boardDTO.setEmail(rs.getString("email"));
					  boardDTO.setSubject(rs.getString("subject"));
					  boardDTO.setContent(rs.getString("content"));
					  boardDTO.setRef(rs.getInt("ref"));
					  boardDTO.setLev(rs.getInt("lev"));
					  boardDTO.setStep(rs.getInt("step"));
					  boardDTO.setPseq(rs.getInt("pseq"));
					  boardDTO.setReply(rs.getInt("reply"));
					  boardDTO.setHit(rs.getInt("hit"));
					  boardDTO.setLogtime(rs.getDate("logtime"));
					  ar.add(boardDTO);
				  } 
			  }
			  } catch(SQLException e) {
			 e.printStackTrace();
			  } 
		return ar;
	}
	public ArrayList<BoardDTO> getBoardList(int startNum, int endNum, String keyword, int searchOption) {
	      
	      String sql = null;
	      ArrayList<BoardDTO> ar = new ArrayList<BoardDTO>();
	      
	      if(searchOption==1) {
	         sql = "select * from (select rownum rn, tt.* from (select * from board where subject like ? order by ref desc, step asc)tt) where rn>=? and rn<=?";
	      }else if(searchOption==2){
	         sql = "select * from (select rownum rn, tt.* from (select * from board where id like ? order by ref desc, step asc)tt) where rn>=? and rn<=?";
	      }
	      try {
	         conn = ds.getConnection();         
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, "%"+keyword+"%");
	         pstmt.setInt(2, startNum);
	         pstmt.setInt(3, endNum);
	         rs = pstmt.executeQuery();
	         
	         while(rs.next()) {
	            BoardDTO boardDTO = new BoardDTO();
	            boardDTO.setSeq(rs.getInt("seq"));
	            boardDTO.setId(rs.getString("id"));
	            boardDTO.setName(rs.getString("name"));
	            boardDTO.setEmail(rs.getNString("email"));
	            boardDTO.setSubject(rs.getString("subject"));
	            boardDTO.setContent(rs.getString("content"));
	            boardDTO.setRef(rs.getInt("ref"));
	            boardDTO.setLev(rs.getInt("lev"));
	            boardDTO.setStep(rs.getInt("step"));
	            boardDTO.setPseq(rs.getInt("pseq"));
	            boardDTO.setReply(rs.getInt("reply"));
	            boardDTO.setHit(rs.getInt("hit"));
	            boardDTO.setLogtime(rs.getDate("logtime"));

	            ar.add(boardDTO);      
	         }
	      } catch (SQLException e) {
	         ar = null;
	         e.printStackTrace();
	      } finally {
	         try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      System.out.println(ar.size()+"개의 항목을 찾았습니다.");
	      return ar;
	   }
	
	public int getTotalA(boolean search, int searchOption, String keyword) {
		int totalA=0;
		String sql="";
		if(search&&searchOption==1) {
			sql="select count(*) as count from board where subject like ?";
		} else if(search&&searchOption==2) {
			sql="select count(*) as count from board where id like ?";
		} 
		try{
			conn=ds.getConnection();
			  pstmt=conn.prepareStatement(sql); 
			  if(search) {
				  pstmt.setString(1,"%"+keyword+"%");
			  }
			  rs=pstmt.executeQuery();
			  rs.next();
			  totalA= rs.getInt("count");
			  } catch(SQLException e) {
			 e.printStackTrace();
			  } finally {
					try {
						if(pstmt!=null) pstmt.close();
						if(conn!=null)conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
		return totalA;
	}
	public int getTotalA() {
		int totalA=0;
		String sql="select count(*) as count from board";
		try{
			conn=ds.getConnection();
			  pstmt=conn.prepareStatement(sql); 
			  rs=pstmt.executeQuery();
			  rs.next();
			  totalA= rs.getInt("count");
			  } catch(SQLException e) {
			 e.printStackTrace();
			  } finally {
					try {
						if(pstmt!=null) pstmt.close();
						if(conn!=null)conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
		return totalA;
	}

	public BoardDTO getBoard(int seq){
		BoardDTO boardDTO = new BoardDTO();
		String sql="select * from board where seq=?";
		
		try{
			conn=ds.getConnection();
			  pstmt=conn.prepareStatement(sql); 
			  pstmt.setInt(1,seq);
			  rs=pstmt.executeQuery();
			  while(rs.next()){
				  boardDTO.setSeq(rs.getInt("seq"));
				  boardDTO.setId(rs.getString("id"));
				  boardDTO.setName(rs.getString("name"));
				  boardDTO.setEmail(rs.getString("email"));
				  boardDTO.setSubject(rs.getString("subject"));
				  boardDTO.setContent(rs.getString("content"));
				  boardDTO.setRef(rs.getInt("ref"));
				  boardDTO.setLev(rs.getInt("lev"));
				  boardDTO.setStep(rs.getInt("step"));
				  boardDTO.setPseq(rs.getInt("pseq"));
				  boardDTO.setReply(rs.getInt("reply"));
				  boardDTO.setHit(rs.getInt("hit"));
				  boardDTO.setLogtime(rs.getDate("logtime"));
			  }
			  } catch(SQLException e) {
			 e.printStackTrace();
			  } finally {
					try {
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(conn!=null)conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
		return boardDTO;
	}
	public int updateBoard(BoardDTO boardDTO) {
		int su=0;
		String sql= "update board set subject =?,content=?, logtime=sysdate where seq=?";
		
		try {
			conn=ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,boardDTO.getSubject());
			pstmt.setString(2,boardDTO.getContent());
			pstmt.setInt(3,boardDTO.getSeq());
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
	
	public void countHit(int seq) {
	      String sql = "update board set hit = hit + 1 where seq=?";
	      
	      try {
	    	 conn=ds.getConnection();
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, seq);
	         pstmt.executeUpdate();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	         try {
	            if(pstmt != null) pstmt.close();
	            if(conn != null) conn.close();
	         }catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	   }

	
	
}
