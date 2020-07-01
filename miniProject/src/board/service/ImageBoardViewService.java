package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.ImageDTO;
import board.dao.BoardDAO;

public class ImageBoardViewService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int seq = Integer.parseInt(request.getParameter("seq"));
		//DB 작업
		BoardDAO boardDAO = BoardDAO.getInstance();
		ImageDTO imageDTO = boardDAO.getImageBoard(seq);
		request.setAttribute("imageDTO", imageDTO);
		request.setAttribute("display", "/imageBoard/imageBoardView.jsp");
		
		return "/main/index.jsp";
	}

}
