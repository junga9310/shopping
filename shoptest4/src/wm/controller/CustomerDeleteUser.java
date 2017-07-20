package wm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wm.model.service.CustomerService;

public class CustomerDeleteUser implements Action {

	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");	
		
	
		String u_id=request.getParameter("userID");
	
		int result=0;
		String urlpath="ErrorView.jsp";
		result=CustomerService.customerDelete(u_id);
		if(result>0)
		{ 
			urlpath="index.jsp";
			return;
		}
		else
		{
			request.setAttribute("errorMsg", "삭제가 불가");
			request.setAttribute("redirectPath", "index.jsp");
		}
		request.getRequestDispatcher(urlpath).forward(request, response);
	}
	
}
