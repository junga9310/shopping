package wm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wm.model.dto.CustomerDTO;
import wm.model.service.CustomerService;

public class CutomerUpdateInfoAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

					request.setCharacterEncoding("UTF-8");
			System.out.println("userErec : "+request.getParameter("userErec"));
			
			String urlpath="page/view/errorView.jsp";
			
				if(request.getParameter("userErec") == null)
				{
					
					request.setAttribute("errorMsg", "이메일 수신여부 체크필수");
					request.setAttribute("redirectPath","wm?command=selectByUser");
					request.getRequestDispatcher(urlpath).forward(request, response);
					return;
				}
			
				String u_id=request.getParameter("userId");
				String u_name=request.getParameter("userName");
				String u_email=request.getParameter("userEmail");
			    int u_rec=Integer.parseInt(request.getParameter("userErec"));
				String u_phone=request.getParameter("userPhone");
				String u_post=request.getParameter("userpost");
				String u_addr=request.getParameter("userAddr");
				String u_addr_de=request.getParameter("userAddrDetail");
			
				int result=0;
			
				try {
					result=CustomerService.customerUpdateInfo(new CustomerDTO(u_id,u_name,u_email,u_rec,u_phone,u_post,u_addr,u_addr_de));
					if(result>0)
					{
						request.setAttribute("errorMsg", "정보가 수정되었습니다.");
						request.setAttribute("redirectPath", "page/customer/mypage.jsp");
					}
					else{
						request.setAttribute("errorMsg", "수정실패.");
						request.setAttribute("redirectPath", "page/customer/mypage.jsp");
					}
					
				} catch (Exception e) {
					request.setAttribute("errorMsg", "수정불가.");
					request.setAttribute("redirectPath", "page/customer/mypage.jsp");
				}
				
				request.getRequestDispatcher(urlpath).forward(request, response);
				return;
			}
}
