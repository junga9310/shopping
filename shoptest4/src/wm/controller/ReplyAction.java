package wm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import wm.model.dto.Qna;
import wm.model.service.QnaService;

public class ReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse respons) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String ref = request.getParameter("BOARD_NUM");
	
		System.out.println("댓글에서"+ref);
		String url="page/view/errorView.jsp";
		if(ref==null)
		{
			  request.setAttribute("errorMsg","게시글이 존재하지 않습니다.");
		        request.setAttribute("redirectPath","index.jsp");
		}
		else{
			request.setAttribute("refNo", ref);
			request.getRequestDispatcher("page/boardqna/writereply.jsp").forward(request, respons);
		}
		

	}

}
