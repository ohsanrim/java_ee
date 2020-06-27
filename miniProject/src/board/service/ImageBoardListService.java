package board.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.ImageDTO;
import board.dao.BoardDAO;

public class ImageBoardListService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//DB 
		BoardDAO boardDAO = new BoardDAO();
		List<ImageDTO> list = boardDAO.getImageBoard();
		request.setAttribute("list", list);
		request.setAttribute("display","/board/imageBoardList.jsp");
		return "/main/index.jsp";
	}

}
