package wm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wm.model.service.CustomerService;

public class CustomerUpdateOut implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	
		HttpSession session=request.getSession();
		String id=(String) session.getAttribute("userId");
		String urlpath="page/view/errorView.jsp";
		int result=0;
		if(id!="admin")
		{
		try {
			
			result=CustomerService.customerUpdateOutdate(id);
			if(result>0)
			{
	
		        session.invalidate();
				request.setAttribute("errorMsg", "»èÁ¦µÇ¾ú½À´Ï´Ù.");
				request.setAttribute("redirectPath", "index.jsp");
				
			}
			else
			{
				request.setAttribute("errorMsg", "Å»ÅðºÒ°¡");
				request.setAttribute("redirectPath", "page/customer/mypage.jsp");
			}
		
		} catch (Exception e) {
			request.setAttribute("errorMsg", "Å»ÅðÇÒ¼ö ¾ø½À´Ï´Ù.");
			request.setAttribute("redirectPath", "page/customer/mypage.jsp");
		}
		}
		else
		{
			request.setAttribute("errorMsg", "°ü¸®ÀÚ´Â Å»ÅðºÒ°¡");
			request.setAttribute("redirectPath", "page/customer/mypage.jsp");
		}
		request.getRequestDispatcher(urlpath).forward(request, response);
	}

}
