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
//상품별 total_price구하기
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
//1. buy1에 삽입
	public static int insertToBuyone(String userid,int totalprice,int payment) throws SQLException{
		BuyoneDTO buyoneDTO = new BuyoneDTO(userid,totalprice,payment);
		int result = buyoneDAO.buyoneInsert(buyoneDTO);
		return result;//0:실패 1:성공
	}
//2. buy2에 삽입
	public static int insertToBuytwo(int productid, int orderamount) throws SQLException{
		//productid랑 productamount, 그리고 ono
		int orderno=buyoneDAO.searchMaxOno();
		BuyTwoDTO buytwoDTO = new BuyTwoDTO(orderno,productid,orderamount);
		int result = buytwoDAO.buytwoinsert(buytwoDTO);
		return result;//0:실패 1:성공
	}
//3. cart에서 삭제 수정 업데이트.
	public static int updateCart(String userid, int productid) throws SQLException{
		//장바구니 수량이랑 비교해서 작으면 업데이트 크면 삭제
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
//0. product에서 수량비교, 업데이트, 수량이 부족하면 에러
	public static int updateProduct(int productid,int orderamount) throws SQLException{
		//주문수량<=재고수량 이면 product업데이트 
		int productamount = productDAO.productQttByNo(productid);
		int amount = productamount-orderamount;
		if(amount<0){
			System.out.println("재고수량이 부족합니다.");
			return 0;
		}else{
			int result=productDAO.productUpdateQtt(productid, amount);
			return result;
		}
	}

//4. 레벨 체크
	public static String userLevelUpdate(String userid){
		String urlPath=null;
		try{
			int sum=buyoneDAO.selectVIP(userid);
			if(sum>300000)
	   		{//레벨업 알림
	   			urlPath="wm?command=levelup";
	   		}else{//아무메시지 없음
			urlPath="buycomplete.jsp";//없는jsp
	   		}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return urlPath;
	}
//5. 히트수 업데이트
}
