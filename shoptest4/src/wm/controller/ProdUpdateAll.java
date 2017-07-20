package wm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import wm.model.dao.ProductDAO;
import wm.model.dao.ProductDAOImpl;
import wm.model.dto.ProductDTO;
import wm.model.service.ProdService;

public class ProdUpdateAll implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// update�뒗 �떎 諛쏆븘�빞�븿.  �쟾泥� �닔�젙�븯�뒗 �럹�씠吏�瑜� 留뚮뱾�뼱�꽌 �쟾遺�瑜� 諛쏆븘�빞�븿.
		String saveDir = request.getSession().getServletContext().getRealPath("/save/");  
		int maxSize=1024*1024*100;//100m
		String encoding="UTF-8";
		String url ="/page/view/errorView.jsp";
		try{
//			MultipartRequest p = new MultipartRequest(request, saveDir,maxSize, encoding, new DefaultFileRenamePolicy());
//			String p_id = request.getParameter("p_id");
//			String p_name=request.getParameter("p_name");
//			String p_singer=request.getParameter("p_singer");
//			String p_price = request.getParameter("p_price");
//			String p_desc=request.getParameter("p_desc");
//		    String p_comp=request.getParameter("p_comp");
//		    String p_hit = request.getParameter("p_hit");
//		    String p_genre=request.getParameter("p_genre");
//		    String p_qtt =request.getParameter("p_qtt");
//		    String p_date=request.getParameter("p_date");
//		    String p_image=p.getFilesystemName("p_image");
			
			
			MultipartRequest p = new MultipartRequest(request, saveDir,maxSize, encoding, new DefaultFileRenamePolicy());
			String p_id = p.getParameter("p_id");
			String p_name=p.getParameter("p_name");
			String p_singer=p.getParameter("p_singer");
			String p_price = p.getParameter("p_price");
			String p_desc=p.getParameter("p_desc");
		    String p_comp=p.getParameter("p_comp");
		    String p_hit = p.getParameter("p_hit");
		    String p_genre=p.getParameter("p_genre");
		    String p_qtt =p.getParameter("p_qtt");
		    String p_date=p.getParameter("p_date");
		    String p_image=p.getFilesystemName("p_image");
		    if(p_name == null || p_singer == null || p_price == null || p_desc == null || p_comp == null || p_hit == null 
		    	|| p_genre == null || p_qtt == null || p_date == null || p_image == null) {
				request.setAttribute("errorMsg", "�븘�닔 �엯�젰�쓣 �븯吏� �븡�븯�뒿�땲�떎.");
				request.setAttribute("redirectPath", "${pageContext.request.contextPath}/page/customer/prodlist.jsp");
		    	//throw new Exception("�엯�젰�쓣 �븯吏� �븡�븯�뒿�땲�떎.");
		    }
		    ProductDTO PD = new ProductDTO(Integer.parseInt(p_id),p_name,p_singer,Integer.parseInt(p_price),p_desc,p_comp,Integer.parseInt(p_hit),p_genre,Integer.parseInt(p_qtt),p_date,p_image);
			ProdService.prodUpdateAll(PD);
		    url ="wm?command=prodselectall";
		    System.out.println("�꽦怨�!");
		}catch(Exception e){
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
