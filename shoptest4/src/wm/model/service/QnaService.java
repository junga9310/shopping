package wm.model.service;


import java.sql.SQLException;
import java.util.List;

import wm.model.dao.BoardDaoImpl;
import wm.model.dto.Qna;

public class QnaService {
	private static BoardDaoImpl  qnaDao = new BoardDaoImpl();

	public static List<Qna> selectAll() throws SQLException{
		  return qnaDao.selectAll();
	  }

	  public static int insert(Qna qna) throws SQLException{
		  return qnaDao.insert(qna);
	  }
	  

	  public static Qna selectByBoardNum(int BOARD_NUM, boolean flag) throws SQLException{
		  return qnaDao.selectByBoardNum(BOARD_NUM , flag);
	  }
	  
	 
	  public static int delete(int BOARD_NUM, String BOARD_PASS) throws SQLException{
		  return qnaDao.delete(BOARD_NUM,BOARD_PASS);
	  }
	  

	  public static int update(Qna qna) throws SQLException{
		  return qnaDao.update(qna);
	  }
	  
	  public static List<Qna> selectReply(int ref) throws SQLException{
		  return qnaDao.selectReply(ref);
	  }
}



