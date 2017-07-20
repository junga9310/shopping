package wm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wm.model.dto.CustomerDTO;
import wm.model.service.CustomerService;

public class CustomerSelectOutdate implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		String urlpath="index.jsp";
		try {
			List<CustomerDTO> list = CustomerService.customerSelectOut();
			request.setAttribute("list", list);
			urlpath = "CustomerselectOut.jsp";

		} catch (Exception e) {
			request.setAttribute("errorMsg", "검색도중 오류가 발생했습니다.");
			request.setAttribute("redirectPath", "index.jsp");
		}
		request.getRequestDispatcher(urlpath).forward(request, response);
	}
		
	}


