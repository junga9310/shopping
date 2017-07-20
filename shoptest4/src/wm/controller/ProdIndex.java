package wm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import wm.model.dto.ProductDTO;
import wm.model.service.ProdService;

public class ProdIndex implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse respons) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 값을 받아오고 !
	
		try {
			List<ProductDTO> list = ProdService.prodIndex(); // order by p_date desc
			System.out.println("list:"+list);
			respons.setCharacterEncoding("UTF-8");
			respons.setContentType("text/html; charset=UTF-8");
				//ajax 사용
				JSONArray jsonArr = JSONArray.fromObject(list);
				PrintWriter out = respons.getWriter();
				out.println(jsonArr);
	
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

/*
 * 		request.setCharacterEncoding("UTF-8");
		String url="page/view/errorView.jsp";
		try{	
			List<ProductDTO> list = ProdService.prodselectAll();
			if(list == null) {
				request.setAttribute("errorMsg", "정보가 없습니다.");
				request.setAttribute("redirectPath", "input.html");
				request.getRequestDispatcher(url).forward(request, response);

				//throw new Exception("정보가 없습니다.");
			}else {
				request.setAttribute("list", list);
				url= "page/product/prodlist.jsp";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
			request.getRequestDispatcher(url).forward(request, response);
 */