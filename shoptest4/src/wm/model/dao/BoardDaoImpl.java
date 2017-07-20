package wm.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wm.model.dto.Qna;
import wm.util.DBUtil;

public class BoardDaoImpl implements BoardDAO {
   
	@Override
	public List<Qna> selectAll() throws SQLException {
		Connection con = DBUtil.getConnection();
		PreparedStatement ps =null;
		ResultSet rs =null;
		List<Qna> list = new ArrayList<Qna>();
		try{
			 ps = con.prepareStatement( "select * from Qna  where BOARD_RE_REF=0 order by BOARD_NUM");
			 rs = ps.executeQuery();
			 while(rs.next()){
				 Qna qna = new Qna(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						 rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getDate(12));
			    list.add(qna);
			 }
		}finally{
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}
	
	@Override
	public Qna selectByBoardNum(int BOARD_NUM, boolean flag) throws SQLException {
		Connection con = DBUtil.getConnection();
		PreparedStatement ps =null;
		ResultSet rs =null;
		Qna qna =null;
		try{
			if(flag){//조회수증가.
				ps = con.prepareStatement("update Qna set BOARD_READNUM = BOARD_READNUM+1 where BOARD_NUM=?");
				 ps.setInt(1, BOARD_NUM);
				 ps.executeUpdate();
			}
			
			 ps = con.prepareStatement( "select * from Qna where BOARD_NUM=?");
			 ps.setInt(1, BOARD_NUM);
			 rs = ps.executeQuery();
			 if(rs.next()){
				 qna =new Qna(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						 rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getDate(12));
			 }
		}finally{
			DBUtil.dbClose(con, ps, rs);
		}
		return qna;
	}

	@Override
	public int insert(Qna qna) throws SQLException {
		Connection con =DBUtil.getConnection();
		PreparedStatement ps =null;
		int result =0;
		try{
			ps = con.prepareStatement("insert into Qna values(bd_seq.nextval,?,?,?,?,?,?,?,0,0,0,sysdate)");
			//ps.setString(1, qna.getBOARD_NUM());
			ps.setString(1, qna.getBOARD_NAME());
			ps.setString(2, qna.getBOARD_PASS());
			ps.setString(3, qna.getBOARD_SUBJECT());
			ps.setString(4, qna.getBOARD_CONTENT());
			ps.setString(5, qna.getBFILE());
			ps.setInt(6, qna.getBFSIZE());
			ps.setInt(7, qna.getBOARD_RE_REF());
			//ps.setInt(7, qna.getBOARD_RE_REF());
			//ps.setInt(8, qna.getBOARD_RE_LEV());
			//ps.setInt(9, qna.getBOARD_RE_SEQ());
			//ps.setInt(10, qna.getBOARD_READNUM());
			
			
			result = ps.executeUpdate();
		}finally{
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int delete(int BOARD_NUM, String BOARD_PASS) throws SQLException {
		Connection con =DBUtil.getConnection();
		PreparedStatement ps =null;
		int result =0;
		try{
			ps = con.prepareStatement("delete Qna where BOARD_NUM=? and BOARD_PASS=?");
			ps.setInt(1, BOARD_NUM);
			ps.setString(2, BOARD_PASS);
			result = ps.executeUpdate();
		}finally{
			DBUtil.dbClose(con, ps, null);
		}
		return result;
	}

	@Override
	public int update(Qna qna) throws SQLException {
		Connection con =DBUtil.getConnection();
		PreparedStatement ps =null;
		int result =0;
		try{
			ps = con.prepareStatement("update Qna set "
					+ " BOARD_NAME=?,BOARD_SUBJECT=?,BOARD_CONTENT=?"
					+ "  where BOARD_NUM=? and BOARD_PASS=?");
			
			ps.setString(1, qna.getBOARD_NAME());
			ps.setString(2, qna.getBOARD_SUBJECT());
			ps.setString(3, qna.getBOARD_CONTENT());
			ps.setInt(4, qna.getBOARD_NUM());
			ps.setString(5, qna.getBOARD_PASS());
			
			result = ps.executeUpdate();
		}finally{
			DBUtil.dbClose(con, ps, null);
		}
		return result;
	}

	@Override
	public List<Qna> selectReply(int ref) throws SQLException {
		Connection con = DBUtil.getConnection();
		PreparedStatement ps =null;
		ResultSet rs =null;
		List<Qna> list = new ArrayList<Qna>();
		try{
			 ps = con.prepareStatement( "select * from Qna  where BOARD_RE_REF=? order by BOARD_NUM");
			 ps.setInt(1, ref);
			 rs = ps.executeQuery();
			 while(rs.next()){
				 Qna qna = new Qna(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						 rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getDate(12));
			    list.add(qna);
			 }
		}finally{
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	

	
	//글 답변.
    /*public int boardReply(Qna qna){
    	Connection con =DBUtil.getConnection();
    	PreparedStatement ps =null;
    	ResultSet rs =null;
        String board_max_sql="select max(board_num) from qna";
        String sql="";
        int num=0;
        int result=0;
        
        int re_ref=qna.getBOARD_RE_REF();
        int re_lev=qna.getBOARD_RE_LEV();
        int re_seq=qna.getBOARD_RE_SEQ();
        
        try{
        	ps=con.prepareStatement(board_max_sql);
            rs = ps.executeQuery();
            if(rs.next())num =rs.getInt(1)+1;
            else num=1;
            
            sql="update board set BOARD_RE_SEQ=BOARD_RE_SEQ+1 where BOARD_RE_REF=? ";
            sql+="and BOARD_RE_SEQ>?";
            
            ps = con.prepareStatement(sql);
            ps.setInt(1,re_ref);
            ps.setInt(2,re_seq);
            result=ps.executeUpdate();
            
            re_seq = re_seq + 1;
            re_lev = re_lev+1;
            
            sql="insert into board (BOARD_NUM,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,";
            sql+="BOARD_CONTENT, BOARD_FILE,BOARD_FSIZE,BOARD_RE_REF,BOARD_RE_LEV,BOARD_RE_SEQ,";
            sql+="BOARD_READBNUM,BOARD_DATE) values(?,?,?,?,?,?,?,?,?,?,sysdate)";
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, num);
            ps.setString(2, qna.getBOARD_NAME());
            ps.setString(3, qna.getBOARD_PASS());
            ps.setString(4, qna.getBOARD_SUBJECT());
            ps.setString(5, qna.getBOARD_CONTENT());
            ps.setString(6, ""); //답장에는 파일을 업로드하지 않음.
            ps.setInt(7, re_ref);
            ps.setInt(8, re_lev);
            ps.setInt(9, re_seq);
            ps.setInt(10, 0);
            ps.executeUpdate();
            return num;
        }catch(SQLException ex){
            System.out.println("boardReply 에러 : "+ex);
        }finally{
            if(rs!=null)try{rs.close();}catch(SQLException ex){}
            if(ps!=null)try{ps.close();}catch(SQLException ex){}
        }
        return 0;
    }
*/
	

}
