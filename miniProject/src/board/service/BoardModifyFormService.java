package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.dao.BoardDAO;
import borad.bean.BoardDTO;

public class BoardModifyFormService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int seq=Integer.parseInt(request.getParameter("seq"));
	    int pg=Integer.parseInt(request.getParameter("pg"));
	    
	  //DB연동
	    BoardDAO boardDAO = BoardDAO.getInstance();
	    BoardDTO boardDTO = new BoardDTO();
	    boardDTO=boardDAO.getBoard(seq);
	    request.setAttribute("seq", seq);
	    request.setAttribute("pg", pg);
	    request.setAttribute("boardDTO", boardDTO);
		request.setAttribute("display","/board/boardModifyForm.jsp");
		return "/main/index.jsp";
	}

}
