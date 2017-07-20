package wm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wm.model.service.CustomerService;

public class LogOutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	
		HttpSession session=request.getSession();
	      
        session.invalidate();
        String urlpath="page/view/errorView.jsp";
        request.setAttribute("errorMsg","�α׾ƿ� �Ǿ����ϴ�.");
        request.setAttribute("redirectPath","index.jsp");
        request.getRequestDispatcher(urlpath).forward(request, response);
	}
}
