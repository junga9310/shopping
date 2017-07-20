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

public class CartDelete implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
	//	String u_id = request.getParameter("userId");
	//	int p_id = Integer.parseInt(request.getParameter("prodId"));
	//	int c_qtt = Integer.parseInt(request.getParameter("c_qtt"));
	//	int c_qtt = -1;
	//	String c_image = request.getParameter("cartImage");
	//	CartDTO cartDTO = new CartDTO(u_id, p_id, c_qtt, c_image);
		HttpSession session = request.getSession();
		String u_id =(String) session.getAttribute("userId");
		int p_id = Integer.parseInt(request.getParameter("prodId"));
		CartDTO cartDTO = new CartDTO(u_id, p_id);
		
		ProductDAO prodDAO = new ProductDAOImpl();		
		CartDAO cartDAO = new CartDAOImpl();

		String urlPath=null;
		try{
			if(CartService.delete(cartDTO) > 0){ //占쏙옙占쏙옙占싹몌옙 占쏙옙크占쏙옙트 占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쌓댐옙占�
				System.out.println("�젙�긽�궘�젣");
				urlPath = "wm?command=CartSelectByUserId";
			}
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("�뿉�윭");
		}
		request.getRequestDispatcher(urlPath).forward(request, response);

	}
	
}
