package member.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
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

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;

public class MemberDAO {
	private static MemberDAO instance;  //싱글톤이기 때문에 선언할 때 instance라고 많이 선언함
	private SqlSessionFactory sqlSessionFactory;
	//생성자
	public MemberDAO(){
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);  //빌드를 통해서 초기값을 부여하는 경우가 많음
		} catch(IOException e) {
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
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int su=sqlSession.insert("memberSQL.writeMember",memberDTO);
		sqlSession.commit();  //insert, delete, update 는 락이 걸려있기 때문에 반드시 commit을 진행해줘야 한다. 
		return su;
	}
	public boolean isExistId(String id) {
		boolean isExisted=false;
		SqlSession sqlSession= sqlSessionFactory.openSession();
		MemberDTO memberDTO =sqlSession.selectOne("memberSQL.isExisted",id);
		if(memberDTO!=null) isExisted=true;
		System.out.println(memberDTO);
		return isExisted;
	}
	//생성자
	
	public List <ZipcodeDTO> getZipcodeList(String sido, String sigungu, String roadname){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sido", sido);
		map.put("sigungu", sigungu);
		map.put("roadname", roadname);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ZipcodeDTO> list =sqlSession.selectList("memberSQL.getZipcodeList",map);
		sqlSession.close();
		return list;
	}
	public int modifyMember(MemberDTO memberDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int su=sqlSession.update("memberSQL.modifyMember",memberDTO);
		sqlSession.commit();  //insert, delete, update 는 락이 걸려있기 때문에 반드시 commit을 진행해줘야 한다. 
		sqlSession.close();
		return su;
	}
	public MemberDTO loginMember(String id, String pwd){
		  //String sql="select * from member where id=? and pwd=?";
			  Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", id);
				map.put("pwd", pwd);
				SqlSession sqlSession = sqlSessionFactory.openSession();
				MemberDTO memberDTO =sqlSession.selectOne("memberSQL.loginMember",map);
				sqlSession.close();
				return memberDTO;
		  }
	
	
}
