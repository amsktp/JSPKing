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

import org.apache.jasper.servlet.JspServlet;

import jdk.nashorn.internal.ir.ForNode;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/member/update"})
public class MemberUpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, res);

		Connection conn = null; // 연결
		PreparedStatement pstmt = null; // 상태
		ResultSet rs = null; // 결과
		
		int mNo = Integer.parseInt(req.getParameter("mNo"));

		String driver = "";
		String url = "";
		String user = "";
		String password = "";
		
		try {
			
			ServletContext sc = this.getServletContext();
			
			driver = sc.getInitParameter("driver");
			url = sc.getInitParameter("url");
			user = sc.getInitParameter("user");
			password = sc.getInitParameter("password");
			
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, user, password);

			String sql = "SELECT MNO, EMAIL, MNAME, CRE_DATE, MOD_DATE, PWD" +
//					"SELECT *" + //*는 안쓰는게 좋다. 명시하는게 좋다
					" FROM MEMBER" + " WHERE MNO = ?";

			// prepareStatement는 sql문장이 완벽해야 하기때문에 아래에 있어야한다.
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, mNo);

			rs = pstmt.executeQuery();

			String mName = "";
			String email = "";
			// Date는 java.util 을 임포트해준다
			Date creDate = null;

			if (rs.next()) {
				mName = rs.getString("MNAME");
				email = rs.getString("EMAIL");
				creDate = rs.getDate("CRE_DATE");
			}

			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");

			PrintWriter out = res.getWriter();

			String htmlStr = "";

			htmlStr += "<!DOCTYPE html>";
			htmlStr += "<html>";
			htmlStr += "<head>";
			htmlStr += "<meta charset='UTF-8'>";
			htmlStr += "<title>회원정보</title>";
			htmlStr += "</head>";
			htmlStr += "<body>";
			htmlStr += "<h1>회원정보</h1>";
			htmlStr += "<form action='./update' method='post'>";
			htmlStr += "번호: <input type='text' name='mNo' value='" + mNo + "' readonly='readonly'><br/>";
			htmlStr += "이름: <input type='text' name='name' value='" + mName + "'><br/>";
			htmlStr += "이메일: <input type='text' name='email' value='" + email + "'><br/>";
			htmlStr += "가입일: " + creDate + "<br>";
			htmlStr += "<input type='submit' value='저장'>";
			htmlStr += "<input type='button' value='취소' onclick='location.href=\"./list\"'>";
			htmlStr += "</form>";
			htmlStr += "</body>";
			htmlStr += "</html>";

			out.println(htmlStr);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}

		} // finally 종료
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		
		
		req.setCharacterEncoding("UTF-8");
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		ServletContext sc = this.getServletContext();
		
		String driver = sc.getInitParameter("driver");
		String url = sc.getInitParameter("url");
		String user = sc.getInitParameter("user");
		String password = sc.getInitParameter("password");
		
		
		String email = req.getParameter("email");
		String name = req.getParameter("name");
		int mNo = Integer.parseInt(req.getParameter("mNo"));
		
		String sql = "";
		
		try {
			Class.forName(driver);
			System.out.println("오라클 드라이버 로드");
		
			conn = DriverManager.getConnection(url, user, password);
			
			sql += "update member ";
			sql += "set member.email = ? , "
				+ "mname = ?, mod_date=sysdate ";
			sql += "where mno = ?" ;
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			pstmt.setString(2, name);
			pstmt.setInt(3, mNo);
			
			//이 순간 이미 데이터베이스에 반영됨
			pstmt.executeUpdate();
			
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
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				
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
