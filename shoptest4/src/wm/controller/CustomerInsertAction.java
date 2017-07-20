package wm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wm.model.dto.CustomerDTO;
import wm.model.service.CustomerService;

public class CustomerInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String urlpath="page/view/errorView.jsp";
		if(request.getParameter("userErec")==null)
		{
			request.setAttribute("errorMsg", "�̸��� ���ſ��θ� üũ�ϼ���");
			request.setAttribute("redirectPath", "page/customer/join.jsp");
			request.getRequestDispatcher(urlpath).forward(request, response);
		}
		
		String u_id=request.getParameter("userId");
		System.out.println(u_id);
		String u_name=request.getParameter("userName");
		String u_pw=request.getParameter("userPwd");
		String u_email=request.getParameter("userEmail");
	    int u_rec=Integer.parseInt(request.getParameter("userErec"));
		String u_phone=request.getParameter("userPhone");
		String u_post=request.getParameter("userpost");
		String u_addr=request.getParameter("userAddr");
		String u_addr_de=request.getParameter("userAddrDetail");
		int result=0;
		
	
		try {
		
			result=CustomerService.customerInsert(new CustomerDTO(u_id,u_name,u_pw,u_email,u_rec,u_phone,u_post,u_addr,u_addr_de));
			if(result>0)
			{
				request.setAttribute("errorMsg", "���ԵǼ̽��ϴ�.");
				request.setAttribute("redirectPath", "page/customer/login.jsp");
			}
			
			else
			{
				request.setAttribute("errorMsg", "ȸ�����ԺҰ�.");
				//request.setAttribute("redirectPath", "page/customer/join.jsp");
				
			}
		
		} catch (Exception e) {
			request.setAttribute("errorMsg", "�̹� �ִ� ���̵��Դϴ�.");
			request.setAttribute("redirectPath", "join.jsp");
		}
		request.getRequestDispatcher(urlpath).forward(request, response);
	}

}
