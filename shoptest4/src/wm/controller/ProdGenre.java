package wm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wm.model.dto.ProductDTO;
import wm.model.service.ProdService;

public class ProdGenre implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse respons) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url ="page/view/errorView.jsp";
		try{
			String genre=request.getParameter("p_genre");
			if(genre == null) {
				request.setAttribute("errorMsg", "�젙蹂닿� �뾾�뒿�땲�떎.");
				request.setAttribute("redirectPath", "index.jsp");
			}
			
			List<ProductDTO> list = ProdService.prodtGenre(genre);
			if(list == null) {
				request.setAttribute("errorMsg", "�젙蹂닿� �뾾�뒿�땲�떎.");
				request.setAttribute("redirectPath", "index.jsp");
				//throw new Exception("�젙蹂닿� �뾾�뒿�땲�떎.");
			}else {
				System.out.println(genre);
				System.out.println("hi");
				request.setAttribute("list", list);
				System.out.println(list);
				url= "page/product/prodgenrelist.jsp";
	}
		}catch(Exception e){
			e.printStackTrace();
		}
			request.getRequestDispatcher(url).forward(request, respons);
	}
}
