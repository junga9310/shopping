package wm.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import wm.model.service.CustomerService;


public class IdCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		String id = request.getParameter("id");
		
		
		String result = CustomerService.idCheck(id);
		
		PrintWriter out =response.getWriter();
		out.print(result);
	}

}





