package board.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.dao.BoardDAO;
import borad.bean.BoardDTO;

public class BoardWriteService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
	    String subject = request.getParameter("subject");
		String content = request.getParameter("content"); 
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("memId");
		String name=(String)session.getAttribute("memName");
		String email=(String)session.getAttribute("memEmail")+"@"+(String)session.getAttribute("memEmail2");
		
		Map<String, String>map = new HashMap<String,String>();
		map.put("id",id);
		map.put("name",name);
		map.put("email",email);
		map.put("subject",subject);
		map.put("content",content);
		//DB
		BoardDAO boardDAO = BoardDAO.getInstance();
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setSeq(boardDAO.seq());
		boardDTO.setId(id);
		boardDTO.setName(name);
		boardDTO.setEmail(email);
		boardDTO.setSubject(subject);
		boardDTO.setContent(content);
		boardDTO.setLev(0);
		boardDTO.setStep(0);
		boardDTO.setPseq(0);
		boardDTO.setReply(0);
		boardDTO.setHit(0);
		//데이터 전송
		int su = boardDAO.insertBoard(boardDTO);
		System.out.println(su);
		request.setAttribute("display","/board/boardWrite.jsp");
		return "/main/index.jsp";
	}

}
