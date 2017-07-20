package wm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wm.model.dto.Qna;
import wm.model.service.QnaService;

public class DeleteBoardAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");	
		
		String BOARD_NUM = request.getParameter("BOARD_NUM");
		String BOARD_PASS = request.getParameter("BOARD_PASS");
		
		PrintWriter out = response.getWriter();
		
		try{
			if(BOARD_NUM==null || BOARD_PASS == null){
			   //throw new Exception("������ ��Ȯ���� �ʽ��ϴ�.");	
				out.println("<script>");
				out.println("alert('������ ��Ȯ���� �ʽ��ϴ�.')");
				out.println("</script>");
			}
			
			//passwordȮ��
			 int bNo=Integer.parseInt(BOARD_NUM);
			Qna dbQna=QnaService.selectByBoardNum(bNo, false);//��ȸ����������
			if(dbQna.getBOARD_PASS().equals(BOARD_PASS)){//��ġ
				 if(QnaService.delete(bNo, BOARD_PASS) > 0){//��������
					 
					response.sendRedirect("wm?command=list");
					 	
					 return;//�޼ҵ� ����������.
				 }else{//��������
					 throw new Exception("�������� �ʾҽ��ϴ�.");
				 }
				
			}else{//�������
				throw new Exception("��й�ȣ Ȯ�����ּ���.");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
		
		request.getRequestDispatcher("page/view/errorView.jsp").forward(request, response);
	
	}

}
