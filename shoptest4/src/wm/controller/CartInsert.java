package wm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wm.model.dao.CartDAO;
import wm.model.dao.CartDAOImpl;
import wm.model.dao.ProductDAO;
import wm.model.dao.ProductDAOImpl;
import wm.model.dto.CartDTO;
import wm.model.service.CartService;

public class CartInsert implements Action {
   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      
      HttpSession session = request.getSession();
      String u_id =(String) session.getAttribute("userId");
      String urlPath="page/view/errorView.jsp";

      if(u_id == null){
    	  request.setAttribute("errorMsg", "login please!");
    	  request.setAttribute("redirectPath", "page/customer/login.jsp");
          request.getRequestDispatcher(urlPath).forward(request, response);
      }
      
      int p_id = Integer.parseInt(request.getParameter("prodId"));
   //   int c_qtt = Integer.parseInt(request.getParameter("cartQtt"));
      int c_qtt = 1;
      
      String c_image = request.getParameter("cartImage");
      
      CartDTO cartDTO = new CartDTO(u_id, p_id, c_qtt, c_image);
      
      
      ProductDAO prodDAO = new ProductDAOImpl();      
      CartDAO cartDAO = new CartDAOImpl();
      

      try{
         if(CartService.insert(cartDTO) > 0){ 
            request.setAttribute("complete", p_id);
            urlPath = "wm?command=CartSelectByUserId";
         }else{
             urlPath="page/view/errorView.jsp";
             request.setAttribute("errorMsg", "fail to insert to cart!");
         }
      }catch(Exception e){
         e.printStackTrace();
      }
      request.getRequestDispatcher(urlPath).forward(request, response);
   }
}
