package wm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wm.model.dao.CartDAO;
import wm.model.dao.CartDAOImpl;
import wm.model.dao.CustomerDAO;
import wm.model.dao.CustomerDAOImpl;
import wm.model.dao.ProductDAO;
import wm.model.dao.ProductDAOImpl;
import wm.model.dto.CartDTO;
import wm.model.dto.CartProdDTO;
import wm.model.dto.CustomerDTO;
import wm.model.service.CartService;

public class CartSelectByUserId implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String u_id =(String)session.getAttribute("userId");
		System.out.println(1);
		System.out.println(u_id);
	/*	int p_id = Integer.parseInt(request.getParameter("prodId"));
		int c_qtt = Integer.parseInt(request.getParameter("cartQtt"));
		String c_image = request.getParameter("cartImage");
		*/
	//	CartDTO cartDTO = new CartDTO(u_id, p_id, c_qtt, c_image);
		CartDTO cartDTO = new CartDTO(u_id);
		
		ProductDAO prodDAO = new ProductDAOImpl();		
		CartDAO cartDAO = new CartDAOImpl();
		List<CartDTO> list;
		List<CartProdDTO> cpList = new ArrayList<>();; 
		String url = "errorView/CartErrorView.jsp";
		List<String> prodName = new ArrayList<>();
		CustomerDAO custDAO = new CustomerDAOImpl();
		try{
			int tot = 0;
			list = CartService.selectMyCart(cartDTO); 
			for(int i = 0; i < list.size(); i++){
				String userIdT = list.get(i).getUserId();
				int prodIdT = list.get(i).getProdId();
				int cartQttT=list.get(i).getCartQtt();
				String cartImageT=list.get(i).getCartImage();
				String cartDateT=list.get(i).getCartDate();
				int prodPriceT= prodDAO.prodPrice(prodIdT);
				int totPriceT = prodPriceT * cartQttT;
				String prodNameT = prodDAO.prodGetPname(prodIdT);
				cpList.add(new CartProdDTO(userIdT, prodIdT, cartQttT, cartImageT,cartDateT,prodPriceT,totPriceT,prodNameT));
				tot+=totPriceT;
			}
			CustomerDTO custDTO = (custDAO.selectByUser(u_id));
			
			if(cpList != null){ 
				request.setAttribute("list", cpList);
				request.setAttribute("total", tot);
				request.setAttribute("custDTO", custDTO);
				url="page/cart/view.jsp";
				System.out.println(cpList);
				System.out.println(tot);
				System.out.println(custDTO);
			}else {
				request.setAttribute("errorMsg", "�옣諛붽뎄�땲�뿉 �긽�뭹�씠 �뾾�뒿�땲�떎.");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}	

}
