package kr.or.ddit.ott.mem.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.ott.mem.service.IMemberService;
import kr.or.ddit.ott.mem.service.MemberService;

@WebServlet("/member/memberdelete.do")
public class MemberDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/view/member/memberlist.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 파라미터 데이터 가져오기
		String memEm = req.getParameter("memEm");
		System.out.println(memEm + " memEm왜띄워짐?");

		// 2. 서비스 객체 생성하기 해봅시다
		IMemberService memService = MemberService.getInstance();
		

		// 3. 회원정보 등록하기
		int cnt = memService.MemberDelete(memEm);
		System.out.println("담겼냐 진짜? " + cnt);
		
		String msg = "";

		if (cnt > 0) {
			// 성공
			msg = "성공";
		} else {
			// 실패
			msg = "실패";
		}

		resp.getWriter().write(msg);
		
	}
}
