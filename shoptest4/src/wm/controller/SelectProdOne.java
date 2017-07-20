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

public class SelectProdOne implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse respons) throws ServletException, IOException {
		// detail!  -- 臾댁뾿�쓣 �빐�빞�븷源�
		// �젙蹂대�� 諛쏆븘���꽌 �븘�슂�븳 遺�遺� �엯�젰
		// p_id瑜� 諛쏆븘�빞�맖! 
		// on click �쓣 諛쏆쓣 �삁�젙 ! 
		request.setCharacterEncoding("UTF-8");
		// 媛믪쓣 諛쏆븘�삤怨� !
		String url = "page/view/errorView.jsp";
		String id = request.getParameter("p_id");  // p_id濡� 諛쏆븘�삱嫄곗엫! 
		if(id == null) {
			
			request.setAttribute("errorMsg", "???");
			request.setAttribute("redirectPath", "wm?command=prodselectall"); //�엯�젰 �뤌�쑝濡� 媛�寃� �븷 嫄곗엫. �븘吏� 
			request.getRequestDispatcher(url).forward(request, respons); // �삤瑜� �뿉留� 蹂대궡 二쇨퀬 洹� �쇅�뒗! ajax �궗�슜!
		}
		int p_id = Integer.parseInt(id);
		System.out.println(p_id);
		try {
			
			List<ProductDTO> list = ProdService.prodDetail(p_id); // order by p_date desc
			if(list == null) {
				
				request.setAttribute("errorMsg", "...");
				request.setAttribute("redirectPath", "wm?command=prodselectall"); //�엯�젰 �뤌�쑝濡� 媛�寃� �븷 嫄곗엫. �븘吏� 
				//throw new Exception("�젙蹂닿� �뾾�뒿�땲�떎.");
			}else {
				
				request.setAttribute("list", list);
				
				url= "page/product/productupdate.jsp";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, respons); // �삤瑜� �뿉留� 蹂대궡 二쇨퀬 洹� �쇅�뒗! ajax �궗�슜!
	}


}
