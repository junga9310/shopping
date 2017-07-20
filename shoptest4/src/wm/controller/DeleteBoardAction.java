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
			   //throw new Exception("정보가 정확하지 않습니다.");	
				out.println("<script>");
				out.println("alert('정보가 정확하지 않습니다.')");
				out.println("</script>");
			}
			
			//password확인
			 int bNo=Integer.parseInt(BOARD_NUM);
			Qna dbQna=QnaService.selectByBoardNum(bNo, false);//조회수증가안함
			if(dbQna.getBOARD_PASS().equals(BOARD_PASS)){//일치
				 if(QnaService.delete(bNo, BOARD_PASS) > 0){//삭제성공
					 
					response.sendRedirect("wm?command=list");
					 	
					 return;//메소드 빠져나가라.
				 }else{//삭제실패
					 throw new Exception("삭제되지 않았습니다.");
				 }
				
			}else{//비번오류
				throw new Exception("비밀번호 확인해주세요.");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
		
		request.getRequestDispatcher("page/view/errorView.jsp").forward(request, response);
	
	}

}
