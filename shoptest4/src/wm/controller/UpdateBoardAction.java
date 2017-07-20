package wm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wm.model.dto.Qna;
import wm.model.service.QnaService;

public class UpdateBoardAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/page/view/errorView.jsp";
		
		//�Ѿ���� ���� �ޱ�
		String BOARD_NUM = request.getParameter("BOARD_NUM");
		String BOARD_NAME = request.getParameter("BOARD_NAME");
		String BOARD_SUBJECT =  request.getParameter("BOARD_SUBJECT");
		String BOARD_CONTENT = request.getParameter("BOARD_CONTENT");
		String BOARD_PASS = request.getParameter("BOARD_PASS");
		
		
		//��ȿ�� �˻�
		try{
		  if(BOARD_NUM==null || BOARD_NAME==null || BOARD_SUBJECT==null
				  || BOARD_CONTENT==null ||BOARD_PASS==null ){
			
			  throw new Exception("�Է°��� ������� �ʽ��ϴ�.");
		  }
		  
		  //��й�ȣ üũ
		  int bNo=Integer.parseInt(BOARD_NUM);
		 Qna dbQna = QnaService.selectByBoardNum(bNo, false);
		 if(dbQna.getBOARD_PASS().equals(BOARD_PASS)){//��ġ
			Qna qna = new Qna(bNo,BOARD_NAME, 
					BOARD_SUBJECT, BOARD_CONTENT, BOARD_PASS);
			 
			 if( QnaService.update(qna) > 0){//�����Ϸ�
				 // commmand=detailView , modelNum=? , flag=?
				 url="wm?command=detailView&flag=1";
				 
			 }else{
				 throw new Exception("�������� �ʾҽ��ϴ�...");
			 }
			 
		 }else{//�������
			 request.setAttribute("errorMsg", "��й�ȣ �ٽ� Ȯ�����ּ���.");
			 request.setAttribute("redirectPath", "wm?command=updateForm&BOARD_NUM="+bNo);
		 }
		
		
		}catch(Exception e){
			request.setAttribute("errorMsg", e.getMessage());
		}
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
