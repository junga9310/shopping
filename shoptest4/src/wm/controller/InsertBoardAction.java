package wm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import wm.model.dto.Qna;
import wm.model.service.QnaService;

public class InsertBoardAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ����÷�ζ����� multipartRequst�ʿ�.
		String saveDir = request.getSession().getServletContext().getRealPath("/save/");

		int maxSize = 1024 * 1024 * 100;// 100m
		String encoding = "UTF-8";

		try {
System.out.println("try");
			MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding,
					new DefaultFileRenamePolicy());

		//	String BOARD_NUM = m.getParameter("BOARD_NUM");
			String BOARD_NAME = m.getParameter("BOARD_NAME");
			String BOARD_SUBJECT = m.getParameter("BOARD_SUBJECT");
			String BOARD_CONTENT = m.getParameter("BOARD_CONTENT");
			String BOARD_PASS = m.getParameter("BOARD_PASS");

			// �Է����� ��ȿ�� üũ
			if (BOARD_NAME == null || BOARD_SUBJECT == null || BOARD_CONTENT == null || BOARD_PASS == null) {

				throw new Exception("�Է°��� ������� �ʽ��ϴ�.");
			}
			
			BOARD_CONTENT = BOARD_CONTENT.replaceAll("<", "&lt;");
		

			int refNo=0;

			//reply���� ������ ���� �ְ� �ƴ� ����.	
			String sref = m.getParameter("ref");
			System.out.println(sref);
			if(sref!=null)
			{
			refNo = Integer.parseInt(sref);
			}
			
			// Qna qna = new Qna(bNo,BOARD_NAME, BOARD_SUBJECT, BOARD_CONTENT,
			// BOARD_PASS);
			// if(m.getFilesystemName("file")!= null){//����÷�εǾ��ٸ�
			// //System.out.println(m.getFilesystemName("file"));
			// qna.setBFILE(m.getFilesystemName("file"));
			// qna.setBFSIZE((int)m.getFile("file").length());
			// System.out.println(qna.getBFILE());
			// System.out.println(qna.getBFSIZE());
			// }
			Qna qna =new Qna(1, BOARD_NAME, BOARD_SUBJECT, BOARD_CONTENT, BOARD_PASS, refNo);

			// ���⼭ ���ÿ����� ���� 0�̸� insert�ٸ���.
//
//			if (refNo != 0) {
//				qna = new Qna(1, BOARD_NAME, BOARD_SUBJECT, BOARD_CONTENT, BOARD_PASS, refNo);
//			} else {
//				qna = new Qna(1, BOARD_NAME, BOARD_SUBJECT, BOARD_CONTENT, BOARD_PASS,0);
//
//			}
			if (m.getFilesystemName("file") != null) {// ����÷�εǾ��ٸ�
				// System.out.println(m.getFilesystemName("file"));
				qna.setBFILE(m.getFilesystemName("file"));
				qna.setBFSIZE((int) m.getFile("file").length());
			}
			int result = QnaService.insert(qna);
			if (result > 0) {
//				if(qna.getBOARD_RE_REF()!=0)
//				{
//					request.setAttribute("BOARD_NUM", qna.getBOARD_RE_REF());
//					response.sendRedirect("wm?command=detailView");
//				}
//				else{
				response.sendRedirect("wm?command=list");
			//	}
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
		

		request.getRequestDispatcher("page/view/errorView.jsp").forward(request, response);

	}

}
