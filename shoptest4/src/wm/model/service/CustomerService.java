package wm.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wm.model.dao.CustomerDAO;
import wm.model.dao.CustomerDAOImpl;
import wm.model.dto.CustomerDTO;

public class CustomerService {
	static public CustomerDAO custdao=new CustomerDAOImpl();
	
	public static int customerDelete(String id){
		int result=0;
		try {
			result=custdao.CustomerDelete(id);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return result;
	}
	
	public static int customerInsert(CustomerDTO dto)
	{
		int result=0;
		try {
			result=custdao.customerInsert(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static List<CustomerDTO> customerSelectAll()
	{
		List<CustomerDTO> list=new ArrayList<>();
		try {
			 list=custdao.customerSelectAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<CustomerDTO> customerSelectOut()
	{
		List<CustomerDTO> list=new ArrayList<>();
		try {
			 list=custdao.customerSelectOut();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static String customerSelectPw(String id)
	{
		String pw=null;
		try {
			 pw=custdao.customerSelectPassword(id);
			 //if(pw==null)
			 //에러메시지
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return pw;
	}
	
	public static int customerUpdateInfo(CustomerDTO dto)
	{
		int result=0;
		try {
			 result=custdao.customerUpdateInfo(dto);
			 //if(pw==null)
			 //에러메시지
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return result;
	}
	
	public static int customerUpdateLevel(String id,int level)
	{
		int result=0;
		try {
			 result=custdao.customerUpdateLevel(id,level);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return result;
	}
	
	public static int customerUpdateOutdate(String id)
	{
		int result=0;
		try {
			 result=custdao.customerUpdateOutdate(id);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return result;
	}
	
	public static int customerUpdatePassword(String id,String pwd)
	{
		int result=0;
		try {
			 result=custdao.customerUpdatePassword(id, pwd);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return result;
	}
	
	public static CustomerDTO customerSelectByUser(String id)
	{
		CustomerDTO dto=null;
		try {
			dto=custdao.selectByUser(id);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return dto;	
	}
	public static String idCheck(String id)
	{
		String result=null;
		try {
			result=custdao.idCheck(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
