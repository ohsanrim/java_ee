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
		String name;
		String logtime;
		String homepage;
		String email;
		String content;
		String subject;
		int pg=Integer.parseInt(request.getParameter("pg"));
		// db
		ArrayList <GuestbookDTO> list = new ArrayList <GuestbookDTO>();
		GuestbookDAO guestbookDAO = GuestbookDAO.getInstance();
		
		//페이징 처리 - 1페이지 당 2개의 방명록 처리
		int endNum=pg*2;
		int startNum=endNum-1;
		list=guestbookDAO.selectAll(startNum, endNum);
		
		int totalA = guestbookDAO.getTotalA();
		System.out.println("total pg="+totalA);
		int totalP =(totalA+1)/2;
		// 응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>회원가입</title>");
		out.println("<style> table,td{ border:1px solid gray;  }");
		//out.println("div{ color:red; width: 500px; word-wrap: break-word; }");
		out.println("#currentPaging{ border: 1px red solid ; text-decoration: underline;}");
		out.println("#Paging{ color : black; text-decoration: none;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form name='listForm' >");
		if(list!=null) {
			for(int i=1;i<=totalP;i++) {
				if(pg==i) {
					out.println("[<a id = 'currentPaging' href='/guestbookServlet/GuestbookListServlet?pg="+i+"'>"+i+"</a>]");
				} else {
					out.println("[<a id = 'Paging' href='/guestbookServlet/GuestbookListServlet?pg="+i+"'>"+i+"</a>]");
				}
				
			}
			out.println("<br><br>");
			for(GuestbookDTO data:list) {
			name=data.getName();
			email=data.getEmail();
			homepage = data.getHomepage();
			subject = data.getSubject();
			content = data.getContent();
			logtime = data.getLogtime();
			//out.println("<div>");
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
			out.println("<td style='width:500px; height:80px;' colspan='4'><pre style='white-space:pre-wrap; word_wrap:break-word; word-break: break-all;'>"+content+"</pre></td>");
			//out.println("<td style='width:500px; height:80px; white-space:pre-wrap; word_wrap:break-word; word-break: break-all;  'colspan='4'>"+content+"</td>");
			out.println("</tr>");
			out.println("</table>");
			//out.println("</div>");
			//간격 조정
			out.println("<br><br>");
		}
		}
		
		
		out.println("</form>");
		out.println("</body>");
		out.println(
				"<script>function guestlistForm(){ location.href='http://localhost:8080/guestbookServlet/GuestbooklistServlet'}</script>");

		out.println("</html>");

	}
}
