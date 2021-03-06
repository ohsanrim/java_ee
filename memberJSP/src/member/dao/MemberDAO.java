package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;

public class MemberDAO {
	private static MemberDAO instance;  //싱글톤이기 때문에 선언할 때 instance라고 많이 선언함
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String userName = "c##java";
	private String password = "bit";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;
	//생성자
	public MemberDAO(){
		Context ctx;
		try {
			ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
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
		
		try {
			conn=ds.getConnection();
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
	public boolean isExistId(String id) {
		boolean exist=false;
		String sql="select count(*) as count from member where id=?";
		try{
			conn=ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			  rs=pstmt.executeQuery();
			  if(rs.next()){
				  exist=(rs.getInt("count")==1)?true:false;
				  System.out.println(rs.getInt("count"));
			}
			  } catch(SQLException e) {
			 e.printStackTrace();
			  } 
		return exist;
	}
	//생성자
	
	public ArrayList <ZipcodeDTO> getZipcodeList(String sido, String sigungu, String roadname){
		ArrayList <ZipcodeDTO> list= new ArrayList<ZipcodeDTO> ();
		String sql="select * from newzipcode where sido like ? and nvl(sigungu,0) like ? and roadname like ?";
		
		try{
			conn=ds.getConnection();
			  pstmt=conn.prepareStatement(sql); 
			  pstmt.setString(1,"%"+sido+"%");
			  pstmt.setString(2,"%"+sigungu+"%");
			  pstmt.setString(3,"%"+roadname+"%");
			  rs=pstmt.executeQuery();
			  
			  while(rs.next()){
				  ZipcodeDTO zipcodeDTO = new ZipcodeDTO();
				  zipcodeDTO.setZipcode(rs.getString("zipcode"));
				  zipcodeDTO.setSido(rs.getString("sido"));
				  zipcodeDTO.setSigungu(rs.getString("sigungu")==null?"":rs.getString("sigungu"));
				  zipcodeDTO.setYubmyundong(rs.getString("yubmyundong"));
				  zipcodeDTO.setRi(rs.getString("ri")==null?"":rs.getString("ri"));
				  zipcodeDTO.setRoadname(rs.getString("roadname"));
				  zipcodeDTO.setBuildingname(rs.getString("buildingname")==null?"":rs.getString("buildingname"));
				  list.add(zipcodeDTO);
			  }
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
		return list;
	}
	public int modifyMember(MemberDTO memberDTO) {
		int su =0;
		String sql= "update member set name=? , pwd=?, gender=?, email1=?,email2=?,tel1=?, tel2=?,tel3=?,zipcode=?, addr1=?, addr2=?, logtime=sysdate where id=?";
		
		try {
			conn=ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,memberDTO.getName());
			pstmt.setString(2,memberDTO.getPwd());
			pstmt.setString(3,memberDTO.getGender());
			pstmt.setString(4,memberDTO.getEmail1());
			pstmt.setString(5,memberDTO.getEmail2());
			pstmt.setString(6,memberDTO.getTel1());
			pstmt.setString(7,memberDTO.getTel2());
			pstmt.setString(8,memberDTO.getTel3());
			pstmt.setString(9,memberDTO.getZipcode());
			pstmt.setString(10,memberDTO.getAddr1());
			pstmt.setString(11,memberDTO.getAddr2());
			pstmt.setString(12, memberDTO.getId());
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
	
	
}
