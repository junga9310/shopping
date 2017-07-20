package wm.model.dao;

import java.sql.SQLException;
import java.util.List;

import wm.model.dto.CartDTO;

public interface CartDAO {
	/**
	 * 레코드 전체검색
	 */
	//List<CartDTO> cartSelectAll() throws SQLException;
	
	/**
	 * 유저Id로 장바구니 검색
	 * select * from cart where U_ID = ?
	 */
	List<CartDTO> cartSelectByUserId(String userId) throws SQLException;
	
//	int isInCart(String userId, int p_id) throws SQLException;
	
	
	/**
	 * 장바구니 등록하기
	 * insert into cart (U_ID, P_ID, C_QTT, C_IMAGE, C_DATE) 
	 * values (?, ?, ?, ?, sysdate)
	 * 삽입 성공시 1 반환
	 */
	int cartInsert(CartDTO cartDTO) throws SQLException;
	
	/**
	 * 특정 회원의 특정 상품의 수량 업데이트
	 * update cart set content = ? where board_no = ?
	 * 업데이트 성공시 1반환
	 */
	int cartUpdate(CartDTO cartDTO) throws SQLException;
	
	/**
	 * 특정 회원의 특정 상품 레코드 삭제
	 * delete from cart where U_ID = ? and P_ID = ?
	 * 삭제 성공시 1 반환
	 */
	int cartDelete(CartDTO cartDTO) throws SQLException;
	
	int cartQttUpdate(int c_qtt, String u_id, int p_id) throws SQLException;
	CartDTO cartSelectByPK(String userId, int prodId) throws SQLException;
	int cartQttByPK(String uid,int pid) throws SQLException;


	 
}
