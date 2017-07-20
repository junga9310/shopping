package wm.util;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import wm.controller.Action;

/**
 * Application Lifecycle Listener implementation class ActionMappingListener
 *
 */
//@WebListener
public class ActionMappingListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent arg0)  { }
    public void contextInitialized(ServletContextEvent e)  { 
        //contextparam��������
    	ServletContext context = e.getServletContext();
    	String file = context.getInitParameter("file");
    	
    	//���ҹ������̿��ؼ� ���� �ε�
    	ResourceBundle rb = ResourceBundle.getBundle(file);
    	
    	Map<String, Action> map = new HashMap<String, Action>();
    	
    	for(String key : rb.keySet()){
    		String value = rb.getString(key);
    		try{
	    		//System.out.println(key +" : " + value);
    			//map�� properties���Ͽ� �ִ� ��ü�� �����ؼ� �ִ´�.
	    		Action action = (Action)Class.forName(value).newInstance();
	    		map.put(key, action);
    		
    		}catch(Exception ex){
    			ex.printStackTrace();
    		}	
    	}//for��
    	
    	//map�� ServletContext������ �����Ѵ�.
    	context.setAttribute("map", map);
    	
    }
	
}










