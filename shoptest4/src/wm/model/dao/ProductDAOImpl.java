package wm.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wm.model.dto.ProductDTO;
import wm.util.DBUtil;

public class ProductDAOImpl implements ProductDAO {
   /**
    * �쉶�썝 紐⑸줉 蹂닿린 - �쟾泥� 蹂닿린 諛� �씤湲곕퀎 �옣瑜대퀎 
    * 理쒖떊蹂� �젙�젹
    */
	
	
   public List<ProductDTO> productSelectAll() throws SQLException{
      Connection con = null;
      PreparedStatement ps = null;
      ResultSet rs = null;
      List<ProductDTO> list = new ArrayList<>();
      try{
         con = DBUtil.getConnection();
         // ps瑜� 留뚮뱾�뼱�꽌 湲곕뒫�쓣 �닔�뻾�븯�뒗 select瑜� 諛쏆븘�샂.
         // �뿬湲곗꽌�뒗 �쉶�썝 紐⑸줉蹂닿린. 
         String sql = "select * from Product";
         ps = con.prepareStatement(sql);
         rs = ps.executeQuery();
            while(rs.next()){
               list.add(new ProductDTO(
                     rs.getInt(1),
                     rs.getString(2),
                     rs.getString(3),
                     rs.getInt(4),
                     rs.getString(5),
                     rs.getString(6),
                     rs.getInt(7),
                     rs.getString(8),
                     rs.getInt(9),
                     rs.getString(10),
                     rs.getString(11)));
                  }
         }finally{
         
            DBUtil.dbClose(con, ps,rs);
         }
         //try{
            // DB瑜� �뿰寃고빐�꽌 ! 
         // 寃곌낵瑜� list�뿉 異붽�!
         //}finally{
          // DB�뒗 臾댁“嫄� �떕�븘二쇰㈃ �맖.
         //}
      return list;
      
   } 
   // �쟾泥대낫湲� �셿�꽦
   // �닚�꽌蹂� 諛곗뿴 �긽�뭹紐낆닚 / �씤湲� / �벑濡앹씪�닚 / 媛�寃⑹닚 
   public List<ProductDTO> productOrder(String order,String desc) throws SQLException{
      // order�뿉�뒗 諛곗뿴�븷 寃껊뱾�쓣 �엯�젰�빐�빞�븿.
      Connection con = null;
      PreparedStatement ps = null;
      ResultSet rs = null;
      List<ProductDTO> list = new ArrayList<>();
      try{
         con = DBUtil.getConnection();
         // ps瑜� 留뚮뱾�뼱�꽌 湲곕뒫�쓣 �닔�뻾�븯�뒗 select瑜� 諛쏆븘�샂.
         // �뿬湲곗꽌�뒗 �쉶�썝 紐⑸줉蹂닿린. 
         String sql = "select * from Product order by "+order+" "+desc;
         ps = con.prepareStatement(sql);
         rs = ps.executeQuery();
            while(rs.next()){
               list.add(new ProductDTO(
                     rs.getInt(1),
                     rs.getString(2),
                     rs.getString(3),
                     rs.getInt(4),
                     rs.getString(5),
                     rs.getString(6),
                     rs.getInt(7),
                     rs.getString(8),
                     rs.getInt(9),
                     rs.getString(10),
                     rs.getString(11)));
                        }
         }finally{
         
            DBUtil.dbClose(con, ps,rs);
         }
      return list;
   }
   public List<ProductDTO> productLike(String decide,String sear) throws SQLException{
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      List<ProductDTO> list = new ArrayList<>();
	      try{
	          con = DBUtil.getConnection();
	          // ps瑜� 留뚮뱾�뼱�꽌 湲곕뒫�쓣 �닔�뻾�븯�뒗 select瑜� 諛쏆븘�샂.
	          // 湲��옄媛� �룷�븿�븳 寃��깋 湲곕뒫!
	          String sql = "select * from Product where "+decide+" like "+"'%"+sear+"%'";
	          System.out.println(sql);
	          ps = con.prepareStatement(sql);
	          rs = ps.executeQuery();
	             while(rs.next()){
	                list.add(new ProductDTO(
	                      rs.getInt(1),
	                      rs.getString(2),
	                      rs.getString(3),
	                      rs.getInt(4),
	                      rs.getString(5),
	                      rs.getString(6),
	                      rs.getInt(7),
	                      rs.getString(8),
	                      rs.getInt(9),
	                      rs.getString(10),
	                      rs.getString(11)));
	                     }
	          }finally{
	             DBUtil.dbClose(con, ps,rs);
	          }
	       return list;
   }
   
