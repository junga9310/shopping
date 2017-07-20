package wm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wm.model.service.CustomerService;

public class CustomerUpdatePwAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		HttpSession session=request.getSession();
		String id=(String) session.getAttribute("userId");
		String uPw = request.getParameter("oldPwd");
		String newPw = request.getParameter("newPwd");
		String checkPw = request.getParameter("checkPwd");

		System.out.println(newPw);
		System.out.println(checkPw);
		if(!newPw.equals(checkPw))
		{	String urlpath = "page/view/errorView.jsp";
			request.setAttribute("errorMsg", "���ο� ��й�ȣ Ȯ���� ���ּ���");
			request.setAttribute("redirectPath", "page/customer/updatePw.jsp");
			request.getRequestDispatcher(urlpath).forward(request, response);
			return;
		}
		String urlpath = "page/view/errorView.jsp";
		try {
			String dbpw = CustomerService.customerSelectPw(id);
			if (dbpw == null) {
				request.setAttribute("errorMsg", "�ش� ���̵� �����ϴ�.");
				request.setAttribute("redirectPath", "page/customer/updatePw.jsp");
			}

			else {
				if (dbpw.equals(uPw)) {
					CustomerService.customerUpdatePassword(id, newPw);
					urlpath="page/view/errorView.jsp";
					request.setAttribute("errorMsg", "��й�ȣ�� �����Ǿ����ϴ�.");
					request.setAttribute("redirectPath", "page/customer/mypage.jsp");

				} else {
					request.setAttribute("errorMsg", "��й�ȣ�� Ʋ��.");
					request.setAttribute("redirectPath", "page/customer/updatePw.jsp");

				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher(urlpath).forward(request, response);
	}

}
