package wm.model.dto;

public class CartDTO {
   private String userId;
   private int prodId; 
   private int cartQtt;
   private String cartImage; 
   private String cartDate; 
   
   //
   public CartDTO() {}
   
   public CartDTO(String userId) {
      super();
      this.userId = userId;
   
   }
   
   public CartDTO(String userId, int prodId, int cartQtt, String cartImage,
         String cartDate) {
      super();
      this.userId = userId;
      this.prodId = prodId;
      this.cartQtt = cartQtt;
      this.cartImage = cartImage;
      this.cartDate = cartDate;
   }
   //cartDate
   public CartDTO(String userId, int prodId, int cartQtt, String cartImage) {
      super();
      this.userId = userId;
      this.prodId = prodId;
      this.cartQtt = cartQtt;
      this.cartImage = cartImage;
   }
   
   public CartDTO(String userId, int prodId, int cartQtt) {
      super();
      this.userId = userId;
      this.prodId = prodId;
      this.cartQtt = cartQtt;
   }
   public CartDTO(String userId, int prodId) {
      super();
      this.userId = userId;
      this.prodId = prodId;
   }
   
   @Override
   public String toString() {
      return userId +"|"+ prodId +"|"+ cartQtt +"|"+ cartImage +"|"+ cartDate;
   }
   
   
   
   //getter, setter
   public String getUserId() {
      return userId;
   }
   public void setUserId(String userId) {
      this.userId = userId;
   }
   public int getProdId() {
      return prodId;
   }
   public void setProdId(int prodId) {
      this.prodId = prodId;
   }
   public int getCartQtt() {
      return cartQtt;
   }
   public void setCartQtt(int cartQtt) {
      this.cartQtt = cartQtt;
   }
   public String getCartImage() {
      return cartImage;
   }
   public void setCartImage(String cartImage) {
      this.cartImage = cartImage;
   }
   public String getCartDate() {
      return cartDate;
   }
   public void setCartDate(String cartDate) {
      this.cartDate = cartDate;
   }
   
}