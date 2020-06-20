package member.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.bean.ZipcodeDTO;
import member.dao.MemberDAO;

public class CheckPostService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		String sido = request.getParameter("sido");
		System.out.println(sido);
		String sigungu = request.getParameter("sigungu");
		String roadname = request.getParameter("roadname");
		//DB
		ArrayList <ZipcodeDTO> list=new ArrayList<ZipcodeDTO>();
		if(sido!=null&& roadname!=null){
			MemberDAO memberDAO = MemberDAO.getInstance();
			list=memberDAO.getZipcodeList(sido, sigungu, roadname);
			System.out.println(list.size());
		}
		if(list!=null) {
	    	request.setAttribute("list", list);
	    } 
		//응답
		return "/member/checkPost.jsp";
	}

	}
