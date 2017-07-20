package wm.model.dto;

public class BuyTwoDTO {

	private int oNo;
	private int productID;
	private int productAmount;
	
	public BuyTwoDTO() {
		
	}
	
	public BuyTwoDTO(int oNo, int productID, int productAmount) {
		this.oNo = oNo;
		this.productID = productID;
		this.productAmount = productAmount;
		
	}



	public int getoNo() {
		return oNo;
	}

	public void setoNo(int oNo) {
		this.oNo = oNo;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}

	@Override
	public String toString() {
		return oNo + " , " + productID + "," + productAmount +"|";}
}
