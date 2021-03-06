package wm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wm.model.dto.CustomerDTO;
import wm.model.service.CustomerService;

public class InfoCust implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int result=0;
		CustomerDTO dto=null;
		String urlpath="page/view/errorView.jsp";
		try {
			HttpSession session=request.getSession();
			String id=(String) session.getAttribute("userId");
			System.out.println(11111);
			System.out.println("id"+id);
			dto=CustomerService.customerSelectByUser(id);
			if(dto!=null)
			{
			request.setAttribute("custdto", dto);
			urlpath="page/buy/buyComplete.jsp";
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher(urlpath).forward(request, response);
	}

}
