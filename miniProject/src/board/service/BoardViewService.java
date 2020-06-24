package board.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardViewService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("memId"); // 접속한 사용자 아이디

		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = request.getParameter("pg") == null ? 1 : (Integer.parseInt(request.getParameter("pg")));

		// DB연동
		BoardDAO boardDAO = BoardDAO.getInstance();
		BoardDTO boardDTO = new BoardDTO();
		boardDTO = boardDAO.getBoard(seq);
		request.setAttribute("seq", seq);
		request.setAttribute("pg", pg);
		request.setAttribute("boardDTO", boardDTO);
		request.setAttribute("display", "/board/boardView.jsp");

		// 조회수 처리
		Cookie[] ar = request.getCookies();   //모든 쿠키 얻어오기
	      String cookieName = null;
	      String cookieValue = null;
	      if(ar != null){
	         for(int i=0; i<ar.length; i++){
	            cookieName = ar[i].getName(); //쿠키명
	            cookieValue = ar[i].getValue(); //값
	            break;
	         }
	      }
	      
	      if(cookieValue.equals("1")){
	          if(id.equals(boardDTO.getId())) {
	             //로그인ID와 작성자ID가 같으면 조회수가 올라가지 않는다.
	             Cookie cookie = new Cookie("boardInsert", "1");
	             cookie.setMaxAge(30*60);
	             response.addCookie(cookie);
	             System.out.println("1");
	          }else {
	             //로그인ID와 작성자ID가 다를경우에만 조회수 UP!!
	             Cookie cookie = new Cookie("boardInsert", "0");
	             cookie.setMaxAge(30*60);
	             response.addCookie(cookie);
	             boardDAO.countHit(seq);
	             System.out.println("2");
	          }
	       }
		return "/main/index.jsp";
	}

}
