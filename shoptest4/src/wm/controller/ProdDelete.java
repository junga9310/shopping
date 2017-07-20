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

      // ��ǰ������ �� ����.
      // id�� request�� ��������. Ŭ���� 
      // check �ڽ��� check�� ��� �����ϱ�! 
      //  form ���� �Ѱ��ָ�  getParameterValues�� ���� �� ����.
      // 1�� �� �޾ƿ���.  - delete - > p_id�� �޾ƿ;� ��.
      // p_id�� check �ڽ��� -> check �� ����  ������ ��.
      //HttpSession session = request.getSession();
      String p_id = request.getParameter("p_id"); // form���� p_id�� �޾ƾ� ��.
      int pid = 0;
      //System.out.println("Hi");
      try{
   /*      if(session.getAttribute("u_id") !="admin"){
            throw new Exception("���� ������ �����ϴ�.");
         } // admin�� ��츸 �Է� ����. 
         */
            if(p_id == null){
               request.setAttribute("errorMsg", "�ʼ� �Է��� ���� �ʾҽ��ϴ�.");
               request.setAttribute("redirectPath", "page/product/prodlist.jsp");
            } //�Է� ���� �ȵ�� �� ��� ����ó�� 
            pid = Integer.parseInt(p_id); // �� ��ȯ
            //System.out.println(pid[i]);
            int result = ProdService.prodDelete(pid);
            url= "wm?command=prodselectall";
            //System.out.println(result);
          // ������ �� ��.
      }catch(Exception e){
         e.printStackTrace();
      }
      request.getRequestDispatcher(url).forward(request, response);   
   }
}