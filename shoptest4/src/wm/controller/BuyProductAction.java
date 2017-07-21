package wm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wm.model.dao.ProductDAO;
import wm.model.dao.ProductDAOImpl;
import wm.model.service.BuyService;

public class BuyProductAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String u_id = "mkim"; //(String)session.getAttribute("id");
		int p_id = Integer.parseInt(request.getParameter("p_Id"));
		int o_amount = Integer.parseInt(request.getParameter("p_amount"));//���� ���ǵȴ�� �ٲٱ�!!
		int payment = Integer.parseInt(request.getParameter("payment"));
		int totalprice=BuyService.calculateTotal(p_id, o_amount);
		ProductDAO prodDAO = new ProductDAOImpl();
		String urlpath = "errorView.jsp";
		System.out.println("���� �ޱ�");
		try{
			int up = BuyService.updateProduct(p_id, o_amount);
			System.out.println(1);
			if(up==1){//���ż���
			BuyService.insertToBuyone(u_id, totalprice, payment);
			//System.out.println(2);
			BuyService.insertToBuytwo(p_id, o_amount);
			//System.out.println(3);
			BuyService.updateCart(u_id, p_id);
			//System.out.println(3);
			prodDAO.productUpdateHit(p_id);
			//System.out.println(5);
			urlpath = BuyService.userLevelUpdate(u_id);
			}else{//���Ž���
				request.setAttribute("errorMsg", "��� �����Ͽ� ������ �� �����ϴ�.");
	            request.setAttribute("redirectPath", "updatePw.jsp");
			}
			request.getRequestDispatcher(urlpath).forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
