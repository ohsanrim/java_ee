package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.dao.MemberDAO;

public class CheckIdService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터 받기
		boolean exist=false;
		 String id = request.getParameter("id");
		//DB
		 MemberDAO memberDAO = MemberDAO.getInstance();
		 exist=memberDAO.isExistId(id);

		//응답
		 request.setAttribute("id",id);
		 if(exist) {  
			 return "/member/checkIdFail.jsp";
		 } else {
			 return "/member/checkIdOk.jsp";
			 
		 }
	}

}
