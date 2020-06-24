package board.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;

public class BoardListService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 조회수 만들기
		Cookie cookie = new Cookie("boardInsert", "1");
		cookie.setMaxAge(30 * 60);
		response.addCookie(cookie);
		//날짜 방식 포멧
		SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd");
		SimpleDateFormat today = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat past = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
		Date current = new Date();
		String currentTime = ft.format(current);
		request.setAttribute("ft", ft);
		request.setAttribute("today", today);
		request.setAttribute("past", past);
		
		int pg = request.getParameter("pg") == null ? 1 : (Integer.parseInt(request.getParameter("pg")));

		// db
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		int endNum = pg * 5;
		int startNum = endNum - 4;

		List<BoardDTO> list = boardDAO.selectAll(startNum, endNum);

		// 페이징 처리 - 1페이지 당 2개의 방명록 처리
		int totalA = 0;
		BoardPaging boardPaging = new BoardPaging();
		totalA = boardDAO.getTotalA(); // 총글수
		boardPaging.setCurrentPage(pg);
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(5);
		boardPaging.setTotalA(totalA);
		boardPaging.makePagingHTML();
		request.setAttribute("boardPaging", boardPaging);
		response.setContentType("text/html;charset=UTF-8");

		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("memId");
		request.setAttribute("pg", pg);
		request.setAttribute("list", list);
		
		request.setAttribute("display", "/board/boardList.jsp");
		return "/main/index.jsp";
	}

}
