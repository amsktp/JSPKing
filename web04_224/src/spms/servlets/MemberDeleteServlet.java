package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");

		Connection conn = null;
		PreparedStatement pstmt = null;

		ServletContext sc = this.getServletContext();

		String driver = sc.getInitParameter("driver");
		String url = sc.getInitParameter("url");
		String user = sc.getInitParameter("user");
		String password = sc.getInitParameter("password");
		
		int mNo = Integer.parseInt(req.getParameter("mNo"));

		System.out.println("회원 번호 : " + mNo + " 삭제를 한다");
		
		String sql = "";

		try {
			Class.forName(driver);
			System.out.println("오라클 드라이버 로드");

			conn = DriverManager.getConnection(url, user, password);

			sql += "delete from member ";
			sql += "where mno = ?";

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, mNo);

			// 이 순간 이미 데이터베이스에 반영됨
			int resultNum = pstmt.executeUpdate();

			System.out.println("delete 수행결과 : " + resultNum);
			
			res.sendRedirect("./list");

//			res.setContentType("text/html");
//			res.setCharacterEncoding("UTF-8");
//
//			PrintWriter out = res.getWriter();
//
//			String htmlStr = "";
//
//			htmlStr += "<html><head><title>회원정보 수정</title>";
//			htmlStr += "</head>";
//			htmlStr += "<body>";
//			htmlStr += "<p>수정 성공입니다.!</p>";
//			htmlStr += "<a href='list'>";
//			htmlStr += "<input type='button' value='리스트 이동'>";
//			htmlStr += "</a>";
//			htmlStr += "</body></html>";
//			
//			out.println(htmlStr);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (conn != null) {

				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}

}
