package wm.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import wm.controller.Action;
import wm.model.dao.ProductDAO;
import wm.model.dao.ProductDAOImpl;
import wm.model.dto.ProductDTO;
import wm.model.service.ProdService;


public class ProdInsert implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("hi");
		// 媛믪쓣 諛쏆븘�삤�옄.
		// Insert�뒗 �떎 諛쏆븘�빞�븿. 
		// String str =request.getParameter("p_price");
		 String saveDir = request.getSession().getServletContext().getRealPath("/save/");  
		 int maxSize=1024*1024*100;//100m
		 String encoding="UTF-8";
		 String url="page/view/errorView.jsp";

		try{
			MultipartRequest p = new MultipartRequest(request, saveDir,maxSize, encoding, new DefaultFileRenamePolicy());
			
			String p_name=p.getParameter("p_name");
			String p_singer=p.getParameter("p_singer");
			System.out.println(p.getParameter("p_price"));
			//int p_price=Integer.parseInt(request.getParameter("p_price"));
			String p_price = p.getParameter("p_price");
			//System.out.println("hi");
			String p_desc=p.getParameter("p_desc");
		    String p_comp=p.getParameter("p_comp");
//		    int p_hit=Integer.parseInt(request.getParameter("p_hit"));
		    String p_hit = p.getParameter("p_hit");
		    String p_genre=p.getParameter("p_genre");
		    String p_qtt =p.getParameter("p_qtt");
		    //int p_qtt=Integer.parseInt(request.getParameter("p_qtt"));
		    String p_date=p.getParameter("p_date");
		    String p_image=p.getFilesystemName("p_image");
		    //System.out.println("hi");
		    if(p_name == null || p_singer == null || p_price == null || p_desc == null || p_comp == null || p_hit == null 
		    	|| p_genre == null || p_qtt == null || p_date == null || p_image == null) {
				request.setAttribute("errorMsg", "not enough input");
				request.setAttribute("redirectPath", "page/product/productInput.jsp");
		    	//throw new Exception("�엯�젰�쓣 �븯吏� �븡�븯�뒿�땲�떎.");
		    }
		    ProductDTO PD = new ProductDTO(p_name,p_singer,Integer.parseInt(p_price),p_desc,p_comp,Integer.parseInt(p_hit),p_genre,Integer.parseInt(p_qtt),p_date,p_image);
		    url ="wm?command=prodselectall";
		    //System.out.println("hi");
			ProdService.prodInsert(PD);
			}catch(Exception e){
				e.printStackTrace();
			}
			request.getRequestDispatcher(url).forward(request, response);	

	}
	
}
