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
		// 파일첨부때문에 multipartRequst필요.
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

			// 입력유무 유효성 체크
			if (BOARD_NAME == null || BOARD_SUBJECT == null || BOARD_CONTENT == null || BOARD_PASS == null) {

				throw new Exception("입력값이 충분하지 않습니다.");
			}
			
			BOARD_CONTENT = BOARD_CONTENT.replaceAll("<", "&lt;");
		

			int refNo=0;

			//reply에서 왔으면 값이 있고 아님 없음.	
			String sref = m.getParameter("ref");
			System.out.println(sref);
			if(sref!=null)
			{
			refNo = Integer.parseInt(sref);
			}
			
			// Qna qna = new Qna(bNo,BOARD_NAME, BOARD_SUBJECT, BOARD_CONTENT,
			// BOARD_PASS);
			// if(m.getFilesystemName("file")!= null){//파일첨부되었다면
			// //System.out.println(m.getFilesystemName("file"));
			// qna.setBFILE(m.getFilesystemName("file"));
			// qna.setBFSIZE((int)m.getFile("file").length());
			// System.out.println(qna.getBFILE());
			// System.out.println(qna.getBFSIZE());
			// }
			Qna qna =new Qna(1, BOARD_NAME, BOARD_SUBJECT, BOARD_CONTENT, BOARD_PASS, refNo);

			// 여기서 리플에대한 값이 0이면 insert다르게.
//
//			if (refNo != 0) {
//				qna = new Qna(1, BOARD_NAME, BOARD_SUBJECT, BOARD_CONTENT, BOARD_PASS, refNo);
//			} else {
//				qna = new Qna(1, BOARD_NAME, BOARD_SUBJECT, BOARD_CONTENT, BOARD_PASS,0);
//
//			}
			if (m.getFilesystemName("file") != null) {// 파일첨부되었다면
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
