package wm.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import wm.model.dto.ProductDTO;
import wm.util.DBUtil;

public interface ProductDAO {

   List<ProductDTO> productSelectAll() throws SQLException;
   
   List<ProductDTO> productOrder(String order,String desc) throws SQLException;
   
   List<ProductDTO> productLike(String decide,String sear) throws SQLException;
   
   List<ProductDTO> productWhere(String point,String show) throws SQLException;

   List<ProductDTO> productWherePrice(int price) throws SQLException;

   int productInsert(ProductDTO PD) throws SQLException;

   int productDelete(int P_id) throws SQLException;
   
   int productUpdateAll(ProductDTO PD) throws SQLException;
   
   int productUpdateQtt(int p_id, int p_qtt) throws SQLException;
   
   int productSelectByNo(int p_id) throws SQLException;
   
   int productQttByNo(int p_id) throws SQLException;
   List<ProductDTO> productGenre(String genre) throws SQLException;
   String productNameByPid(int P_id) throws SQLException;

   int prodGetQtt(String u_id, int p_id) throws SQLException;
   
   List<ProductDTO> prodGetCartByUserId(String u_id) throws SQLException;
   
   int prodQtt(int p_id) throws SQLException;

   List<ProductDTO> productIndex() throws SQLException;
   
   List<ProductDTO> productDetail(int p_id) throws SQLException;
   
   int prodPrice(int p_id) throws SQLException;
   
   int productUpdateHit(int p_id) throws SQLException;


   
   String prodGetPname(int p_id) throws SQLException;
   
}