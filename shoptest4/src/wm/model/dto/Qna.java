package wm.model.dto;

import java.sql.Date;

public class Qna {
	private int BOARD_NUM;
	private String BOARD_NAME;
	private String BOARD_PASS;
	private String BOARD_SUBJECT; 
	private String BOARD_CONTENT ;
	private String  BFILE; 
	private int  BFSIZE;
	private int  BOARD_RE_REF;
	private int  BOARD_RE_LEV;
	private int  BOARD_RE_SEQ;
	private int  BOARD_READNUM;
	private Date  BOARD_DATE;
	
	
	
	public Qna(){}
	
	//삭제할때..
	public Qna(int BOARD_NUM, String BOARD_PASS) {
		this.BOARD_NUM = BOARD_NUM;
		this.BOARD_PASS = BOARD_PASS;
	}
	
	//업로드 안될경우 생성자
	public Qna(int BOARD_NUM, String BOARD_NAME, String BOARD_SUBJECT,
			String BOARD_CONTENT, String BOARD_PASS) {
		this.BOARD_NUM = BOARD_NUM;
		this.BOARD_NAME = BOARD_NAME;
		this.BOARD_SUBJECT = BOARD_SUBJECT;
		this.BOARD_CONTENT = BOARD_CONTENT;
		this.BOARD_PASS = BOARD_PASS;
	}

	//업로드가 될때
	public Qna(int BOARD_NUM, String BOARD_NAME, String BOARD_PASS,
			String BOARD_SUBJECT, String BOARD_CONTENT,String BFILE,
			int BFSIZE, int BOARD_RE_REF, int BOARD_RE_LEV,
			int BOARD_RE_SEQ, int BOARD_READNUM, Date BOARD_DATE) {
		
		this.BOARD_NUM = BOARD_NUM;
		this.BOARD_NAME = BOARD_NAME;
		this.BOARD_PASS = BOARD_PASS;
		this.BOARD_SUBJECT = BOARD_SUBJECT;
		this.BOARD_CONTENT = BOARD_CONTENT;
		this.BFILE = BFILE;
		this.BFSIZE = BFSIZE;
		this.BOARD_RE_REF = BOARD_RE_REF;
		this.BOARD_RE_LEV = BOARD_RE_LEV;
		this.BOARD_RE_SEQ = BOARD_RE_SEQ;
		this.BOARD_READNUM = BOARD_READNUM;
		this.BOARD_DATE = BOARD_DATE;
	}

	//리플용 생성자
	
	
	
	
	public Qna(int bOARD_NUM, String bOARD_NAME,  String bOARD_SUBJECT,String bOARD_CONTENT,String bOARD_PASS, 
			int bOARD_RE_REF) {
		
		BOARD_NUM = bOARD_NUM;
		BOARD_NAME = bOARD_NAME;
		BOARD_PASS = bOARD_PASS;
		BOARD_SUBJECT = bOARD_SUBJECT;
		BOARD_CONTENT = bOARD_CONTENT;
		BOARD_RE_REF = bOARD_RE_REF;
	}

	public int getBOARD_NUM() {
		return BOARD_NUM;
	}

	public void setBOARD_NUM(String BOARD_NUM) {
		BOARD_NUM = BOARD_NUM;
	}

	public String getBOARD_NAME() {
		return BOARD_NAME;
	}

	public void setBOARD_NAME(String BOARD_NAME) {
		BOARD_NAME = BOARD_NAME;
	}

	public String getBOARD_PASS() {
		return BOARD_PASS;
	}

	public void setBOARD_PASS(String BOARD_PASS) {
		BOARD_PASS = BOARD_PASS;
	}

	public String getBOARD_SUBJECT() {
		return BOARD_SUBJECT;
	}

	public void setBOARD_SUBJECT(String BOARD_SUBJECT) {
		BOARD_SUBJECT = BOARD_SUBJECT;
	}

	public String getBOARD_CONTENT() {
		return BOARD_CONTENT;
	}

	public void setBOARD_CONTENT(String BOARD_CONTENT) {
		BOARD_CONTENT = BOARD_CONTENT;
	}
	

	public String getBFILE() {
		return BFILE;
	}

	public void setBFILE(String bFILE) {
		BFILE = bFILE;
	}

	public int getBFSIZE() {
		return BFSIZE;
	}

	public void setBFSIZE(int bFSIZE) {
		BFSIZE = bFSIZE;
	}

	public int getBOARD_RE_REF() {
		return BOARD_RE_REF;
	}

	public void setBOARD_RE_REF(int BOARD_RE_REF) {
		BOARD_RE_REF = BOARD_RE_REF;
	}

	public int getBOARD_RE_LEV() {
		return BOARD_RE_LEV;
	}

	public void setBOARD_RE_LEV(int BOARD_RE_LEV) {
		BOARD_RE_LEV = BOARD_RE_LEV;
	}

	public int getBOARD_RE_SEQ() {
		return BOARD_RE_SEQ;
	}

	public void setBOARD_RE_SEQ(int BOARD_RE_SEQ) {
		BOARD_RE_SEQ = BOARD_RE_SEQ;
	}

	public int getBOARD_READNUM() {
		return BOARD_READNUM;
	}

	public void setBOARD_READNUM(int BOARD_READNUM) {
		BOARD_READNUM = BOARD_READNUM;
	}

	public Date getBOARD_DATE() {
		return BOARD_DATE;
	}

	public void setBOARD_DATE(Date BOARD_DATE) {
		BOARD_DATE = BOARD_DATE;
	}

	
	
	

}
