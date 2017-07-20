package wm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wm.model.service.ProdService;

public class ProdDelete implements Action{
   
   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      String url="page/view/errorView.jsp";

      // 상품삭제를 할 꺼야.
      // id는 request로 받을꺼임. 클릭시 
      // check 박스로 check된 경우 삭제하기! 
      //  form 에서 넘겨주면  getParameterValues로 받을 수 있음.
      // 1번 값 받아오기.  - delete - > p_id를 받아와야 함.
      // p_id는 check 박스로 -> check 된 것을  받으면 됨.
      //HttpSession session = request.getSession();
      String p_id = request.getParameter("p_id"); // form에서 p_id로 받아야 됨.
      int pid = 0;
      //System.out.println("Hi");
      try{
   /*      if(session.getAttribute("u_id") !="admin"){
            throw new Exception("접근 권한이 없습니다.");
         } // admin인 경우만 입력 받음. 
         */
            if(p_id == null){
               request.setAttribute("errorMsg", "필수 입력을 하지 않았습니다.");
               request.setAttribute("redirectPath", "page/product/prodlist.jsp");
            } //입력 정보 안들어 온 경우 예외처리 
            pid = Integer.parseInt(p_id); // 형 변환
            //System.out.println(pid[i]);
            int result = ProdService.prodDelete(pid);
            url= "wm?command=prodselectall";
            //System.out.println(result);
          // 삭제는 다 됨.
      }catch(Exception e){
         e.printStackTrace();
      }
      request.getRequestDispatcher(url).forward(request, response);   
   }
}