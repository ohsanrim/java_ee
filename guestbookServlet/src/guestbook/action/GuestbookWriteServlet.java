package guestbook.action;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;

//@WebServlet("/LoginServlet")
public class  GuestbookWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 데이터
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String homepage = request.getParameter("homepage");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		GuestbookDTO guestbookDTO = new GuestbookDTO();
		guestbookDTO.setName(name);
		guestbookDTO.setEmail(email);
		guestbookDTO.setHomepage(homepage);
		guestbookDTO.setSubject(subject);
		guestbookDTO.setContent(content);
		
		// db
		GuestbookDAO guestbookDAO = GuestbookDAO.getInstance();
		guestbookDTO.setSeq(guestbookDAO.seq());
		guestbookDAO.writeMember(guestbookDTO);
		// 응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>회원가입</title>");
		
		out.println("</head>");
		out.println("<body>");
		out.println("<form name='writebookServlet' action='/guestbookServlet/GuestbookListServlet'>");
		out.println("작성하신 글을 저장하였습니다.");
		out.println("<input type='button' value='글목록' onclick='listForm()'>");
		out.println("</form>");
		out.println("</body>");
		//out.println("<script>function guestlistForm(){ location.href='http://localhost:8080/guestbookServlet/GuestbookListServlet'}</script>");
		out.println("<script> function listForm(){ document.writebookServlet.submit(); }</script>");
		out.println("</html>");

	}
}
