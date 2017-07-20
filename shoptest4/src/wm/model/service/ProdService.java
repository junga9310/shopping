package wm.model.service;

import java.sql.SQLException;
import java.util.List;

import wm.model.dao.ProductDAO;
import wm.model.dao.ProductDAOImpl;
import wm.model.dto.ProductDTO;

public class ProdService {
	private static ProductDAO prodDao = new ProductDAOImpl();
	// 臾댁뒯 李⑥씠 �씪源�...
	// 紐⑸줉 異쒕젰
	public static List<ProductDTO> prodselectAll() throws SQLException{
		return prodDao.productSelectAll();
	}
	// �씤湲곕퀎 �젙�젹 -> �븘�슂�븳 �뙆�씪誘명꽣�뒗 String �삎�떇�쑝濡� �엯�젰諛쏄린
	public static List<ProductDTO> prodorder(String order,String desc) throws SQLException{
		return prodDao.productOrder(order, desc);
	}
	public static List<ProductDTO> prodtGenre(String genre) throws SQLException{
		return prodDao.productGenre(genre);
	}
	// 寃��깋 湲곕뒫 -> �뿊�냼 �븿踰�
	public static List<ProductDTO> prodsearch(String decide,String sear) throws SQLException{
		return prodDao.productLike(decide,sear);
	}
	// �옣瑜대퀎 寃��깋 -> decide = show
	public static List<ProductDTO> prodselectWhere(String point, String show) throws SQLException{
		return prodDao.productWhere(point, show);
	}
	// 媛�寃� �씠�븯 異쒕젰
	public static List<ProductDTO> prodselectWherePrice(int price) throws SQLException{
		return prodDao.productWherePrice(price);
	}
	// �궫�엯 - PD�뒗 action�뿉�꽌 留뚮뱾�뼱�꽌 �뙆�씪誘명꽣濡� �꽆寃� 二쇱옄.
	public static int prodInsert(ProductDTO PD) throws SQLException{
		return prodDao.productInsert(PD);
	}
	// �궘�젣
	public static int prodDelete(int p_id) throws SQLException{
		return prodDao.productDelete(p_id);
	}
	
	// �쟾泥� �닔�젙
	public static int prodUpdateAll(ProductDTO PD) throws SQLException{
		return prodDao.productUpdateAll(PD);
	}
	
	// �닔�웾留� �닔�젙!  --> �씪�떒 留뚮뱾湲곕뒗 �븯�뒗�뜲 �씠嫄� 援щℓ service�뿉�꽌 �궗�슜�빐�빞 �븷 �벏! 
	public static int prodUpdateQtt(int p_id,int p_qutt) throws SQLException{
		return prodDao.productUpdateQtt(p_id, p_qutt);
	}
	
	public static List<ProductDTO> prodIndex() throws SQLException{
		return prodDao.productIndex();
	}
	
	public static List<ProductDTO> prodDetail(int p_id) throws SQLException{
		return prodDao.productDetail(p_id);
	}
}

/*
 * 湲곕뒫
 * �궘�젣
 * �궫�엯
 * like 寃��깋
 * order �젙�젹
 * select -> where decide = show
 * UpdateAll 
 * updateQtt
 */
//   public List<ProductDTO> productSelectAll() throws SQLException{
//   public List<ProductDTO> productOrder(String order,String desc) throws SQLException{
//   public List<ProductDTO> productLike(String sear) throws SQLException{
//   public List<ProductDTO> productWhere(String decide,String show) throws SQLException{
//   public List<ProductDTO> productWherePrice(int price) throws SQLException{
//   public int productInsert(ProductDTO PD) throws SQLException{
//	 public int productDelete(int p_id) throws SQLException{
//	 public int productUpdateAll(ProductDTO PD) throws SQLException{
//	 public int productUpdateQtt(int p_id, int p_qutt) throws SQLException{
