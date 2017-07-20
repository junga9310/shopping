package wm.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import wm.model.dto.BuyoneDTO;
import wm.util.DBUtil;


/*
 * 	<회占쏙옙>
	insert - 占쏙옙占쏙옙 占쏙옙占쏙옙
	<占쏙옙占쏙옙占쏙옙>
	delete - 占쌉쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 환占쌀뱄옙占실곤옙 占쏙옙占쏙옙占쏙옙 占쏙옙占� 환占쏙옙 占쏙옙치 

 */

public class BuyoneDAOImpl implements BuyoneDAO {

	@Override
	public int buyoneInsert(BuyoneDTO BuyoneDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("insert into buy values (O_NO.NEXTVAL,?,?,?,sysdate)");
			///占쏙옙占쏙옙占쌔억옙占쏙옙!!!!!!!!!!!!
			ps.setString(1, BuyoneDTO.getU_ID());
			ps.setInt(2, BuyoneDTO.getTOT_PRICE());
			ps.setInt(3, BuyoneDTO.getPAYMENT());
			result = ps.executeUpdate();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int buyoneDelete(int O_NO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("delete from buy where O_NO = ? ");
			ps.setInt(1, O_NO);
			result = ps.executeUpdate();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}
	@Override
	   public int selectVIP(String u_id) throws SQLException {
		  Connection con =null;
	      PreparedStatement ps =null;
	      ResultSet rs = null;
	      int result=0;
	      
	      try{
	         con=DBUtil.getConnection();
	         ps=con.prepareStatement("select sum(b.tot_price) from customer c, buy b  where c.U_ID = b.U_ID "
	         		+ "and c.u_level=1 and b.u_id=?");
	         ps.setString(1, u_id);
	         rs=ps.executeQuery();
	         while(rs.next()) {
	            result = rs.getInt(1);
	         }
	      }finally{
	    	  
	    	  DBUtil.dbClose(con, ps,rs);
	         
	      }
	      return result;
	   }

	@Override
	public int searchMaxOno() throws SQLException {
		Connection con =null;
	    PreparedStatement ps =null;
	    ResultSet rs = null;
	    int result=0;
	    try{
	    	con=DBUtil.getConnection();
	    	ps=con.prepareStatement("select max(o_no) from buy");
	    	rs=ps.executeQuery();
	    	while(rs.next()){
	    		result=rs.getInt(1);
	    	}
	    }finally{
	    	DBUtil.dbClose(con, ps, rs);
	    }
		return result;
	}
	
	
}
