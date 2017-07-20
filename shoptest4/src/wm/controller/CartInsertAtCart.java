package wm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wm.model.dao.CartDAO;
import wm.model.dao.CartDAOImpl;
import wm.model.dao.ProductDAO;
import wm.model.dao.ProductDAOImpl;
import wm.model.dto.CartDTO;
import wm.model.service.CartService;

public class CartInsertAtCart implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		System.out.println("오나요");
		String u_id =(String) session.getAttribute("userId");
		int p_id = Integer.parseInt(request.getParameter("prodId"));
	//	int c_qtt = Integer.parseInt(request.getParameter("cartQtt"));
	//	String c_image = request.getParameter("cartImage");
		
	//	CartDTO cartDTO = new CartDTO(u_id, p_id, c_qtt, c_image);
		int c_qtt = 1;
		CartDTO cartDTO = new CartDTO(u_id, p_id, c_qtt);
		
		System.out.println(cartDTO);
		
		ProductDAO prodDAO = new ProductDAOImpl();		
		CartDAO cartDAO = new CartDAOImpl();
		
		String urlPath=null;

		
		try{
			if(CartService.insert(cartDTO) > 0){ 
				System.out.println("찎히나요오오오");
				urlPath = "wm?command=CartSelectByUserId";
			}else{
	 			urlPath="errorView/error.jsp";
	 			request.setAttribute("errorMsg", "�옣諛붽뎄�땲�뿉 �떞�쓣 �닔 �뾾�뒿�땲�떎");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		request.getRequestDispatcher(urlPath).forward(request, response);
	}
}
