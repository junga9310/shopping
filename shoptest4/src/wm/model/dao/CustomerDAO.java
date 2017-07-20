package wm.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import wm.model.dto.CustomerDTO;





public interface CustomerDAO {
	
	/**
	 * 레코드 전체검색
	 */
	List<CustomerDTO> customerSelectAll() throws SQLException;//예외처리는 controller에서 할거임!
	/**
	 * 회원별 정보검색
	 * */
	CustomerDTO selectByUser(String id) throws SQLException;
	
	/**
	 * 비밀번호검색(로그인시)
	 * */
	String customerSelectPassword(String id)throws SQLException;
	
	/**
	 * 비밀번호 수정
	 */
	int customerUpdatePassword(String id,String password) throws SQLException;
	
	/**
	 * 회원가입시 회원입력
	 * */
	int customerInsert(CustomerDTO customerDTO) throws SQLException;
	
	/**
	 * 주소, 전화번호  수정
	 */
	int customerUpdateInfo(CustomerDTO customerDTO) throws SQLException;//글번호 : primary key 레코드는 0아니면 1, 유일함
	
	/**
	 * 회원 탈퇴 - 회원탈퇴날짜 insert (회원 탈퇴 날짜가 있을 경우 로그인 불가!)
	 */
	int customerUpdateOutdate(String id) throws SQLException;
	
	/**
	 * 	회원 완전 삭제 - 기준 : 30일 후! 수동!
	 */
	int CustomerDelete(String id) throws SQLException;
	
	/**
	 * 유저 레벨 업데이트 - 기준 : 총 가격 10만원 이상 (group by user_id join buy1)
	 */
	int customerUpdateLevel(String id, int level) throws SQLException;
	
	/**
	 * 탈퇴를 원하는 회원들의 리스트
	 * */
	List<CustomerDTO> customerSelectOut() throws SQLException;
	
	/**
	 * 아이지중복체크
	 * */
	String idCheck(String id) throws SQLException;
	
	}

