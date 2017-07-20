package wm.model.service;

import java.sql.SQLException;
import wm.model.dao.BuyTwoDAO;
import wm.model.dao.BuyTwoDAOImpl;
import wm.model.dao.BuyoneDAO;
import wm.model.dao.BuyoneDAOImpl;
import wm.model.dao.CartDAO;
import wm.model.dao.CartDAOImpl;
import wm.model.dao.ProductDAO;
import wm.model.dao.ProductDAOImpl;
import wm.model.dto.BuyTwoDTO;
import wm.model.dto.BuyoneDTO;
import wm.model.dto.CartDTO;

public class BuyService {
	private static BuyoneDAO buyoneDAO = new BuyoneDAOImpl();
	private static BuyTwoDAO buytwoDAO = new BuyTwoDAOImpl();
	private static ProductDAO productDAO = new ProductDAOImpl();
	private static CartDAO cartDAO = new CartDAOImpl();
//��ǰ�� total_price���ϱ�
	public static int calculateTotal(int productid, int orderamount){
		int totprice =0;
		try{
			int pprice = productDAO.productSelectByNo(productid);
			totprice = pprice*orderamount;
		}catch(Exception e){
			e.printStackTrace();
		}
		return totprice;
	}
//1. buy1�� ����
	public static int insertToBuyone(String userid,int totalprice,int payment) throws SQLException{
		BuyoneDTO buyoneDTO = new BuyoneDTO(userid,totalprice,payment);
		int result = buyoneDAO.buyoneInsert(buyoneDTO);
		return result;//0:���� 1:����
	}
//2. buy2�� ����
	public static int insertToBuytwo(int productid, int orderamount) throws SQLException{
		//productid�� productamount, �׸��� ono
		int orderno=buyoneDAO.searchMaxOno();
		BuyTwoDTO buytwoDTO = new BuyTwoDTO(orderno,productid,orderamount);
		int result = buytwoDAO.buytwoinsert(buytwoDTO);
		return result;//0:���� 1:����
	}
//3. cart���� ���� ���� ������Ʈ.
	public static int updateCart(String userid, int productid) throws SQLException{
		//��ٱ��� �����̶� ���ؼ� ������ ������Ʈ ũ�� ����
		int cartamount = cartDAO.cartQttByPK(userid,productid);
		int productamount = productDAO.productQttByNo(productid);
		int amount = cartamount-productamount;
		int result=0;
		CartDTO cartDTO = new CartDTO(userid,productid);
		if(amount<=0){
			//result = cartDAO.cartDelete(cartDTO);
		}else{
		result = cartDAO.cartUpdate(cartDTO);
		}
		return result;
	}
//0. product���� ������, ������Ʈ, ������ �����ϸ� ����
	public static int updateProduct(int productid,int orderamount) throws SQLException{
		//�ֹ�����<=������ �̸� product������Ʈ 
		int productamount = productDAO.productQttByNo(productid);
		int amount = productamount-orderamount;
		if(amount<0){
			System.out.println("�������� �����մϴ�.");
			return 0;
		}else{
			int result=productDAO.productUpdateQtt(productid, amount);
			return result;
		}
	}

//4. ���� üũ
	public static String userLevelUpdate(String userid){
		String urlPath=null;
		try{
			int sum=buyoneDAO.selectVIP(userid);
			if(sum>300000)
	   		{//������ �˸�
	   			urlPath="wm?command=levelup";
	   		}else{//�ƹ��޽��� ����
			urlPath="buycomplete.jsp";//����jsp
	   		}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return urlPath;
	}
//5. ��Ʈ�� ������Ʈ
}
