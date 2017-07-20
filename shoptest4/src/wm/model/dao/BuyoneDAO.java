package wm.model.dao;

import java.sql.SQLException;

import wm.model.dto.BuyoneDTO;

/*
 * 	<회占쏙옙>
	insert - 占쏙옙占쏙옙 占쏙옙占쏙옙
	<占쏙옙占쏙옙占쏙옙>
	delete - 占쌉쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 환占쌀뱄옙占실곤옙 占쏙옙占쏙옙占쏙옙 占쏙옙占� 환占쏙옙 占쏙옙치 

 */

public interface BuyoneDAO {
	/**
	 * 占쏙옙占신몌옙臼占� 占쌩곤옙
	 */
	int buyoneInsert(BuyoneDTO buyoneDTO) throws SQLException;
	
	/**
	 * 占쏙옙占신몌옙臼占쏙옙占� 占쏙옙占쏙옙
	 */
	int buyoneDelete(int buyoneNo) throws SQLException;
	
	int selectVIP(String userId)throws SQLException;
	
	int searchMaxOno() throws SQLException;
}
