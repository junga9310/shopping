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
				request.setAttribute("errorMsg", "�����Ǿ����ϴ�.");
				request.setAttribute("redirectPath", "index.jsp");
				
			}
			else
			{
				request.setAttribute("errorMsg", "Ż��Ұ�");
				request.setAttribute("redirectPath", "page/customer/mypage.jsp");
			}
		
		} catch (Exception e) {
			request.setAttribute("errorMsg", "Ż���Ҽ� �����ϴ�.");
			request.setAttribute("redirectPath", "page/customer/mypage.jsp");
		}
		}
		else
		{
			request.setAttribute("errorMsg", "�����ڴ� Ż��Ұ�");
			request.setAttribute("redirectPath", "page/customer/mypage.jsp");
		}
		request.getRequestDispatcher(urlpath).forward(request, response);
	}

}