   public List<ProductDTO> productWhere(String point,String show) throws SQLException{
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      List<ProductDTO> list = new ArrayList<>();
	      try{
	    	  con = DBUtil.getConnection();
	          String sql = "select * from Product where "+point+"=?";
	         // where 議곌굔�쑝濡� �옣瑜대퀎, 媛�寃⑹닚!
	          ps = con.prepareStatement(sql);
	          ps.setString(1, show);
	          rs = ps.executeQuery();
	             while(rs.next()){
	                list.add(new ProductDTO(
	                      rs.getInt(1),
	                      rs.getString(2),
	                      rs.getString(3),
	                      rs.getInt(4),
	                      rs.getString(5),
	                      rs.getString(6),
	                      rs.getInt(7),
	                      rs.getString(8),
	                      rs.getInt(9),
	                      rs.getString(10),
	                      rs.getString(11)));
	                         }
	          }finally{
	             DBUtil.dbClose(con, ps,rs);
	          }
	       return list;
   }
   

   public List<ProductDTO> productWherePrice(int price) throws SQLException{
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      List<ProductDTO> list = new ArrayList<>();
	      try{
	    	  con = DBUtil.getConnection();
	          String sql = "select * from Product where < ?";
	         // where 議곌굔�쑝濡� �옣瑜대퀎, 媛�寃⑹닚!
	          ps = con.prepareStatement(sql);
	          ps.setInt(1, price);
	          rs = ps.executeQuery();
	             while(rs.next()){
	                list.add(new ProductDTO(
	                      rs.getInt(1),
	                      rs.getString(2),
	                      rs.getString(3),
	                      rs.getInt(4),
	                      rs.getString(5),
	                      rs.getString(6),
	                      rs.getInt(7),
	                      rs.getString(8),
	                      rs.getInt(9),
	                      rs.getString(10),
	                      rs.getString(11)));
	                         }
	          }finally{
	             DBUtil.dbClose(con, ps,rs);
	          }
	       return list;
   }

   
   
   /**
    * �젣紐⑹뿉 �듅�젙 臾몄옄�뿴�씠 �룷�븿�맂 �젅肄붾뱶 寃��깋
    * select * from product where subject like ?
    */
   /*
   List<ProductDTO> productSelectBySubject(String keyWord) throws SQLException;
   */
   
   /**
    * 湲�踰덊샇�뿉 �빐�떦�븯�뒗 �젅肄붾뱶 寃��깋
    * select * from product where product_no = ? 
    */
   /*
   ProductDTO productSelectByNo(int productNo) throws SQLException;
   */
   
   /**
    * �긽�뭹 �벑濡앺븯湲�
    * insert 
    */
   public int productInsert(ProductDTO PD) throws SQLException{
      Connection con = null;
      PreparedStatement ps = null;
      int result = 0;
      try {
         con = DBUtil.getConnection();
         String sql ="insert into product values(P_ID.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";
         ps =con.prepareStatement(sql);
         ps.setString(1,PD.getP_name());
         ps.setString(2,PD.getP_singer());
         ps.setInt(3,PD.getP_price());
         ps.setString(4,PD.getP_desc());
         ps.setString(5,PD.getP_comp());
         ps.setInt(6,PD.getP_hit());
         ps.setString(7,PD.getP_genre());
         ps.setInt(8,PD.getP_qtt());
         ps.setString(9,PD.getP_date());
         ps.setString(10,PD.getP_image());
         result =ps.executeUpdate();
      }finally{
         DBUtil.dbClose(con, ps);
      }
      return result;
   }
     
   public int productDelete(int p_id) throws SQLException{
      Connection con = null;
      PreparedStatement ps = null;
      int result = 0;
      try {
         con = DBUtil.getConnection();
         String sql ="delete from product where p_id=?";
         ps =con.prepareStatement(sql);
         ps.setInt(1,p_id);
         result = ps.executeUpdate();
      } finally {
         DBUtil.dbClose(con, ps);
      }
      return result;   
   }
   
 

