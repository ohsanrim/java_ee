package member.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.bean.LoginDTO;
import member.bean.MemberDTO;
import member.dao.LoginDAO;

//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String name=null;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 데이터
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		LoginDTO loginDTO = new LoginDTO();
		// db
		LoginDAO loginDAO = LoginDAO.getInstance();
		//ArrayList<MemberDTO> ar = loginDAO.checkLogin();
		// 응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>회원가입</title>");
		
		out.println("</head>");
		out.println("<body>");
		name = loginDAO.checkLogin(id,pwd);
//			for(MemberDTO data:ar) {
//				if(data.getId().equals(id)&&data.getPwd().equals(pwd)) {
//					name=data.getName();
//					break;
//				}
//			}
			if(name==null) {
				out.println("로그인에 실패하셨습니다.");
				out.println("<input type='button' value='회원가입' onclick='writeForm()'>");
			} else {
				out.println(name+"님이 로그인 하셨습니다.");
			}
		out.println("</body>");
		out.println("<script>function writeForm(){ window.open('http://localhost:8080/memberServlet/member/writeForm.html')}</script>");
		
		out.println("</html>");

	}
  

}
