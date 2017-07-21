package wm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wm.model.dao.CartDAO;
import wm.model.dao.CartDAOImpl;
import wm.model.dto.CartDTO;

public class BuyCartCheck implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse respons) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String u_id = (String) session.getAttribute("userId");
		CartDAO cartDAO = new CartDAOImpl();
		List<CartDTO> cartlist = cartDAO.cartSelectByUserId(u_id);
		String urlpath="page/view/errorView.jsp";
		if(cartlist==null){
			request.setAttribute("errorMsg", "장바구니에 상품이 없습니다.");
			request.setAttribute("redirectPath", "wm?command=CartSelectByUserId");
			request.getRequestDispatcher(urlpath).forward(request,respons);
		}else{
			request.setAttribute("redirectPath", "wm?command=purchase");
			request.getRequestDispatcher(urlpath).forward(request,respons);
		}
	}

}
