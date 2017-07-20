package wm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import wm.model.dao.ProductDAO;
import wm.model.dao.ProductDAOImpl;
import wm.model.dto.ProductDTO;
import wm.model.service.ProdService;

public class ProdLike implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	

		String decide =request.getParameter("decide");
		String sear =request.getParameter("sear"); // sear을 보내줘야 됨.  

		// 엑소 같은 검색을 sear로 받음
		String url ="errorView/error.jsp";

		try{
			/*MultipartRequest p = new MultipartRequest(request, saveDir,maxSize, encoding, new DefaultFileRenamePolicy());
			String decide =p.getParameter("decide");
			String sear =p.getParameter("sear"); // sear을 보내줘야 됨.  
			*/  
			if(sear == null) {
				request.setAttribute("errorMsg", "입력값이 충분하지 않습니다.");
				request.setAttribute("redirectPath", "input.html");
				//throw new Exception("입력값이 충분하지 않습니다."); 
			}
			List<ProductDTO> list =	ProdService.prodsearch(decide,sear);
			if(list == null) {
				throw new Exception("정보가 없습니다.");
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
