package wm.model.dao;


import java.sql.SQLException;
import java.util.List;

import wm.model.dto.Qna;

public interface BoardDAO {
	 /**
	  * ���ڵ� ��ü �˻�
	  * */
	  List<Qna> selectAll() throws SQLException;
	  
	  /**
		  * �𵨹�ȣ�� �ش��ϴ� ���ڵ� �˻�
		  * @param : boolean flag - true�̸� ��ȸ�� ����,  false�̸� ��ȸ���� ����.
		  * */
	  Qna selectByBoardNum(int BOARD_NUM, boolean flag) throws SQLException;
	  
	/**
	 * ���ڵ� ����
	 * @return : 1�̻� -���Լ��� , 0 - ���Խ���
	 * */
	  int insert(Qna qna) throws SQLException;
	  
	  /**
	   * �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����
	   * @return : 1�̻� -�������� , 0 - ��������
	   * */
	   int delete(int BOARD_NUM, String BOARD_PASS) throws SQLException;
	  
	   /**
	    * �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����
	    * @return : 1�̻� -�������� , 0 - ��������
	    * */
	   int update(Qna qna) throws SQLException;

	   //int boardcount() throws SQLException;
	   
	   /**
	    * �ۿ����� ��۸�� �ҷ�����
	    * */
	   List<Qna> selectReply(int ref) throws SQLException;
	//List getBoardList(int page, int limit);
}




