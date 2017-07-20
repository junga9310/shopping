package wm.model.dao;

import java.sql.SQLException;
import java.util.List;

import wm.model.dto.CartDTO;

public interface CartDAO {
	/**
	 * ���ڵ� ��ü�˻�
	 */
	//List<CartDTO> cartSelectAll() throws SQLException;
	
	/**
	 * ����Id�� ��ٱ��� �˻�
	 * select * from cart where U_ID = ?
	 */
	List<CartDTO> cartSelectByUserId(String userId) throws SQLException;
	
//	int isInCart(String userId, int p_id) throws SQLException;
	
	
	/**
	 * ��ٱ��� ����ϱ�
	 * insert into cart (U_ID, P_ID, C_QTT, C_IMAGE, C_DATE) 
	 * values (?, ?, ?, ?, sysdate)
	 * ���� ������ 1 ��ȯ
	 */
	int cartInsert(CartDTO cartDTO) throws SQLException;
	
	/**
	 * Ư�� ȸ���� Ư�� ��ǰ�� ���� ������Ʈ
	 * update cart set content = ? where board_no = ?
	 * ������Ʈ ������ 1��ȯ
	 */
	int cartUpdate(CartDTO cartDTO) throws SQLException;
	
	/**
	 * Ư�� ȸ���� Ư�� ��ǰ ���ڵ� ����
	 * delete from cart where U_ID = ? and P_ID = ?
	 * ���� ������ 1 ��ȯ
	 */
	int cartDelete(CartDTO cartDTO) throws SQLException;
	
	int cartQttUpdate(int c_qtt, String u_id, int p_id) throws SQLException;
	CartDTO cartSelectByPK(String userId, int prodId) throws SQLException;
	int cartQttByPK(String uid,int pid) throws SQLException;


	 
}
