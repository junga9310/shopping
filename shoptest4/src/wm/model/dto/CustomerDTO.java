package wm.model.dto;

public class CustomerDTO {


private String u_id;
  private String u_name;
  private String u_pw;
  private String u_email;
  private int e_rec;
  private String u_phone;
  private String u_post;
  private String u_addr;
  private String u_addr_detail;
  private int u_level;
  private String u_indate;
  private String u_outdate;
  
  public CustomerDTO(){}
  
  
  //인서트
  public CustomerDTO(String u_id, String u_name, String u_pw, String u_email, int e_rec, String u_phone, String u_post,
		String u_addr, String u_addr_detail) {
	super();
	this.u_id = u_id;
	this.u_name = u_name;
	this.u_pw = u_pw;
	this.u_email = u_email;
	this.e_rec = e_rec;
	this.u_phone = u_phone;
	this.u_post = u_post;
	this.u_addr = u_addr;
	this.u_addr_detail = u_addr_detail;
}


//정보수정
public CustomerDTO(String u_id, String u_name, String u_email, int e_rec, String u_phone, String u_post, String u_addr,
		String u_addr_detail) {
	this.u_id = u_id;
	this.u_name=u_name;
	this.u_email = u_email;
	this.e_rec = e_rec;
	this.u_phone = u_phone;
	this.u_post = u_post;
	this.u_addr = u_addr;
	this.u_addr_detail = u_addr_detail;
}


//탈퇴회원 리스트
public CustomerDTO(String u_id, String u_name, int u_level, String u_indate, String u_outdate) {
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_level = u_level;
		this.u_indate = u_indate;
		this.u_outdate = u_outdate;
	}
public CustomerDTO(String u_id, String u_name, String u_pw, String u_email, int e_rec, String u_phone, String u_post,
			String u_addr, String u_addr_detail, int u_level, String u_indate, String u_outdate) {
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_pw = u_pw;
		this.u_email = u_email;
		this.e_rec = e_rec;
		this.u_phone = u_phone;
		this.u_post = u_post;
		this.u_addr = u_addr;
		this.u_addr_detail = u_addr_detail;
		this.u_level = u_level;
		this.u_indate = u_indate;
		this.u_outdate = u_outdate;
	}


public String getU_id() {
	return u_id;
}


public void setU_id(String u_id) {
	this.u_id = u_id;
}


public String getU_name() {
	return u_name;
}


public void setU_name(String u_name) {
	this.u_name = u_name;
}


public String getU_pw() {
	return u_pw;
}


public void setU_pw(String u_pw) {
	this.u_pw = u_pw;
}


public String getU_email() {
	return u_email;
}


public void setU_email(String u_email) {
	this.u_email = u_email;
}


public int getE_rec() {
	return e_rec;
}


public void setE_rec(int u_rec) {
	this.e_rec = e_rec;
}


public String getU_phone() {
	return u_phone;
}


public void setU_phone(String u_phone) {
	this.u_phone = u_phone;
}


public String getU_post() {
	return u_post;
}


public void setU_post(String u_post) {
	this.u_post = u_post;
}


public String getU_addr() {
	return u_addr;
}


public void setU_addr(String u_addr) {
	this.u_addr = u_addr;
}


public String getU_addr_detail() {
	return u_addr_detail;
}


public void setU_addr_detail(String u_addr_detail) {
	this.u_addr_detail = u_addr_detail;
}


public int getU_level() {
	return u_level;
}


public void setU_level(int u_level) {
	this.u_level = u_level;
}


public String getU_indate() {
	return u_indate;
}


public void setU_indate(String u_indate) {
	this.u_indate = u_indate;
}


public String getU_outdate() {
	return u_outdate;
}


public void setU_outdate(String u_outdate) {
	this.u_outdate = u_outdate;
}
  
@Override
public String toString() {
	return u_id+" | "+u_name+" | "+u_pw+" | "+u_email+" | "+e_rec+" | "+u_phone+" | "+u_post+" | "+u_addr+" | "+u_addr_detail+" | "+u_level+" | "+u_indate+" | "+u_outdate;
}

  
}
