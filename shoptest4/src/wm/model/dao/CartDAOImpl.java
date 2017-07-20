package wm.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wm.model.dto.CartDTO;
import wm.util.DBUtil;

public class CartDAOImpl implements CartDAO {


	@Override
	public List<CartDTO> cartSelectByUserId(String userId) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CartDTO> list = new ArrayList<>();
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from cart where U_ID = ?");
			ps.setString(1, userId); 
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new CartDTO(rs.getString(1), rs.getInt(2), rs.getInt(3),
						rs.getString(4), rs.getString(5)));
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public CartDTO cartSelectByPK(String userId, int prodId) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from cart where U_ID = ? and p_id = ?");
			ps.setString(1, userId); 
			ps.setInt(2, prodId); 
			rs = ps.executeQuery();
			if(rs.next()) {
				CartDTO dto = new CartDTO(rs.getString(1), rs.getInt(2), rs.getInt(3),
						rs.getString(4), rs.getString(5));
				DBUtil.dbClose(con, ps, rs);
				return dto;
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return null;
	}
	
	
	@Override
	public int cartInsert(CartDTO cartDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("insert into cart (U_ID, P_ID, C_QTT, C_IMAgE, C_DATE) "
					+ "values (?, ?, ?, ?, sysdate)");
			ps.setString(1, cartDTO.getUserId());
			ps.setInt(2, cartDTO.getProdId());
			ps.setInt(3, cartDTO.getCartQtt());
			ps.setString(4, cartDTO.getCartImage());
			result = ps.executeUpdate(); //0占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占� 占쏙옙占쏙옙占싼거니깍옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占실듸옙占싣곤옙占쏙옙
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int cartUpdate(CartDTO cartDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("update cart set C_QTT = ? where U_ID = ? and P_ID = ?");
			ps.setInt(1, cartDTO.getCartQtt()); //service占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쌓놂옙 占쏙옙占썩서占쏙옙 占쌔댐옙 占쏙옙占쏙옙 占쏙옙占쌉몌옙 占쏙옙
			ps.setString(2, cartDTO.getUserId());
			ps.setInt(3, cartDTO.getProdId());
			result = ps.executeUpdate();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}
	
	public int cartQttUpdate(int c_qtt, String u_id, int p_id)/* throws SQLException*/ {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("update cart set C_QTT = ? where U_ID = ? and P_ID = ?");
			ps.setInt(1, c_qtt);
			ps.setString(2, u_id);
			ps.setInt(3, p_id);
			result = ps.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}
		finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}
	


	@Override
	public int cartDelete(CartDTO cartDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("delete from cart where U_ID = ? and P_ID = ?");
			ps.setString(1, cartDTO.getUserId());
			ps.setInt(2, cartDTO.getProdId());
			result = ps.executeUpdate();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}
	
	@Override
	   public int cartQttByPK(String userId, int prodId) throws SQLException{
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      int result=0;
	      try {
	         con = DBUtil.getConnection();
	         ps = con.prepareStatement("select c_qtt from cart where U_ID = ? and p_id = ?");
	         ps.setString(1, userId); 
	         ps.setInt(2, prodId); 
	         rs = ps.executeQuery();
	         if(rs.next()) {
	            result = rs.getInt(1);
	         }
	      } finally {
	         DBUtil.dbClose(con, ps);
	      }
	      return result;
	   }
}
