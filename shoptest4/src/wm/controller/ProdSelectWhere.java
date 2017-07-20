package wm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wm.model.dao.ProductDAO;
import wm.model.dao.ProductDAOImpl;
import wm.model.dto.ProductDTO;
import wm.model.service.ProdService;

public class ProdSelectWhere implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url ="errorView/error.jsp";
		try{
			// point = 기준 ex ) 장르
			// show = 'dance';
			String point=request.getParameter("point");
			String show=request.getParameter("show");
			if(point == null || show ==null) {
				throw new Exception("입력값이 충분하지 않습니다.");
			}
			
			List<ProductDTO> list = ProdService.prodselectWhere(point, show);
			if(list == null) {
				request.setAttribute("errorMsg", "정보가 없습니다.");
				request.setAttribute("redirectPath", "input.html");
				//throw new Exception("정보가 없습니다.");
			}else {
				request.setAttribute("list", list);
				url= "prodView/prodlist.jsp";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
			request.getRequestDispatcher(url).forward(request, response);
	}

}
