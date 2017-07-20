package wm.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wm.model.dto.Qna;
import wm.model.service.QnaService;

public class SelectBoardAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="page/view/errorView.jsp";
		try{	
		 List<Qna> list = QnaService.selectAll();
		 request.setAttribute("list", list);//viewpage에서 ${list}
		 url="page/boardqna/list.jsp";
		 
		}catch(SQLException e){
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());//뷰페이지 ${errorMsg}
		}
		
		 request.getRequestDispatcher(url).forward(request, response);
		
	}

}







