package wm.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import wm.model.dto.CustomerDTO;





public interface CustomerDAO {
	
	/**
	 * ���ڵ� ��ü�˻�
	 */
	List<CustomerDTO> customerSelectAll() throws SQLException;//����ó���� controller���� �Ұ���!
	/**
	 * ȸ���� �����˻�
	 * */
	CustomerDTO selectByUser(String id) throws SQLException;
	
	/**
	 * ��й�ȣ�˻�(�α��ν�)
	 * */
	String customerSelectPassword(String id)throws SQLException;
	
	/**
	 * ��й�ȣ ����
	 */
	int customerUpdatePassword(String id,String password) throws SQLException;
	
	/**
	 * ȸ�����Խ� ȸ���Է�
	 * */
	int customerInsert(CustomerDTO customerDTO) throws SQLException;
	
	/**
	 * �ּ�, ��ȭ��ȣ  ����
	 */
	int customerUpdateInfo(CustomerDTO customerDTO) throws SQLException;//�۹�ȣ : primary key ���ڵ�� 0�ƴϸ� 1, ������
	
	/**
	 * ȸ�� Ż�� - ȸ��Ż��¥ insert (ȸ�� Ż�� ��¥�� ���� ��� �α��� �Ұ�!)
	 */
	int customerUpdateOutdate(String id) throws SQLException;
	
	/**
	 * 	ȸ�� ���� ���� - ���� : 30�� ��! ����!
	 */
	int CustomerDelete(String id) throws SQLException;
	
	/**
	 * ���� ���� ������Ʈ - ���� : �� ���� 10���� �̻� (group by user_id join buy1)
	 */
	int customerUpdateLevel(String id, int level) throws SQLException;
	
	/**
	 * Ż�� ���ϴ� ȸ������ ����Ʈ
	 * */
	List<CustomerDTO> customerSelectOut() throws SQLException;
	
	/**
	 * �������ߺ�üũ
	 * */
	String idCheck(String id) throws SQLException;
	
	}

