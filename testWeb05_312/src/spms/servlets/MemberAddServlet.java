package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/add")
public class MemberAddServlet extends HttpServlet {

	// doGet 자동완성 Go Go

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);

		RequestDispatcher dispatcher = req.getRequestDispatcher("./MemberAddView.jsp");
		
		dispatcher.forward(req, res);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement pstmt = null;

		
		//파라메타로 받은 것을 UTF-8 적용시켜줌
//		req.setCharacterEncoding("UTF-8");

		//사용자의 입력을 받는다.
		String emailStr = req.getParameter("email");
		String pwdStr = req.getParameter("password");
		String nameStr = req.getParameter("name");

		try {
			
			ServletContext sc = this.getServletContext();
			
			conn = (Connection) sc.getAttribute("conn");

			String sql = "insert into member " 
//						+ "(mno, email, pwd, mname, cre_date, mod_date) "
//						+ "value(mno, email, pwd, mname, cre_date, mod_date) "
						+ "values(member_mno_seq.nextval, ?, ?, ?, sysdate, sysdate)";

			//sql을 검증하기
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, emailStr);
			pstmt.setString(2, pwdStr);
			pstmt.setString(3, nameStr);

			//인서트 등 뭔가 바뀌는게 되면 update로 해야함
			pstmt.executeUpdate();

			
			
//			res.sendRedirect("./list");
			
			//커밋은 오토커밋이 적용됨
			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");

			PrintWriter out = res.getWriter();

			String htmlStr = "";

			htmlStr += "<html><head><title>회원등록 결과</title>";
			//새로고침(refresh)하는데 3(content)초 후에 list(url)로 간다는 말임
			htmlStr += "<meta http-equiv='Refresh' ";
			htmlStr += "content='3; url=./list'>";

			htmlStr += "</head>";
			htmlStr += "<body>";
			htmlStr += "<p>등록 성공입니다.!</p>";
			htmlStr += "<a href='list'>";
			htmlStr += "<input type='button' value='리스트 이동'>";
			htmlStr += "</a>";
			htmlStr += "</body></html>";
			out.println(htmlStr);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("insert into member 수행 실패");
		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("pstmt 종료 실패");
				}

			}


		}

	}

}
