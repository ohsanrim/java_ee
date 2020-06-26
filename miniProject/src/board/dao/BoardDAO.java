package board.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.bean.BoardDTO;

public class BoardDAO {
	private static BoardDAO instance;
	private SqlSessionFactory sqlSessionFactory;

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
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader); // 빌드를 통해서 초기값을 부여하는 경우가 많음
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void insertBoard(BoardDTO boardDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("boardSQL.insertBoard", boardDTO);
		sqlSession.commit(); // insert, delete, update 는 락이 걸려있기 때문에 반드시 commit을 진행해줘야 한다.
	}

	public int seq() {
		int seq = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		seq =  sqlSession.selectOne("boardSQL.seq");
		System.out.println(seq);
		return seq;
	}

	public List<BoardDTO> selectAll(int startNum, int endNum) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("startNum", Integer.toString(startNum));
		map.put("endNum", Integer.toString(endNum));
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<BoardDTO> list = sqlSession.selectList("boardSQL.selectAll",map);
		System.out.println(list.size() + "개의 항목을 찾았습니다.");
		return list;
	}

	public List<BoardDTO> getBoardList(int startNum, int endNum, String keyword, int searchOption) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("startNum", Integer.toString(startNum));
		map.put("endNum", Integer.toString(endNum));
		map.put("searchOption", Integer.toString(searchOption));
		map.put("keyword", keyword);
		
		/*
		 * if(searchOption==1) { sql =
		 * "select * from (select rownum rn, tt.* from (select * from board where subject like ? order by ref desc, step asc)tt) where rn>=? and rn<=?"
		 * ; }else if(searchOption==2){ sql =
		 * "select * from (select rownum rn, tt.* from (select * from board where id like ? order by ref desc, step asc)tt) where rn>=? and rn<=?"
		 * ; }
		 */
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<BoardDTO> list = sqlSession.selectList("boardSQL.getBoardList", map);
		System.out.println(list.size() + "개의 항목을 찾았습니다.");
		return list;
	}

	public int getTotalA(boolean search, int searchOption, String keyword) {
		int totalA = 0;
		Map<String, String> map = new HashMap<String, String>();
	      map.put("searchOption", Integer.toString(searchOption));
	      map.put("keyword", keyword);
		/*
		 * String sql=""; if(search&&searchOption==1) {
		 * sql="select count(*) as count from board where subject like ?"; } else
		 * if(search&&searchOption==2) {
		 * sql="select count(*) as count from board where id like ?"; } try{
		 * conn=ds.getConnection(); pstmt=conn.prepareStatement(sql); if(search) {
		 * pstmt.setString(1,"%"+keyword+"%"); } rs=pstmt.executeQuery(); rs.next();
		 * totalA= rs.getInt("count"); } catch(SQLException e) { e.printStackTrace(); }
		 * finally { try { if(pstmt!=null) pstmt.close(); if(conn!=null)conn.close(); }
		 * catch (SQLException e) { e.printStackTrace(); } }
		 */
		SqlSession sqlSession = sqlSessionFactory.openSession();
		totalA = sqlSession.selectOne("boardSQL.getTotalA1", map);
		return totalA;
	      
	      
	}

	public int getTotalA() {
		int totalA = 0;
		/*
		String sql = "select count(*) as count from board";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totalA = rs.getInt("count");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		*/
		SqlSession sqlSession = sqlSessionFactory.openSession();
		totalA = sqlSession.selectOne("boardSQL.getTotalA");
		return totalA;
	}

	public BoardDTO getBoard(int seq) {
		BoardDTO boardDTO = new BoardDTO();
		String sql = "select * from board where seq=?";
/*
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			while (rs.next()) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		*/
		SqlSession sqlSession = sqlSessionFactory.openSession();
		boardDTO = sqlSession.selectOne("boardSQL.getBoard",seq);
		return boardDTO;
	}

	public int updateBoard(BoardDTO boardDTO) {
		int su = 0;
		String sql = "update board set subject =?,content=?, logtime=sysdate where seq=?";
/*
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDTO.getSubject());
			pstmt.setString(2, boardDTO.getContent());
			pstmt.setInt(3, boardDTO.getSeq());
			su = pstmt.executeUpdate(); // 실행
			System.out.println(su + "개의 행이 만들어졌습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		*/
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("boardSQL.updateBoard",boardDTO);
		sqlSession.commit();  //insert, delete, update 는 락이 걸려있기 때문에 반드시 commit을 진행해줘야 한다. 
		sqlSession.close();
		return su;
	}

	public void countHit(int seq) {
		String sql = "update board set hit = hit + 1 where seq=?";
/*
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		*/
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int su=sqlSession.update("boardSQL.countHit",seq);
		sqlSession.commit();  //insert, delete, update 는 락이 걸려있기 때문에 반드시 commit을 진행해줘야 한다. 
		sqlSession.close();
		System.out.println(su+"조회수 업!");
	}

	public void boardReply(Map<String, String> map) {
		//그룹번gh: 원글의 그룹번호
		//만약 똑같은 단계의 글이 들어오게 되면 새로 작성한 글번호 이후의 그 이전에 있던 번호들의 단계+1 를 해주어야 한다. 
		//update board step=step+1 where ref= 원글ref and step>(select step from board where seq='119')
		//글 번호		제목		그룹번호		단계		글순서		원글번호		답글수	
		//seq	subject		ref			lev		step		pseq		reply
		//10		과일		10			0		0			0			1
		//11		야채		11			0		0			0			1
		//12		사과 		10			1		1			10			1
		//13		오이		11			1		1			11			0
		//14		빨간 사과	10			2		2			12			0
		/*
		map.put("id",id);
		map.put("name",name);
		map.put("email",email);
		map.put("subject",subject);
		map.put("content",content);
		map.put("pseq", pseq+"");   //원글번호*/
		BoardDTO pDTO = this.getBoard(Integer.parseInt(map.get("pseq")));
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//step(글순서) update
		sqlSession.update("boardSQL.boardReply1",pDTO);
		
		//insert
		map.put("ref",pDTO.getRef()+"");
		map.put("lev",pDTO.getLev()+1+"");
		map.put("step",pDTO.getStep()+1+"");
		sqlSession.update("boardSQL.boardReply2",map);
		
		//reply(답글수) update
		sqlSession.update("boardSQL.boardReply3",Integer.parseInt(map.get("pseq")));
		
		sqlSession.commit();
		sqlSession.close();
	}

	public void boardDelete(int seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//답글 수 감소(reply)
		//그 아래의 답글 앞에 [원글이 삭제된 삭제된 답글] 이라고 붙여주기
		//BB삭제
		sqlSession.update("boardSQL.boardDelete",seq);
		sqlSession.commit();
		sqlSession.close();
	}

}
