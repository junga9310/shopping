package wm.model.dao;


import java.sql.SQLException;

import wm.model.dto.BuyTwoDTO;


public interface BuyTwoDAO {
	 /**
	 * ���ڵ� ����
	 * @return : 1�̻� -���Լ��� , 0 - ���Խ���
	 * */
	  int buytwoinsert(BuyTwoDTO buytwoDTO) throws SQLException;
	  
	  /**
	   * �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����
	   * @return : 1�̻� -�������� , 0 - ��������
	   * */
	   int delete(String modelNum, String password) throws SQLException;
	  
	   /**
	    * �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����
	    * @return : 1�̻� -�������� , 0 - ��������
	    * */
	   int update(BuyTwoDTO electronics) throws SQLException;
}




