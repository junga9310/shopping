package wm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wm.model.dto.Qna;
import wm.model.service.QnaService;

public class UpdateFormBoardAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String BOARD_NUM = request.getParameter("BOARD_NUM");
		String url="/page/view/errorView.jsp";
		try{
			if(BOARD_NUM==null){
				throw new Exception("BOARD_NUM�� �����ϴ�.");
			}
			int bNo=Integer.parseInt(BOARD_NUM);
			Qna qna=QnaService.selectByBoardNum(bNo, false);//��ȸ����������.
			if(qna==null){
				throw new Exception("�ش��ϴ� ���� �����ϴ�.");
			}else{
				request.setAttribute("qna", qna);
				 url="/page/boardqna/update.jsp";
			}
			
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
