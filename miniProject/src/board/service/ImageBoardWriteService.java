package board.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.bean.BoardPaging;
import board.bean.ImageDTO;
import board.dao.BoardDAO;

public class ImageBoardWriteService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String realFolder= request.getServletContext().getRealPath("/storage");
		System.out.println("실제폴더"+realFolder);
		
		//업로드
		MultipartRequest multi = new MultipartRequest(request,realFolder,5*1024*1024,"UTF-8", new DefaultFileRenamePolicy());  //똑같은 이름의 파일이 들어오면 파일 뒤에 번호를 붙여줌
		
		//사진 파일 업로드
		String originalImage1=multi.getOriginalFileName("image1");
		String fileName1 = multi.getFilesystemName("image1");
		File file1= multi.getFile("image1");
		long fileSize1= 0;
		if(file1!=null)fileSize1=file1.length();
		
		
		//DB
		BoardDAO boardDAO = BoardDAO.getInstance();
		ImageDTO imageDTO = new ImageDTO();
		imageDTO.setImageId(multi.getParameter("imageId"));
		imageDTO.setImageName(multi.getParameter("imageName"));
		imageDTO.setImagePrice(Integer.parseInt(multi.getParameter("imagePrice")));
		imageDTO.setImageQty(Integer.parseInt(multi.getParameter("imageQty")));
		imageDTO.setImageContent(multi.getParameter("imageContent"));
		imageDTO.setImage1(originalImage1);
		boardDAO.imageBoardUpdate(imageDTO);
		
		System.out.println("파일"+originalImage1);
		System.out.println("파일이름"+originalImage1);
		System.out.println("크기"+fileSize1);
		request.setAttribute("display","/board/imageBoardWrite.jsp");
		return "/main/index.jsp";
	}

}
