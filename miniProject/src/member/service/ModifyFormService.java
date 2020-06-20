package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.LoginDAO;

public class ModifyFormService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();
		String name=(String)session.getAttribute("memName");
		String id=(String)session.getAttribute("memId");
		String pwd=(String)session.getAttribute("memPwd");
		
		//DB
		LoginDAO loginDAO = LoginDAO.getInstance();
		MemberDTO memberDTO =new MemberDTO();
		memberDTO=loginDAO.loginMember(id,pwd);
		String gender= memberDTO.getGender();
		String email1= memberDTO.getEmail1();
		String email2= memberDTO.getEmail2();
		String tel1= memberDTO.getTel1();
		String tel2= memberDTO.getTel2();
		String tel3= memberDTO.getTel3();
		String zipcode= memberDTO.getZipcode();
		String addr1= memberDTO.getAddr1();
		String addr2= memberDTO.getAddr2();
		request.setAttribute("memberDTO",memberDTO);
		System.out.println(pwd);
		System.out.println(gender);
		System.out.println("DB 작업 완료");
		request.setAttribute("display","/member/modifyForm.jsp");
		return "/main/index.jsp";
	}

}
