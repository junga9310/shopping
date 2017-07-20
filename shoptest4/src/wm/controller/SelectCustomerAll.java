package wm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wm.model.dto.CustomerDTO;
import wm.model.service.CustomerService;

public class SelectCustomerAll implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse respons) throws ServletException, IOException {
		
		List<CustomerDTO> list=CustomerService.customerSelectAll();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("page/admin/CustmerselectAll.jsp").forward(request, respons);
		
		

	}

}
