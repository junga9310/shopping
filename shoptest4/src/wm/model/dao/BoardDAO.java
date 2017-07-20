package wm.model.dao;


import java.sql.SQLException;
import java.util.List;

import wm.model.dto.Qna;

public interface BoardDAO {
	 /**
	  * 레코드 전체 검색
	  * */
	  List<Qna> selectAll() throws SQLException;
	  
	  /**
		  * 모델번호에 해당하는 레코드 검색
		  * @param : boolean flag - true이면 조회수 증가,  false이면 조회증가 안함.
		  * */
	  Qna selectByBoardNum(int BOARD_NUM, boolean flag) throws SQLException;
	  
	/**
	 * 레코드 삽입
	 * @return : 1이상 -삽입성공 , 0 - 삽입실패
	 * */
	  int insert(Qna qna) throws SQLException;
	  
	  /**
	   * 모델번호에 해당하는 레코드 삭제
	   * @return : 1이상 -삭제성공 , 0 - 삭제실패
	   * */
	   int delete(int BOARD_NUM, String BOARD_PASS) throws SQLException;
	  
	   /**
	    * 모델번호에 해당하는 레코드 수정
	    * @return : 1이상 -수정성공 , 0 - 수정실패
	    * */
	   int update(Qna qna) throws SQLException;

	   //int boardcount() throws SQLException;
	   
	   /**
	    * 글에대한 답글목록 불러오기
	    * */
	   List<Qna> selectReply(int ref) throws SQLException;
	//List getBoardList(int page, int limit);
}




