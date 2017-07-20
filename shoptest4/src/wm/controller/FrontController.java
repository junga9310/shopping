package wm.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/wm")
public class FrontController extends HttpServlet {

	Map<String, Action> map ;
	
	@Override
	public void init() throws ServletException {
		//contextparam가져오기
    	ServletContext context = super.getServletContext();
    	
    	
    	//리소번들을이용해서 파일 로딩
    	ResourceBundle rb = ResourceBundle.getBundle("wm.util.action");  //action.properties
    	
    	map = new HashMap<String, Action>();
    	
    	for(String key : rb.keySet()){
    		String value = rb.getString(key);
    		try{
	    		//System.out.println(key +" : " + value);
    			//map에 properties파일에 있는 객체들 생성해서 넣는다.
	    		Action action = (Action)Class.forName(value).newInstance();
	    		map.put(key, action);
	    		
    		    System.out.println(action);
    		}catch(Exception ex){
    			ex.printStackTrace();
    		}	
    	}//for끝
    	System.out.println(map);
    	
    	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//parameter로 넘어오는 command 값 받기
		String key = request.getParameter("command");//encType있을경우 null
		if(key==null) key="list";
		
		Action action = map.get(key);
		action.execute(request, response);
		
		
	}

}