   public int productUpdateAll(ProductDTO PD) throws SQLException{
      Connection con = null;
      PreparedStatement ps = null;
      int result = 0;
      try {
         con = DBUtil.getConnection();
         String sql = "update product set p_name=?,p_singer=?,p_price=?,p_desc=?,p_comp=?,"
               + "p_hit=?,p_genre=?,p_qtt=?,p_date=?,p_image=? where p_id = ?";
         ps =con.prepareStatement(sql);
         ps.setString(1,PD.getP_name());
         ps.setString(2,PD.getP_singer());
         ps.setInt(3,PD.getP_price());
         ps.setString(4,PD.getP_desc());
         ps.setString(5,PD.getP_comp());
         ps.setInt(6,PD.getP_hit());
         ps.setString(7,PD.getP_genre());
         ps.setInt(8,PD.getP_qtt());
         ps.setString(9,PD.getP_date());
         ps.setString(10,PD.getP_image());
         ps.setInt(11,PD.getP_id());
         result =ps.executeUpdate();
      }finally{
         DBUtil.dbClose(con, ps);
      }
      return result;   
   }
   
  
   public int productUpdateQtt(int p_id, int p_qutt) throws SQLException{
      Connection con = null;
      PreparedStatement ps = null;
      int result = 0;
      try {
         con = DBUtil.getConnection();
         String sql = "update product set p_qtt=? where p_id = ?";
         ps =con.prepareStatement(sql);
         ps.setInt(1,p_qutt);
         ps.setInt(2,p_id);
         result =ps.executeUpdate();
      }finally{
         DBUtil.dbClose(con, ps);
      }
      return result;   
   }

   
   
   
   public List<ProductDTO> prodGetCartByUserId(String u_id) throws SQLException{
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      List<ProductDTO> list = null;
	      try {
	         con = DBUtil.getConnection();
	         String sql = "select * from cart where u_id = ?;";
	         ps = con.prepareStatement(sql);
	         ps.setString(1, u_id);
	         rs = ps.executeQuery();
	         while(rs.next()) {
	        	 list.add(new ProductDTO(
	                     rs.getInt(1),
	                     rs.getString(2),
	                     rs.getString(3),
	                     rs.getInt(4),
	                     rs.getString(5),
	                     rs.getString(6),
	                     rs.getInt(7),
	                     rs.getString(8),
	                     rs.getInt(9),
	                     rs.getString(10),
	                     rs.getString(11)));     
	         }
	      }finally{
	         DBUtil.dbClose(con, ps,rs);
	      }
	      return list;   
	   }
	
	
	public int prodGetQtt(String u_id, int p_id) throws SQLException{
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      int result = 0;
	      try {
	         con = DBUtil.getConnection();
	         String sql = "select distinct p.p_qtt "
	         		+ "from PRODUCT p, CART c "
	         		+ "where p.p_id = "
	         		+ "(select c.p_id from Cart c where c.u_id = ? and c.p_id = ?";
	         ps = con.prepareStatement(sql);
	         ps.setString(1, u_id);
	         ps.setInt(2, p_id);
	         rs = ps.executeQuery();
	         if(rs.next()) result = rs.getInt(1);        
	      }finally{
	         DBUtil.dbClose(con, ps,rs);
	      }
	      return result;   
	   }
	
	
	public int prodPrice(int p_id) throws SQLException{
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      int result = 0;
	      try {
	         con = DBUtil.getConnection();
	         String sql = "select p_price "
	         		+ "from PRODUCT "
	         		+ "where p_id = ?";
	         ps = con.prepareStatement(sql);
	         ps.setInt(1, p_id);
	         
	         rs = ps.executeQuery();
	         if(rs.next()) result = rs.getInt(1); 
	      }finally{
	    	  DBUtil.dbClose(con, ps,rs);
	      }
	      return result;   
	   }
	
	
	public int prodQtt(int p_id) throws SQLException{
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      int result = 0;
	      try {
	         con = DBUtil.getConnection();
	         String sql = "select p_qtt "
	         		+ "from PRODUCT "
	         		+ "where p_id = ?";
	         ps = con.prepareStatement(sql);
	         ps.setInt(1, p_id);
	         
	         rs = ps.executeQuery();
	         if(rs.next()) result = rs.getInt(1); 
	      }finally{
	         DBUtil.dbClose(con, ps,rs);
	      }
	      return result;   
	   }
	
