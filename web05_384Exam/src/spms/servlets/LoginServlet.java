package spms.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import spms.dao.MemberDao;
import spms.dto.MemberDto;

@WebServlet(value = "/auth/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher rd = req.getRequestDispatcher("./LoginForm.jsp");
		rd.forward(req, res);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 데이터베이스 관련 객체 변수 선언
		Connection conn = null; // 연결

		String email = req.getParameter("email");
		String pwd = req.getParameter("password");

		try {
			ServletContext sc = this.getServletContext();

			conn = (Connection) sc.getAttribute("conn");

			MemberDto memberDto = null;

			MemberDao memberDao = new MemberDao();
			memberDao.setConnection(conn);

			memberDto = memberDao.memberExist(email, pwd);

			if(memberDto == null) {
				// 회원이 없다면 로그인 실패 페이지로 이동
				
				RequestDispatcher rd = req.getRequestDispatcher("./LoginFail.jsp");
				rd.forward(req, res);
			}else {
				//회원이 존재한다면 세션에 달고 회원 전체 페이지로 이동
				
				HttpSession session = req.getSession();
				session.setAttribute("member", memberDto);
				res.sendRedirect("../member/list");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServletException(e);
		}

	}

}
