package wm.model.dto;

public class ProductDTO {

   private int p_id;
   private String p_name;
   private String p_singer;
   private int p_price;
   private String p_desc;
   private String p_comp;
   private int p_hit;
   private String p_genre;
   private int p_qtt;
   private String p_date;
   private String p_image;
   
   public ProductDTO() {   }
   
   public ProductDTO(int p_id, String p_name, String p_singer, int p_price, String p_desc, String p_comp, int p_hit,
         String p_genre, int p_qtt, String p_date, String p_image) {
      super();
      this.p_id = p_id;
      this.p_name = p_name;
      this.p_singer = p_singer;
      this.p_price = p_price;
      this.p_desc = p_desc;
      this.p_comp = p_comp;
      this.p_hit = p_hit;
      this.p_genre = p_genre;
      this.p_qtt = p_qtt;
      this.p_date = p_date;
      this.p_image = p_image;
   }
   
   
   public ProductDTO(String p_name, String p_singer, int p_price, String p_desc, String p_comp, int p_hit,
         String p_genre, int p_qtt, String p_date, String p_image) {
      super();
      this.p_name = p_name;
      this.p_singer = p_singer;
      this.p_price = p_price;
      this.p_desc = p_desc;
      this.p_comp = p_comp;
      this.p_hit = p_hit;
      this.p_genre = p_genre;
      this.p_qtt = p_qtt;
      this.p_date = p_date;
      this.p_image = p_image;
   }


   public int getP_id() {
      return p_id;
   }


   public void setP_id(int p_id) {
      this.p_id = p_id;
   }


   public String getP_name() {
      return p_name;
   }


   public void setP_name(String p_name) {
      this.p_name = p_name;
   }


   public String getP_singer() {
      return p_singer;
   }


   public void setP_singer(String p_singer) {
      this.p_singer = p_singer;
   }


   public int getP_price() {
      return p_price;
   }


   public void setP_price(int p_price) {
      this.p_price = p_price;
   }


   public String getP_desc() {
      return p_desc;
   }


   public void setP_desc(String p_desc) {
      this.p_desc = p_desc;
   }


   public String getP_comp() {
      return p_comp;
   }


   public void setP_comp(String p_comp) {
      this.p_comp = p_comp;
   }


   public int getP_hit() {
      return p_hit;
   }


   public void setP_hit(int p_hit) {
      this.p_hit = p_hit;
   }


   public String getP_genre() {
      return p_genre;
   }


   public void setP_genre(String p_genre) {
      this.p_genre = p_genre;
   }


   public int getP_qtt() {
      return p_qtt;
   }


   public void setP_qtt(int p_qtt) {
      this.p_qtt = p_qtt;
   }


   public String getP_date() {
      return p_date;
   }


   public void setP_date(String p_date) {
      this.p_date = p_date;
   }

   public String getP_image() {
      return p_image;
   }


   public void setP_image(String p_image) {
      this.p_image = p_image;
   }
   
   public String toString(){
		return  p_id+ " | " +p_name + "|" +p_singer + "|" +p_desc+ "|" +p_comp  + "|" +p_hit+  "|" +p_genre  + "|" +p_qtt+ "|" +p_date+ "|" +p_image+'\n'; 
   }
	
}

/*
 *       this.p_id = p_id;
      this.p_name = p_name;
      this.p_singer = p_singer;
      this.p_price = p_price;
      this.p_desc = p_desc;
      this.p_comp = p_comp;
      this.p_hit = p_hit;
      this.p_genre = p_genre;
      this.p_qtt = p_qtt;
      this.p_date = p_date;
      this.p_image = p_image;
 */
