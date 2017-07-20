package wm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wm.model.service.CustomerService;

public class CustomerLevelUpAction implements Action {

	//ȸ���� ����Ȯ��
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id=(String) request.getAttribute("userID");
		
		
		int result=CustomerService.customerUpdateLevel(id, 2);
		String urlpath="ErrorView.jsp";
		if(result>0)
		{
			request.setAttribute("errorMsg", "VIP�� �ǽŰ� �����մϴ�.");
            request.setAttribute("redirectPath", "index.jsp");
		}
		request.getRequestDispatcher(urlpath).forward(request, response);
	}

}
