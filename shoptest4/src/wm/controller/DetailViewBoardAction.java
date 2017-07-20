package wm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wm.model.dto.Qna;
import wm.model.service.QnaService;

public class DetailViewBoardAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="page/view/errorView.jsp";
		String BOARD_NUM = request.getParameter("BOARD_NUM");
		String flag = request.getParameter("flag");
		boolean state=true;
		if(flag!=null)state=false;
		
		//System.out.println("modelNum : " + modelNum);
		//System.out.println("command : " + request.getParameter("command"));
		
		try{
			/*if(BOARD_NUM==null){
				throw new Exception("BOARD_NUM�� �ݵ�� �Է��ؾ��մϴ�.");
			}
			*/
			 int bNo=Integer.parseInt(BOARD_NUM);
			Qna qna = 
					QnaService.selectByBoardNum(bNo, state);//��ȸ������
			
			request.setAttribute("BOARD_NUM", bNo);
		    if(qna==null){
		    	throw new Exception(BOARD_NUM +"������ �����ϴ�.");
		    }else{
		       request.setAttribute("qna", qna); 
		       
		       //��۸�Ϻҷ�����
		       List<Qna> list=QnaService.selectReply(bNo);
		       request.setAttribute("replylist", list);
		       url="page/boardqna/read.jsp";
		    }
		   
		}catch (Exception e) {
			url="page/boardqna/read.jsp";//��
			//request.setAttribute("errorMsg", e.getMessage());
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}	

}
