package wm.model.dto;

public class CartProdDTO {
	private String userId; // 占쏙옙占쏙옙id
	private int prodId; // 占쏙옙품id
	private int cartQtt; // 占쏙옙占쏙옙
	private String cartImage; // 占싱뱄옙占쏙옙占쏙옙占�
	private String cartDate; // 占쏙옙占쏙옙占�
	private int prodPrice;
	private int totPrice;
	private String prodName;

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public CartProdDTO(){}

	public CartProdDTO(String userId, int prodId, int cartQtt, String cartImage, String cartDate, int prodPrice, 
			int totPrice, String prodName) {
		super();
		this.userId = userId;
		this.prodId = prodId;
		this.cartQtt = cartQtt;
		this.cartImage = cartImage;
		this.cartDate = cartDate;
		this.prodPrice = prodPrice;
		this.totPrice = totPrice;
		this.prodName = prodName;
	}

	public int getTotPrice() {
		return totPrice;
	}

	public void setTotPrice(int totPrice) {
		this.totPrice = totPrice;
	}

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

	public int getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}

	
	
}
