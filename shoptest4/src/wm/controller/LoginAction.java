package wm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wm.model.service.CustomerService;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");	
		
		String u_id=request.getParameter("userId");
		String u_pw=request.getParameter("userPwd");
	   
		String urlpath="page/view/errorView.jsp";
		
		try {
			String dbpw=CustomerService.customerSelectPw(u_id);
			if(dbpw.equals(u_pw))
			{
				HttpSession session=request.getSession();
				session.setAttribute("userId", u_id);
				urlpath="index.jsp";
			}
			else
			{
				request.setAttribute("errorMsg", "비밀번호가 일치하지 않습니다.");
				request.setAttribute("redirectPath", "page/customer/login.jsp");
			}
		} catch (Exception e) {
			request.setAttribute("errorMsg", "해당 아이디가 없습니다.");
			request.setAttribute("redirectPath", "page/customer/login.jsp");
		}

		request.getRequestDispatcher(urlpath).forward(request, response);

	}
}
