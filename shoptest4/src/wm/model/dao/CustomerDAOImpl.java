package wm.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wm.model.dto.CustomerDTO;
import wm.util.DBUtil;


public class CustomerDAOImpl implements CustomerDAO {


	@Override
	public List<CustomerDTO> customerSelectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<CustomerDTO> list = new ArrayList<>();

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from customer");
			rs = ps.executeQuery();

			while (rs.next()) {
				String u_id = rs.getString("u_id");
				String u_name = rs.getString("u_name");
				String u_pw = rs.getString("u_pw");
				String u_email = rs.getString("u_email");
				int e_rec = rs.getInt("e_rec");
				String u_phone = rs.getString("u_phone");
				String u_post = rs.getString("u_post");
				String u_addr = rs.getString("u_addr");
				String u_addr_detail = rs.getString("u_addr_detail");
				int u_level = rs.getInt("u_level");
				String u_indate = rs.getString("u_indate");
				String u_outdate = rs.getString("u_outdate");

				list.add(new CustomerDTO(u_id, u_name, u_pw, u_email, e_rec, u_phone, u_post, u_addr, u_addr_detail,
						u_level, u_indate, u_outdate));
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public int customerUpdatePassword(String id, String password) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("update customer set u_pw = ? where u_id = ?");

			ps.setString(1, password);
			ps.setString(2, id);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	//form에서는 기존의 정보가 자동적으로 입력된 상태에서, 바꾸고 싶은 것만 다시 입력하여 정보를 업데이트한다.
	public int customerUpdateInfo(CustomerDTO customerDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		System.out.println("us"+customerDTO);
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("update customer set u_name=?,u_email = ?,e_rec=?,u_phone=?,u_post=?,u_addr=?,u_addr_detail=? where u_id = ?");
			ps.setString(1,customerDTO.getU_name());	
			System.out.println(customerDTO.getU_name());
			ps.setString(2, customerDTO.getU_email());
			System.out.println(customerDTO.getU_email());
			ps.setInt(3, customerDTO.getE_rec());
			System.out.println(customerDTO.getE_rec());
			ps.setString(4, customerDTO.getU_phone());
			System.out.println(customerDTO.getU_phone());
			ps.setString(5, customerDTO.getU_post());
			System.out.println(customerDTO.getU_post());
			ps.setString(6, customerDTO.getU_addr());
			System.out.println(customerDTO.getU_addr());
			ps.setString(7, customerDTO.getU_addr_detail());
			System.out.println(customerDTO.getU_addr_detail());
			ps.setString(8, customerDTO.getU_id());
			System.out.println(customerDTO.getU_id());
		
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, ps); 
		}
		System.out.println("result : "+result);
		return result;
	
	}

	@Override
	public int customerUpdateOutdate(String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("update customer set u_outdate=sysdate where u_id = ?");

			ps.setString(1, id);
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int CustomerDelete(String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = DBUtil.getConnection();
			
			ps = con.prepareStatement("delete from customer where u_id =?");
			

			ps.setString(1, id);
		
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			DBUtil.dbClose(con, ps);
		}
		return result;
	}



	@Override
	public int customerUpdateLevel(String id, int level) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("update customer set u_level = ? where u_id = ?");

			ps.setInt(1, level);
			ps.setString(2, id);
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int customerInsert(CustomerDTO customerDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = DBUtil.getConnection();
			
			//아이디,이름,비번,메일,수신여부,전화번호,우편번호,주소,주소디테일,가입날짜
			ps = con.prepareStatement("insert into customer (u_id,u_name,u_pw,u_email,e_rec,u_phone,u_post,u_addr,u_addr_detail,u_indate)  values(?,?,?,?,?,?,?,?,?,sysdate)");

			ps.setString(1, customerDTO.getU_id());
			ps.setString(2, customerDTO.getU_name());
			ps.setString(3, customerDTO.getU_pw());
			ps.setString(4, customerDTO.getU_email());
			ps.setInt(5, customerDTO.getE_rec());
			ps.setString(6, customerDTO.getU_phone());
			ps.setString(7, customerDTO.getU_post());
			ps.setString(8, customerDTO.getU_addr());
			ps.setString(9, customerDTO.getU_addr_detail());
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public List<CustomerDTO> customerSelectOut() throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<CustomerDTO> list = new ArrayList<>();

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select u_id,u_name,u_level,u_indate,u_outdate from customer where u_outdate is not null order by u_outdate");
			rs = ps.executeQuery();

			while (rs.next()) {
				String u_id = rs.getString("u_id");
				String u_name = rs.getString("u_name");
				//String u_pw = rs.getString("u_pw");
				//String u_email = rs.getString("u_email");
				//int e_rec = rs.getInt("e_rec");
				//String u_phone = rs.getString("u_phone");
				//String u_post = rs.getString("u_post");
				//String u_addr = rs.getString("u_addr");
				//String u_addr_detail = rs.getString("u_addr_detail");
				int u_level = rs.getInt("u_level");
				String u_indate = rs.getString("u_indate");
				String u_outdate = rs.getString("u_outdate");

				list.add(new CustomerDTO(u_id, u_name, u_level, u_indate, u_outdate));
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public String customerSelectPassword(String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String password=null;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select u_pw from customer where u_id=? and u_outdate is null");
			ps.setString(1,id);
			rs = ps.executeQuery();

			while (rs.next()) {
				
				String u_pw = rs.getString("u_pw");
			

				password=u_pw;
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return password;
	}

	@Override
	public CustomerDTO selectByUser(String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CustomerDTO dto=null;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from customer where u_id=?");
			ps.setString(1,id);
			rs = ps.executeQuery();

			while (rs.next()) {
				
				String u_id = rs.getString("u_id");
				String u_name = rs.getString("u_name");
				String u_email = rs.getString("u_email");
				int e_rec = rs.getInt("e_rec");
				String u_phone = rs.getString("u_phone");
				String u_post = rs.getString("u_post");
				String u_addr = rs.getString("u_addr");
				String u_addr_detail = rs.getString("u_addr_detail");
				
				dto=new CustomerDTO(u_id,u_name,u_email,e_rec,u_phone,u_post,u_addr,u_addr_detail);
		
			}
			
			
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return dto;
	}

	@Override
	public String idCheck(String id) throws SQLException {

		
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
		
			String result="중복이 아닙니다.";
			try {
				
				con = DBUtil.getConnection();
				ps = con.prepareStatement("select u_id from customer where u_id=?");
				ps.setString(1, id);
				rs = ps.executeQuery();
				if(rs.next()){
					result="중복입니다.";
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtil.dbClose(con, ps, rs);
			}
			return result;
	}
}
