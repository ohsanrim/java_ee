package board.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardPaging;
import board.bean.ImageDTO;
import board.dao.BoardDAO;

public class ImageBoardListService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		//페이징 처리
		BoardDAO boardDAO = BoardDAO.getInstance();
		int pg = request.getParameter("pg") == null ? 1 : (Integer.parseInt(request.getParameter("pg")));
		
		int endNum = pg * 3;
		int startNum = endNum - 2;
		int totalA = 0;
		
		BoardPaging boardPaging = new BoardPaging();
		totalA = boardDAO.getTotalImageBoard(); // 총글수
		boardPaging.setCurrentPage(pg);
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(3);
		boardPaging.setTotalA(totalA);
		boardPaging.makePagingHTML();
		request.setAttribute("boardPaging", boardPaging);
		
		//DB 
		List<ImageDTO> list = boardDAO.getImageBoard(startNum, endNum);
		request.setAttribute("list", list);
		request.setAttribute("display","/board/imageBoardList.jsp");
		return "/main/index.jsp";
	}
}
