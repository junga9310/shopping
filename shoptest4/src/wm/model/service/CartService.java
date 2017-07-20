package wm.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wm.model.dao.CartDAO;
import wm.model.dao.CartDAOImpl;
import wm.model.dao.ProductDAO;
import wm.model.dao.ProductDAOImpl;
import wm.model.dto.CartDTO;

public class CartService {
	
private static CartDAO cartDAO = new CartDAOImpl();
	
	public static int delete(CartDTO cartDTO) throws SQLException{
		int result = 0;
		
		String u_id = cartDTO.getUserId();
		int p_id = cartDTO.getProdId();
		int c_qtt = cartDTO.getCartQtt();
		
		ProductDAO prodDAO = new ProductDAOImpl();		
		CartDTO tempDTO = cartDAO.cartSelectByPK(u_id, p_id);
		int qtt = tempDTO.getCartQtt();
		System.out.println(qtt);
		if(qtt-1 > 0){
			result = cartDAO.cartQttUpdate(qtt-1, u_id, p_id);
		}else{ //�븘�삁 �궘�젣
			result = cartDAO.cartDelete(cartDTO);
		}
		
		return result;
	}

	
	
	public static int insert(CartDTO cartDTO) throws SQLException{
		int result = 0;
		
		String u_id = cartDTO.getUserId();
		int p_id = cartDTO.getProdId();
		int c_qtt = cartDTO.getCartQtt();
		
		ProductDAO prodDAO = new ProductDAOImpl();		
		CartDAO cartDAO = new CartDAOImpl();
		
		int prodQtt = 0;
		try{
			prodQtt = prodDAO.prodQtt(p_id); //�뜝�룞�삕�뭹�뜝�룞�삕�뜝�룞�삕 �뜝�뙣源띿삕
			System.out.println(prodQtt);
			result = 1;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		List<CartDTO> list = null;
		CartDTO tempDTO = cartDAO.cartSelectByPK(u_id, p_id);
		if(tempDTO==null){ //�빐�떦 �긽�뭹�쓣 移댄듃�뿉 �떞吏� �븡�븯�떎 -> 諛붾줈 �씤�꽌�듃
			if(prodQtt >= c_qtt){ //�긽�뭹�닔�웾�씠 �떞怨좎옄 �븯�뒗 �닔�웾蹂대떎 留롫떎
				result = cartDAO.cartInsert(cartDTO);
				return result;
			}else{
				return 0; //�꽑�깮�븳 �닔�웾�씠 �옱怨좎닔�웾蹂대떎 �뜑 留롫떎.
			}
		}else{  //�빐�떦 �긽�뭹�씠 �씠誘� �떞寃� �엳�떎 -> �뾽�뜲�씠�듃
			if(prodQtt >= c_qtt+1){ //�긽�뭹�닔�웾�씠 �떞怨좎옄 �븯�뒗 �닔�웾蹂대떎 留롫떎
				result = cartDAO.cartQttUpdate(c_qtt+1, u_id, p_id);
				return result;
			}else{
				return 0; //�꽑�깮�븳 �닔�웾�씠 �옱怨좎닔�웾蹂대떎 �뜑 留롫떎.
			}
		}
	}
	
	
	public static List<CartDTO> selectMyCart(CartDTO cartDTO) throws SQLException{
		int result = 0;
		
		String u_id = cartDTO.getUserId();
		int p_id = cartDTO.getProdId();
		int c_qtt = cartDTO.getCartQtt();
		
		ProductDAO prodDAO = new ProductDAOImpl();		
		CartDAO cartDAO = new CartDAOImpl();
		
		List<CartDTO> list = new ArrayList<>();
		
		list = cartDAO.cartSelectByUserId(u_id);
	
		return list;
	}
	
	
}
