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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GuestUpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, res);

		Connection conn = null; // 연결
		PreparedStatement pstmt = null; // 상태
		ResultSet rs = null; // 결과
		
		ServletContext sc = this.getServletContext();
		
		String url = sc.getInitParameter("url");
		String user = sc.getInitParameter("user");
		String password = sc.getInitParameter("password");
		String driverUrl = sc.getInitParameter("driver");
		
		
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String user = "jsp";
//		String password = "jsp12";

		int mNo = Integer.parseInt(req.getParameter("mNo"));
		System.out.println(mNo);
		
		
		try {

			Class.forName(driverUrl);

			conn = DriverManager.getConnection(url, user, password);


			String sql = "SELECT MNO, EMAIL, MNAME, CRE_DATE, MOD_DATE, PWD, user_id, sal" +
//					"SELECT *" + //*는 안쓰는게 좋다. 명시하는게 좋다
						" FROM GUEST" + 
						" WHERE MNO = ?";
			
			//prepareStatement는 sql문장이 완벽해야 하기때문에 아래에 있어야한다.
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, mNo);

			rs = pstmt.executeQuery();

			String mName = "";
			String email = "";
			//Date는 java.util 을 임포트해준다
			Date creDate = null;
			int sal = 0;
			String userId = "";
			
			if(rs.next()) {
				mName = rs.getString("MNAME");
				email = rs.getString("EMAIL");
				creDate = rs.getDate("CRE_DATE");
				sal = rs.getInt("sal");
				userId = rs.getString("user_id");
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
			htmlStr += "이름: <input type='text' name='name' value='" + mName +"'><br/>";
			htmlStr += "이메일: <input type='text' name='email' value='" + email +"'><br/>";
			htmlStr += "아이디: <input type='text' name='userId' value='" + userId +"'><br/>";
			htmlStr += "급여: <input type='text' name='sal' value='" + sal +"'><br/>";
			htmlStr += "가입일: " + creDate + "<br>";
			htmlStr += " <input type='submit' value='저장'>";
			htmlStr += " <input type='button' value='회원탈퇴' onclick='location.href=\"./delete?mNo=" + rs.getInt("mNo") + "\"'>";
			htmlStr += " <input type='button' value='취소' onclick='location.href=\"./list\"'>";
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
	
		Connection conn = null;
		PreparedStatement pstmt = null;

//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String user = "jsp";
//		String password = "jsp12";
//		String driverUrl = "oracle.jdbc.driver.OracleDriver";
		
		ServletContext sc = this.getServletContext();
		
		String url = sc.getInitParameter("url");
		String user = sc.getInitParameter("user");
		String password = sc.getInitParameter("password");
		String driverUrl = sc.getInitParameter("driver");
		
		req.setCharacterEncoding("UTF-8");

		int mNo = Integer.parseInt(req.getParameter("mNo"));
		String nameStr = req.getParameter("name");
		String emailStr = req.getParameter("email");
		String userIdStr = req.getParameter("userId");
		int sal = Integer.parseInt(req.getParameter("sal"));
		
		try {
			Class.forName(driverUrl);
			conn = DriverManager.getConnection(url, user, password);

			String sql = "update guest set " 
						+ "guest.mname = ?, guest.email = ?, guest.user_id = ?, guest.sal = ? "
						+ "where guest.mno = ? ";

			//sql을 검증하기
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, nameStr);
			pstmt.setString(2, emailStr);
			pstmt.setString(3, userIdStr);
			pstmt.setInt(4, sal);
			pstmt.setInt(5, mNo);
			

			//인서트 등 뭔가 바뀌는게 되면 update로 해야함
			pstmt.executeUpdate();
			//커밋은 오토커밋이 적용됨
			
			res.sendRedirect("./list");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("jdbc 오라클 드라이버 로드 실패");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("insert into guest 수행 실패");
		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("pstmt 종료 실패");
				}

			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("db연결 해제 실패");
				}
			}

		}
	
	}

}
