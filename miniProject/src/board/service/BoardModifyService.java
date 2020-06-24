package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardModifyService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
	    String seq=request.getParameter("seq");
	    String pg=request.getParameter("pg");
	    String subject=request.getParameter("subject");
	    String content=request.getParameter("content");
	    BoardDAO boardDAO = BoardDAO.getInstance();
	    
	    BoardDTO boardDTO = new BoardDTO();
	    boardDTO.setSeq(Integer.parseInt(seq));
	    boardDTO.setSubject(subject);
	    boardDTO.setContent(content);
	    int su=boardDAO.updateBoard(boardDTO);
	    System.out.println(su);
	    
	    request.setAttribute("pg",pg);
		request.setAttribute("display","/board/boardModify.jsp");
		return "/main/index.jsp";
	}

}
