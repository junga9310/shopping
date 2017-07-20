package wm.model.dto;

import java.sql.Date;

public class BuyoneDTO {

	private int O_NO; // �۹�ȣ
	private String U_ID; // ����
	private int TOT_PRICE; // �ۼ���
	private int PAYMENT; // ����
	private String O_DATE; // �����
	
	public BuyoneDTO() {}

	public BuyoneDTO(String U_ID, int TOT_PRICE, int PAYMENT) {
		super();
		this.U_ID = U_ID;
		this.TOT_PRICE = TOT_PRICE;
		this.PAYMENT = PAYMENT;
	}

	public int getO_NO() {
		return O_NO;
	}

	public int getTOT_PRICE() {
		return TOT_PRICE;
	}

	public void setTOT_PRICE(int tOT_PRICE) {
		TOT_PRICE = tOT_PRICE;
	}

	public void setO_NO(int o_NO) {
		O_NO = o_NO;
	}

	public String getU_ID() {
		return U_ID;
	}

	public void setU_ID(String u_ID) {
		U_ID = u_ID;
	}

	public int getPAYMENT() {
		return PAYMENT;
	}

	public void setPAYMENT(int pAYMENT) {
		PAYMENT = pAYMENT;
	}

}
