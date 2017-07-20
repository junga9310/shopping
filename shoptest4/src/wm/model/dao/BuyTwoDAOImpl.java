package wm.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import wm.model.dto.BuyTwoDTO;
import wm.util.DBUtil;


public class BuyTwoDAOImpl implements BuyTwoDAO {

	@Override
	public int buytwoinsert(BuyTwoDTO buyTwoDTO) throws SQLException {
		Connection con =DBUtil.getConnection();
		PreparedStatement ps =null;
		int result =0;
		try{
			ps = con.prepareStatement("insert into buy2 values((select max(o_no) from buy),?,?)");
			//ps.setInt(1, buyTwoDTO.getoNo());
			ps.setInt(1, buyTwoDTO.getProductID());
			ps.setInt(2, buyTwoDTO.getProductAmount());
			
			result = ps.executeUpdate();
		}finally{
			DBUtil.dbClose(con, ps, null);
		}
		return result;
	}

	@Override
	public int delete(String modelNum, String password) throws SQLException {
		Connection con =DBUtil.getConnection();
		PreparedStatement ps =null;
		int result =0;
		try{
			ps = con.prepareStatement("delete Electronics where model_num=? and password=?");
			ps.setString(1, modelNum);
			ps.setString(2, password);
			result = ps.executeUpdate();
		}finally{
			DBUtil.dbClose(con, ps, null);
		}
		return result;
	}
	@Override
	public int update(BuyTwoDTO electronics) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
}
