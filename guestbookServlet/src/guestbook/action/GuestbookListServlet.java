package guestbook.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;

public class GuestbookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 데이터
		String name="홍길동";
		String logtime="20/05/08";
		String homepage="homepage";
		String email= "ka28@naver,com";
		String content="나좀 살려줘어어어ㅜㅜㅜㅜㅜ";
		String subject="";
		// db
		ArrayList <GuestbookDTO> list = new ArrayList <GuestbookDTO>();
		GuestbookDAO guestbookDAO = GuestbookDAO.getInstance();
		list=guestbookDAO.selectAll();
		// 응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>회원가입</title>");
		out.println("<style> table,td{ border:1px solid gray;}</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form name='listForm' >");
		for(GuestbookDTO data:list) {
			name=data.getName();
			email=data.getEmail();
			homepage = data.getHomepage();
			subject = data.getSubject();
			content = data.getContent();
			logtime = data.getLogtime();
			out.println("<table>");
			//1번째
			out.println("<tr>");
			out.println("<td style='width:100px;' align='center'>작성자</td>");
			out.println("<td style='width:150px;'>"+name+"</td>");
			out.println("<td style='width:100px;' align ='center'>작성일</td>");
			out.println("<td style='width:150px;'>"+logtime+"</td>");
			out.println("</tr>");
			//2번쨰
			out.println("<tr>");
			out.println("<td align='center'>이메일</td>");
			out.println("<td colspan='3'>"+email+"</td>");
			out.println("</tr>");
			//3번쨰
			out.println("<tr>");
			out.println("<td align='center'>홈페이지</td>");
			out.println("<td colspan='3'>"+homepage+"</td>");
			out.println("</tr>");
			//4번쨰
			out.println("<tr>");
			out.println("<td align='center'>제목</td>");
			out.println("<td colspan='3'>"+subject+"</td>");
			out.println("</tr>");
			//5번째
			out.println("<tr>");
			out.println("<td style='width:500px; height:80px;'colspan='4'>"+content+"</td>");
			out.println("</tr>");
			out.println("</table>");
			//간격 조정
			out.println("<br><br>");
		}
		
		out.println("</form>");
		out.println("</body>");
		out.println(
				"<script>function guestlistForm(){ location.href='http://localhost:8080/guestbookServlet/GuestbooklistServlet'}</script>");

		out.println("</html>");

	}
}
