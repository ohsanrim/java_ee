package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class LoginService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println(id+" "+pwd);
		//DB
		MemberDAO memberDAO= MemberDAO.getInstance();
		MemberDTO memberDTO = new MemberDTO();
		if(pwd!=null) {   //구글 로그인이 아닌 일반 로그인 시
		    memberDTO = memberDAO.loginMember(id,pwd);
		} else {  //구글 로그인 진행 시 회원가입
		    if(!memberDAO.isExistId(id)) {  //구글 로그인 연동이 처음인 경우로, 회원가입이 되어있지 않을 경우
		    	//회원가입 진행
		    	memberDTO.setName(request.getParameter("name"));
				memberDTO.setId(request.getParameter("id"));
				memberDTO.setGender("0");
				memberDTO.setTel1("010");
				String [] email= request.getParameter("email").split("@");
				System.out.println(email[0]+" "+email[1]);
				memberDTO.setEmail1(email[0]);
				memberDTO.setEmail2(email[1]);
				int su = memberDAO.writeMember(memberDTO);
		    }
		  //회원가입 된 회원 정보 다시 담아오기
		    memberDTO = memberDAO.loginMember(id,"111");
		}
		
		//응답
	    String loginCheckTry=null;
	    if(memberDTO!=null) {
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
	    } else {
	    	loginCheckTry="fail";
	    	request.setAttribute("display","../template/body.jsp");
	    	request.setAttribute("loginCheckTry","false");
	    	return "/main/index.jsp";
	    }
	}
}
