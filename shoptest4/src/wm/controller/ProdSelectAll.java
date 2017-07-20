package wm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wm.model.dto.ProductDTO;
import wm.model.service.ProdService;

public class ProdSelectAll implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url="page/view/errorView.jsp";
		try{	
			List<ProductDTO> list = ProdService.prodselectAll();
			if(list == null) {
				request.setAttribute("errorMsg", "�젙蹂닿� �뾾�뒿�땲�떎.");
				request.setAttribute("redirectPath", "input.html");
				//throw new Exception("�젙蹂닿� �뾾�뒿�땲�떎.");
			}else {
				request.setAttribute("list", list);
				url= "page/product/prodlist.jsp";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
			request.getRequestDispatcher(url).forward(request, response);
	}
}	