	public String productNameByPid(int P_id) throws SQLException{
		   Connection con=null;
		   PreparedStatement ps =null;
		   String result=null;
		   ResultSet rs = null;
		   try{
			   con = DBUtil.getConnection();
			   String sql = "Select p_name from product where P_ID = ?";
			   ps=con.prepareStatement(sql);
			   ps.setInt(1,	P_id);
			   rs=ps.executeQuery();
			   if(rs.next()){
				   result = rs.getString(1);
			   }
		   }finally{
			   DBUtil.dbClose(con, ps);
		   }
		   return result;
	   } 
	   public int productSelectByNo(int p_id) throws SQLException{
		   Connection con=null;
		   PreparedStatement ps =null;
		   int result=0;
		   ResultSet rs = null;
		   try{
			   con = DBUtil.getConnection();
			   String sql = "Select p_price from product where P_ID = ?";
			   ps=con.prepareStatement(sql);
			   ps.setInt(1,	p_id);
			   rs=ps.executeQuery();
			   if(rs.next()){
				   result = rs.getInt(1);
			   }
		   }finally{
			   DBUtil.dbClose(con, ps);
		   }
		   return result;
	   }
	   
	   public int productQttByNo(int p_id) throws SQLException{
		   Connection con=null;
		   PreparedStatement ps =null;
		   int result=0;
		   ResultSet rs = null;
		   try{
			   con = DBUtil.getConnection();
			   String sql = "Select p_qtt from product where P_ID = ?";
			   ps=con.prepareStatement(sql);
			   ps.setInt(1,	p_id);
			   rs=ps.executeQuery();
			   if(rs.next()){
				   result = rs.getInt(1);
			   }
		   }finally{
			   DBUtil.dbClose(con, ps);
		   }
		   return result;
	   }
	   
	   
	   public List<ProductDTO> productIndex() throws SQLException{
		   Connection con=null;
		   PreparedStatement ps =null;
		   ResultSet rs = null;
           List<ProductDTO> list = new ArrayList<>();

		   try{
			   con = DBUtil.getConnection();
			   String sql = "Select * from product order by p_date desc";
			   ps=con.prepareStatement(sql);
			   rs=ps.executeQuery();
			   while(rs.next()){
				   list.add(new ProductDTO(
						     rs.getInt(1),
		                     rs.getString(2),
		                     rs.getString(3),
		                     rs.getInt(4),
		                     rs.getString(5),
		                     rs.getString(6),
		                     rs.getInt(7),
		                     rs.getString(8),
		                     rs.getInt(9),
		                     rs.getString(10),
		                     rs.getString(11)));
			   }
		   }finally{
			   DBUtil.dbClose(con, ps,rs);
		   }
		   return list;
	   }
	   
	   public List<ProductDTO> productDetail(int p_id) throws SQLException{
		   Connection con=null;
		   PreparedStatement ps =null;
		   ResultSet rs = null;
           List<ProductDTO> list = new ArrayList<>();

		   try{
			   con = DBUtil.getConnection();
			   String sql = "Select * from product where P_ID = ?";
			   ps=con.prepareStatement(sql);
			   ps.setInt(1,	p_id);
			   rs=ps.executeQuery();
			   while(rs.next()){
				   list.add(new ProductDTO(
						     rs.getInt(1),
		                     rs.getString(2),
		                     rs.getString(3),
		                     rs.getInt(4),
		                     rs.getString(5),
		                     rs.getString(6),
		                     rs.getInt(7),
		                     rs.getString(8),
		                     rs.getInt(9),
		                     rs.getString(10),
		                     rs.getString(11)));			   }
		   }finally{
			   DBUtil.dbClose(con, ps);
		   }
		   return list;
	   }
	   public int productUpdateHit(int p_id) throws SQLException {
			Connection con=null;
			PreparedStatement ps=null;
			int result=0;
			try{
				con=DBUtil.getConnection();
				String sql = "Update product set p_hit=p_hit+1 where p_id=?";
				ps=con.prepareStatement(sql);
				ps.setInt(1, p_id);
				result=ps.executeUpdate();
			}finally{
				DBUtil.dbClose(con, ps);
			}
			return result;

}
	@Override
	public List<ProductDTO> productGenre(String genre) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	   
	   public String prodGetPname(int p_id) throws SQLException{
		      Connection con = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      String result = null;
		      try {
		         con = DBUtil.getConnection();
		         String sql = "select p_name "
		         		+ "from PRODUCT "
		         		+ "where p_id = ?";
		         ps = con.prepareStatement(sql);
		         ps.setInt(1, p_id);
		         rs = ps.executeQuery();
		         if(rs.next()) result = rs.getString(1);        
		      }finally{
		         DBUtil.dbClose(con, ps,rs);
		      }
		      return result;   
		   }
	   ///
}