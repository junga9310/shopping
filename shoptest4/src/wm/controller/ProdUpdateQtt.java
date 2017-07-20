package wm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wm.model.dao.ProductDAO;
import wm.model.dao.ProductDAOImpl;
import wm.model.dto.ProductDTO;
import wm.model.service.ProdService;

public class ProdUpdateQtt implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url ="errorView/error.jsp";
		// 수량 업데이트시 -> 제품들을 선택하고 -> 그 수량만 바꿔줌. 
		// 수량 업데이트를 우째할까?  
		// 계산 결과를 setAttribute로 해주자!
		try{
			String p_id = request.getParameter("p_id");
		    String p_qtt= request.getParameter("p_qtt"); 
		    if(p_id == null || p_qtt ==null) {
				request.setAttribute("errorMsg", "필수 입력을 하지 않았습니다.");
				request.setAttribute("redirectPath", "input.html");
		    	//throw new Exception("입력을 하지 않았습니다.");
		    }
		    ProdService.prodUpdateQtt(Integer.parseInt(p_id),Integer.parseInt(p_qtt));
		    url ="index.html";
		    System.out.println("성공!");
		}catch(Exception e){
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);	
	}
}
