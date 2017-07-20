package wm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wm.model.dao.CartDAO;
import wm.model.dao.CartDAOImpl;
import wm.model.dao.ProductDAO;
import wm.model.dao.ProductDAOImpl;
import wm.model.dto.CartDTO;
import wm.model.service.BuyService;

public class BuyCartAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse respons) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String u_id = (String) session.getAttribute("userId");
		int payment = Integer.parseInt(request.getParameter("payment"));
		int tot_price=0;
		//List buylist = new ArrayList<>();
		CartDAO cartDAO = new CartDAOImpl();
		ProductDAO prodDAO = new ProductDAOImpl();
		
		try{
		List<CartDTO> cartlist = cartDAO.cartSelectByUserId(u_id);
		
			for(CartDTO list : cartlist){
				int p_id = list.getProdId();
				int o_amount = list.getCartQtt();
				
				BuyService.updateCart(u_id, p_id);
				BuyService.updateProduct(p_id, o_amount);
				tot_price=+BuyService.calculateTotal(p_id, o_amount);
			}
			
			BuyService.insertToBuyone(u_id, tot_price, payment);//cart에서 받은 totprice
			
			for(CartDTO list: cartlist){
				int p_id = list.getProdId();
				int o_amount = list.getCartQtt();
				
				BuyService.insertToBuytwo(p_id, o_amount);
				prodDAO.productUpdateHit(p_id);
			}
			
			request.getRequestDispatcher(BuyService.userLevelUpdate(u_id)).forward(request,respons);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
