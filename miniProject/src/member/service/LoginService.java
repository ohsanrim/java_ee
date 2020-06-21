package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.LoginDAO;

public class LoginService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println(id+" "+pwd);
		//DB
		LoginDAO loginDAO = LoginDAO.getInstance();
	    MemberDTO memberDTO = loginDAO.loginMember(id,pwd);
		//응답
	    String loginCheckTry=null;
	    if(memberDTO.getId()==null) {
	    	loginCheckTry="fail";
	    	request.setAttribute("display","../template/body.jsp");
	    	request.setAttribute("loginCheckTry","false");
	    	return "/main/index.jsp";
	    } else {
	    	request.setAttribute("display","../template/body.jsp");
	    	request.setAttribute("loginCheckTry",loginCheckTry);
	    	HttpSession session = request.getSession();
	    	session.setAttribute("memName", memberDTO.getName());
	    	session.setAttribute("memId", memberDTO.getId());
	    	session.setAttribute("memPwd", memberDTO.getPwd());
	    	session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2());
	    	return "/main/index.jsp";
	    }
	}
}
