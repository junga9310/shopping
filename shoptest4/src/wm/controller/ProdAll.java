package wm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wm.model.dto.ProductDTO;
import wm.model.service.ProdService;

public class ProdAll implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse respons) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url="page/view/errorView.jsp";
		try{	
			List<ProductDTO> list = ProdService.prodselectAll();
			if(list == null) {
				request.setAttribute("errorMsg", "정보가 없습니다.");
				request.setAttribute("redirectPath", "index.jsp");
			}else {
				request.setAttribute("list", list);
				url= "page/product/prodall.jsp";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
			request.getRequestDispatcher(url).forward(request, respons);
	}
}
